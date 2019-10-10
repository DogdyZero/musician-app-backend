package br.com.musicianapp.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.adapter.EstoqueAdapter;
import br.com.musicianapp.adapter.IAdapter;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Estoque;
import br.com.musicianapp.domain.Produto;
import br.com.musicianapp.impl.ConsultasPadrao;
import br.com.musicianapp.repository.EstoqueRepository;

@Service
public class EstoqueDao extends AbstractDao {
	
	@Autowired
	private EstoqueRepository repository;
	private IAdapter<Estoque> adapter;
	
	@Autowired
	private ProdutoDao produtoDao;
	public EstoqueDao() {
		adapter = new EstoqueAdapter<Estoque>();
	}
	@Override
	public EntidadeDominio salvar(EntidadeDominio entidade) {
		adapter.setAdapter(entidade);
		Estoque estoque = adapter.getObject();
		if(estoque.getProduto()!=null) {
			produtoDao.setParametro(ConsultasPadrao.PRODUTO_ID);
			Produto produto = estoque.getProduto();
			List<EntidadeDominio> entidades =  produtoDao.consultar(produto);
			produto = (Produto) entidades.get(0);
			estoque.setProduto(produto);
		}
		return repository.save(estoque);
	}

	@Override
	public EntidadeDominio alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void apagar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

	}

}
