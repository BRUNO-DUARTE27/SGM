package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/smg";
    private static final String USUARIO = "root";
    private static final String SENHA = "@Dev7851";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
    
    //MAIN DESENVOLVIDO PARA TESTE DE CONXAO
    
    public static void main(String[] args) {
        try (Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            System.out.println("BANCO CONECTADO !!!!");
        } catch (SQLException e) {
        	System.out.println("ERRO AO CONECTAR AO BANCO" + e.getMessage());
        }
    }  	

}
