package br.com.musicianapp.adapter;

import java.util.Set;

public class CartaoAdapter<E> extends AbstractAdapter<E> {

	@Override
	public E getObject() {
		return (E)super.cartao;
	}

	@Override
	public Set<E> getListObject() {
		return (Set<E>)super.cartoes;
	}

}
