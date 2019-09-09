package br.com.musicianapp.adapter;

import java.util.Set;

public class PessoaAdapter<T> extends AbstractAdapter<T> {

	@Override
	public T getObject() {
		return (T) super.pessoa;
	}

	@Override
	public Set<T> getListObject() {
		return null;
	}

}
