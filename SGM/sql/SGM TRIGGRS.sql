-- trigger para prenchimento automatico do custo das peças usadas

DELIMITER $$

CREATE TRIGGER triG_pecas_usadas
BEFORE INSERT ON pecas_usadas
FOR EACH ROW
BEGIN
    DECLARE v_quantOrig INT;
    DECLARE v_valor_unitario FLOAT;

    SELECT QUANTIDADE INTO v_quantOrig
    FROM peca
    WHERE ID_PECAS = NEW.ID_PECAS;

    IF v_quantOrig IS NULL THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'PEÇA NÃO ENCONTRADA NO ESTOQUE';

    ELSEIF v_quantOrig < NEW.quant_peças THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 
            'NÃO A PEÇAS SUFICIENTES NO ESTOQUE';
    ELSE
        SELECT VALOR_UNIDADE INTO v_valor_unitario
        FROM pecas
        WHERE ID_PECAS = NEW.ID_PECAS;

        SET NEW.CUSTO = v_valor_unitario * NEW.QUANT_PEÇAS;

        UPDATE pecas
        SET QUANTIDADE = v_quantOrig - NEW.QUANT_PEÇAS
        WHERE ID_PECAS = NEW.ID_PECAS;
    END IF;
END$$;
DELIMITER ;

-- TRIGGER PARA CORRIGIR CUSTO DAS PEÇAS NA ORDEM DE SERVIÇO

DELIMITER $$

CREATE TRIGGER triG_custoPecas
BEFORE INSERT ON pecas_usadas
FOR EACH ROW
BEGIN
    DECLARE v_valor_unitario FLOAT;

    -- Obter valor unitário da peça
    SELECT VALOR_UNIDADE INTO v_valor_unitario
    FROM pecas
    WHERE ID_PECAS = NEW.ID_PECAS;

    UPDATE ordem_de_servicos
    SET VALOR_PECAS = VALOR_PECAS + (v_valor_unitario * NEW.QUANT_PEÇAS)
    WHERE ID_Os = NEW.NUM_OS;
END$$

DELIMITER ;

-- TRIGGER PARA CALCULO FINAL NO BANCO	
DELIMITER $$

CREATE TRIGGER triG_custoFINAL
AFTER UPDATE ON ordem_de_servicos 
FOR EACH ROW
BEGIN
    UPDATE ordem_de_servicos
    SET VALOR_TOTAL = VALOR_PECAS + VALOR_HH
    WHERE ID_Os = NEW.NUM_OS;
END$$

DELIMITER ;