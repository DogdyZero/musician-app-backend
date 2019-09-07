package br.com.musicianapp.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;

import br.com.musicianapp.Enum.Perfil;
import br.com.musicianapp.Enum.Status;

@Entity
@Component
@SequenceGenerator(name="usuario_generator", sequenceName = "usuario_seq", allocationSize=50,initialValue=1)
public class Usuario extends EntidadeDominio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_generator")
	@Column(name="usu_id")
	private int id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="usu_perfil")
	private Perfil perfil;
	
	@Column(name="usu_login")
	private String login;
	
	@Column(name="usu_hashcode")
	private String hashCore;
	
	@Column(name="usu_senha")
	private String senha;
	
	@Column(name="usu_status")
	private Status status;

	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER)
	@JoinColumn(name="pes_id")
	private Pessoa pessoa;
	
	public Usuario() {
		
	}
	
	public Usuario(Perfil perfil, String senha) {
		super();
		this.perfil = perfil;
		this.senha = senha;
	}
	

	public Usuario(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}

	public Usuario(String hashCore) {
		super();
		this.hashCore = hashCore;
	}

	public Usuario(Perfil perfil, String login, String senha, Status status) {
		super();
		this.perfil = perfil;
		this.login = login;
		this.senha = senha;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getHashCore() {
		return hashCore;
	}

	public void setHashCore(String hashCore) {
		this.hashCore = hashCore;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	
	
	

}
