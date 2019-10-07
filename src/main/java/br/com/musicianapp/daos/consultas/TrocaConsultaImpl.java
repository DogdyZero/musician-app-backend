package br.com.musicianapp.daos.consultas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.domain.CarrinhoCompra;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.ItemProduto;
import br.com.musicianapp.domain.Pedido;
import br.com.musicianapp.domain.Pessoa;
import br.com.musicianapp.domain.Troca;
import br.com.musicianapp.repository.TrocaRepository;
@Service
public class TrocaConsultaImpl {
	@Autowired
	private TrocaRepository repository;
	
	@PersistenceContext
	private EntityManager em;
	
	
	private List<EntidadeDominio> entidades;
	private Optional<Troca> optional;
	
	private List<EntidadeDominio> createList(List<Troca> list){
		entidades = new ArrayList<EntidadeDominio>();
		for (EntidadeDominio t : list) {
			entidades.add(t);
		}
		return entidades;
	}
	
	public List<EntidadeDominio> pesquisarTodos(Troca troca){
		return createList(repository.findAll());
		
	}
	public List<EntidadeDominio> pesquisarPorId(Troca troca){
		entidades = new ArrayList<EntidadeDominio>();
		optional = repository.findById(troca.getId());
		troca = optional.get();
		entidades.add(troca);
		return entidades;
	}
	public List<EntidadeDominio> pesquisarUsuarioTroca(Troca troca) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Pessoa> query = builder.createQuery(Pessoa.class);
		Root<Pessoa> from = query.from(Pessoa.class);

		Join<Pedido,Pessoa> joinPessoa = from.join("pedido",JoinType.INNER);
		Join<CarrinhoCompra,Pedido> joinPedido = joinPessoa.join("carrinhoCompra",JoinType.INNER);
		Join<ItemProduto,CarrinhoCompra> joinItem = joinPedido.join("itemProduto",JoinType.INNER);
		Join<Troca,ItemProduto> joinTroca = joinItem.join("troca",JoinType.INNER);

		Predicate predicado
		  = builder.equal(joinTroca.get("id"),troca.getId());
		query.where(predicado);
		List<Pessoa> results = em.createQuery(query).getResultList();
		
		entidades = new ArrayList<EntidadeDominio>();
		for (EntidadeDominio t : results) {
			entidades.add(t);
		}
		return entidades;
		
	}
	
	
}
