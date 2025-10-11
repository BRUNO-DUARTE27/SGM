package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StringConexao {

    public static void main(String[] args) {
        // Dados da conexão
        String url = "jdbc:mysql://127.0.0.1:3306/smg";
        String usuario = "root";
        String senha = "@Dev7851";

        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("✅ Conectado com sucesso ao banco de dados!");
            
            
            
            
            /*
            // SQL de inserção
            String sql = "INSERT INTO USUARIOS (NOME, CPF, TELEFONE) VALUES (?, ?, ?)";

            // Prepara o comando
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, "Bruno Oliveira");  // nome
            stmt.setString(2, "123.456.789-00");  // cpf
            stmt.setString(3, "(27) 99999-0000"); // telefone

            // Executa o comando
            stmt.executeUpdate();
            System.out.println("✅ Usuário inserido com sucesso!");
			
            // Fecha a conexão
            stmt.close();
            
            
            
            

            // Cria o comando SQL
            String sql = "SELECT * FROM USUARIOS";

            // Executa o comando
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Percorre o resultado
            System.out.println("\n📋 Lista de usuários cadastrados:");
            System.out.println("----------------------------------");

            while (rs.next()) {
                String nome = rs.getString("NOME");
                String cpf = rs.getString("CPF");
                String telefone = rs.getString("TELEFONE");

                System.out.println("Nome: " + nome);
                System.out.println("CPF: " + cpf);
                System.out.println("Telefone: " + telefone);
                System.out.println("----------------------------------");
            }

            // Fecha conexões
            rs.close();
            stmt.close();
            */
            
            
            
            
            
            
            
            
            conexao.close();
        } catch (SQLException e) {
            System.out.println("❌ Erro ao conectar: " + e.getMessage());
        }
    }
}
