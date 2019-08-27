package br.com.musicianapp.daos;

import java.util.List;

import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.impl.IStyleQuery;

public abstract class AbstractDao implements IDAO, IStyleQuery {
	private String parametro;
	
	@Override
	public String getParametro() {
		return parametro;
	}
	@Override
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	@Override
	public abstract void salvar(EntidadeDominio entidade) ;

	@Override
	public abstract EntidadeDominio alterar(EntidadeDominio entidade);

	@Override
	public abstract List<EntidadeDominio> consultar(EntidadeDominio entidade) ;

	@Override
	public abstract void apagar(EntidadeDominio entidade) ;

}
