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

@Entity @Component
@SequenceGenerator(name="precificacao_generator", sequenceName = "precificacao_seq", allocationSize=50,initialValue=1)
public class GrupoPrecificacao {
	@Id
	@Column(name="gpr_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "precificacao_generator")
	private int id;
	
	@Column(name="gpr_custo_compra")
	private double custoCompra;
	
	@Column(name="gpr_custo_operacional")
	private double custoOperacional;
	
	@Column(name="gpr_margem_lucro")
	private double margemLucroEstimada;
	
	@OneToOne
	@JoinColumn(name="gpr_id")
	private Frete frete;
	
	@Column(name="gpr_valor_final")
	private double valorFinalProduto;
	
	@OneToOne
	@JoinColumn(name="gpr_id")
	private ItemProduto item;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCustoCompra() {
		return custoCompra;
	}

	public void setCustoCompra(double custoCompra) {
		this.custoCompra = custoCompra;
	}

	public double getCustoOperacional() {
		return custoOperacional;
	}

	public void setCustoOperacional(double custoOperacional) {
		this.custoOperacional = custoOperacional;
	}

	public double getMargemLucroEstimada() {
		return margemLucroEstimada;
	}

	public void setMargemLucroEstimada(double margemLucroEstimada) {
		this.margemLucroEstimada = margemLucroEstimada;
	}

	public Frete getFrete() {
		return frete;
	}

	public void setFrete(Frete frete) {
		this.frete = frete;
	}

	public double getValorFinalProduto() {
		return valorFinalProduto;
	}

	public void setValorFinalProduto(double valorFinalProduto) {
		this.valorFinalProduto = valorFinalProduto;
	}

	public ItemProduto getItem() {
		return item;
	}

	public void setItem(ItemProduto item) {
		this.item = item;
	}
	
	
	
}
