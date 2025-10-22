package reports;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexao.Conexao;
import Model.Pecas;

public class RelatoriosPecas {

    
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
    
    

}
