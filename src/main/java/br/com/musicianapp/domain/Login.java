package br.com.musicianapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import br.com.musicianapp.Enum.Perfil;

@Entity
@Component
public class Login extends EntidadeDominio {
	
	@Id
	@GeneratedValue
	@Column(name="login_id")
	private int id;
	
	@Column(name="pes_perfil")
	private Perfil perfil;
	
	@Column(name="login_senha")
	private String senha;

	public Login(Perfil perfil, String senha) {
		super();
		this.perfil = perfil;
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
	
	
	
	

}
