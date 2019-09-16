package br.com.musicianapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.ItemProduto;
import br.com.musicianapp.domain.Pedido;

@RestController
@CrossOrigin
@RequestMapping("/item")
public class ItemProdutoController {
	@Autowired
	private Facade facade;
	
	@Autowired
	private ItemProduto item;
	@PutMapping("{id}")
	public Pedido alterarPedido(@RequestBody ItemProduto item, @PathVariable int id){
		item.setId(id);
		this.facade.alterar(item);
		return null;
	}
	@GetMapping
	public List<ItemProduto> consultarPedido(){
		this.facade.setParametro("trade");
		List<EntidadeDominio> entidades = facade.consultar(this.item);
		List<ItemProduto> itens = new ArrayList<ItemProduto>();
		for (EntidadeDominio ent : entidades) {
			
			itens.add((ItemProduto)ent);
		}
		return itens;	
	}
	
}