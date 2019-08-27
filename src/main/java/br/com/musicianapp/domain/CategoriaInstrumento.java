package br.com.musicianapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class CategoriaInstrumento extends EntidadeDominio {
	
	@Id
	@GeneratedValue
	private int Id;
	
	@Column(name="categoria_nome")
	private String nome;
	
	//@OneToMany(mappedBy="categoriaProduto",targetEntity=Produto.class)
//	private Produto produto;
	
	public CategoriaInstrumento(){
		
	}
	
	public CategoriaInstrumento(String nome, Produto produto) {
		super();
		this.nome = nome;
//		this.produto = produto;
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

//	q	
	
	
	
}
