package br.com.musicianapp.domain;

public enum Bandeira {
	MASTERCARD("Mastercard"),
	VISA("Visa"), 
	HYPERCARD ("Hypercard");
	
	private String descricao;
	
	private Bandeira(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao(){
        return this.descricao;
	}
	
}
