package br.com.musicianapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.musicianapp.domain.Endereco;
import br.com.musicianapp.domain.EntidadeDominio;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private Facade facade;
	
	@GetMapping
	public List<Endereco> consultarEndereco(){
		return null;
	}
	
	@CrossOrigin
	@PostMapping
	public Endereco salvarEndereco(@RequestBody Endereco endereco){
		EntidadeDominio e = facade.salvar(endereco);
		if(e!=null)
			return (Endereco) e;
		else 
			return null;
	}
	
	@PutMapping
	public Endereco alterarEndereco(){
		return null;
	}
	
	@DeleteMapping
	public void deletarEndereco(){
		
	}
}
