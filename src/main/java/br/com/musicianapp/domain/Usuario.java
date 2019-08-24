package br.com.musicianapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.print.attribute.IntegerSyntax;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.musicianapp.Enum.Perfil;
import br.com.musicianapp.impl.IStyleQuery;

@Entity
@Component
public class Usuario extends EntidadeDominio {
	
	@Id
	@GeneratedValue
	@Column(name="log_id")
	private int id;
	
	@Column(name="pes_perfil")
	private Perfil perfil;
	
	@Column(name="usu_login")
	private String login;
	
	@Column(name="usu_hashcode")
	private String hashCore;
	
	@Column(name="log_senha")
	private String senha;

	public Usuario() {
		
	}
	
	public Usuario(Perfil perfil, String senha) {
		super();
		this.perfil = perfil;
		this.senha = senha;
	}

	public Usuario(String hashCore) {
		super();
		this.hashCore = hashCore;
	}

	public Usuario(Perfil perfil, String login, String senha) {
		super();
		this.perfil = perfil;
		this.login = login;
		this.senha = senha;
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
	
	
	
	

}
