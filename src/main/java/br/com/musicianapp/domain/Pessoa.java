package br.com.musicianapp.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;

@Entity
@Component
@SequenceGenerator(name="pessoa_generator", sequenceName = "pessoa_seq", allocationSize=50,initialValue=1)
public class Pessoa extends EntidadeDominio{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_generator")
	@Column(name="pes_id")
	private int id;

	@Column(name="pes_nome")
	private String nome;
	
	@OneToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinColumn(name="pes_id")
	private Usuario usuario;
	
	@Column(name="pes_cpf")
	private String cpf;

	@Column(name="pes_rg")
	private String rg;
//	private Date dataAniversario;
	
	@OneToMany(cascade= { CascadeType.MERGE}, fetch=FetchType.EAGER, orphanRemoval=true)
	@JoinColumn(name="pes_tel_id")
	private Set<Telefone> telefone;

	@OneToMany(cascade= {CascadeType.PERSIST, CascadeType.DETACH}, fetch=FetchType.EAGER)
	@JoinColumn(name="pes_id")
	private Set<Cartao> cartao;

	@OneToMany(cascade= {CascadeType.PERSIST, CascadeType.DETACH}, fetch=FetchType.EAGER)
	@JoinColumn(name="pes_id")
	private Set<Endereco> endereco;
	
	@Column(name="pes_email")
	private String email;
	
	
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
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
	public Set<Telefone> getTelefone() {
		return telefone;
	}
	public void setTelefone(Set<Telefone> telefone) {
		this.telefone = telefone;
	}
	public Set<Cartao> getCartao() {
		return cartao;
	}
	public void setCartao(Set<Cartao> cartoes) {
		this.cartao = cartoes;
	}
	public Set<Endereco> getEndereco() {
		return endereco;
	}
	public void setEndereco(Set<Endereco> enderecos) {
		this.endereco = enderecos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
