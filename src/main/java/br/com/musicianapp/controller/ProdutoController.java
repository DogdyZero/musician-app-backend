package br.com.musicianapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.musicianapp.domain.Produto;
import br.com.musicianapp.impl.Resultado;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private Facade facade;
	
	@GetMapping
	public List<Produto> consultarProdutos(){
		return null;
	}
	
	@PostMapping
	public void salvarProduto(){
		
	}
	
	@PutMapping("{id}")
	public Object alterarProduto(@RequestBody Produto produto, int id){
		produto.setId(id);
		Resultado resultado = this.facade.alterar(produto);
		
		if(resultado!=null) {
			return resultado;
		}
		
		return null;
	}
	
	@DeleteMapping
	public void deletarProduto(){
		
	}
}
