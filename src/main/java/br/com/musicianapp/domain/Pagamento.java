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

import org.springframework.stereotype.Component;

@Entity
@Component
public class Pagamento {
	@Id
	@Column(name="pag_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pagamento_seq")
	private int id;
	
	@JoinColumn(name="pag_id")
	@OneToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private List<FormaPagamento> formaPagamento;
	
	@Column(name="pag_total")
	private double totalPago;
	
	@Column(name="pag_pagamento_efetivado")
	private boolean statusPagamento;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<FormaPagamento> getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(List<FormaPagamento> formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public double getTotalPago() {
		return totalPago;
	}

	public void setTotalPago(double totalPago) {
		this.totalPago = totalPago;
	}

	public boolean isStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(boolean statusPagamento) {
		this.statusPagamento = statusPagamento;
	}
	
	
}
