package visao;

import java.util.Scanner;

import controle.ClienteControl;
import controle.SimulacaoControl;

public class telaTeste {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		ClienteControl clienteControl = new ClienteControl();
		
		SimulacaoControl simulacaoControl = new SimulacaoControl();

		int menu;
		Integer cpf;
		String nome;
		Double salLiquido;
		int idade;

		System.out.println("########## MENU ##########");
		System.out.println("1 - Cadastrar cliente");
		System.out.println("2 - Excluir cliente");
		System.out.println("3 - Editar cliente");
		System.out.println("4 - Listar clientes");
		System.out.println("5 - Calcular Simulação");
		
		System.out.print("\nOpção: ");
		menu = ler.nextInt();
		
		

		switch (menu) {
			case 1:
				
				System.out.print("Nome: ");
				nome = ler.next();
				
				System.out.print("CPF: ");
				cpf = ler.nextInt();
				
				System.out.print("Salário líquido: ");
				salLiquido = ler.nextDouble();
				
				System.out.print("Idade: ");
				idade = ler.nextInt();
				
				clienteControl.registrarCliente(nome, cpf, salLiquido, idade);
				break;
			
			case 2:
				
				System.out.print("CPF: ");
				cpf = ler.nextInt();
				
				clienteControl.excluirCliente(cpf);
				break;
			
			case 3:
				
				System.out.print("Nome: ");
				nome = ler.next();
				
				System.out.print("CPF: ");
				cpf = ler.nextInt();
				
				System.out.print("Salário Líquido: ");
				salLiquido = ler.nextDouble();
				
				System.out.print("Idade: ");
				idade = ler.nextInt();
				
				clienteControl.editarCliente(nome, cpf, salLiquido, idade);
				break;
			
			case 4:
				
				clienteControl.listarTodos();
				break;
				
			case 5:
				
				Double pagamentos;
				
				System.out.print("Digite seu CPF: ");
				cpf = ler.nextInt();
				
				System.out.print("Valor total gasto mensalmente com outros financiamentos: ");
				pagamentos = ler.nextDouble();
				
				simulacaoControl.calcularPossiveisFinanciamentos(cpf, pagamentos);
				
				
			default:
				break;
		}
	}

}

