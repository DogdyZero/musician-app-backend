package br.com.musicianapp.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	
	@OneToOne
	@JoinColumn(name="ped_id")
	private Pessoa pessoa;
	
	@OneToMany
	@JoinColumn(name="ped_id")
	private List<ItemProduto> itemProduto;
	
	@Column(name="ped_frete")
	private double frete;
	
	@Column(name="ped_valor")
	private double total;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name="ped_data")
	private Date data;
	
	@Column(name="ped_status")
	private StatusPedido status;
	
	public Pedido() {}
	
	public Pedido(Pessoa cliente, double frete, double total,
			Date data, StatusPedido status) {
		super();
		this.pessoa = pessoa;
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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

	public List<ItemProduto> getItemProduto() {
		return itemProduto;
	}

	public void setItemProduto(List<ItemProduto> itemProduto) {
		this.itemProduto = itemProduto;
	}
	
	
		
}
