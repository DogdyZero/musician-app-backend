package br.com.musicianapp.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.adapter.IAdapter;
import br.com.musicianapp.adapter.ProdutoAdapter;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Produto;
import br.com.musicianapp.impl.ConsultasPadrao;
import br.com.musicianapp.repository.ProdutoRepository;

@Service
public class ProdutoDao  extends AbstractDao  {	
	private List<EntidadeDominio> entidades;
	private IAdapter<Produto> adapter;
	private Optional<Produto> optProduto;
	
	public ProdutoDao() {
		adapter = new ProdutoAdapter<Produto>();
	}
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		adapter.setAdapter(entidade);
		if(adapter.getObject()!=null) {
			entidades = new ArrayList<EntidadeDominio>();
			ConsultasPadrao parametro=super.getParametro();
			if(parametro.equals(ConsultasPadrao.PRODUTO_TUDO)) {
				parametro=null;
				return consultarAll();
			}else if(parametro.equals(ConsultasPadrao.PRODUTO_ID)) {
				parametro = null;
				return consultaById(adapter.getObject());
			}
		}
		
		return null;
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
		prodCopy.getGrupoPrecificacao().setCustoCompra(prodMem.getGrupoPrecificacao().getCustoCompra());
		prodCopy.getGrupoPrecificacao().setMargemLucroEstimada(prodMem.getGrupoPrecificacao().getMargemLucroEstimada());
		prodCopy.getGrupoPrecificacao().setValorFinalProduto(prodMem.getGrupoPrecificacao().getValorFinalProduto());
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
	
	private List<EntidadeDominio> consultarAll(){
		List<Produto> produtos = produtoRepository.findAll();
		for (Produto prod : produtos) {
			entidades.add(prod);
		}
		return entidades;
	}
	
	private List<EntidadeDominio> consultaById(Produto produto){
		Optional<Produto> optionalProd = produtoRepository.findById(produto.getId());
		produto = optionalProd.get();
		entidades.add(produto);
		return entidades;
	}
	

}
