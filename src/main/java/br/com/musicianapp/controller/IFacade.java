package br.com.musicianapp.controller;

import java.util.List;

import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.impl.Resultado;

public interface IFacade {
	public Resultado salvar(EntidadeDominio entidade);
	
	public Resultado alterar(EntidadeDominio entidade);
	
	public List<EntidadeDominio> consultar(EntidadeDominio entidade);
	
	public Resultado apagar(EntidadeDominio entidade);
	
}
