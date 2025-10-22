package controller;

import Model.Usuario;
import Model.UsuarioDAO;

import reports.RelatoriosUsu;
import Model.Funcionario;

import Model.Cliente;



public class Control_Usuario {
	
	
	private static UsuarioDAO usuDAO=new UsuarioDAO();
		
	public void cadastro(int tipo_usuario, Usuario usu) {
		
	 if(tipo_usuario==1) {
		 	usuDAO.insertFuncioanrio((Funcionario) usu);
		 }else {
			 usuDAO.insertCliente((Cliente) usu);
		 }
	 
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
