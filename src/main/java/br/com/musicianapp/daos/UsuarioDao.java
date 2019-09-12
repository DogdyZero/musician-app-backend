package br.com.musicianapp.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.adapter.IAdapter;
import br.com.musicianapp.adapter.UsuarioAdapter;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Usuario;
import br.com.musicianapp.repository.UsuarioRepository;

@Service
public class UsuarioDao extends AbstractDao {
	List<EntidadeDominio> entidades;

	private IAdapter<Usuario> adapter;
	
	public UsuarioDao() {
		this.adapter = new UsuarioAdapter<Usuario>();
	}
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public EntidadeDominio salvar(EntidadeDominio entidade) {
		IAdapter<Usuario> adapter = new UsuarioAdapter<Usuario>();
		adapter.setAdapter(entidade);
		
		return 	usuarioRepository.save(adapter.getObject());

	}

	@Override
	public EntidadeDominio alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		entidades = new ArrayList<EntidadeDominio>();
		String parametro=super.getParametro().toLowerCase();
		
		adapter.setAdapter(entidade);
		
		if(adapter.getObject()!=null) {

			if(parametro.equals("usuarioid")) {
				parametro=null;
				return consultarPorID(adapter.getObject());
			} else if(parametro.equals("login")) {
				parametro=null;
				return validarAcesso(adapter.getObject());
			} else if(parametro.equals("all")){
				parametro = null;
				return consultarTodos();
			} else if(parametro.equals("usuarioHash".toLowerCase())) {
				parametro = null;
				return consultarHash(adapter.getObject());
			}
		}
		return null;
	}
	
	private List<EntidadeDominio> consultarPorID(Usuario usuario){
		Optional<Usuario> optionalUsuario = usuarioRepository.findById(usuario.getId());
		usuario = optionalUsuario.get();
		entidades.add(usuario);
		System.out.println("Resultado: " + usuario.getLogin());
		return entidades;
	}
	
	private List<EntidadeDominio> validarAcesso(Usuario usuario){
		usuario = usuarioRepository.findByLoginAndSenha(usuario.getLogin(), usuario.getSenha());
		entidades.add(usuario);
		System.out.println("Resultado: " + usuario.getLogin());
		return entidades;
	}
	
	private List<EntidadeDominio> consultarTodos(){
		List<Usuario> usuarios = usuarioRepository.findAll();
		for (Usuario user : usuarios) {
			entidades.add(user);
		}
		return entidades;
	}
	private List<EntidadeDominio> consultarHash(Usuario usuario){
		usuario = usuarioRepository.findByHashCode(usuario.getHashCode());
		entidades.add(usuario);
		System.out.println("Resultado: " + usuario.getLogin());
		return entidades;
	}

	@Override
	public void apagar(EntidadeDominio entidade) {
		adapter.setAdapter(entidade);
		usuarioRepository.deleteById(((Usuario) adapter.getObject()).getId());
	}

}
