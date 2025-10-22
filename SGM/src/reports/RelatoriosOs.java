package reports;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexao.Conexao;

public class RelatoriosOs {
	
	   public void relat_OsCompleto() {
	        String sql = "SELECT * FROM ORDEM_DE_SERVICOS '";

	        try (Connection conexao = Conexao.getConnection();
	             PreparedStatement stmt = conexao.prepareStatement(sql)) {

	            

	            try (ResultSet rs = stmt.executeQuery()) {
	                if (!rs.isBeforeFirst()) {
	                    System.out.println("SEM OS !!!");
	                    return;
	                }

	                while (rs.next()) {
	                	System.out.println("ORDEM DE SERVIÇO:"+rs.getInt(1)+" | CLIENTE:"+rs.getString(3)+" | MODELO MOTO:"+rs.getString(3)+" "+rs.getString(4)+" | PLACA:"+rs.getString(5)+
	                			" | VALOR PEÇAS:"+rs.getFloat(6)+" | VALOR MÃO DE OBRA:"+rs.getFloat(7)+" | VALOR TOTAL:"+rs.getFloat(8)); 
	                }
	            }

	        } catch (SQLException e) {
	            System.out.println("OS NÃO ENCONTRADA");
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
	                    System.out.println("SEM OS ABERTO");
	                    return;
	                }

	                while (rs.next()) {
	                	System.out.println("ID OS:"+rs.getInt(1)+" | CLIENTE:"+rs.getString(2)+" | MODELO MOTO:"+rs.getString(3)+" "+rs.getString(4)+" | PLACA:"+rs.getString(5)); 
	                }
	            }

	        } catch (SQLException e) {
	            System.out.println("ERRO NA BUSCA: " + e.getMessage());
	        }
	    }

}
