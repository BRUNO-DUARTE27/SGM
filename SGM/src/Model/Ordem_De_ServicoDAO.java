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
    	                System.out.println("ORDEM E PEÇAS REMOVIDAS COM SUCESSO!");
    	            } else {
    	                System.out.println("NENHUMA OS ENCONTRADA COM ESTE ID");
    	            }

    	        } catch (SQLException e) {
    	            con.rollback();
    	            System.out.println("ERRO AO REMOVER  " + e.getMessage());
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
