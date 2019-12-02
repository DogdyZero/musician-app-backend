package br.com.musicianapp.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity @Component
public class Frete {
	@Id
	@Column(name="fre_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "frete_seq")
	private int id;
	
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="end_id")
	private Endereco endereco;
	
	@Column(name="fre_calculo_frete")
	private double calculoFrete;
	
	@Column(name="fre_prazo")
	private Date prazoEntrega;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public double getCalculoFrete() {
		return calculoFrete;
	}

	public void setCalculoFrete(double calculoFrete) {
		this.calculoFrete = calculoFrete;
	}

	public Date getPrazoEntrega() {
		return prazoEntrega;
	}

	public void setPrazoEntrega(Date prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}
	
	
}
