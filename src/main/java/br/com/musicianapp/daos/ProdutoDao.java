package br.com.musicianapp.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.adapter.IAdapter;
import br.com.musicianapp.adapter.ProdutoAdapter;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Produto;
import br.com.musicianapp.impl.FactoryConsulta;
import br.com.musicianapp.repository.ProdutoRepository;

@Service
public class ProdutoDao  extends AbstractDao  {	
	private List<EntidadeDominio> entidades;
	private IAdapter<Produto> adapter;
	private Optional<Produto> optProduto;
	@Autowired
	private FactoryConsulta fabrica;
	
	public ProdutoDao() {
		adapter = new ProdutoAdapter<Produto>();
	}
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		return fabrica.fabricarConsulta(Produto.class.cast(entidade), super.getParametro());

	}

	@Override
	public EntidadeDominio salvar(EntidadeDominio entidade) {
		adapter.setAdapter(entidade);
		return produtoRepository.save(adapter.getObject());
	}

	@Override
	public EntidadeDominio alterar(EntidadeDominio entidade) {
		adapter.setAdapter(entidade);
		optProduto = produtoRepository.findById(adapter.getObject().getId());
		if(optProduto!=null) {
			Produto produto = optProduto.get();
			Produto prodMem =(Produto)entidade;
			
			produto = copyProduto(prodMem,produto);
			return produtoRepository.save(produto);
		}	
		return null;
	}
	private Produto copyProduto(Produto prodMem, Produto prodBD) {
		Produto prodCopy = new Produto();
		if(!prodMem.getEan().equals(prodBD.getEan())) {
			prodCopy.setEan(prodBD.getEan());
		} 
		prodCopy.setGrupoPrecificacao(prodMem.getGrupoPrecificacao());
//		prodCopy.getGrupoPrecificacao().setMargemLucroEstimada(prodMem.getGrupoPrecificacao().getMargemLucroEstimada());
//		prodCopy.getGrupoPrecificacao().setValorFinalProduto(prodMem.getGrupoPrecificacao().getValorFinalProduto());
		prodCopy.setDescricao(prodMem.getDescricao());
		prodCopy.setAno(prodMem.getAno());
		prodCopy.setId(prodMem.getId());
		prodCopy.setNome(prodMem.getNome());
		prodCopy.setMarca(prodMem.getMarca());
		prodCopy.setModelo(prodMem.getModelo());
		prodCopy.setStatus(prodMem.getStatus());
		prodCopy.setImagem(prodMem.getImagem());

		
		prodBD = prodCopy;
		return prodBD;
		
	}

	@Override
	public void apagar(EntidadeDominio entidade) {
		adapter.setAdapter(entidade);
		produtoRepository.deleteById(adapter.getObject().getId());
	}
}
