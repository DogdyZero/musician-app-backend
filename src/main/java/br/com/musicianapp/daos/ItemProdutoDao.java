package br.com.musicianapp.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.adapter.IAdapter;
import br.com.musicianapp.adapter.ItemProdutoAdapter;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.ItemProduto;
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
			optItem = repository.findById(adapter.getObject().getId());
			
			ItemProduto itemBD = optItem.get();
			
			if(itemBD.getId()==adapter.getObject().getId()) {
				itemBD.setStatusItem(adapter.getObject().getStatusItem());
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
		}
		return null;
	}
	private List<EntidadeDominio> consultarTrocas(ItemProduto itemProduto){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<ItemProduto> query = builder.createQuery(ItemProduto.class);
		Root<ItemProduto> from = query.from(ItemProduto.class);
		
		Predicate predicado
		  = builder.isNotNull(from.get("statusItem"));
		query.where(predicado);
		List<ItemProduto> results = em.createQuery(query).getResultList();

		entidades.addAll(results);
		return entidades;
	}

	@Override
	public void apagar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

	}

}
