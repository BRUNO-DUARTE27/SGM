package reports;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexao.Conexao;

public class RelatoriosUsu {
	
	public void vw_Clientes() {
	 	   
	    String sql = "SELECT * FROM RELATORIO_CLIENTE";

	    try (Connection conexao = Conexao.getConnection();
	         PreparedStatement stmt = conexao.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery()) {

	        if (!rs.isBeforeFirst()) {
	            System.out.println("SEM CLIENTES CADASTRADOS");
	            return;
	        }

	        System.out.println("------------- CLIENTES CASTRADOS -------------");

	        while (rs.next()) {

	        	System.out.println("ID: "+rs.getString(1)+" | NOME:"+rs.getString(2)+" | MOTO:"+rs.getString(8)+" | PLACA "+rs.getString(10));
	        }

	    } catch (SQLException e) {
	        System.out.println("ERRO AO CONSULTAR A VIEW: " + e.getMessage());
	    }
	
	}
	public void vw_Funcionario() {
	 	   
	    String sql = "SELECT * FROM RELATORIO_FUNCIONARIO";

	    try (Connection conexao = Conexao.getConnection();
	         PreparedStatement stmt = conexao.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery()) {

	        if (!rs.isBeforeFirst()) {
	            System.out.println("SEM FUNCIONARIOS CADASTRADOS");
	            return;
	        }

	        System.out.println("------------- FUNCIONARIOS CASTRADOS -------------");

	        while (rs.next()) {

	        	System.out.println("ID: "+rs.getString(1)+" | NOME:"+rs.getString(2));
	        }

	    } catch (SQLException e) {
	        System.out.println("ERRO AO CONSULTAR A VIEW: " + e.getMessage());
	    }
	
	}
	public void relatorioG() {
		vw_Clientes();
		vw_Funcionario();
	}
}
