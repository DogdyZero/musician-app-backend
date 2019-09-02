package br.com.musicianapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Telefone;

@RestController
@RequestMapping("/telefones")
public class TelefoneController {
	
	@Autowired
	private Facade facade;
	
	@Autowired 
	private Telefone telefone;
	@GetMapping
	public List<Telefone> buscarTelefone(){
		
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
	
	@PutMapping("{id}")
	public Telefone alterarTelefone(@RequestBody Telefone telefone, @PathVariable int id){
		telefone.setId(id);
		this.facade.alterar(telefone);
		return null;
	}
	
	@DeleteMapping
	public void deletarTelefone(){
		
	}

}
