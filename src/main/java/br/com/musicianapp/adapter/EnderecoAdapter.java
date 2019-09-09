package br.com.musicianapp.adapter;

import java.util.Set;

public class EnderecoAdapter<E> extends AbstractAdapter<E> {

	@Override
	public E getObject() {
		return (E) super.endereco;
	}

	@Override
	public Set<E> getListObject() {
		return (Set<E>) super.enderecos;
	}

}
