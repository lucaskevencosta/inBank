package entidade;

public class Cliente {
	
	private String nome;
	
	private Integer cpf;
	
	private Double salLiquido;
	
	private int idade;
	
	public Cliente(String nome, Integer cpf, Double salLiquido, int idade) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.salLiquido = salLiquido;
		this.idade = idade;
	}
	
	public Cliente() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
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
