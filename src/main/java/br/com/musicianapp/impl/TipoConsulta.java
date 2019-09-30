package br.com.musicianapp.impl;

import org.springframework.stereotype.Service;

@Service
public class TipoConsulta implements IStyleQuery{
	private ConsultasPadrao consultaPadrao;

	@Override
	public ConsultasPadrao getParametro() {
		return consultaPadrao;
	}

	@Override
	public void setParametro(ConsultasPadrao parametro) {
		this.consultaPadrao = parametro;
		
	}


	
}
