package br.com.musicianapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;

import br.com.musicianapp.Enum.Status;

@Entity @Component
@SequenceGenerator(name="telefone_generator", sequenceName = "telefone_seq", allocationSize=50,initialValue=1)
public class Telefone  extends EntidadeDominio{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "telefone_generator")
	@Column(name="tel_id")
	private int id;

	@Column(name="tel_ddd")
	private String ddd;

	@Column(name="tel_numero")
	private String numero;
	
	@Column(name="tel_status")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	
	public Telefone() {
		
	}	
	
	public Telefone(String ddd, String numero) {
		super();
		this.ddd = ddd;
		this.numero = numero;
	}
	public Telefone(String ddd, String numero, Status status) {
		super();
		this.ddd = ddd;
		this.numero = numero;
		this.status=status;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	
	
}
