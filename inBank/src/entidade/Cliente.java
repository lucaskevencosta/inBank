package entidade;

public class Cliente {
	
	private String nome;
	
	private String cpf;
	
	private Double salLiquido;
	
	private int idade;
	
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getSalLiquido() {
		return salLiquido;
	}

	public void setSalLiquido(Double salLiquido) {
		this.salLiquido = salLiquido;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
}
