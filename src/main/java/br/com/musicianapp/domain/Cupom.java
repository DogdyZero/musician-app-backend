package br.com.musicianapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;

import br.com.musicianapp.Enum.OrigemCupom;

@Entity
@Component
@SequenceGenerator(name="cupom_generator", sequenceName = "cupom_seq", allocationSize=50,initialValue=1)
public class Cupom extends EntidadeDominio{
	
	@Id
	@Column(name="cpm_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cupom_generator")
	private int id;
	
	@Column(name="cpm_codigo")
	private String codigo;
	
	@Column(name="cpm_origem_cupom")
	private OrigemCupom origemCupom;
	
	@Column(name="cpm_valor")
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
