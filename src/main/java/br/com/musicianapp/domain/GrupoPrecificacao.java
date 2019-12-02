package br.com.musicianapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity @Component
public class GrupoPrecificacao {
	@Id
	@Column(name="grp_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grupo_precificacao_seq")
	private int id;
	
	@Column(name="gpr_custo_compra")
	private double custoCompra;
	
	@Column(name="gpr_margem_lucro")
	private double margemLucroEstimada;
	
	@Column(name="gpr_valor_final")
	private double valorFinalProduto;
	
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

	public double getMargemLucroEstimada() {
		return margemLucroEstimada;
	}

	public void setMargemLucroEstimada(double margemLucroEstimada) {
		this.margemLucroEstimada = margemLucroEstimada;
	}

	public double getValorFinalProduto() {
		return valorFinalProduto;
	}

	public void setValorFinalProduto(double valorFinalProduto) {
		this.valorFinalProduto = valorFinalProduto;
	}

}
