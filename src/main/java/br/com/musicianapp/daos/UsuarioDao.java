package br.com.musicianapp.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Usuario;
import br.com.musicianapp.repository.UsuarioRepository;

@Service
public class UsuarioDao extends AbstractDao {
	private final String CLASSE = Usuario.class.getName();
	List<EntidadeDominio> entidades;

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public void salvar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
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
		if(entidade.getClass().getName().equals(CLASSE)) {
			Usuario usuario = (Usuario)entidade;

			if(parametro.equals("usuarioid")) {
				parametro=null;
				return consultarPorID(usuario);
			} else if(parametro.equals("login")) {
				parametro=null;
				return validarAcesso(usuario);
			} else if(parametro.equals("all")){
				parametro = null;
				return consultarTodos();
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

	@Override
	public void apagar(EntidadeDominio entidade) {
		Usuario user = (Usuario) entidade;
		usuarioRepository.deleteById(user.getId());
	}

}
