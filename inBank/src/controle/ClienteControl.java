package controle;

import java.util.ArrayList;
import java.util.List;

import persistencia.ClienteDao;
import entidade.Cliente;

public class ClienteControl {
	
	Cliente cliente;
	
	ClienteDao clienteDao = new ClienteDao();
	
	List<Cliente> clientes = new ArrayList<Cliente>();
	
	public void registrarCliente(String nome, Integer cpf, Double salLiquido, int idade) {
		cliente = new Cliente(nome, cpf, salLiquido, idade);
		clienteDao.salvar(cliente);
	}
	
	public void excluirCliente(Integer cpf){
		clienteDao.excluir(cpf);
	}
	
	public void editarCliente(String nome, Integer cpf, Double salLiquido, int idade) {
		cliente = new Cliente(nome, cpf, salLiquido, idade);
		clienteDao.editar(cliente);
	}
	
	public void listarTodos() {
		clientes = clienteDao.listar();
		
		for (int i = 0; i < clientes.size(); i++) {
			System.out.println("Nome: " + clientes.get(i).getNome());
			System.out.println("CPF: " + clientes.get(i).getCpf());
			System.out.println("Idade: " + clientes.get(i).getIdade());
			System.out.println("Salário Líquido: " + clientes.get(i).getSalLiquido() + "\n\n");
		}
	}
	
	public Cliente localizarCliente(Integer cpf) {
		cliente = new Cliente();
		cliente = clienteDao.localizarPorCPF(cpf);
		return cliente;
	}
}
