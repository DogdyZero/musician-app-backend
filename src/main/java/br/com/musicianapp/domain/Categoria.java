package br.com.musicianapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Categoria extends EntidadeDominio {
	
	@Id
	@GeneratedValue
	private int Id;
	
	@Column(name="categoria_nome")
	private String nome;
	
	@OneToMany(mappedBy="categoriaProduto",targetEntity=Produto.class)
	private Produto produto;
	
	public Categoria(){
		
	}
	
	public Categoria(String nome, Produto produto) {
		super();
		this.nome = nome;
		this.produto = produto;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	
	
}
