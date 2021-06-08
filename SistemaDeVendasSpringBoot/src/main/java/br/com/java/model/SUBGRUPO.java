package br.com.java.model;

public enum SUBGRUPO {
	
	Cereais("Cereais, pães e tubérculos"),
	Hortalicas("Legumes, verduras e vegetais"),
	Frutas("Frutas"),
	Leguminosas("feijões, lentilha, grão de bico, soja e oleaginosas"),
	Carnes("Proteínas de origem animal"),
	Laticionios("Leite e derivados"),
	Gorduras("Óleos e gorduras"),
	Sacaroses("Açúcares");
	
//	private String sigla;
	private String descricao;
	
	SUBGRUPO(String descricao){
//		this.sigla = sigla;
		this.descricao = descricao;
	}

//	public String getSigla() {
//		return sigla;
//	}
//
//	public void setSigla(String sigla) {
//		this.sigla = sigla;
//	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
