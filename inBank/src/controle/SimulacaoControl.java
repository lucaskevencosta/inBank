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

			System.out.println("\n\n1 - SAC");
			System.out.println("2 - Price");

			System.out.print("Opção: ");
			int menu = ler.nextInt();

			System.out.print("Prazo desejado: ");
			int n = ler.nextInt();

			System.out.print("Valor a ser financiado: ");
			Double pv = ler.nextDouble();

			if (menu == 1)
				calcularSac(n, pv);
			else if (menu == 2)
				calcularPrice(n, pv);
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

	public void calcularSac(int n, Double pv) {
		Double amort = pv / n;
		
		Double pf = 0.0;
		
		Double countPmt = 0.0;

		boolean semaforo;
		boolean flag;
		
		System.out
		.print("\n\nSaldo inicial       Juros       Amortização       PMT       Saldo final\n");
		
		flag = true;
		semaforo = true;
		while (semaforo) {
			
			if (flag == false)
				pv = pf;
			
			Double juros = pv * i;
			Double pmt = amort + juros;
			pf = pv - amort;
			
			System.out
			.printf("%.2f          %.2f          %.2f          %.2f          %.2f \n",
					pv, juros, amort, pmt, pf);
			
			countPmt = countPmt + pmt;
			
			flag = false;
			if (pf <= 5)
				semaforo = false;
		}
		
		System.out.printf("\n\nTotal do financiamento: %.2f", countPmt);
	}

	public void calcularPrice(int n, Double pv) {
		Double pf = 0.0;

		boolean flag;
		boolean semaforo;

		Double pot = Math.pow((1 + i), n);
		Double pmt = pv * ((pot * i) / (pot - 1));

		flag = true;
		semaforo = true;

		System.out
				.print("\n\nSaldo inicial       Juros       Amortização       PMT       Saldo final\n");
		while (semaforo) {

			if (flag == false)
				pv = pf;

			Double juros = pv * i;
			Double amort = pmt - juros;
			pf = pv - amort;

			System.out
					.printf("%.2f          %.2f          %.2f          %.2f          %.2f \n",
							pv, juros, amort, pmt, pf);

			flag = false;
			if (pf <= 5)
				semaforo = false;
		}

		System.out.printf("\n\nTotal do financiamento: %.2f", (pmt * n));
	}

}
