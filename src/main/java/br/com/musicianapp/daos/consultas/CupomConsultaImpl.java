package br.com.musicianapp.daos.consultas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.domain.Cupom;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.repository.CupomRepository;

@Service
public class CupomConsultaImpl {
	@Autowired
	private CupomRepository repository;
	private List<EntidadeDominio> entidades;
	private Optional<Cupom> optional;
	
	private List<EntidadeDominio> createList(List<Cupom> list){
		entidades = new ArrayList<EntidadeDominio>();
		for (EntidadeDominio t : list) {
			entidades.add(t);
		}
		return entidades;
	}
	
	public List<EntidadeDominio> pesquisarTodos(Cupom cupom){
		return createList(repository.findAll());
		
	}
	public List<EntidadeDominio> pesquisarPorId(Cupom cupom){
		entidades = new ArrayList<EntidadeDominio>();
		optional = repository.findById(cupom.getId());
		cupom = optional.get();
		entidades.add(cupom);
		return entidades;
	}
}
