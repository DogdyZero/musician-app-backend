package br.com.musicianapp.domain;

public enum Bandeira {
	Dinheiro("Dinheiro"),
	Crédito("Cartão de Crédito"), 
	Débito ("Cartão de Débito");
	
	private String descricao;
	
	private Bandeira(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao(){
        return this.descricao;
	}
	
}
