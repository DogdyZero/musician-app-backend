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
	
//	@OneToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE}, fetch=FetchType.EAGER)
//	@JoinColumn(name="pes_id")
//	private Usuario usuario;
	
	@Column(name="pes_cpf")
	private String cpf;

	@Column(name="pes_rg")
	private String rg;
//	private Date dataAniversario;
	
	@Column(name="pes_email")
	private String email;
	
	@JoinColumn(name="pes_id")
	@OneToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private Set<Telefone> telefone;

	@OneToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="pes_id")
	private Set<Cartao> cartao;

	@OneToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="pes_id")
	private Set<Endereco> endereco;
	
	@OneToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="pes_id")
	private Set<Pedido> pedido;
	
	@OneToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="pes_id")
	private Set<Compra> compra;
	
	@OneToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="pes_id")
	private Set<Cupom> cupom;
	
	@OneToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="pes_id")
	private Set<Troca> troca;
	
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
//	public Usuario getUsuario() {
//		return usuario;
//	}
//	public void setUsuario(Usuario usuario) {
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
	public Set<Pedido> getPedido() {
		return pedido;
	}
	public void setPedido(Set<Pedido> pedido) {
		this.pedido = pedido;
	}
	public Set<Compra> getCompra() {
		return compra;
	}
	public void setCompra(Set<Compra> compra) {
		this.compra = compra;
	}
	public Set<Cupom> getCupom() {
		return cupom;
	}
	public void setCupom(Set<Cupom> cupom) {
		this.cupom = cupom;
	}
	public Set<Troca> getTroca() {
		return troca;
	}
	public void setTroca(Set<Troca> troca) {
		this.troca = troca;
	}
	
	
	
}
