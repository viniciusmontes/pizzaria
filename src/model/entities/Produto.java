package model.entities;

public class Produto {

	private Long id;
	private String nome;
	private Double preco;
	private String descricao;

	public Produto() {

	}

	public Produto(String nome, Double preco) {

		this.nome = nome;
		this.preco = preco;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
