package br.com.musicianapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.musicianapp.domain.Pedido;
import br.com.musicianapp.repository.PedidosRepository;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidosRepository pedidoRepository;
	
	@GetMapping
	public List<Pedido> consultarPedido(){
		return pedidoRepository.findAll();
	}
	
	@PostMapping
	public void salvarPedido(){
		
	}
	
	@PutMapping
	public Pedido alterarPedido(){
		return null;
	}
	
	@DeleteMapping
	public void deletarPedido(){
		
	}
	

}