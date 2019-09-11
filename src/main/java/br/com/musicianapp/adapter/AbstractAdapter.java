package br.com.musicianapp.adapter;

import java.util.Set;

import org.springframework.stereotype.Service;

import br.com.musicianapp.domain.Cartao;
import br.com.musicianapp.domain.Endereco;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Pessoa;
import br.com.musicianapp.domain.Produto;
import br.com.musicianapp.domain.Telefone;
import br.com.musicianapp.domain.Usuario;

@Service
public abstract class AbstractAdapter<E> implements IAdapter<E>{

	protected Telefone telefone;
	protected Pessoa pessoa;
	
	protected Usuario usuario;
	protected Endereco endereco;
	protected Cartao cartao;
	protected Produto produto;
	
	protected Set<Telefone> telefones;
	protected Set<Endereco> enderecos;
	protected Set<Cartao> cartoes;

	
	public void setAdapter(EntidadeDominio entidade) {
		// cast to object
		if(entidade instanceof Pessoa) {this.pessoa = Pessoa.class.cast(entidade);}
		if(entidade instanceof Usuario) {this.usuario = Usuario.class.cast(entidade);}
		if(entidade instanceof Telefone) {this.telefone = Telefone.class.cast(entidade);}
		if(entidade instanceof Endereco) {this.endereco = Endereco.class.cast(entidade);}
		if(entidade instanceof Cartao) {this.cartao = Cartao.class.cast(entidade);}
		if(entidade instanceof Produto) {this.produto = Produto.class.cast(entidade);}
		
		if(this.usuario!=null) {
			if(this.usuario.getPessoa()!=null) {this.pessoa = this.usuario.getPessoa();}
		}

		if(this.pessoa!=null) {
			if(this.pessoa.getTelefone()!=null) {this.telefones = this.pessoa.getTelefone();}
			if(this.pessoa.getEndereco()!=null) {this.enderecos = this.pessoa.getEndereco();}
			if(this.pessoa.getCartao()!=null) {this.cartoes = this.pessoa.getCartao();}
		}
	}
	
}
