package visao;

import java.util.Scanner;

import controle.ClienteControl;

public class telaTeste {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		ClienteControl clienteControl = new ClienteControl();

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
				
			default:
				break;
		}
	}

}

