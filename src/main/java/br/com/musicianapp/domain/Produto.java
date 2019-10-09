package br.com.musicianapp.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import br.com.musicianapp.Enum.Status;

@Entity @Component
@SequenceGenerator(name="produto_generator", sequenceName = "produto_seq", allocationSize=50,initialValue=1)
public class Produto extends EntidadeDominio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_generator")
	@Column(name="prod_id")
	private int id;
	
	@Column(name="prod_data_cadastro")
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;
	
	@Column(name="prod_nome")
	private String nome;

	@Column(name="prod_modelo")
	private String modelo;
	
	@Column(name="prod_ean")
	private String ean;
	
	@Column(name="prod_ano")
	private Date ano;
	
	@Column(name="prod_marca")
	private String marca;
	
	@Column(name="prod_imagem")
	private String pathImage;
	
	@Column(name="prod_foto_imagem")
	private byte[] imagem;
	
	@Transient
	@Column(name="prod_foto_imagem_")
	private String imagemString;
	
	@Column(name="prod_desc")
	private String descricao;
	
	@OneToOne
	@JoinColumn(name="prod_categoria_id")
	private Categoria categoria;
	
	@Column(name="prod_status")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name="prod_dimensao")
	private String dimensao;
	
	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER)
	@JoinColumn(name="grp_id")
	private GrupoPrecificacao grupoPrecificacao;

	public Produto(){
		
	}

	public Produto(String nome,double preco, String modelo, Date ano, String marca,
			String pathImage, String descricao, int quantidade,
			Categoria categoriaProduto) {
		super();
		this.nome = nome;
		this.modelo = modelo;
		this.ano = ano;
		this.marca = marca;
		this.pathImage = pathImage;
		this.descricao = descricao;
//		this.categoriaProduto = categoriaProduto;
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

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}	

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getDimensao() {
		return dimensao;
	}

	public void setDimensao(String dimensao) {
		this.dimensao = dimensao;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public String getImagemString() {
		return imagemString;
	}

	public void setImagemString(String imagemString) {
		this.imagemString = imagemString;
	}

	public GrupoPrecificacao getGrupoPrecificacao() {
		return grupoPrecificacao;
	}

	public void setGrupoPrecificacao(GrupoPrecificacao grupoPrecificacao) {
		this.grupoPrecificacao = grupoPrecificacao;
	}
	
}
