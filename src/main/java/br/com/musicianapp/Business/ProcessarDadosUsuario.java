package br.com.musicianapp.Business;

import java.util.Random;

import org.springframework.stereotype.Service;

import br.com.musicianapp.Enum.Perfil;
import br.com.musicianapp.Enum.Status;
import br.com.musicianapp.adapter.IAdapter;
import br.com.musicianapp.adapter.UsuarioAdapter;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Usuario;

@Service
public class ProcessarDadosUsuario implements IStrategyPreparToSave{
	
	private IAdapter<Usuario> adapter;
	public ProcessarDadosUsuario() {
		adapter = new UsuarioAdapter<Usuario>();
	}
	
	@Override
	public EntidadeDominio processarDados(EntidadeDominio entidade) {
		adapter.setAdapter(entidade);
		Usuario usuario = adapter.getObject();
		if(usuario.getLogin()!=null)
			usuario.setLogin(usuario.getLogin().toUpperCase());
		if(usuario.getPerfil()==null)
			usuario.setPerfil(Perfil.CLIENTE);
		if(usuario.getStatus()==null)
			usuario.setStatus(Status.ATIVO);
		if(usuario.getHashCode()==null)
			usuario.setHashCode(gerarHashCode());
		
		return usuario;
	}
	
	private String gerarHashCode() {
		Random r;

		StringBuilder sb= new StringBuilder();
		for(int i = 0;i<10;i++) {
			r = new Random();
			if(r.nextBoolean()) {
				int aux = r.nextInt(26);
				aux +=65;
				char letra =(char) aux;
				sb.append(letra);
			} else {
				sb.append(r.nextInt(9));
			}
		}
		return sb.toString();
	}
}
