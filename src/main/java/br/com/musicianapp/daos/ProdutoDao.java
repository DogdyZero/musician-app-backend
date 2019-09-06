package br.com.musicianapp.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Pessoa;
import br.com.musicianapp.domain.Produto;
import br.com.musicianapp.repository.ProdutoRepository;

@Service
public class ProdutoDao  extends AbstractDao  {	
	private final String CLASSE = Produto.class.getName();
	List<EntidadeDominio> entidades;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	private Produto convertClass(EntidadeDominio entidade) {
		if(entidade.getClass().getName().equals(CLASSE)) {
			return (Produto)entidade;
		}
		return null;
	}
	
	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		entidades = new ArrayList<EntidadeDominio>();
		String parametro=super.getParametro().toLowerCase();
		if(entidade.getClass().getName().equals(CLASSE)) {
			Produto produto = (Produto)entidade;
			if(parametro.equals("all")) {
				parametro=null;
				return consultarAll();
			}else if(parametro.equals("prodid")) {
				parametro = null;
				return consultaById(produto);
			}
		}
		return null;
	}

	@Override
	public EntidadeDominio salvar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntidadeDominio alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void apagar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		
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
