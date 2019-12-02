package br.com.musicianapp.domain;

import java.util.Date;
import java.util.List;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Pessoa extends EntidadeDominio{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_seq")
	@Column(name="pes_id")
	private int id;

	@Column(name="pes_nome")
	private String nome;
	
	@Column(name="pes_cpf")
	private String cpf;

	@Column(name="pes_rg")
	private String rg;
	
	@Column(name="pes_genero")
	private String genero;
	
	@Column(name="pes_data_aniversario")
	@Temporal(TemporalType.DATE)
	private Date dataAniversario;
	
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
	private List<Pedido> pedido;
	
	@OneToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="pes_id")
	private Set<Cupom> cupom;
	
		
	public Pessoa() {
		
	}
	
	public Pessoa(Set<Endereco> endereco) {
		super();
		this.endereco = endereco;
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
	public Date getDataAniversario() {
		return dataAniversario;
	}
	public void setDataAniversario(Date dataAniversario) {
		this.dataAniversario = dataAniversario;
	}
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
	public List<Pedido> getPedido() {
		return pedido;
	}
	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}
	
	public Set<Cupom> getCupom() {
		return cupom;
	}

	public void setCupom(Set<Cupom> cupom) {
		this.cupom = cupom;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
}
