package br.com.java.model;

public enum GRUPO {
	
	Perecível("Perecível", "Perecível"),
	imperecível("imperecível", "imperecível");
	
	private String sigla;
	private String descricao;
	
	GRUPO(String sigla, String descricao){
		this.sigla = sigla;
		this.descricao = descricao;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
