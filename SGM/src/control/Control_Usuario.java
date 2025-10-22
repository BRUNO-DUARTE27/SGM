package control;

import Model.Usuario;
import Model.UsuarioDAO;
import Model.Funcionario;
import Model.PecasDAO;
import Model.Cliente;
import java.util.Scanner;


public class Control_Usuario {
	
	private static Scanner scan=new Scanner(System.in);
	private static UsuarioDAO usuDAO=new UsuarioDAO();
	private static PecasDAO pecaDAO =new PecasDAO();
	
	public Usuario loginn(String cpf,String senha) {
		
		return usuDAO.proc_Login(cpf, senha);
	
	}	
	public void cadastro(int tipo_usuario, Usuario usu) {
		
	 if(tipo_usuario==1) {
		 	usuDAO.insertFuncioanrio((Funcionario) usu);
		 }else {
			 usuDAO.insertCliente((Cliente) usu);
		 }
	 
	}
	public void lancamentoHora( ) {
		
		System.out.println("----------------- ALOCAR INSUMOS PECAS -----------------\n");

		//osDAO.relat_orcaGeral();
		
		System.out.println("\nINSIRA O ID QUE VAMOS ALTERA");
		System.out.println("ID OS:");
		int id_os=scan.nextInt();
		
		
		pecaDAO.relat_Pecas();
		while(true) {
			System.out.println("\nINSIRA O ID PARA ALOCAR A PEÇAS OU 0 PARA PULAR ESTA ETAPA");
			System.out.println("DIGITE O ID PEÇAS:");
			int id_pecas=scan.nextInt();
			if(id_pecas==0) {
				break;
			}else {
			System.out.println("QUANT. PEÇAS:");
			int quant_pecas=scan.nextInt();
			pecaDAO.insertPecasUsadas(id_os, id_pecas, quant_pecas);
			
			}
			
		}
		
		
	}
	public void relatorioCliente() {
		usuDAO.vw_Clientes();
	}
	public void relatorioFuncionario() {
		usuDAO.vw_Funcionario();
	}
	public Usuario return_usuario(int id_usuarios) {
		return usuDAO.return_usuario(id_usuarios);
	}
	public void removeUsuario(int id) {
		usuDAO.removeUsuario(id);
	}
	public void cont_usu() {
		usuDAO.count_usu();
	}
	
	public void atuli_usu(int idUsuario, String coluna, String novoValor) {
		usuDAO.updat_usu(idUsuario, coluna, novoValor);
	}
	
	
	
	
}
