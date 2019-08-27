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

import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Telefone;

@RestController
@RequestMapping("/telefones")
public class TelefoneController {
	
	@Autowired
	private Facade facade;
	
	@GetMapping
	public List<Telefone> consultarTelefones(){
		return null;
	}
	
	@PostMapping
	public Telefone salvarTelefone(@RequestBody Telefone telefone){
//		EntidadeDominio e = facade.salvar(telefone);
//		if(e!=null)
//			return (Telefone) e;
//		else 
			return null;
	}
	
	@PutMapping
	public Telefone alterarTelefone(){
		return null;
	}
	
	@DeleteMapping
	public void deletarTelefone(){
		
	}

}
