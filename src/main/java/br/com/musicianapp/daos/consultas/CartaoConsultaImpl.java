package br.com.musicianapp.daos.consultas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.domain.Cartao;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.repository.CartaoRepository;

@Service
public class CartaoConsultaImpl {
	@Autowired
	private CartaoRepository repository;
	private List<EntidadeDominio> entidades;
	private Optional<Cartao> optional;
	
	private List<EntidadeDominio> createList(List<Cartao> list){
		entidades = new ArrayList<EntidadeDominio>();
		for (EntidadeDominio t : list) {
			entidades.add(t);
		}
		return entidades;
	}
	
	public List<EntidadeDominio> pesquisarTodos(Cartao cartao){
		return createList(repository.findAll());
		
	}
	public List<EntidadeDominio> pesquisarPorId(Cartao cartao){
		entidades = new ArrayList<EntidadeDominio>();
		optional = repository.findById( cartao.getId());
		cartao = optional.get();
		entidades.add(cartao);
		return entidades;
	}

}
