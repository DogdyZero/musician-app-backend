package br.com.musicianapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.musicianapp.domain.Cupom;
import br.com.musicianapp.repository.CuponsRepository;


@RestController
@RequestMapping("/Cupons")
public class CupomController {
	
	@Autowired
	private CuponsRepository cupomRepository;
	
	@GetMapping 
	public List<Cupom> consultarCupom(){
		return cupomRepository.findAll();
	}
	
	@PostMapping
	public void salvarCupom(){
		
	}
	
	@PutMapping
	public Cupom alterarCupom(){
		return null;
	}
	
	@DeleteMapping
	public void deletarCupom(){
		
	}
}
