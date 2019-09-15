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
import org.springframework.web.bind.annotation.RestController;

import br.com.musicianapp.controller.viewhelper.CadastroPessoaVH;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Pessoa;
import br.com.musicianapp.domain.Usuario;
import br.com.musicianapp.impl.IStyleQuery;

@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private Facade facade;
	
	@Autowired
	private Usuario usuario;
	
	@Autowired
	private CadastroPessoaVH cadastroPessoaVH;
//	
//	@GetMapping("{id}")
//	public Usuario consultarUsuario(@PathVariable int id){
//		this.usuario.setId(id);
//		this.facade.setParametro("usuarioID");
//		List<EntidadeDominio> entidades = facade.consultar(this.usuario);
//		Usuario usuario = (Usuario) entidades.get(0);
//		return usuario;	
//	}
	
	@GetMapping("{hash}")
	public Usuario consultarUsuario(@PathVariable String hash){
		this.usuario.setHashCode(hash);
		this.facade.setParametro("usuarioHash");
		List<EntidadeDominio> entidades = facade.consultar(this.usuario);
		Usuario usuario = (Usuario) entidades.get(0);
		return usuario;	
	}
	
	@GetMapping()
	public List<Usuario> consultarTodos(){
		this.facade.setParametro("all");
		List<EntidadeDominio> entidades = facade.consultar(this.usuario);
		List<Usuario> usuarios = new ArrayList<Usuario>();
		for (EntidadeDominio ent : entidades) {
			usuarios.add((Usuario)ent);
		}
		return usuarios;	
	}
	@PostMapping
	public Usuario salvar(@RequestBody Usuario usuario) {
		usuario = (Usuario) cadastroPessoaVH.prepararParaSalvar(usuario);

		facade.salvar(usuario);
		return null;
	}
	
	@PostMapping("/login")
	public Usuario fazerLogin(@RequestBody Usuario usuario) {
		this.facade.setParametro("login");
		List<EntidadeDominio> entidades = facade.consultar(usuario);
		usuario = (Usuario) entidades.get(0);
		System.out.println(usuario.getPerfil());
		
		return usuario;
	}
	
	@PutMapping("{idUsuario}")
	public Object alterarPessoa(@PathVariable int idUsuario, @RequestBody Usuario usuario) {
		// adiciona novo numero ao banco relacionado ao cliente
		// criar o metodo
		usuario.setId(idUsuario);
		this.facade.alterar(usuario);
		return null;
	}
	
	
	@DeleteMapping("{id}")
	public void deletarUsuario(@PathVariable int id){
		this.usuario.setId(id);
		facade.apagar(this.usuario);
	}

}
