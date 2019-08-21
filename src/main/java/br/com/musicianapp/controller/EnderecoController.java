package br.com.musicianapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.musicianapp.domain.Endereco;
import br.com.musicianapp.repository.EnderecosRepository;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecosRepository enderecoRepository;
	
	@GetMapping
	public List<Endereco> consultarEndereco(){
		return enderecoRepository.findAll();
	}
	
	@PostMapping
	public void salvarEndereco(){
		
	}
	
	@PutMapping
	public Endereco alterarEndereco(){
		return null;
	}
	
	@DeleteMapping
	public void deletarEndereco(){
		
	}
}
