package br.com.musicianapp.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import br.com.musicianapp.Enum.StatusItem;

@Entity
@Component
@SequenceGenerator(name="troca_generator", sequenceName = "troca_seq", allocationSize=50,initialValue=1)
public class Troca {
	@Id
	@Column(name="tro_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "troca_generator")
	private int id;
	
	@Column(name="tro_data_solicitacao")
	@Temporal(TemporalType.DATE)
	private Date dataPedidoTroca;
	
	@Column(name="tro_data_resposta")
	@Temporal(TemporalType.DATE)
	private Date dataResposta;
	
	@Column(name="ipd_status_troca")
	@Enumerated(EnumType.STRING)
	private StatusItem statusItem;
	
	@Column(name="tro_descricao_problema")
	private String descricaoProblema;
	
	@Column(name="tro_resposta")
	private String resposta;
	
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="cpm_id")
	private Cupom cupom;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataPedidoTroca() {
		return dataPedidoTroca;
	}

	public void setDataPedidoTroca(Date dataPedidoTroca) {
		this.dataPedidoTroca = dataPedidoTroca;
	}

	public Date getDataResposta() {
		return dataResposta;
	}

	public void setDataResposta(Date dataResposta) {
		this.dataResposta = dataResposta;
	}

	public StatusItem getStatusItem() {
		return statusItem;
	}

	public void setStatusItem(StatusItem statusItem) {
		this.statusItem = statusItem;
	}

	public String getDescricaoProblema() {
		return descricaoProblema;
	}

	public void setDescricaoProblema(String descricaoProblema) {
		this.descricaoProblema = descricaoProblema;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public Cupom getCupom() {
		return cupom;
	}

	public void setCupom(Cupom cupom) {
		this.cupom = cupom;
	}
	
	
	
}
