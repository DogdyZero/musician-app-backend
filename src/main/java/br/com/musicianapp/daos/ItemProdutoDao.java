package br.com.musicianapp.daos;

import java.util.ArrayList;
import java.util.Date;
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

import br.com.musicianapp.adapter.IAdapter;
import br.com.musicianapp.adapter.ItemProdutoAdapter;
import br.com.musicianapp.domain.CarrinhoCompra;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.ItemProduto;
import br.com.musicianapp.domain.Pedido;
import br.com.musicianapp.domain.Pessoa;
import br.com.musicianapp.domain.Troca;
import br.com.musicianapp.impl.ConsultasPadrao;
import br.com.musicianapp.repository.ItemProdutoRepository;

@Service
public class ItemProdutoDao extends AbstractDao {
	@Autowired 
	private ItemProdutoRepository repository;
	
	private IAdapter<ItemProduto> adapter;
	private Optional<ItemProduto> optItem;
	private List<EntidadeDominio> entidades;
	
	@PersistenceContext
	private EntityManager em;
	
	public ItemProdutoDao() {
		adapter = new ItemProdutoAdapter<ItemProduto>();
	}
	@Override
	public EntidadeDominio salvar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntidadeDominio alterar(EntidadeDominio entidade) {
		adapter.setAdapter(entidade);
		if(adapter.getObject()!=null) {
			ItemProduto item = adapter.getObject();
			optItem = repository.findById(item.getId());
			
			ItemProduto itemBD = optItem.get();
			
			if(itemBD.getId()==item.getId()) {
				if(itemBD.getTroca()==null) {
					Troca troca = new Troca();
					troca.setStatusItem(item.getTroca().getStatusItem());
					troca.setDescricaoProblema(item.getTroca().getDescricaoProblema());
					troca.setDataPedidoTroca(new Date());
					itemBD.setTroca(troca);
				} else {
					itemBD.getTroca().setStatusItem(item.getTroca().getStatusItem());
				}
				return repository.save(itemBD);
			}
		}
		return null;	
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		entidades = new ArrayList<EntidadeDominio>();
		adapter.setAdapter(entidade);

		ConsultasPadrao parametro=super.getParametro();
			
		if(parametro.equals(ConsultasPadrao.ITEM_PRODUTO_TRADE)) {
				parametro=null;
				return consultarTrocas(adapter.getObject());
		} else if(parametro.equals(ConsultasPadrao.CARTAO_ID)) {
			return teste();
			
		}
				
		return null;
	}
	private List<EntidadeDominio> consultarTrocas(ItemProduto itemProduto){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<ItemProduto> query = builder.createQuery(ItemProduto.class);
		Root<ItemProduto> from = query.from(ItemProduto.class);
		
		Join<ItemProduto,Troca> join = from.join("troca",JoinType.INNER);
		
		Predicate predicado
		  = builder.isNotNull(join.get("statusItem"));
		query.where(predicado);
		List<ItemProduto> results = em.createQuery(query).getResultList();

		entidades.addAll(results);
		return entidades;
	}
	private List<EntidadeDominio> teste() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Pessoa> query = builder.createQuery(Pessoa.class);
		Root<Pessoa> from = query.from(Pessoa.class);

		Join<Pedido,Pessoa> joinPessoa = from.join("pedido",JoinType.INNER);
		Join<CarrinhoCompra,Pedido> joinPedido = joinPessoa.join("carrinhoCompra",JoinType.INNER);
		Join<ItemProduto,CarrinhoCompra> joinItem = joinPedido.join("itemProduto",JoinType.INNER);
		Join<Troca,ItemProduto> joinTroca = joinItem.join("troca",JoinType.INNER);

		Predicate predicado
		  = builder.equal(joinTroca.get("id"),102);
		query.where(predicado);
		List<Pessoa> results = em.createQuery(query).getResultList();
		

		entidades.addAll(results);
		return entidades;
	}
	
	@Override
	public void apagar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

	}

}
