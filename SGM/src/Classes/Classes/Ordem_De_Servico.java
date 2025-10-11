package Classes;

public class Ordem_De_Servico {
	
	Funcionario funcionario;
	Cliente cliente;
	int id;
	double valorTotal;
	double valorPecas;
	int  cargaHoraria;
	double custoHH;
	String Observacao;
	
	public Ordem_De_Servico(Funcionario funcionario, Cliente cliente,String observacao) {
		
		this.funcionario = funcionario;
		this.cliente = cliente;
		this.Observacao=observacao;
	}
	public Ordem_De_Servico() {
		super();
		this.funcionario = null;
		this.cliente = null;
		this.Observacao=null;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public double getValorPecas() {
		return valorPecas;
	}
	public void setValorPecas(double valorPecas) {
		this.valorPecas = valorPecas;
	}
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
	
		this.cargaHoraria = cargaHoraria;
	}
	
	public double calculo_HH(int cargaHoraria,Funcionario funcionario) {
		
			double hh=funcionario.getSalario()/220;
	
		return cargaHoraria*hh ;
	}
	
	public double getCustoHH() {
		calculo_HH(cargaHoraria,this.funcionario);
		return custoHH;
	}
	public void setCustoHH(double custoHH) {
		this.custoHH = calculo_HH(cargaHoraria,this.funcionario);;
	}

	public String getObservacao() {
		return Observacao;
	}
	public void setObservacao(String observacao) {
		Observacao = observacao;
	}
	@Override
	public String toString() {
		return "Ordem_De_Servico:" + id +" | Mecanico:" + funcionario + " | Cliente:" + cliente + 
				" | Valor Mão de Obra=" + custoHH+ " | Valor Pecas=" + valorPecas+" | Valor Total:"
				+ valorTotal  ;
	}

}
