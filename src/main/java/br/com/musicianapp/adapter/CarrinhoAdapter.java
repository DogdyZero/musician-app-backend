package br.com.musicianapp.adapter;

import java.util.Set;

public class CarrinhoAdapter<T> extends AbstractAdapter<T> {

	@Override
	public T getObject() {
		return (T) super.carrinhoCompra;
	}

	@Override
	public Set<T> getListObject() {
		// TODO Auto-generated method stub
		return null;
	}

}
