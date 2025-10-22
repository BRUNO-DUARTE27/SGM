package control;

import Model.Ordem_De_Servico;
import Model.Ordem_De_ServicoDAO;
import Model.Usuario;

public class Control_Ordem_De_Serico {
	
	private static Ordem_De_ServicoDAO osDAO=new Ordem_De_ServicoDAO();
	
	
	public void criaOS( Ordem_De_Servico os) {
		osDAO.insertOrdemServico(os);
	}
	public void finalizarOS() {	
	}
	public  void relatorioCliente( Usuario usu) {
		osDAO.relat_orcaUsuario(usu.getId());
	}
	public void relatorioGeralOS() {
		osDAO.relat_orcaGeral();
	}
	public void removeOS(int id) {
		osDAO.removeOrdemServico(id);
	}
	public void cont_os() {
		osDAO.count_OS();
	}
	public void atualiazarso(int idOS, String coluna, String novoValor) {
		osDAO.atualizarOrdemServico(idOS, novoValor, novoValor);
	}
	
	
	
}
