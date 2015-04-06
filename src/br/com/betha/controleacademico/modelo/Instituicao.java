package br.com.betha.controleacademico.modelo;

public class Instituicao {

	private int codigo;
	private String nome;
	private String endereco;
	private String cnpj;
	private String telefone;
	private String complemento;
	
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
