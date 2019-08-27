package br.com.musicianapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.musicianapp.domain.CategoriaInstrumento;
import br.com.musicianapp.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public List<CategoriaInstrumento> consultarCategoria(){
		return categoriaRepository.findAll();
	}
	
	@PostMapping
	public void salvarCategoria(){
		
	}
	
	@PutMapping
	public CategoriaInstrumento alterarCategoria(){
		return null;
	}
	
	@DeleteMapping
	public void deletarProduto(){
		
	}
}
