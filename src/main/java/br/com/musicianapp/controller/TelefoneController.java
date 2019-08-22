package br.com.musicianapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.musicianapp.domain.Telefone;
import br.com.musicianapp.repository.TelefonesRepository;

@RestController
@RequestMapping("/telefones")
public class TelefoneController {
	
	@Autowired
	private TelefonesRepository telefoneRepository;
	
	@GetMapping
	public List<Telefone> consultarTelefones(){
		return telefoneRepository.findAll();
	}
	
	@PostMapping
	public void salvarTelefone(){
		
	}
	
	@PutMapping
	public Telefone alterarTelefone(){
		return null;
	}
	
	@DeleteMapping
	public void deletarTelefone(){
		
	}

}
