package br.com.musicianapp.domain;

import java.util.Date;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Entity @Component
public class Estoque {
	private int id;
	
	private ItemProduto item;
	
	private int quantidadeProduto;
	
	private Date dataEntrada;
	
	private Date dataVenda;
	
	
}
