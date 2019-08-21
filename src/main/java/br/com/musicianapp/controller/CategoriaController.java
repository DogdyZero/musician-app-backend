package br.com.musicianapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.musicianapp.domain.Categoria;
import br.com.musicianapp.repository.CategoriasRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriasRepository categoriaRepository;
	
	@GetMapping
	public List<Categoria> consultarCategoria(){
		return categoriaRepository.findAll();
	}
	
	@PostMapping
	public void salvarCategoria(){
		
	}
	
	@PutMapping
	public Categoria alterarCategoria(){
		return null;
	}
	
	@DeleteMapping
	public void deletarProduto(){
		
	}
}
