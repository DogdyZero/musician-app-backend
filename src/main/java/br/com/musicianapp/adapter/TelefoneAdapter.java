package br.com.musicianapp.adapter;

import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class TelefoneAdapter<E> extends AbstractAdapter<E>{
	
	@Override
	public E getObject() {
		return (E) super.telefone;
	}

	@Override
	public Set<E> getListObject() {
		return (Set<E>) super.telefones;
	}
	
}
