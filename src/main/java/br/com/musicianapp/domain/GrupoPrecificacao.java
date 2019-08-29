package br.com.musicianapp.domain;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Entity @Component
public class GrupoPrecificacao {
	private int id;
	
	private ItemProduto item;
	
	private double custoCompra;
	
	private double custoOperacional;
	
	private double margemLucroEstimada;
	
	private Frete frete;
	
	private double valorFinalPedido;
}
