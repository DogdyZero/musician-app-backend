package br.com.musicianapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.musicianapp.domain.EntidadeDominio;
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
	
	/*
	 * @Autowired
	 */private IStyleQuery parametro;
	
	@GetMapping("{id}")
	public Usuario consultarUsuario(@PathVariable int id){
		this.usuario.setId(id);
		parametro.setParametro("login");
		List<EntidadeDominio> entidades = facade.consultar(this.usuario);
		Usuario usuario = (Usuario) entidades.get(0);
		
		return usuario;	
	}
	@PostMapping
	public Usuario fazerLogin(@RequestBody Usuario usuario) {
		
		return null;
	}

}
