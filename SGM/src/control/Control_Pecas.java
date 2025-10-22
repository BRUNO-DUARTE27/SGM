package control;



import Model.Pecas;
import Model.PecasDAO;


public class Control_Pecas {
	
	private static PecasDAO pecaDAO =new PecasDAO();

	
	
	
	public void lancamentoPecas(int id_os, int id_pecas, int quant_pecas ) {	
			pecaDAO.insertPecasUsadas(id_os, id_pecas, quant_pecas);
	}
	public void cadastrarPecas(Pecas peca) {
		 pecaDAO.insertPecas(peca);
	}
	public void removerPecas(int id) {
				pecaDAO.proc_RemovePecas(id);
	}
	public void relatorio_pecas() {
		pecaDAO.relat_Pecas();
	}
	public void relatorio_pecas_usadas(int id) {
		pecaDAO.relat_pecas_usadas(id);
	}
	public void relatorio_pecas_tipo() {
		pecaDAO.vw_pecaTipo();
	}

	public void removePecasU(int numOS, int idPeca,int quant) {
		pecaDAO.removePecaUsada(numOS, idPeca, quant);
	}
	public void cont_pecas() {
		pecaDAO.count_pecas();
	}
	public void atualizarpecas(int idPeca, String coluna, String novoValor) {
		pecaDAO.atualizarPeca(idPeca, coluna, novoValor);
	}
	
}
