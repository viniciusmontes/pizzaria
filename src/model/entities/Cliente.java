package model.entities;

public class Cliente {

	private Long id;
	private String nome;
	private String email;

	public Cliente() {

	}

	public Cliente(Long id, String nome, String email) {
		this.setId(id);
		this.nome = nome;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", email=" + email + "]";
	}

}
