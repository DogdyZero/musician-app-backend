package br.com.musicianapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;

@Entity
@Component
@SequenceGenerator(name="categoria_generator", sequenceName = "categoria_seq", allocationSize=50,initialValue=1)
public class Categoria extends EntidadeDominio {
	
	@Id
	@Column(name="cat_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoria_generator")
	private int Id;
	
	@Column(name="cat_nome")
	private String nome;
	
	@OneToOne
	@JoinColumn(name="cat_id")
	private Produto produto;
	
	public Categoria(){
		
	}
	
	public Categoria(String nome, Produto produto) {
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

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	
	
	
}
