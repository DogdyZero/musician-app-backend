package br.com.musicianapp.daos.consultas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Pedido;
import br.com.musicianapp.repository.PedidosRepository;

@Service
public class PedidoConsultaImpl {
	@Autowired
	private PedidosRepository repository;
	private List<EntidadeDominio> entidades;
	private Optional<Pedido> optional;
	
	private List<EntidadeDominio> createList(List<Pedido> list){
		entidades = new ArrayList<EntidadeDominio>();
		for (EntidadeDominio t : list) {
			entidades.add(t);
		}
		return entidades;
	}
	
	public List<EntidadeDominio> pesquisarTodos(Pedido pedido){
		return createList(repository.findAll());
		
	}
	public List<EntidadeDominio> pesquisarPorId(Pedido pedido){
		entidades = new ArrayList<EntidadeDominio>();
		optional = repository.findById( pedido.getId());
		pedido = optional.get();
		entidades.add(pedido);
		return entidades;
	}
}
