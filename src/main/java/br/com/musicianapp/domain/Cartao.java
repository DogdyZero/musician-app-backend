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
@SequenceGenerator(name="cartao_generator", sequenceName = "cartao_seq", allocationSize=50,initialValue=1)
public class Cartao extends TipoPagamento{
	
	@Id
	@Column(name="car_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cartao_generator")
	private int id;
	
	@Column(name="car_nome_cartao")
	private String nomeCartao;
	
	@Column(name="car_numero_cartao")
	private String numeroCartao;
	
	@Column(name="car_validade")
	private String validade;
	
	@Column(name="car_cod_seguranca")
	private int codSeguranca;

	@Column(name="car_bandeira")
	@Enumerated(EnumType.STRING)
	private Bandeira bandeira;
	
	@Column(name="car_preferencial")
	private boolean preferencial;
	
	@Enumerated(EnumType.STRING)
	@Column(name="car_status")
	private Status status;
	
	public Cartao() {
	}
	public Cartao(String nomeCartao, String numeroCartao, String validade, int codSeguranca, Bandeira bandeira) {
		super();
		this.nomeCartao = nomeCartao;
		this.numeroCartao = numeroCartao;
		this.validade = validade;
		this.codSeguranca = codSeguranca;
		this.bandeira = bandeira;
	}
	
	public Cartao(String nomeCartao, String numeroCartao, String validade, int codSeguranca, Bandeira bandeira,
			boolean preferencial, Status status) {
		super();
		this.nomeCartao = nomeCartao;
		this.numeroCartao = numeroCartao;
		this.validade = validade;
		this.codSeguranca = codSeguranca;
		this.bandeira = bandeira;
		this.preferencial = preferencial;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeCartao() {
		return nomeCartao;
	}
	public void setNomeCartao(String nomeCartao) {
		this.nomeCartao = nomeCartao;
	}
	public String getNumeroCartao() {
		return numeroCartao;
	}
	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	public String getValidade() {
		return validade;
	}
	public void setValidade(String validade) {
		this.validade = validade;
	}
	public int getCodSeguranca() {
		return codSeguranca;
	}
	public void setCodSeguranca(int codSeguranca) {
		this.codSeguranca = codSeguranca;
	}
	public Bandeira getBandeira() {
		return bandeira;
	}
	public void setBandeira(Bandeira bandeira) {
		this.bandeira = bandeira;
	}
	public boolean isPreferencial() {
		return preferencial;
	}
	public void setPreferencial(boolean preferencial) {
		this.preferencial = preferencial;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
}
