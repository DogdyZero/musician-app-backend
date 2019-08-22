package br.com.musicianapp.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Pessoa  extends EntidadeDominio{
	
	@Id
	@GeneratedValue
	@Column(name="pes_id")
	private int id;

	@Column(name="pes_nome")
	private String nome;
	
	@Column(name="pes_cpf")
	private String cpf;

	@Column(name="pes_rg")
	private String rg;
//	private Date dataAniversario;
	
	@OneToMany(mappedBy="pessoa",fetch=FetchType.LAZY)
	private List<Telefone> telefones;

	@OneToMany(mappedBy="pessoa",fetch=FetchType.LAZY)
	private List<Cartao> cartoes;

	@OneToMany(mappedBy="pessoa",fetch=FetchType.LAZY)
	private List<Endereco> enderecos;
	
	public Pessoa() {
		
	}
	public Pessoa(String nome, String cpf, String rg, Date dataAniversario) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
//		this.dataAniversario = dataAniversario;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
//	public Date getDataAniversario() {
//		return dataAniversario;
//	}
//	public void setDataAniversario(Date dataAniversario) {
//		this.dataAniversario = dataAniversario;
//	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	public List<Cartao> getCartoes() {
		return cartoes;
	}
	public void setCartoes(List<Cartao> cartoes) {
		this.cartoes = cartoes;
	}
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	
}
