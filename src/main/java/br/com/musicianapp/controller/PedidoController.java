package br.com.musicianapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.musicianapp.controller.viewhelper.CadastroPedidoVH;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Pedido;
import br.com.musicianapp.impl.ConsultasPadrao;

@CrossOrigin
@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	private Facade facade;
	
	@Autowired
	private Pedido pedido;
	
	@Autowired
	private CadastroPedidoVH cadastroPedidoVH;
	
	@GetMapping
	public List<Pedido> consultarPedido(){
		this.facade.setParametro(ConsultasPadrao.PEDIDO_TUDO);
		List<EntidadeDominio> entidades = facade.consultar(this.pedido);
		List<Pedido> pedidos = new ArrayList<Pedido>();
		for (EntidadeDominio ent : entidades) {
			
			pedidos.add((Pedido)ent);
		}
		return pedidos;	
	}
	
	@GetMapping("/pedido/{idusuario}")
	public Pedido consultarPedidoPorUsuario(@PathVariable int id){
		this.facade.setParametro(ConsultasPadrao.PEDIDO_POR_USUARIO);
		List<EntidadeDominio> entidades = facade.consultar(this.pedido);
		return (Pedido) entidades.get(0);	
	}
	
	@GetMapping("{id}")
	public Pedido consultarPedidoPorId(@PathVariable int id){
		this.facade.setParametro(ConsultasPadrao.PEDIDO_ID);
		this.pedido.setId(id);
		List<EntidadeDominio> entidades = facade.consultar(this.pedido);
		return (Pedido) entidades.get(0);	
	}
		
	@PostMapping
	public Pedido salvarPedido(@RequestBody Pedido pedido){
		pedido = (Pedido) cadastroPedidoVH.prepararSalvar(pedido);
		facade.salvar(pedido);
		System.out.println(pedido);
		return pedido;
	}
	
	@PutMapping("{id}")
	public Pedido alterarPedido(@RequestBody Pedido pedido, @PathVariable int id){
		pedido.setId(id);
		this.facade.alterar(pedido);
		return null;
	}
	
	@DeleteMapping
	public void deletarPedido(){
		
	}
	

}
