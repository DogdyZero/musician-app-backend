package br.com.musicianapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity @Component
public class HistoricoProduto {
	@Id
	@Column(name="hpr_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "historico_produto_seq")
	private int id;
	@OneToOne
	@JoinColumn(name="hpr_id")
	private Usuario usuario;
	
	@Column(name="hpr_tipo_mudanca")
	private String tipoMudanca;
	
	@Column(name="hpr_descricao")
	private String descricao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTipoMudanca() {
		return tipoMudanca;
	}

	public void setTipoMudanca(String tipoMudanca) {
		this.tipoMudanca = tipoMudanca;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
