package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexao.Conexao;

public class Ordem_De_ServicoDAO {
	
    public  void insertOrdemServico(Ordem_De_Servico os) {
        String sql = "INSERT INTO ORDEM_DE_SERVICOS (STATUS, ID_FUNCIONARIO, ID_CLIENTE, CARGA_HORARIA, VALOR_PECAS,VALOR_HH,VALOR_TOTAL,OBSERVACAO)VALUES (?,?,?,?,?,?,?,?)";

        try (Connection conexao = Conexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {


            stmt.setString(1, os.getStatus());
            stmt.setInt(2, os.getFuncionario());
            stmt.setInt(3,os.getCliente());
            stmt.setInt(4,os.getCargaHoraria());
            stmt.setFloat(5,os.getValorPecas());
            stmt.setFloat(6,os.getCustoHH());
            stmt.setFloat(7,os.getValorTotal());
            stmt.setString(8,os.getObservacao());
 
            stmt.executeUpdate();
            System.out.println("OS CADASTRADA COM SUCESSO....");
        } catch (SQLException e) {
            System.out.println("ERRO NO CADASTRO" + e.getMessage());
        }
    } 
  
    public void relat_orcaUsuario(int id) {
        String sql = "SELECT * FROM ORDEM_DE_SERVICOS WHERE ID_CLIENTE = ? AND STATUS = 'ANDAMENTO'";

        try (Connection conexao = Conexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.isBeforeFirst()) {
                    System.out.println("SEM ORÇAMENTO !!!");
                    return;
                }

                while (rs.next()) {
                	System.out.println("ORDEM DE SERVIÇO:"+rs.getInt(1)+" | CLIENTE:"+rs.getString(3)+" | MODELO MOTO:"+rs.getString(3)+" "+rs.getString(4)+" | PLACA:"+rs.getString(5)+
                			" | VALOR PEÇAS:"+rs.getFloat(6)+" | VALOR MÃO DE OBRA:"+rs.getFloat(7)+" | VALOR TOTAL:"+rs.getFloat(8)); 
                }
            }

        } catch (SQLException e) {
            System.out.println("ERRO NA BUSCA: " + e.getMessage());
        }
    } 
    public void relat_orcaGeral() {
        String sql = " SELECT \r\n"
        		+ "        OS.ID_OS AS 'NUM OS',\r\n"
        		+ "        USU.NOME AS 'CLIENTE',\r\n"
        		+ "        USU.MOTO_MODELO AS 'MODELO DA MOTO',\r\n"
        		+ "        USU.MOTO_ANO AS 'ANO',\r\n"
        		+ "        USU.MOTO_PLACA AS 'PLACA',\r\n"
        		+ "        OS.VALOR_PECAS AS 'VALOR PEÇAS',\r\n"
        		+ "        OS.VALOR_HH AS 'VALOR MÃO DE OBRA',\r\n"
        		+ "        OS.VALOR_TOTAL AS 'VALOR TOTAL'\r\n"
        		+ "    FROM \r\n"
        		+ "        ORDEM_DE_SERVICOS OS\r\n"
        		+ "        INNER JOIN USUARIOS USU ON OS.ID_CLIENTE = USU.ID_USUARIOS\r\n"
        		+ "   ";

        try (Connection conexao = Conexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.isBeforeFirst()) {
                    System.out.println("SEM ORÇAMENTO ABERTO");
                    return;
                }

                while (rs.next()) {
                	System.out.println("ORDEM DE SERVIÇO:"+rs.getInt(1)+" | CLIENTE:"+rs.getString(2)+" | MODELO MOTO:"+rs.getString(3)+" "+rs.getString(4)+" | PLACA:"+rs.getString(5)); 
                }
            }

        } catch (SQLException e) {
            System.out.println("ERRO NA BUSCA: " + e.getMessage());
        }
    }
    public void removeOrdemServico(int idOs) {
    	
    	    String sqlDeletePecas = "DELETE FROM pecas_usadas WHERE NUM_OS = ?";
    	    String sqlDeleteOrdem = "DELETE FROM ordem_de_servicos WHERE ID_OS = ?";

    	    try (Connection con = Conexao.getConnection()) {
    	        con.setAutoCommit(false); 

    	        try (PreparedStatement psPecas = con.prepareStatement(sqlDeletePecas);
    	             PreparedStatement psOrdem = con.prepareStatement(sqlDeleteOrdem)) {

    	            
    	            psPecas.setInt(1, idOs);
    	            psPecas.executeUpdate();

    	            psOrdem.setInt(1, idOs);
    	            int linhasAfetadas = psOrdem.executeUpdate();

    	            con.commit();

    	            if (linhasAfetadas > 0) {
    	                System.out.println("✅ ORDEM E PEÇAS REMOVIDAS COM SUCESSO!");
    	            } else {
    	                System.out.println("⚠️ Nenhuma ordem encontrada com esse ID.");
    	            }

    	        } catch (SQLException e) {
    	            con.rollback();
    	            System.out.println("❌ Erro ao remover ordem e peças (rollback): " + e.getMessage());
    	        } finally {
    	            con.setAutoCommit(true);
    	        }

    	    } catch (SQLException e) {
    	        System.out.println("❌ Erro de conexão: " + e.getMessage());
    	    
    	}

    	
    }
    public void count_OS() {
        String sql = "SELECT COUNT(1) AS ordem_de_servicos FROM ordem_de_servicos";
        try (Connection conexao = Conexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) { 
                int cont = rs.getInt("ordem_de_servicos");
                System.out.println("TOTAL DE ORDEM DE SERVIÇO: " + cont);
            } else {
                System.out.println("TOTAL DE ORDEM DE SERVIÇO: 0");
            }

        } catch (SQLException e) {
            System.out.println("ERRO NA BUSCA: " + e.getMessage());
        }
    }
    public void atualizarOrdemServico(int idOS, String coluna, String novoValor) {
        String sql = "UPDATE ordem_de_servicos SET " + coluna + " = ? WHERE ID_OS = ?";

        try (Connection conexao = Conexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, novoValor);
            stmt.setInt(2, idOS);

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("ORDEM DE SERVIÇO ATUALIZADO");
            } else {
                System.out.println("OS NÃO ENCONTRADA");
            }

        } catch (SQLException e) {
            System.out.println("ERRO AO ATUALIZAR ORDEM: " + e.getMessage());
        }
    }

	


}
