package br.com.musicianapp.grafico;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class GraficoPesquisa extends Grafico {
	private Date dataInicial;
	private Date dataFinal;
	
	public Date getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}
	public Date getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	
	
	
}
