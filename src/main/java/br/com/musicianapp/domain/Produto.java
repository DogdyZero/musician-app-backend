package br.com.musicianapp.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity @Component
public class Produto extends EntidadeDominio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="prod_id")
	private int id;
	
	@Column(name="prod_ean")
	private String ean;
	
	@Column(name="prod_nome")
	private String nome;
	
	@Column(name="prod_modelo")
	private String modelo;
	
	@Column(name="prod_ano")
	private Date ano;
	
	@Column(name="prod_marca")
	private String marca;
	
	@Column(name="prod_imagem")
	private String pathImage;
	
	@Column(name="prod_desc")
	private String descricao;
	
	@Column(name="prod_qtd")
	private int quantidade;

	@OneToOne
	@JoinColumn(name="prod_categoria_id")
	private Categoria categoriaProduto;
	
	public Produto(){
		
	}

	public Produto(String nome, String modelo, Date ano, String marca,
			String pathImage, String descricao, int quantidade,
			Categoria categoriaProduto) {
		super();
		this.nome = nome;
		this.modelo = modelo;
		this.ano = ano;
		this.marca = marca;
		this.pathImage = pathImage;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.categoriaProduto = categoriaProduto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Date getAno() {
		return ano;
	}

	public void setAno(Date ano) {
		this.ano = ano;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPathImage() {
		return pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Categoria getCategoriaProduto() {
		return categoriaProduto;
	}

	public void setCategoriaProduto(Categoria categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}
	
	
	
	
}
