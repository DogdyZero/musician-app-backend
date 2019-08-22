package br.com.musicianapp.controller;

import java.util.List;

import br.com.musicianapp.domain.EntidadeDominio;

public interface IFacade {
	public EntidadeDominio salvar(EntidadeDominio entidade);
	
	public EntidadeDominio alterar(EntidadeDominio entidade);
	
	public List<EntidadeDominio> consultar(EntidadeDominio entidade);
	
	public void apagar(EntidadeDominio entidade);
	
}
