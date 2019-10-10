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

import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Estoque;
import br.com.musicianapp.domain.Produto;
import br.com.musicianapp.repository.ProdutoRepository;

@Service
public class ProdutoConsultaImpl {
	@Autowired
	private ProdutoRepository repository;
	
	@PersistenceContext
	private EntityManager em;
	
	private List<EntidadeDominio> entidades;
	private Optional<Produto> optional;
	
	private List<EntidadeDominio> createList(List<Produto> list){
		entidades = new ArrayList<EntidadeDominio>();
		for (EntidadeDominio t : list) {
			entidades.add(t);
		}
		return entidades;
	}
	
	public List<EntidadeDominio> pesquisarTodos(Produto produto){
		return createList(repository.findAll());
		
	}
	public List<EntidadeDominio> pesquisarPorId(Produto produto){
		entidades = new ArrayList<EntidadeDominio>();
		optional = repository.findById(produto.getId());
		produto = optional.get();
		entidades.add(produto);
		return entidades;
	}
	public List<EntidadeDominio> pesquisarProdutoEstoque(Produto produto) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Estoque> query = builder.createQuery(Estoque.class);
		Root<Estoque> from = query.from(Estoque.class);

		Join<Produto,Estoque> join = from.join("produto",JoinType.INNER);

		Predicate predicado
		  = builder.equal(join.get("id"),produto.getId());
		query.where(predicado);
		List<Estoque> results = em.createQuery(query).getResultList();
		
		entidades = new ArrayList<EntidadeDominio>();
		for (Estoque t : results) {
			entidades.add(t);
		}
		return entidades;
		
	}
	public List<EntidadeDominio> consultarProdutosDisponiveis(Produto produto){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Estoque> query = builder.createQuery(Estoque.class);
		Root<Estoque> from = query.from(Estoque.class);
		
		Join<Estoque,Produto> join = from.join("produto",JoinType.INNER);
		
		Predicate predicado
		  = builder.ge(from.get("quantidadeProduto"), 1);
		query.where(predicado);
		List<Estoque> results = em.createQuery(query).getResultList();

		entidades = new ArrayList<EntidadeDominio>();
		for (EntidadeDominio t : results) {
			entidades.add(t);
		}
		return entidades;
	}
}
