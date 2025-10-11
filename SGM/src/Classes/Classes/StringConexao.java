package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StringConexao {


    private static final String URL = "jdbc:mysql://127.0.0.1:3306/smg";
    private static final String USUARIO = "root";
    private static final String SENHA = "@Dev7851";


    public String testeInsert() {
        try (Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            return "BANCO CONECTADO !!!!";
        } catch (SQLException e) {
            return "ERRO AO CONECTAR AO BANCO" + e.getMessage();
        }
    }  	 
    public  void insertFuncionario(String nome,String cpf,String telefone,String senha,String tipo, double salario) {
        String sql = "INSERT INTO FUNCIONARIOS (NOME, CPF, TELEFONE, SENHA, TIPO, SALARIO) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setString(3, telefone);
            stmt.setString(4, senha);
            stmt.setString(5, tipo);
            stmt.setDouble(6, salario);
            
            
            stmt.executeUpdate();
            System.out.println("USUARIO CADASTRADO COM SUCESSO....");
        } catch (SQLException e) {
            System.out.println("ERRO NO CADASTRO" + e.getMessage());
        }
    }
    public  void insertCliente(String nome, String cpf, String telefone, String senha, String tipo, String moto_modelo,
			int moto_Ano, String moto_Placa) {
        String sql = "INSERT INTO CLIENTES (NOME, CPF, TELEFONE, SENHA, TIPO, MOTO_MODELO, MOTO_ANO, PLACA ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setString(3, telefone);
            stmt.setString(4, senha);
            stmt.setString(5, tipo);
            stmt.setString(6, moto_modelo);
            stmt.setInt(7, moto_Ano);
            stmt.setString(8, moto_Placa);
            
            stmt.executeUpdate();
            System.out.println("USUARIO CADASTRADO COM SUCESSO....");
        } catch (SQLException e) {
            System.out.println("ERRO NO CADASTRO" + e.getMessage());
        }
    }
    public  void insertPecas(String nomePeca, double valorPecas, String unid, int quat_Pecas, String tipo_elemento) {
        String sql = "INSERT INTO PECAS (NOME, VALOR PECA, UNIDADE, QUANTIDADE, TIPO_DO_ELEMENTO) VALUES (?, ?, ?, ?, ?)";

        try (Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, nomePeca);
            stmt.setDouble(2, valorPecas);
            stmt.setString(3, unid);
            stmt.setInt(4, quat_Pecas);
            stmt.setString(5, tipo_elemento);
 
            stmt.executeUpdate();
            System.out.println("PAÇA CADASTRADO COM SUCESSO....");
        } catch (SQLException e) {
            System.out.println("ERRO NO CADASTRO" + e.getMessage());
        }
    }
    
   
    
    
}
