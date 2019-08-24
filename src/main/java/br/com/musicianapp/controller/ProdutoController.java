package br.com.musicianapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.musicianapp.domain.Produto;
import br.com.musicianapp.repository.ProdutoRepository;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository pRepository;
	
	@GetMapping
	public List<Produto> consultarProdutos(){
		return pRepository.findAll();
	}
	
	@PostMapping
	public void salvarProduto(){
		
	}
	
	@PutMapping
	public Produto alterarProduto(){
		return null;
	}
	
	@DeleteMapping
	public void deletarProduto(){
		
	}
}
