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
public class UsuarioDao implements IDAO {
	private final String CLASSE = Usuario.class.getName();

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public EntidadeDominio salvar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntidadeDominio alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
		if(entidade.getClass().getName().equals(CLASSE)) {
			Usuario usuario = (Usuario)entidade;
			Optional<Usuario> optionalUsuario = usuarioRepository.findById(usuario.getId());
			usuario = optionalUsuario.get();
			entidades.add(usuario);
			System.out.println("Resultado: " + usuario.getLogin());
			return entidades;
		}
		System.out.println("Consulta com sucesso");
		return null;
	}

	@Override
	public void apagar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

	}

}
