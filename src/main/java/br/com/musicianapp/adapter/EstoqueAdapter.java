package br.com.musicianapp.adapter;

import java.util.Set;

public class EstoqueAdapter<E> extends AbstractAdapter<E> {

	@Override
	public E getObject() {
		return (E) super.estoque;
	}

	@Override
	public Set<E> getListObject() {
		return null;
	}

}
