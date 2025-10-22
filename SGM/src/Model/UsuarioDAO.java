package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexao.Conexao;


public class UsuarioDAO {
	
    public Usuario proc_Login(String cpf, String senha) {
        String sql = "CALL verif_cadastro(?, ?)";

        try (Connection conexao = Conexao.getConnection();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {
        	
            stmt.setString(1, cpf);
            stmt.setString(2, senha);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                	
                    if (rs.getMetaData().getColumnCount() > 1) {
                        System.out.println("QUE BOM QUE VOLTOU, " + rs.getString("NOME"));
                      
                        return returnObj(rs);
                        
                    } else {	
                        
                        System.out.println(rs.getString("mensagem"));
                        return null;
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro no login: " + e.getMessage());
            return null;
        }
        return null;
    }
	public  void insertFuncioanrio(Funcionario func) {
        String sql = "INSERT INTO USUARIOS (NOME, CPF, TELEFONE, SENHA, TIPO, SALARIO, MOTO_MODELO, MOTO_ANO, MOTO_PLACA)VALUES (?,?,?,?,?,?,?,?,?)";

        try (Connection conexao = Conexao.getConnection();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, func.getNome());
            stmt.setString(2, func.getCpf());
            stmt.setString(3, func.getTelefone());
            stmt.setString(4, func.getSenha());
            stmt.setString(5, func.getTipo());
            stmt.setFloat(6, func.getSalario());
            stmt.setString(7, null);
            stmt.setInt(8, 0);
            stmt.setString(9, null);
            
            stmt.executeUpdate();
            System.out.println("USUARIO CADASTRADO COM SUCESSO....");
        } catch (SQLException e) {
            System.out.println("ERRO NO CADASTRO" + e.getMessage());
        }
    }
    public  void insertCliente(Cliente cli) {
        String sql = "INSERT INTO USUARIOS (NOME, CPF, TELEFONE, SENHA, TIPO, SALARIO, MOTO_MODELO, MOTO_ANO, MOTO_PLACA)VALUES (?,?,?,?,?,?,?,?,?)";

        try (Connection conexao = Conexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, cli.getNome());
            stmt.setString(2, cli.getCpf());
            stmt.setString(3, cli.getTelefone());
            stmt.setString(4, cli.getSenha());
            stmt.setString(5, cli.getTipo());
            stmt.setFloat(6, 0);
            stmt.setString(7, cli.getMoto_modelo());
            stmt.setInt(8, cli.getMoto_Ano());
            stmt.setString(9, cli.getMoto_Placa());
            
            stmt.executeUpdate();
            System.out.println("USUARIO CADASTRADO COM SUCESSO....");
        } catch (SQLException e) {
            System.out.println("ERRO NO CADASTRO" + e.getMessage());
        }
    }
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
    private Usuario returnObj(ResultSet rs) throws SQLException {
    	
    	if(rs.getString(6)=="CLIENTE") {
    		Cliente cli=new Cliente();
    		cli.setId(rs.getInt(1));
    		cli.setNome(rs.getString(2));
    		cli.setCpf(rs.getString(3));
    		cli.setTelefone(rs.getString(4));
    		cli.setSenha(rs.getString(5));
    		cli.setTipo(rs.getString(6));
    		cli.setMoto_Ano(rs.getInt(9));
    		cli.setMoto_modelo(rs.getString(8));
    		cli.setMoto_Placa(rs.getString(10));
    		return cli;
    			
    	}else {
    		Funcionario func=new Funcionario();
    		func.setId(rs.getInt(1));
    		func.setNome(rs.getString(2));
    		func.setCpf(rs.getString(3));
    		func.setTelefone(rs.getString(4));
    		func.setSenha(rs.getString(5));
    		func.setTipo(rs.getString(6));
    		func.setSalario(rs.getFloat(7));
    		return func;
    	}
    }
    public void proc_Orca_P_usu(int id_os) {
        String sql = "CALL ORCAMENTO_porUsuario(?)";

        try (Connection conexao = Conexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id_os);

            try (ResultSet rs = stmt.executeQuery()) {
            	
            if (rs.next()) {
            	System.out.println("ORÇAMENTO:"+rs.getInt(1)+" | CLIENTE:"+rs.getString(2)+" | MODELO MOTO:"+rs.getString(3)+" "+rs.getString(4)+" | PLACA:"+rs.getString(5)+
            			" | VALOR PEÇAS:"+rs.getFloat(6)+" | VALOR MÃO DE OBRA:"+rs.getFloat(7)+" | VALOR TOTAL:"+rs.getFloat(8));         	                      
                    
            } else {
                System.out.println("Nenhum orçamento encontrado para o cliente de ID " + id_os);
            }

        }

    } catch (SQLException e) {
        System.out.println("Erro ao buscar orçamento: " + e.getMessage());
        e.printStackTrace(); 
    }
    }
    public Ordem_De_Servico relat_OrcaOBJ(int id_os) {
        String sql = "select * from ordem_de_servicos where id_os = ?";

        try (Connection conexao = Conexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id_os);

            try (ResultSet rs = stmt.executeQuery()) {
            	
            	Ordem_De_Servico os=new Ordem_De_Servico();
            		os.setId(rs.getInt(1));
            		os.setStatus(rs.getString(2));
            		os.setFuncionario(rs.getInt(3));
            		os.setCliente(rs.getInt(4));
            		os.setCargaHoraria(rs.getInt(5));
            		os.setValorPecas(rs.getFloat(6));
            		os.setCustoHH(rs.getFloat(7));
            		os.setValorTotal(rs.getFloat(8));
            		os.setObservacao(rs.getString(9));
       			
    				return os;
            }

        } catch (SQLException e) {
            System.out.println(" ORÇAMENTO NÃO ENCONTRADO....");
            
        }
		return null;
       
    }
    public Usuario return_usuario(int id_usuarios) {
        String sql = "SELECT * FROM USUARIOS WHERE ID_USUARIOS=? ";

        try (Connection conexao = Conexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id_usuarios);
            
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return returnObj(rs);
            }
        } catch (SQLException e) {
            System.out.println("Erro no login: " + e.getMessage());
            return null;
        }
    } catch (SQLException e1) {
		e1.printStackTrace();
	}
		return null;
    
    }
    public void removeUsuario(int id) {
    	 String sqlDeletePecas = """
    		        DELETE pu FROM pecas_usadas pu
    		        INNER JOIN ordem_de_servicos os ON pu.NUM_OS = os.ID_OS
    		        WHERE os.ID_CLIENTE = ? OR os.ID_FUNCIONARIO = ?
    		        """;

    		    String sqlDeleteOrdens = "DELETE FROM ordem_de_servicos WHERE ID_CLIENTE = ? OR ID_FUNCIONARIO = ?";
    		    String sqlDeleteUsuario = "DELETE FROM usuarios WHERE ID_USUARIOS = ?";

    		    try (Connection con = Conexao.getConnection()) {
    		        con.setAutoCommit(false);

    		        try (
    		            PreparedStatement psPecas = con.prepareStatement(sqlDeletePecas);
    		            PreparedStatement psOrdens = con.prepareStatement(sqlDeleteOrdens);
    		            PreparedStatement psUsuario = con.prepareStatement(sqlDeleteUsuario)
    		        ) {

    		            // 1️⃣ Deleta peças usadas
    		            psPecas.setInt(1, id);
    		            psPecas.setInt(2, id);
    		            psPecas.executeUpdate();

    		            // 2️⃣ Deleta ordens do usuário
    		            psOrdens.setInt(1, id);
    		            psOrdens.setInt(2, id);
    		            psOrdens.executeUpdate();

    		            // 3️⃣ Deleta o usuário
    		            psUsuario.setInt(1, id);
    		            int linhasAfetadas = psUsuario.executeUpdate();

    		            con.commit();

    		            if (linhasAfetadas > 0) {
    		                System.out.println(" USUÁRIO REMOVIDOS COM SUCESSO!");
    		            } else {
    		                System.out.println(" Nenhum usuário encontrado com esse ID.");
    		            }

    		        } catch (SQLException e) {
    		            con.rollback();
    		            System.out.println(" Erro ao remover usuário e dependências (rollback): " + e.getMessage());
    		        } finally {
    		            con.setAutoCommit(true);
    		        }

    		    } catch (SQLException e) {
    		        System.out.println(" Erro de conexão: " + e.getMessage());
    		    }
    	
    	
    }
    public void count_usu() {
        String sql = "SELECT COUNT(1) AS usuarios FROM usuarios";
        try (Connection conexao = Conexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) { 
                int cont = rs.getInt("usuarios");
                System.out.println("TOTAL DE USUARIOS: " + cont);
            } else {
                System.out.println("TOTAL DE USUARIOS: 0");
            }

        } catch (SQLException e) {
            System.out.println("ERRO NA BUSCA: " + e.getMessage());
        }
    }
    public void updat_usu(int idUsuario, String coluna, String novoValor) {
    	
    	    String sql = "UPDATE usuarios SET " + coluna + " = ? WHERE ID_USUARIOS = ?";

    	    try (Connection conexao = Conexao.getConnection();
    	         PreparedStatement stmt = conexao.prepareStatement(sql)) {

    	        
    	        stmt.setString(1, novoValor);
    	        stmt.setInt(2, idUsuario);

    	        int linhasAfetadas = stmt.executeUpdate();

    	        if (linhasAfetadas > 0) {
    	            System.out.println("✅ Usuário atualizado com sucesso!");
    	        } else {
    	            System.out.println("⚠️ Nenhum usuário encontrado com esse ID.");
    	        }

    	    } catch (SQLException e) {
    	        System.out.println("ERRO AO ATUALIZAR: " + e.getMessage());
    	    }
    	}
    
    
    
}