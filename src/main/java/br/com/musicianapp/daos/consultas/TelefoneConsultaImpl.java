package br.com.musicianapp.daos.consultas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Telefone;
import br.com.musicianapp.repository.TelefoneRepository;

@Service
public class TelefoneConsultaImpl {
	@Autowired
	private TelefoneRepository repository;
	private List<EntidadeDominio> entidades;
	private Optional<Telefone> optional;
	
	private List<EntidadeDominio> createList(List<Telefone> list){
		entidades = new ArrayList<EntidadeDominio>();
		for (EntidadeDominio t : list) {
			entidades.add(t);
		}
		return entidades;
	}
	
	public List<EntidadeDominio> pesquisarTodos(Telefone telefone){
		return createList(repository.findAll());
		
	}
	public List<EntidadeDominio> pesquisarPorId(Telefone telefone){
		entidades = new ArrayList<EntidadeDominio>();
		optional = repository.findById( telefone.getId());
		telefone = optional.get();
		entidades.add(telefone);
		return entidades;
	}
}
