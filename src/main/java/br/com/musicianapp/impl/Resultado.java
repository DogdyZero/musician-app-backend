package br.com.musicianapp.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.musicianapp.domain.EntidadeDominio;

public class Resultado {
	private String resultado;
	private List<EntidadeDominio> entidades;
	
	public Resultado() {}
	
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public List<EntidadeDominio> getEntidades() {
		return entidades;
	}
	public void setEntidades(List<EntidadeDominio> entidades) {
		this.entidades = entidades;
	}
	
	public void addEntidadeList(EntidadeDominio entidade) {
		if(entidades==null) {
			entidades = new ArrayList<EntidadeDominio>();
		}
		entidades.add(entidade);
	}
	
	
}
