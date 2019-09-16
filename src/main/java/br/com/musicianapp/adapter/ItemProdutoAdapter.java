package br.com.musicianapp.adapter;

import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class ItemProdutoAdapter<E> extends AbstractAdapter<E> {

	@Override
	public E getObject() {
		return (E) super.itemProduto;
	}

	@Override
	public Set<E> getListObject() {
		// TODO Auto-generated method stub
		return null;
	}

}
