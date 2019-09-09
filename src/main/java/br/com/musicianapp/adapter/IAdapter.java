package br.com.musicianapp.adapter;

import java.util.Set;

import br.com.musicianapp.domain.EntidadeDominio;

/**
 * 
 * This interface cast Entidade to class you need.
 * @author Douglas
 *
 */
public interface IAdapter<E> {
	public void setAdapter(EntidadeDominio entidade);

	public E getObject();
	
	public Set<E> getListObject();
}
