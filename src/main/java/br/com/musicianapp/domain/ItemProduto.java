package br.com.musicianapp.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;

import br.com.musicianapp.Enum.StatusItem;

@Entity
@Component
@SequenceGenerator(name="item_produto_generator", sequenceName = "item_produto_seq", allocationSize=50,initialValue=1)
public class ItemProduto extends EntidadeDominio{
	@Id
	@Column(name="ipr_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_produto_generator")
	private int id;
	
	@Column(name="prod_cod_barras")
	private String codigoBarras;
	
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="prod_id")
	private Produto produto;
	
	@Column(name="ipd_quantidade")
	private int quantidade;
	
	@Column(name="ipd_valor_produto")
	private double valorProduto;
	
	@Column(name="ipd_status_troca")
	@Enumerated(EnumType.STRING)
	private StatusItem statusItem;
	
	
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

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}

	public StatusItem getStatusItem() {
		return statusItem;
	}

	public void setStatusItem(StatusItem statusItem) {
		this.statusItem = statusItem;
	}
	
	
}
