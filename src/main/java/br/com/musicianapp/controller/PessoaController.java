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

import br.com.musicianapp.domain.Bandeira;
import br.com.musicianapp.domain.Cartao;
import br.com.musicianapp.domain.Cupom;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.FormaPagamento;
import br.com.musicianapp.domain.Pessoa;
import br.com.musicianapp.domain.TipoPagamento;

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
//	@PostMapping
//	public Object salvarPessoa(@RequestBody FormaPagamento fp) {
//		
//		FormaPagamento fp2 = new FormaPagamento();
//		Cupom cupom = new Cupom();
//		Cartao cartao = new Cartao();
//
//		List<TipoPagamento> lista = new ArrayList<TipoPagamento>();
//		cartao.setBandeira(Bandeira.HYPERCARD);
//		cupom.setCodigo("1231231");
//		lista.add(cupom);
//		lista.add(cartao);
//
//		fp2.setTipo(lista);
//		System.out.println(fp);
//		
//		facade.salvar(pessoa);
//		return fp2; 
//	}
	
	@PutMapping("{idPessoa}")
	public Object alterarPessoa(@PathVariable int idPessoa, @RequestBody Pessoa pessoa) {
		// adiciona novo numero ao banco relacionado ao cliente
		// criar o metodo
		pessoa.setId(idPessoa);
		this.facade.alterar(pessoa);
		return null;
	}
	
	
	@DeleteMapping("{id}")
	public void deletarPessoa(@PathVariable int id) {
		this.pessoa.setId(id);
		this.facade.apagar(pessoa);
		
	}
}
