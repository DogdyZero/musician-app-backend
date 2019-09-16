package br.com.musicianapp.domain;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import br.com.musicianapp.Enum.StatusPedido;

@Entity
@Component
@SequenceGenerator(name="pedido_generator", sequenceName = "pedido_seq", allocationSize=50,initialValue=1)
public class Pedido extends EntidadeDominio{

	@Id
	@Column(name="ped_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido_generator")
	private int id;
	
	@OneToOne(cascade=CascadeType.MERGE)
	private CarrinhoCompra carrinhoCompra;
	
	@OneToOne(cascade=CascadeType.MERGE)
	private Frete frete;
	
	@OneToOne(cascade=CascadeType.MERGE)
	private Pagamento pagamento;
	
	@Column(name="ped_valor")
	private double total;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name="ped_data")
	private Date data;
	
	@Column(name="ped_status")
	@Enumerated(EnumType.STRING)
	private StatusPedido statusPedido;
	
	public Pedido() {}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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


	public CarrinhoCompra getCarrinhoCompra() {
		return carrinhoCompra;
	}


	public void setCarrinhoCompra(CarrinhoCompra carrinhoCompra) {
		this.carrinhoCompra = carrinhoCompra;
	}


	public Frete getFrete() {
		return frete;
	}


	public void setFrete(Frete frete) {
		this.frete = frete;
	}


	public Pagamento getPagamento() {
		return pagamento;
	}


	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}


	public StatusPedido getStatusPedido() {
		return statusPedido;
	}


	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

	
		
}
