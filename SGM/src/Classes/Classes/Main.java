package Classes;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static Scanner scan=new Scanner(System.in);
	static ArrayList<Usuario> list_usuarios = new ArrayList<>();
	static ArrayList<Pecas> list_Pecas = new ArrayList<>();
	static ArrayList<Ordem_De_Servico> ordemServico = new ArrayList<>();
	
	public static void main(String[] args) {
		
		
	//CRIAÇÃO DO FUNCIONARIO PARA TESTE.
	Funcionario funcionario = new Funcionario("BRUNO","166","997589528","000","FUNCIONARIO",5000);
	Cliente cliente= new Cliente( "UDI","171","998877225","111","CLIENTE", "TITAN 150", 2012, "R1010");
	Pecas peca =new Pecas("PARAFUSO",10,"UN",50,"FIXAÇÃO");
	list_usuarios.add(funcionario);
	list_usuarios.add(cliente);
	list_Pecas.add(peca);
	StringConexao conet =new StringConexao();
	
	
	
	Tela tela=new Tela();
		
		while(true) {
		
		menu(tela);
		login(tela);
		}
	
	}
	

	public static void menu(Tela tela) {
		
		while(true) {
		int opcao=tela.tela_menu();
		
		if(opcao==1) {
			break;
		}else if(opcao==2) {
			tela.tela_cadastro(list_usuarios);
		}else {
			System.out.println("CODIGO ERRADO, TENTE NOVAMENTE");
			
			}
		}
	}
	public static void login(Tela tela) {
			
		int id=tela.tela_login(list_usuarios);
		
		if(id==-1) {
			
			return;
			
		}else {
	
			if("FUNCIONARIO".equals(list_usuarios.get(id).getTipo())) {
				
				tela_funcionario(id,tela);
				
				
			}else if("CLIENTE".equals(list_usuarios.get(id).getTipo())) {
			
				tela_cliente();
			
				}
			}	
		}



	private static void tela_cliente() {
		
		System.out.println("AINDA EM DESENSOVIMENTO");
		
	}


	private static void tela_funcionario(int id, Tela tela) {
	    while (true) {
	        int opcao = tela.tela_Funcionario(id, list_usuarios, list_Pecas);
	        System.out.println(opcao);
	        
	        if (opcao == 0) {
	            break;
	        } else if (opcao == 1) {
	            tela.estoque(list_Pecas);
	        } else if (opcao == 2) {
	            tela.lancamentoHora(list_usuarios, list_Pecas, ordemServico, ordemServico);
	        } else if (opcao == 3) {
	            // Chama o método para criar a Ordem de Serviço
	            tela.criaOS(list_usuarios, ordemServico, id);
	        }
	    }
	}

	
}
