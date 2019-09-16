package br.com.musicianapp.adapter;

import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class PedidoAdapter<E> extends AbstractAdapter<E> {

	@Override
	public E getObject() {
		return (E) super.pedido;
	}

	@Override
	public Set<E> getListObject() {
		return null;
	}

}
