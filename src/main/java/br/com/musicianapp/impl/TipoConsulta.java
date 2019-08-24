package br.com.musicianapp.impl;

public class TipoConsulta implements IStyleQuery{
	private String parametro;

	@Override
	public String getParametro() {
		return this.parametro;
	}

	@Override
	public void setParametro(String parametro) {
		this.parametro=parametro;
	}


	
}
