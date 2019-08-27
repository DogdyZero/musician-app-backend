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

import br.com.musicianapp.domain.Cartao;
import br.com.musicianapp.domain.EntidadeDominio;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {

	@Autowired
	private Facade facade;
	
	@GetMapping
	public List<Cartao> consultarCartao(){
		return null;
	}
	@CrossOrigin
	@PostMapping
	public Cartao salvarCartao(@RequestBody Cartao cartao){
//		EntidadeDominio e = facade.salvar(cartao);
//		
		
//		if(e!=null)
//			return (Cartao) e;
//		else 
//			return null;
		return null;
	}
	
	@PutMapping
	public Cartao alterarCartao(){
		return null;
	}
	
	@DeleteMapping
	public void deletarCartao(){
		
	}
	
	
}
