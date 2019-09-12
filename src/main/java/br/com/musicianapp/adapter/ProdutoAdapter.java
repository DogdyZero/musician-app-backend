package br.com.musicianapp.adapter;

import java.util.Set;

public class ProdutoAdapter<E> extends AbstractAdapter<E> {

	@Override
	public E getObject() {
		return (E) super.produto;
	}

	@Override
	public Set<E> getListObject() {
		// TODO Auto-generated method stub
		return null;
	}

}
