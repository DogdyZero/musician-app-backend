package br.com.musicianapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Entity @Component
public class Telefone  extends EntidadeDominio{
	
	@Id
	@GeneratedValue
	@Column(name="tel_id")
	private int id;

	@Column(name="tel_ddd")
	private String ddd;

	@Column(name="tel_numero")
	private String numero;
	
	@ManyToOne
	@JoinColumn(name="pes_tel_id")
	private Pessoa pessoaTelefone;
	
	public Telefone() {
		
	}
	
	public Telefone(String ddd, String numero) {
		super();
		this.ddd = ddd;
		this.numero = numero;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
}
