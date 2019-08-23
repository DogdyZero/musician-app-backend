package br.com.musicianapp.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import br.com.musicianapp.Enum.StatusPedido;

@Entity
@Component
public class Pedido extends EntidadeDominio{

	@Id
	@GeneratedValue
	private int id;
	
	@OneToOne
	@JoinColumn(name="ped_pes_id")
	private Pessoa cliente;
	
	@OneToMany(mappedBy="pedido",fetch=FetchType.LAZY)
	private List<Produto> produtos;
	
	@Column(name="ped_frete")
	private double frete;
	
	@Column(name="ped_valor")
	private double total;
	
	@Column(name="ped_data")
	private Date data;
	
	@Column(name="ped_status")
	private StatusPedido status;

	public Pedido() {}
	
	public Pedido(Pessoa cliente, double frete, double total,
			Date data, StatusPedido status) {
		super();
		this.cliente = cliente;
		this.frete = frete;
		this.total = total;
		this.data = data;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public double getFrete() {
		return frete;
	}

	public void setFrete(double frete) {
		this.frete = frete;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}
	
		
}
