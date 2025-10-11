package Classes;

public class Funcionario extends Usuario {
	
	private double salario;
	private String data_contratacao;

	public Funcionario(String nome, String cpf, String telefone, String senha,double salario, String data_contratacao, String tipo) {
		super(nome,cpf,telefone,senha,tipo="Funcionario");
		
		this.salario 			= salario;
		this.data_contratacao 	= data_contratacao;
	}

	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getData_contratacao() {
		return data_contratacao;
	}
	public void setData_contratacao(String data_contratacao) {
		this.data_contratacao = data_contratacao;
	}
	

}
