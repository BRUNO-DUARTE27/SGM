package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexao.Conexao;

public class PecasDAO {
    public  void insertPecas(Pecas pecas) {
        String sql = "INSERT INTO PECAS(NOME, VALOR_PECAS, UNIDADE, QUANTIDADE, VALOR_UNIDADE, TIPO_ELEMENTO)VALUES(?,?,?,?,?,?)";

        try (Connection conexao = Conexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {


            stmt.setString(1, pecas.getNomePeca());
            stmt.setFloat(2, pecas.getValorPecas());
            stmt.setString(3, pecas.getUnid());
            stmt.setInt(4, pecas.getQuat_Pecas());
            stmt.setFloat(5,pecas.getValor_unid());
            stmt.setString(6,pecas.getTipo_elemento());
 
            stmt.executeUpdate();
            System.out.println("PAÇA CADASTRADO COM SUCESSO....");
        } catch (SQLException e) {
            System.out.println("ERRO NO CADASTRO" + e.getMessage());
        }
    }
    
    public  void insertPecasUsadas(int id_os,int id_pecas,int quant_pecas) {
        String sql = "INSERT INTO PECAS_USADAS (NUM_OS, ID_PECAS,QUANT_PEÇAS) VALUES (?,?,?)";

        try (Connection conexao = Conexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1,id_os);
            stmt.setInt(2,id_pecas); 
            stmt.setInt(3, quant_pecas); 
 
            stmt.executeUpdate();
            System.out.println("EXECUTADO O REGISTRO NA OS "+id_os);
        } catch (SQLException e) {
            System.out.println("ERRO AO REGISTRAR " + e.getMessage());
        }
    } 
    public void proc_RemovePecas(int id_peca) {
        String sql = "CALL REMOVER_PECAS(?)";

        try (Connection conexao = Conexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id_peca);

            try (ResultSet rs = stmt.executeQuery()) {
            	
             System.out.println("PEÇA REMOVIDA COM SUCESSO!!");
                                        
            }

        } catch (SQLException e) {
            System.out.println("Erro no login: " + e.getMessage());
            
        }
       
    }
    public void vw_pecaTipo() {
 	   
	    String sql = "select * from relatorio_pecas";

	    try (Connection conexao = Conexao.getConnection();
	         PreparedStatement stmt = conexao.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery()) {

	        if (!rs.isBeforeFirst()) {
	            System.out.println("SEM PEÇAS DISPONÍVEIS");
	            return;
	        }

	        System.out.println("------------- PEÇAS POR TIPO -------------");

	        while (rs.next()) {

	        	System.out.println("TIPO DE ELEMENTO:"+rs.getString(1)+" | ESTOQUE UNI:"+rs.getInt(2)+" "+rs.getString(3)+" | VALOR MEDIO:"+rs.getFloat(4));

	        }

	    } catch (SQLException e) {
	        System.out.println("ERRO AO CONSULTAR A VIEW");
	    }
    }
    public void relat_Pecas() {
        String sql = "SELECT * FROM PECAS WHERE QUANTIDADE>0";
      

        try (Connection conexao = Conexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

        	
        	if(!rs.isBeforeFirst()) {
        		System.out.println("SEM PEÇA CADASTRADA !!!");
        	}else {
        
        		System.out.println("------------------- LISTA DE PECAS -------------------");
        		
        	while (rs.next()) {
                Pecas peca =new Pecas(rs.getString(2),rs.getFloat(3),rs.getString(4),rs.getInt(5),rs.getFloat(6),rs.getString(7));
                System.out.println("ID="+rs.getString(1)+" "+peca.toString());
                
        	}
            }

        } catch (SQLException e) {
            System.out.println("ERRO NA BUSCA ");
        }

      
        }
    public void relat_pecas_usadas(int id_os) {
        String sql = " select  pecas_usadas.NUM_OS,pecas.NOME,pecas_usadas.QUANT_PEÇAS,pecas_usadas.CUSTO\r\n"
        		+ "from pecas_usadas\r\n"
        		+ "inner join  pecas on pecas_usadas.ID_PECAS = pecas.ID_PECAS\r\n"
        		+ "where NUM_OS=?";

        try (Connection conexao = Conexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
        	
        	  stmt.setInt(1, id_os);
        	
        		
            try (ResultSet rs = stmt.executeQuery()) {
            		System.out.println("------------- INSUMOS DA OS "+id_os+" -------------");
                while (rs.next()) {
                	System.out.println("ORDEM DE SERVIÇO:"+rs.getInt(1)+" | NOME PEÇAS:"+rs.getString(2)+" | QUANTIDADE:"+rs.getInt(3)+" | CUSTO:"+rs.getFloat(4)); 
                
            }

        } catch (SQLException e) {
            System.out.println("ERRO NA BUSCA: " + e.getMessage());
        }
    } catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    } 
    public void removePecaUsada(int numOS, int idPeca,int quant) {
	    String sql = "DELETE FROM pecas_usadas WHERE NUM_OS = ? AND ID_PECAS = ? AND QUANT_PEÇAS=?";
	    
	    try (Connection conexao = Conexao.getConnection();
	             PreparedStatement stmt = conexao.prepareStatement(sql)) {
	        
	        stmt.setInt(1, numOS);
	        stmt.setInt(2, idPeca);
	        stmt.setInt(3, quant);
	        int linhasAfetadas = stmt.executeUpdate();
	        
	        if(linhasAfetadas > 0) {
	        	System.out.println("PEÇA USADA REMOVIDA COM SUCESSO");
	        }else if(linhasAfetadas == 0) {
	        	System.out.println("INSUMO NÃO ENCONTRADO");
	        }
	        
	    } catch (SQLException e) {
	        System.out.println("Erro ao remover peça usada: " + e.getMessage());
	        
	    }
	}
    public void count_pecas() {
        String sql = "SELECT COUNT(1) AS PECAS FROM PECAS";
        try (Connection conexao = Conexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) { 
                int cont = rs.getInt("pecas");
                System.out.println("TOTAL DE PEÇAS: " + cont);
            } else {
                System.out.println("TOTAL DE PEÇAS: 0");
            }

        } catch (SQLException e) {
            System.out.println("ERRO NA BUSCA: " + e.getMessage());
        }
    }
    public void atualizarPeca(int idPeca, String coluna, String novoValor) {

        String sql = "UPDATE pecas SET " + coluna + " = ? WHERE ID_PECA = ?";

        try (Connection conexao = Conexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, novoValor);
            stmt.setInt(2, idPeca);

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("✅ Peça atualizada com sucesso!");
            } else {
                System.out.println("⚠️ Nenhuma peça encontrada com esse ID.");
            }

        } catch (SQLException e) {
            System.out.println("ERRO AO ATUALIZAR PEÇA: " + e.getMessage());
        }
    }
    
    
    
}
