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

import br.com.musicianapp.domain.Pessoa;
import br.com.musicianapp.repository.PessoasRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoasRepository repository;
	@GetMapping
	public List<Pessoa> consultarPessoas(){
		List<Pessoa> pessoas = repository.findAll();
		return pessoas;
	}
	
	@PostMapping
	public Pessoa salvarPessoa(@RequestBody Pessoa pessoa) {
		return repository.findByNome(pessoa.getNome());
	}
	
	@PutMapping
	public Pessoa alterarPessoa() {
		return null;
	}
	
	@DeleteMapping
	public void deletarPessoa() {
		
	}
}
