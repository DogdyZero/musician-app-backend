package br.com.musicianapp.domain;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Pessoa extends EntidadeDominio{
	
	@Id
	@GeneratedValue 
	@Column(name="pes_id")
	private int id;

	@Column(name="pes_nome")
	private String nome;
	
//	@Column(name="pes_usuario")
//	private Usuario usuario;
	
	@Column(name="pes_cpf")
	private String cpf;

	@Column(name="pes_rg")
	private String rg;
//	private Date dataAniversario;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="pes_id", referencedColumnName = "pes_id")
	private Set<Telefone> telefone;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="pes_id", referencedColumnName = "pes_id")	
	private Set<Cartao> cartao;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="pes_id", referencedColumnName = "pes_id")
	private Set<Endereco> endereco;
	
	public Pessoa() {
		
	}
	public Pessoa(String nome, Usuario usuario, String cpf, String rg, Date dataAniversario) {
		super();
		this.nome = nome;
//		this.usuario = usuario;
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
//	public Usuario getLogin() {
//		return usuario;
//	}
//	public void setLogin(Usuario usuario) {
//		this.usuario = usuario;
//	}
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
	public Set<Telefone> getTelefone() {
		return telefone;
	}
	public void setTelefones(Set<Telefone> telefone) {
		this.telefone = telefone;
	}
	public Set<Cartao> getCartoes() {
		return cartao;
	}
	public void setCartoes(Set<Cartao> cartoes) {
		this.cartao = cartoes;
	}
	public Set<Endereco> getEnderecos() {
		return endereco;
	}
	public void setEnderecos(Set<Endereco> enderecos) {
		this.endereco = enderecos;
	}
	
	
}
