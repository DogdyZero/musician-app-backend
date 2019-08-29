package br.com.musicianapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import br.com.musicianapp.Enum.OrigemCupom;

@Entity
@Component
public class Cupom extends EntidadeDominio{
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="cupom_codigo")
	private String codigo;
	
	@Column(name="origem_cupom")
	private OrigemCupom origemCupom;
	
	@Column(name="cupom_valor")
	private double  valor;

	public Cupom() {
		
	}
	
	public Cupom(String codigo, double valor) {
		super();
		this.codigo = codigo;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
