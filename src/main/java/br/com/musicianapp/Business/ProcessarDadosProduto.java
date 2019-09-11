package br.com.musicianapp.Business;

import java.util.Random;

import org.springframework.stereotype.Service;

import br.com.musicianapp.Enum.Status;
import br.com.musicianapp.adapter.IAdapter;
import br.com.musicianapp.adapter.ProdutoAdapter;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Produto;

@Service
public class ProcessarDadosProduto implements IStrategyPreparToSave{
	
	private IAdapter<Produto> adapter;
	
	public ProcessarDadosProduto() {
		adapter = new ProdutoAdapter<Produto>();
	}
	
	@Override
	public EntidadeDominio processarDados(EntidadeDominio entidade) {
		adapter.setAdapter(entidade);
		Produto produto = adapter.getObject();
		
		if(produto.getNome()!=null)
			produto.setNome(produto.getNome().toUpperCase());

		if(produto.getMarca()!=null)
			produto.setMarca(produto.getMarca().toUpperCase());
		
		if(produto.getModelo()!=null)
			produto.setModelo(produto.getModelo().toUpperCase());
		
		if(produto.getStatus()==null)
			produto.setStatus(Status.ATIVO);
		
		if(produto.getMarca()!=null &&
				produto.getModelo()!=null &&
				produto.getNome()!=null)
			produto.setEan(generateEan(produto));
		
		return produto;
	}
	
	private String generateEan(Produto produto) {
		Random r = new Random();
		
		String marca = produto.getMarca().substring(0,3).toUpperCase();
		String modelo = produto.getModelo().substring(0,3).toUpperCase();
		String nome = produto.getNome().substring(0,3).toUpperCase();

		int idGenerate = r.nextInt(100);
		
		
		return marca+"_"+modelo+"_"+nome+"_"+idGenerate;
	}

}
