package br.com.musicianapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.musicianapp.domain.Cupom;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.TipoPagamento;
import br.com.musicianapp.impl.ConsultasPadrao;

@CrossOrigin
@RestController
@RequestMapping("/cupons")
public class CupomController {
	
	@Autowired
	private Facade facade;
	
	@Autowired
	private Cupom cupom;
	
//	@Autowired
//	private TipoPagamento tipo;
	
	@GetMapping 
	public List<Cupom> consultarCupom(){
		facade.setParametro(ConsultasPadrao.CUPOM_TUDO);
		List<EntidadeDominio> entidades = facade.consultar(cupom);
		List<Cupom> cupons = new ArrayList<Cupom>();
		for(EntidadeDominio entidade : entidades) {
			Cupom cupom =(Cupom)entidade;
			cupons.add(cupom);
		}
		return cupons;
	}
	
	@PutMapping("{id}")
	public Cupom alterarCupom(@PathVariable int id, @RequestBody Cupom cupom){
		cupom.setId(id);
		facade.alterar(cupom);
		return null;
	}
	
}
