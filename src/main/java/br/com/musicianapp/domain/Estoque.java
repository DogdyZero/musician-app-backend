package br.com.musicianapp.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;

@Entity @Component
@SequenceGenerator(name="estoque_generator", sequenceName = "estoque_seq", allocationSize=50,initialValue=1)
public class Estoque {
	@Id
	@Column(name="est_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estoque_generator")
	private int id;
	
	@OneToOne
	@JoinColumn(name="est_item_produto")
	private ItemProduto item;

	@Column(name="est_qtd_produto")
	private int quantidadeProduto;
	
	@Column(name="est_data_entrada")
	private Date dataEntrada;
	
	@Column(name="est_data_venda")
	private Date dataVenda;
	
	@Column(name="est_fornecedor")
	private String fonecedor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ItemProduto getItem() {
		return item;
	}

	public void setItem(ItemProduto item) {
		this.item = item;
	}

	public int getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(int quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public String getFonecedor() {
		return fonecedor;
	}

	public void setFonecedor(String fonecedor) {
		this.fonecedor = fonecedor;
	}

		
}
