package br.com.musicianapp.impl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;
@Entity
@Component
@Table(name="logger_resource")
@SequenceGenerator(name="logger_generator", sequenceName = "logger_resource_seq")
public class LoggerResource {
	@Id
	@Column(name="log_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "logger_generator")
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="log_data")
	private Date data;
	
	@Column(name="log_id_requisitado")
	private int idRequisitado;
	
	@Column(name="log_ocorrencia")
	private String ocorrencia;
	
	@Column(name="log_nome_objeto")
	private String nomeObjeto;
	
	@Column(name="log_nome_classe")
	private String nomeClasse;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getIdRequisitado() {
		return idRequisitado;
	}

	public void setIdRequisitado(int idRequisitado) {
		this.idRequisitado = idRequisitado;
	}

	public String getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(String ocorrencia) {
		this.ocorrencia = ocorrencia;
	}

	public String getNomeObjeto() {
		return nomeObjeto;
	}

	public void setNomeObjeto(String nomeObjeto) {
		this.nomeObjeto = nomeObjeto;
	}

	public String getNomeClasse() {
		return nomeClasse;
	}

	public void setNomeClasse(String nomeClasse) {
		this.nomeClasse = nomeClasse;
	}
	
	
	
}
