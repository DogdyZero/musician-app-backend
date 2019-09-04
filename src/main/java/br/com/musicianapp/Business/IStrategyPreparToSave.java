package br.com.musicianapp.Business;

import br.com.musicianapp.domain.EntidadeDominio;

public interface IStrategyPreparToSave {
	public EntidadeDominio processarDados(EntidadeDominio entidade);
}
