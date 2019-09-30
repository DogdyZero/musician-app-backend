package br.com.musicianapp.daos;

import java.util.List;

import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.impl.ConsultasPadrao;
import br.com.musicianapp.impl.IStyleQuery;

public abstract class AbstractDao implements IDAO, IStyleQuery {
	private ConsultasPadrao parametro;
	
	@Override
	public ConsultasPadrao getParametro() {
		return parametro;
	}
	@Override
	public void setParametro(ConsultasPadrao parametro) {
		this.parametro = parametro;
	}

	@Override
	public abstract EntidadeDominio salvar(EntidadeDominio entidade) ;

	@Override
	public abstract EntidadeDominio alterar(EntidadeDominio entidade);

	@Override
	public abstract List<EntidadeDominio> consultar(EntidadeDominio entidade) ;

	@Override
	public abstract void apagar(EntidadeDominio entidade) ;

}
