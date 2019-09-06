package br.com.musicianapp.daos;

import java.util.List;

import br.com.musicianapp.domain.EntidadeDominio;

public interface IDAO {
	public EntidadeDominio salvar(EntidadeDominio entidade);
	
	public EntidadeDominio alterar(EntidadeDominio entidade);
	
	public EntidadeDominio alterar (EntidadeDominio entidade, int id);
	
	public List<EntidadeDominio> consultar (EntidadeDominio entidade);
	
	public void apagar(EntidadeDominio entidade);
}
