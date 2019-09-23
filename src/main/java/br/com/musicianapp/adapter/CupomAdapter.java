package br.com.musicianapp.adapter;

import java.util.Set;

import br.com.musicianapp.domain.Cupom;
import br.com.musicianapp.domain.EntidadeDominio;

public class CupomAdapter<E> extends AbstractAdapter<E> {

	@Override
	public E getObject() {
		return (E)super.cupom;
	}

	@Override
	public Set<E> getListObject() {
		return null;
	}

}
