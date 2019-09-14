package br.com.musicianapp.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="carrinho_compra")
@SequenceGenerator(name="carrinho_generator", sequenceName = "carrinho_produto_seq", allocationSize=50,initialValue=1)
public class CarrinhoCompra extends EntidadeDominio {

	@Id
	@Column(name="crc_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carrinho_generator")
	private int id;
	
	@JoinColumn(name="ipr_id")
	@OneToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private List<ItemProduto> itemProduto;
	
	@Column(name="crc_total_carrinho")
	private double totalCarrinho;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<ItemProduto> getItemProduto() {
		return itemProduto;
	}

	public void setItemProduto(List<ItemProduto> itemProduto) {
		this.itemProduto = itemProduto;
	}

	public double getTotalCarrinho() {
		return totalCarrinho;
	}

	public void setTotalCarrinho(double totalCarrinho) {
		this.totalCarrinho = totalCarrinho;
	}
	
	
	
}
