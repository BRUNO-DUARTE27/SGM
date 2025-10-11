package Classes;

public class Funcionario extends Usuario {
	
	private double salario;
	

	public Funcionario(String nome, String cpf, String telefone, String senha, String tipo,double salario) {
		super(nome,cpf,telefone,senha,tipo);
		
		this.salario 			= salario;
		
	}
	
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}	

}
