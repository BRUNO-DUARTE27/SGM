package Classes;

import java.util.ArrayList;
import java.util.Scanner;


public class Tela {
	static Scanner scan=new Scanner(System.in);
	

	public int tela_menu() {
		System.out.println("----------------- MENU -----------------");
		System.out.println("1- LOGIN\n"
				+ "2- CADASTRO DE NOVO USUARIO");
		
		return scan.nextInt();
	}

	public void tela_cadastro(ArrayList<Usuario> list_usuarios) {

		//PENDENTE CRIAR O CLIENTE
		
		System.out.println("----------------- CADASTRO DE USUARIO -----------------");
		
		System.out.print("NOME:");
		String nome		=scan.next().toUpperCase();
		System.out.print("CPF:"); 
		String cpf			=scan.next();
		System.out.print("TELEFONE:");
		String telefone	=scan.next().trim();
		System.out.print("SENHA:");
		String senha		=scan.next();
		System.out.println("1- FUNCIONARIO\n"
				+ "2- CLIENTE");
		int tipo_usuario	=scan.nextInt();
		
		 if(tipo_usuario==1) {
			 
			 String tipo="FUNCIOANRIO";
			 System.out.print("Salario do Coloborador:");
			 Double salario	=scan.nextDouble();
			 
			 Funcionario funcionario = new Funcionario(nome,cpf,telefone,senha,tipo,salario);
			 list_usuarios.add(funcionario); 
			 System.out.println("Funcionário cadastrado com sucesso!");
			 return;
			 
			 
			 
		 }else if (tipo_usuario==2) {
			 String tipo="CLIENTE";
			 
			 System.out.println("Modelo da moto");
			 String 	moto_modelo=scan.next();
			 System.out.println("Modelo da Ano");
			 int 	moto_Ano=scan.nextInt();
			 System.out.println("Modelo da Placa");
			 String 	moto_Placa=scan.next();
			 System.out.println("Novo Cliente cadastrado com sucesso!");
			  Cliente cliente= new Cliente( nome,cpf,telefone,senha,tipo, moto_modelo, moto_Ano, moto_Placa);
			 list_usuarios.add(cliente); 
			 
				return;
		 }
		 
	}

	public int tela_login(ArrayList<Usuario> list_usuarios) {
		
		System.out.println("----------------- LOGIN DE USUARIO -----------------");
		
		System.out.print("CPF DO USUARIO :");
		String cpf		=scan.next();
		
		System.out.print("SENHA :");
		String senha	=scan.next();
		
		int id=verifica_deCadastro(cpf,senha,list_usuarios);
		if(id == -1) {
			System.out.println("USUARIO NÃO ENCONTRADO, FAÇA SEU CADASTRO");
			return -1;
		}else if(id== -2) {
			System.out.println("SENHA INCORRETA ");
			return -1;
			
		}else if(id==-3) {
			System.out.println("USUSARIO NÃO CADASTRADO");
			return -1;
		}
		else {
			System.out.println("Olá "+ list_usuarios.get(id).getNome());
			return id;
		}
		
	}
	
	public  int tela_Funcionario(int id, ArrayList<Usuario> list_usuarios, ArrayList<Pecas> list_Pecas) {
		System.out.println("----------------- BEM VINDO AO SGM -----------------");
			
		System.out.println("0- Sair\n"
				+ "1- ESTOQUE\n"
				+ "2- LANÇAMENTO DE HORA E INSUMO\n"
				+ "3- CRIAR O.S");
		
		
	
		return scan.nextInt();
	}
	

	public void lancamentoHora( ArrayList<Usuario> list_usuarios, ArrayList<Pecas> list_Pecas, ArrayList<Ordem_De_Servico> ordemServico, ArrayList<Ordem_De_Servico> ordemServico2) {
		
		System.out.println("-----------------LANÇAMENTO DE HORA E INSUMO-----------------");
		
		ordemServico.toString();
		
		System.out.print("Qual os vai finalizar N° O.S: ");
		int os=scan.nextInt();
		ordemServico.get(os).toString();
		
		System.out.print("Quantas horas gastas na atividade: ");
		int horas=scan.nextInt();
		ordemServico.get(os).setCargaHoraria(horas);
		
		
		
		
	}

	public  void tela_Cliente(int id, ArrayList<Usuario> list_usuarios) {
		System.out.println("-----------------BEM VINDO "+ list_usuarios.get(id).getNome()+"-----------------");
				
	}
	

	public void estoque(ArrayList<Pecas> list_Pecas) {
		
	System.out.println("------------- GERENCIAMENTO DE ESTOQUE -------------");
		
		System.out.println("0- SAIR\n"
				+ "1- RELATORIO GERAL PECAS\n"
				+ "2- RELATORIO POR TIPO DE PECA\n"
				+ "3- CADASTRO DE PEÇAS\n"
				+ "4- REMOVER PEÇA\n"
				+ "5- REFRESH");
		int opcao=scan.nextInt();
		if(opcao==1) {
			if(list_Pecas.size()==0) {
				System.out.println("Sem elementos registrados");
				estoque(list_Pecas);
			}else {
				System.out.println("TOTAL DE PECAS CADASTRADAS "+list_Pecas.size());
				list_Pecas.toString();
			}

		}else if(opcao==2) {
		
			
			
		}else if(opcao==3) {
		
			System.out.println("------------- CADASTRO DE PEÇAS -------------");
			
			
			System.out.print("Nome:");
			 String 	nomePeca=scan.next().toUpperCase();
			 System.out.print("valor:");
			 double		valorPecas=scan.nextInt();
			 System.out.print("Unidade de medida:");
			 String 	unid=scan.next();
			 System.out.print("Quantidade de peças:");
			 int 	quat_Pecas=scan.nextInt();
			 
			 System.out.println("TIPOS DE ELEMENTO DE MAQUINA :\n"
			 		+ "1- ELEMENTO DE VEDAÇÃO\n"
			 		+ "2- ELEMENTO ELASTICO\n"
			 		+ "3- ELEMENTO DE TRANSMIÇÃO\n"
			 		+ "4- ELEMENTO DE FIXAÇÃO");
			 int num=scan.nextInt();
			 
			 String tipo_elemento = null;
			 if(num==1) {
				 		tipo_elemento="VEDAÇÃO";
			 }else if(num==2) {
				 		tipo_elemento="ELASTICO";
			 }else if(num==3) {
				 		tipo_elemento="TRANSMIÇÃO";
			 }else if(num==4) {
				 		tipo_elemento="FIXAÇÃO";
			 }else {
				 System.out.println("Elemento não identificado");
			 }
			 
			 Pecas peca =new Pecas(nomePeca,valorPecas,unid,quat_Pecas,tipo_elemento);
			 list_Pecas.add(peca);
			 System.out.println("PEÇA CASTRADA COM SUCESSO");
			 
			 
			 
		}else if(opcao==4) {
			
			System.out.println("------------- REMOÇÃO DE PEÇAS -------------");
			
			for(int i=0;i<list_Pecas.size();i++) {
				
				System.out.println("ID="+i+"=>"+list_Pecas.toString());
			}
				
				System.out.print("Insira o ID que deseja remover:");
				int idRemocao=scan.nextInt();
				list_Pecas.remove(idRemocao);
				System.out.println("Peça removida com sucesso");
			}
			
		
	}

	//VERIFICAÇÃO DE CADASTRO DE USUARIO
	public int verifica_deCadastro(String cpf, String senha, ArrayList<Usuario> list_usuarios) {
	    int size = list_usuarios.size();

	    if (size <= 0) {
	        return -1;
	    }

	    for (int i = 0; i < size; i++) {
	        if (cpf.equals(list_usuarios.get(i).getCpf())) {
	            if (senha.equals(list_usuarios.get(i).getSenha())) {
	                return i; 
	            } else {
	                return -2; 
	            }
	        }
	    }
	    

	    return -3;
	}
	
	public void criaOS(ArrayList<Usuario> list_usuarios, ArrayList<Ordem_De_Servico> ordemServico, int id) {
	    System.out.println("OS N°= " + ordemServico.size()); // Mostra o número da OS
	    System.out.println("Nome do Mecanico: " + list_usuarios.get(id).getNome());

	    // Perguntar o ID do cliente, em vez de assumir que é sempre o índice 1
	    System.out.print("Digite o ID do Cliente: ");
	    int idCliente = scan.nextInt();
	    
	    System.out.println("Nome do Cliente: " + list_usuarios.get(idCliente).getNome());

	    // Verificar se o usuário é do tipo correto (funcionário e cliente)
	    Usuario usuarioFuncionario = list_usuarios.get(id);
	    Usuario usuarioCliente = list_usuarios.get(idCliente);
	    
	    if (usuarioFuncionario instanceof Funcionario && usuarioCliente instanceof Cliente) {
	        Funcionario funcionario = (Funcionario) usuarioFuncionario;
	        Cliente cliente = (Cliente) usuarioCliente;

	        // Cria a Ordem de Serviço
	        Ordem_De_Servico os = new Ordem_De_Servico(funcionario, cliente, "Descrição do serviço");
	        
	        // Adiciona à lista de ordens de serviço
	        ordemServico.add(os);
	        System.out.println("Ordem de Serviço criada com sucesso!");
	    } else {
	        System.out.println("Erro: Certifique-se de que o ID do funcionário e do cliente estão corretos.");
	    }
	}

	public void gerarOS(ArrayList<Pecas> list_Pecas) {
		System.out.println("Teste");
	}
		
}
