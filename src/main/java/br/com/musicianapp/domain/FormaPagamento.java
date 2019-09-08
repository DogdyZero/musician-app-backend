package br.com.musicianapp.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@SequenceGenerator(name="form_pagamento_generator", sequenceName = "form_pagamento_seq", allocationSize=50,initialValue=1)
@Table(name="forma_pagamento")
public class FormaPagamento {
	@Id
	@Column(name="fmp_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "form_pagamento_generator")
	private int id;
	
	@OneToMany
	@JoinColumn(name="fmp_id")
	private List<Cartao> cartao;
	
	@OneToMany
	@JoinColumn(name="fmp_id")
	private List<Cupom> cupom;
	
	@Column(name="fmp_saldo")
	private double saldo;
	
	@Column(name="fmp_pago")
	private boolean pagoTudo;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Cartao> getCartao() {
		return cartao;
	}

	public void setCartao(List<Cartao> cartao) {
		this.cartao = cartao;
	}

	public List<Cupom> getCupom() {
		return cupom;
	}

	public void setCupom(List<Cupom> cupom) {
		this.cupom = cupom;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public boolean isPagoTudo() {
		return pagoTudo;
	}

	public void setPagoTudo(boolean pagoTudo) {
		this.pagoTudo = pagoTudo;
	}
	
	
	
}
