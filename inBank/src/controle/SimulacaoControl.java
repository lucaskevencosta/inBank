package controle;

import java.util.Scanner;

import entidade.Cliente;

public class SimulacaoControl {

	Scanner ler = new Scanner(System.in);
	
	ClienteControl clienteControl = new ClienteControl();

	Cliente cliente;
	
	Double i = 0.10;

	public void calcularPossiveisFinanciamentos(Integer cpf, Double pagamentos) {
		Double maxPmt = calcularTaxaFinan(cpf, pagamentos);

		if (maxPmt > 0) {
			
			System.out.println("Prazo desejado: ");
			int prazo = ler.nextInt();
			
			System.out.println("\n\n1 - SAC");
			System.out.println("2 - Price");
			
			System.out.print("Opção: ");
			int menu = ler.nextInt();
			
			if (menu == 1) 
				calcularSac(prazo);
			else if (menu == 2)
				calcularPrice(prazo);
			else
				System.out.println("Valor inválido.");
			
		} else {
			impossivelCalcular("Não foi possível calcular. Seus pagamentos mensais ultrapassam 30% do seu salário.");
		}
	}

	public Double calcularTaxaFinan(Integer cpf, Double pagamentos) {
		cliente = new Cliente();
		cliente = clienteControl.localizarCliente(cpf);

		Double taxa = cliente.getSalLiquido() * 0.3;
		Double maxPmt = taxa - pagamentos;

		return maxPmt;
	}

	public void impossivelCalcular(String s) {
		System.out.println(s);
	}
	
	public void calcularSac(int prazo) {
		
	}
	
	public void calcularPrice(int prazo) {
		
	}

}
