package br.com.musicianapp.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="pes_id", referencedColumnName = "pes_id")
	private Pessoa pessoa;
	
	public Telefone() {
		
	}
	
	public Telefone(String ddd, String numero) {
		super();
		this.ddd = ddd;
		this.numero = numero;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
