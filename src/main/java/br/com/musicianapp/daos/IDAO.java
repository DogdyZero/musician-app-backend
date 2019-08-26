package br.com.musicianapp.daos;

import java.util.List;

import br.com.musicianapp.domain.EntidadeDominio;

public interface IDAO {
	public void salvar(EntidadeDominio entidade);
	
	public EntidadeDominio alterar(EntidadeDominio entidade);
	
	public List<EntidadeDominio> consultar (EntidadeDominio entidade);
	
	public void apagar(EntidadeDominio entidade);
}
