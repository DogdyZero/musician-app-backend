package br.com.musicianapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;

@Entity @Component
@SequenceGenerator(name="endereco_generator", sequenceName = "endereco_seq", allocationSize=50,initialValue=1)
public class Endereco  extends EntidadeDominio{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_generator")
	@Column(name="end_id")
	private int id;
	
	@Column(name="end_cep")
	private String cep;
	
	@Column(name="end_tipo")
	private String tipoLogradouro;
	
	@Column(name="end_logradouro")
	private String logradouro;
	
	@Column(name="end_numero")
	private int numero;
	
	@Column(name="end_complemento")
	private String complemento;
	
	@Column(name="end_bairro")
	private String bairro;
	
	@Column(name="end_cidade")
	private String cidade;
	
	@Column(name="end_estado")
	private String estado;
	
	public Endereco() {
		
	}
	
	public Endereco(String cep, String tipoLogradouro, String logradouro, int numero, String complemento, String bairro,
			String cidade, String estado) {
		super();
		this.cep = cep;
		this.tipoLogradouro = tipoLogradouro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getTipoLogradouro() {
		return tipoLogradouro;
	}
	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
