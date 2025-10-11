package Classes;

public class Cliente extends Usuario {
	
	private int 	valor_orcamento;
	private String 	moto_modelo;
	private String 	moto_Ano;
	private String 	moto_Placa;
	
	public Cliente(String nome, String cpf, String numero, String senha, int valor_orcamento, String moto_modelo,
			String moto_Ano, String moto_Placa, String tipo) {
		
		super(nome, cpf, numero, senha, tipo="Cliente");
		this.valor_orcamento 	= valor_orcamento;
		this.moto_modelo 		= moto_modelo;
		this.moto_Ano 			= moto_Ano;
		this.moto_Placa 		= moto_Placa;
	}
	
	public int getValor_orcamento() {
		return valor_orcamento;
	}
	public void setValor_orcamento(int valor_orcamento) {
		this.valor_orcamento = valor_orcamento;
	}
	public String getMoto_modelo() {
		return moto_modelo;
	}
	public void setMoto_modelo(String moto_modelo) {
		this.moto_modelo = moto_modelo;
	}
	public String getMoto_Ano() {
		return moto_Ano;
	}
	public void setMoto_Ano(String moto_Ano) {
		this.moto_Ano = moto_Ano;
	}
	public String getMoto_Placa() {
		return moto_Placa;
	}
	public void setMoto_Placa(String moto_Placa) {
		this.moto_Placa = moto_Placa;
	}
	
	
	
	

}
