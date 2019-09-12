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
@SequenceGenerator(name="item_produto_generator", sequenceName = "item_produto_seq", allocationSize=50,initialValue=1)
public class ItemProduto {
	@Id
	@Column(name="ipr_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_produto_generator")
	private int id;
	
	@Column(name="prod_cod_barras")
	private String codigoBarras;
	
	@OneToOne
	@JoinColumn(name="prod_id")
	private Produto produto;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	
	
}
