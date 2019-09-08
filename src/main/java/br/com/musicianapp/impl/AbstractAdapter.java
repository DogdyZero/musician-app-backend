package br.com.musicianapp.impl;

import java.util.Set;

import org.springframework.stereotype.Service;

import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Pessoa;
import br.com.musicianapp.domain.Telefone;
import br.com.musicianapp.domain.Usuario;

@Service
public abstract class AbstractAdapter<E> implements IAdapter<E>{

	protected Telefone telefone;
	protected Pessoa pessoa;
	
	protected Usuario usuario;
	
	protected Set<Telefone> telefones;
	
	public void setAdapter(EntidadeDominio entidade) {
		// cast to object
		if(entidade instanceof Pessoa) {this.pessoa = Pessoa.class.cast(entidade);}
		if(entidade instanceof Telefone) {this.telefone = Telefone.class.cast(entidade);}
		if(entidade instanceof Usuario) {this.usuario = Usuario.class.cast(entidade);}

		if(this.pessoa.getTelefone()!=null) {
			this.telefones = this.pessoa.getTelefone();
		}
	}
	
}
