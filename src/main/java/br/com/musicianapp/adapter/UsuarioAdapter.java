package br.com.musicianapp.adapter;

import java.util.Set;

public class UsuarioAdapter<E> extends AbstractAdapter<E> {

	@Override
	public E getObject() {
		return (E) super.usuario;
	}

	@Override
	public Set<E> getListObject() {
		return null;
	}

}
