package br.com.musicianapp.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.grafico.GraficoPesquisa;
import br.com.musicianapp.impl.ConsultasPadrao;

@CrossOrigin
@RestController
@RequestMapping("/grafico")
public class GraficoController {
	
	@Autowired
	private Facade facade;
	
	@Autowired
	private GraficoPesquisa grafico;
	
	@RequestMapping
	public Object gerarGrafico(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date dataInicio,
			@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date dataFinal) {

		if(dataInicio.before(dataFinal)) {
			grafico.setDataInicial(dataInicio);
			grafico.setDataFinal(dataFinal);
			facade.setParametro(ConsultasPadrao.GRAFICO);
			List<EntidadeDominio> resultado = facade.consultar(grafico);
			if(resultado!=null) {
				Object grafico = resultado.get(0);
				return grafico;
			}
		}

		return null;
	}
	
}
