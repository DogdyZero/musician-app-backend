package br.com.musicianapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.musicianapp.domain.Cartao;
import br.com.musicianapp.repository.CartaoRepository;


@RestController
@RequestMapping("/cartoes")
public class CartaoController {

	private CartaoRepository cardRepo;
	
	@GetMapping
	public List<Cartao> consultarCartao(){
		return cardRepo.findAll();
	}
	
	@PostMapping
	public void salvarCartao(){
		
	}
	
	@PutMapping
	public Cartao alterarCartao(){
		return null;
	}
	
	@DeleteMapping
	public void deletarCartao(){
		
	}
	
	
}
