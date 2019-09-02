package br.com.musicianapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import br.com.musicianapp.domain.Pessoa;

@CrossOrigin
@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private Facade facade;
	
	@Autowired
	private Pessoa pessoa;
	
	@GetMapping("{id}")
	public Pessoa consultarPessoa(@PathVariable int id){
		this.pessoa.setId(id);
		this.facade.setParametro("consId");
		List<EntidadeDominio> entidades = facade.consultar(this.pessoa);
		Pessoa pessoa = (Pessoa) entidades.get(0);
		return pessoa;	
	}
	@GetMapping("/buscarNome")
	public List<Pessoa> buscarPorNome(@RequestParam String nome){
		facade.setParametro("nome");
		pessoa.setNome(nome);
		List<EntidadeDominio> entidades = facade.consultar(this.pessoa);
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		for (EntidadeDominio ent : entidades) {
			
			pessoas.add((Pessoa)ent);
		}
		return pessoas;	
	}
	@GetMapping("/buscarCpf")
	public List<Pessoa> buscarPorCpf(@RequestParam String cpf){
		facade.setParametro("cpf");
		pessoa.setCpf(cpf);
		List<EntidadeDominio> entidades = facade.consultar(this.pessoa);
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		for (EntidadeDominio ent : entidades) {
			
			pessoas.add((Pessoa)ent);
		}
		return pessoas;	
	}
	
	@GetMapping()
	public List<Pessoa> consultarPessoa(){
		this.facade.setParametro("all");
		List<EntidadeDominio> entidades = facade.consultar(this.pessoa);
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		for (EntidadeDominio ent : entidades) {
			
			pessoas.add((Pessoa)ent);
		}
		return pessoas;		
	}
	@PostMapping
	public Object salvarPessoa(@RequestBody Pessoa pessoa) {
		facade.salvar(pessoa);
		return null; 
	}
	
	@PutMapping("{id}")
	public Object alterarPessoa(@PathVariable int id, @RequestBody Pessoa pessoa) {
		pessoa.setId(id);
//		this.pessoa.setNome(pessoa.getNome());
//		this.pessoa.setCpf(pessoa.getCpf());
		this.facade.alterar(pessoa);
		return null;
	}
	
	@DeleteMapping("{id}")
	public void deletarPessoa(@PathVariable int id) {
		this.pessoa.setId(id);
		this.facade.apagar(pessoa);
		
	}
}
