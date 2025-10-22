package viwer;

import java.util.Scanner;

import Model.Cliente;
import Model.Funcionario;
import Model.Ordem_De_Servico;
import Model.Pecas;
import Model.Usuario;
import control.Control_Ordem_De_Serico;
import control.Control_Pecas;
import control.Control_Usuario;

public class Tela<bollean> {
			static Scanner scan=new Scanner(System.in);
	private static Control_Usuario cont_usu=new Control_Usuario();
	private static Control_Pecas cont_pecas=new Control_Pecas();
	private static Control_Ordem_De_Serico cont_os=new Control_Ordem_De_Serico();
	
	public void splashScreen() {
		System.out.println("--------- SISTEMA DE GERENCIAMENTO DE MANUTENÇÃO (SGM) ---------");
		  
		
	    System.out.println(">> TOTAL DE REGISTROS EXISTENTES:\n");
	    cont_usu.cont_usu();
	    cont_pecas.cont_pecas();
	    cont_os.cont_os();
	    System.out.println();
	    
	   
	    System.out.println("CRIADO POR:");
	    System.out.println(" - LARISSA MORAES DE JESUS");
	    System.out.println(" - BRUNO OLIVEIRA DUARTE");
	    System.out.println(" - LEO FERNANDE \n");
	
	    System.out.println("DISCIPLINA: BANCO DE DADOS 2025/2");
	    System.out.println("PROFESSOR: HAWARD ROATTI\n");
	}

	public int tela_menu() {
		System.out.println("----------------- MENU -----------------");
		
		System.out.println("1- RELATORIOS\n"
				+ "2- INSERIR REGISTROS\n"
				+ "3- REMOVER REGISTROS\n"
				+ "4- ATUALIZAR\n"
				+ "5- SAIR");
		return scan.nextInt();
	}
	public int tela_inserir() {
		System.out.println("----------------- INSERT -----------------");
		
		System.out.println("1- CADASTRO USUARIO(CLIENTE OU FUNCIONARIO)\n"
				+ "2- CADASTRO O.S\n"
				+ "3- CADASTRO DE PEÇAS\n"
				+ "4- ALOCAÇÃO DE INSUMOS\n"
				+ "5- SAIR");
		return scan.nextInt();	

	}
	public int tela_remover() {
		System.out.println("----------------- REMOVE -----------------");
		
		System.out.println("1- REMOVER USUARIO(CLIENTE OU FUNCIONARIO)\n"
				+ "2- REMOVER O.S\n"
				+ "3- REMOVER PEÇAS\n"				
				+ "4- SAIR");
		return scan.nextInt();
		
	}
	public int tela_relatorio() {
		System.out.println("----------------- REPORT -----------------");
		
		System.out.println("1- RELATORIO DE USUARIO\n"
				+ "2- RELATORIO DE O.S\n"
				+ "3- RELATORIO DE PEÇAS\n"
				+ "4- RELATORIO DE PEÇAS USADAS POR OS\n"
				+ "5- RELATORIO DE PEÇAS POR TIPO\n"
				+ "6- SAIR");
		return scan.nextInt();
	}	
	public void tela_cadastro() {

	
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
			 
			 String tipo="FUNCIONARIO";
			 System.out.print("Salario do Coloborador:");
			 float salario	=scan.nextFloat();
			 
			 Funcionario funcionario = new Funcionario(nome,cpf,telefone,senha,tipo,salario);
			 cont_usu.cadastro(tipo_usuario,funcionario);

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
			
			  cont_usu.cadastro(tipo_usuario,cliente);
				return;
		 }
		 
	}
	public void tela_cadastrarPecas() {
		System.out.println("------------- CADASTRO DE PEÇAS -------------");
		
		
		System.out.print("Nome:");
		 String 	nomePeca=scan.next().toUpperCase();
		 System.out.print("valor:");
		 float		valorPecas=scan.nextInt();
		 System.out.print("Unidade de medida:");
		 String 	unid=scan.next();
		 System.out.print("Quantidade de peças:");
		 int 	quat_Pecas=scan.nextInt();
		 float valor_unid=(valorPecas/quat_Pecas);
		 System.out.println("TIPOS DE ELEMENTO DE MAQUINA :\n"
		 		+ "1- ELEMENTO DE VEDAÇÃO\n"
		 		+ "2- ELEMENTO ELASTICO\n"
		 		+ "3- ELEMENTO DE TRANSMIÇÃO\n"
		 		+ "4- ELEMENTO DE FIXAÇÃO\n"
		 		+ "5- ELEMENTO ESPECIFICO");
		 int num=scan.nextInt();
		 
		 String tipo_elemento = null;
		 if(num==1) {
			 		tipo_elemento="GENUINO";
		 }else if(num==2) {
			 		tipo_elemento="ORIGINAL";
		 }else if(num==3) {
			 		tipo_elemento="2° LINHA";
		 }
		 else {
			 System.out.println("Elemento não identificado");
		 }
		 Pecas peca =new Pecas(nomePeca,valorPecas,unid,quat_Pecas,valor_unid,tipo_elemento);		
		 cont_pecas.cadastrarPecas(peca);
	}
	public void tela_criaOS() {
		Usuario usu=new Usuario();
		System.out.println("----------------- CRIAR OS -----------------");
		
		cont_usu.relatorioFuncionario();
		
	    System.out.print("DIGITE O ID DO FUNCIONARIO:");
	    int id_Funcionario=scan.nextInt();
	    usu=cont_usu.return_usuario(id_Funcionario);
	    
	    cont_usu.relatorioCliente();
	    
	    System.out.print("\nDigite o ID do Cliente: ");
	    int  id_Cliente=scan.nextInt();
	    
	    System.out.println("DESCRIÇÃO DA ATIVIDADE:");
	    String observacao=scan.next();
	    
	    float custoHH=((Funcionario) usu).getCustoHH();
	    Ordem_De_Servico os = new Ordem_De_Servico(id_Funcionario,id_Cliente,observacao,custoHH);	  
	    cont_os.criaOS(os);
	    
	}
	public void tela_lancamentoPecas() {
		System.out.println("----------------- ALOCAR PECAS -----------------\n");

		cont_os.relatorioGeralOS();
		
		System.out.println("\nINSIRA O ID QUE VAMOS ALTERA");
		System.out.println("ID OS:");
		int id_os=scan.nextInt();
		
		cont_pecas.relatorio_pecas();
		
		while(true) {
			System.out.println("\nINSIRA O ID PARA ALOCAR A PEÇAS OU 0 PARA PULAR ESTA ETAPA");
			System.out.println("DIGITE O ID PEÇAS:");
			int id_pecas=scan.nextInt();
			if(id_pecas==0) {
				break;
			}else {
			System.out.println("QUANT. PEÇAS:");
			int quant_pecas=scan.nextInt();
			cont_pecas.lancamentoPecas(id_os, id_pecas, quant_pecas);
			
			}
			
		}
	}	
	public boolean tela_confir(String operacao) {
		System.out.println("TEM CERTEZA QUE DESEJA "+operacao+"?");
		System.out.println("DIGITE S PARA CONFIRMAR OU N PARA CANCELAR ,POR FAVOR.");
		String status=scan.next();
		if(status.equalsIgnoreCase("S")) {
			return true;	
		}else if (status.equalsIgnoreCase("N")) {
			return false;
		}
		System.out.println("TENTE NOVAMENTE");
	return false;
	}
	
	public void tela_removeUsuario() {
		while(true) {
		System.out.println("------------- REMOÇÃO DE USUARIOS -------------");
			
		cont_usu.relatorioFuncionario();
		cont_usu.relatorioCliente();
		
		System.out.println("INSIRA O ID DO FUNCIONARIO:");
				
		int id=scan.nextInt();
		if(id==0) {
			break;
		}else {
			boolean bol=tela_confir("REMOVER");
			if(bol==true) {
				cont_usu.removeUsuario(id);
			}else {
				return;
			}
			
			}
		}
	
		
	}
	public void tela_removerPecas() {
		while(true) {
			System.out.println("------------- REMOÇÃO DE PEÇAS -------------");
			
			cont_pecas.relatorio_pecas();
			
			System.out.print("0 SAIR OU ID DA PEÇA:");
			int id=scan.nextInt();
			if(id==0) {
				break;
			}else {
				boolean bol=tela_confir("REMOVER");
				if(bol==true) {
				cont_pecas.removerPecas(id);
				}else {
					return;
				}
			}
			
		}
	}
	public void tela_removeOS() {
		while(true) {
			System.out.println("------------- REMOVE ORDEM DE SERVICO -------------");
			
			cont_os.relatorioGeralOS();
			
			System.out.print("0 SAIR OU ID DA O.S:");
			int id=scan.nextInt();
			if(id==0) {
				break;
			}else {
				boolean bol=tela_confir("REMOVER");
				if(bol==true) {
					cont_os.removeOS(id);
				}else {
					return;
				}
				
			}
			
		}
	}
	public void relat_Usuario() {
		System.out.println("------------- RELATORIO GERAL DE USUARIOS -------------");
		cont_usu.relatorioFuncionario();
		cont_usu.relatorioCliente();
	}
	public void relat_OrdemServico() {
		System.out.println("------------- RELATORIO GERAL DE ORDEM DE SERVIÇOS -------------");
		cont_os.relatorioGeralOS();
		
	}
	public void relat_pecas() {
		cont_pecas.relatorio_pecas();
	}
	public void relat_pecasUsadas() {
		System.out.println("------------- RELATORIO PEÇAS POR OS -------------");
		cont_os.relatorioGeralOS();
		System.out.print("INSIRA ID DA O.S:");
		int num=scan.nextInt();
		cont_pecas.relatorio_pecas_usadas(num);
	}
	public void relat_pecasTipo() {
		System.out.println("------------- RELATORIO PEÇAS POR TIPO------------");
		cont_pecas.relatorio_pecas_tipo();
		
	}
	public void removePecasUsadas() {
		while(true) {
		System.out.println("-----------------REMOVE DE PEÇAS USADAS-----------------");
		
		cont_os.relatorioGeralOS();
		System.out.print("INSIRA ID DA O.S:");
		int num=scan.nextInt();
		if(num==0) {
			break;
		}
		cont_pecas.relatorio_pecas_usadas(num);
		System.out.print("INSIRA ID DA PEÇA A SER REMOVIDA:");
		int num2=scan.nextInt();
		System.out.print("INSIRA ID OS:");
		int num1=scan.nextInt();
		System.out.print("INSIRA QUANTIDADE:");
		int num3=scan.nextInt();
		
		boolean bol=tela_confir("REMOVER");
		if(bol==true) {
			cont_pecas.removePecasU(num1, num2, num3);
		}else {
			return;
		}
		
		}
	}

	public int tela_atualizar() {
		System.out.println("--------- UPDATE ---------");
		System.out.println("1- ATUALIZAR USUARIOS\n"
				+ "2- ATUALIZAR PEÇAS\n"
				+ "3- ATUALIZAR ORDENS DE SERVIÇO\n"
				+ "4- SAIR");
		return scan.nextInt();
	}
	public void tela_atualizarUsu() {
		
		cont_usu.relatorioCliente();
		cont_usu.relatorioFuncionario();
		System.out.print("0 PARA SAIR OU ID DO USUARIO:");
		
		
		
		int idUsuario=scan.nextInt();
		if(idUsuario==0) {
			return;
		}
		System.out.println("\n1- ID_USUARIOS\n"
				+ "2- NOME\n"
				+ "3- CPF\n"
				+ "4- TELEFONE\n"
				+ "5- SENHA\n"
				+ "6- TIPO\n"
				+ "7- MOTO_MODELO\n"
				+ "8- MOTO_ANO\n"
				+ "9- MOTO_PLACA");
		System.out.print("INSIRA A COLUNA QUE VAI MODIFICAR:");
		int opcao=scan.nextInt();
		String coluna = null;
		switch (opcao) {
	    case 1 -> coluna = "ID_USUARIOS";
	    case 2 -> coluna = "NOME";
	    case 3 -> coluna = "CPF";
	    case 4 -> coluna = "TELEFONE";
	    case 5 -> coluna = "SENHA";
	    case 6 -> coluna = "TIPO";
	    case 7 -> coluna = "MOTO_MODELO";
	    case 8 -> coluna = "MOTO_ANO";
	    case 9 -> coluna = "MOTO_PLACA";
		}
		
		System.out.print("INSIRA O NOVO VALOR:");
		String novoValor=scan.next();
		
		boolean bol=tela_confir("ATUALIZAR");
		if(bol==true) {
			cont_usu.atuli_usu(idUsuario, coluna, novoValor);
		}else {
			return;
		}
		
	
	}
	public void tela_atualizarOS() {
		
		
		
		cont_os.relatorioGeralOS();
		
		
System.out.print("0 PARA SAIR OU ID DA ORDEM DE SERVIÇO:");
		
		
		
		int idOS=scan.nextInt();
		if(idOS==0) {
			return;
		}
		System.out.println("\n1- ID_Os\n"
				+ "2- STATUS\n"
				+ "3- ID_FUNCIONARIO\n"
				+ "4- ID_CLIENTE\n"
				+ "5- CARGA_HORARIA\n"
				+ "6- VALOR_PECAS\n"
				+ "7- VALOR_HH\n"
				+ "8- VALOR_TOTAL\n"
				+ "9- OBSERVACAO");
		System.out.print("INSIRA A COLUNA QUE VAI MODIFICAR:");
		int opcao=scan.nextInt();
		
		String coluna = null;
		switch (opcao) {
	    case 1 -> coluna = "ID_Os";
	    case 2 -> coluna = "STATUS";
	    case 3 -> coluna = "ID_FUNCIONARIO";
	    case 4 -> coluna = "ID_CLIENTE";
	    case 5 -> coluna = "CARGA_HORARIA";
	    case 6 -> coluna = "VALOR_PECAS";
	    case 7 -> coluna = "VALOR_HH";
	    case 8 -> coluna = "VALOR_TOTAL";
	    case 9 -> coluna = "OBSERVACAO";
		}
		
		System.out.print("INSIRA O NOVO VALOR:");
		String novoValor=scan.next();
		
		
		boolean bol=tela_confir("ATUALIZAR");
		if(bol==true) {
			cont_os.atualiazarso(idOS, coluna, novoValor);
		}else {
			return;
		}
		
		
		
		
	}
	public void tela_atualizarPecas() {
		
		
		
		cont_pecas.relatorio_pecas();
		
		
System.out.print("0 PARA SAIR OU ID DA ORDEM DE SERVIÇO:");
		
		
		
		int idpecas=scan.nextInt();
		if(idpecas==0) {
			return;
		}
		System.out.println("\n1- ID_PECAS\n"
				+ "2- NOME\n"
				+ "3- VALOR_PECAS\n"
				+ "4- UNIDADE\n"
				+ "5- QUANTIDADE\n"
				+ "6- VALOR_UNIDADE\n"
				+ "7- TIPO_ELEMENTO\n");
		System.out.print("INSIRA A COLUNA QUE VAI MODIFICAR:");
		int opcao=scan.nextInt();
		
		String coluna = null;
		switch (opcao) {
	    case 1 -> coluna = "ID_PECAS";
	    case 2 -> coluna = "NOME";
	    case 3 -> coluna = "VALOR_PECAS";
	    case 4 -> coluna = "UNIDADE";
	    case 5 -> coluna = "QUANTIDADE";
	    case 6 -> coluna = "VALOR_UNIDADE";
	    case 7 -> coluna = "TIPO_ELEMENTO";
	    
		}
		
		System.out.print("INSIRA O NOVO VALOR:");
		String novoValor=scan.next();
		
		
		boolean bol=tela_confir("ATUALIZAR");
		if(bol==true) {
			cont_pecas.atualizarpecas(idpecas, coluna, novoValor);
		}else {
			return;
		}
		
	}
}
	
	

