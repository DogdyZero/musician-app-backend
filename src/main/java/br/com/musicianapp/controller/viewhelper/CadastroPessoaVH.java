package br.com.musicianapp.controller.viewhelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.Business.ProcessarDadosCartao;
import br.com.musicianapp.Business.ProcessarDadosEndereco;
import br.com.musicianapp.Business.ProcessarDadosPessoa;
import br.com.musicianapp.Business.ProcessarDadosTelefone;
import br.com.musicianapp.Business.ProcessarDadosUsuario;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Pedido;
import br.com.musicianapp.domain.Pessoa;
import br.com.musicianapp.domain.Usuario;

@Service
public class CadastroPessoaVH {
	@Autowired private ProcessarDadosPessoa processarDadosPessoa;
	@Autowired private ProcessarDadosEndereco processarDadosEndereco;
	@Autowired private ProcessarDadosCartao processarDadosCartao;
	@Autowired private ProcessarDadosTelefone processarDadosTelefone;
	@Autowired private ProcessarDadosUsuario processarDadosUsuario;

	
	public EntidadeDominio prepararParaSalvar(Usuario usuario) {
		
		if(usuario.getPessoa() != null)
			usuario.setPessoa((Pessoa) processarDadosPessoa.processarDados(usuario));
		
		if(usuario.getPessoa().getEndereco() != null)
			usuario=(Usuario) processarDadosEndereco.processarDados(usuario);
		if(usuario.getPessoa().getCartao() != null)
			usuario=(Usuario) processarDadosCartao.processarDados(usuario);
		if(usuario.getPessoa().getTelefone() != null)
			usuario=(Usuario) processarDadosTelefone.processarDados(usuario);
		
		usuario = (Usuario) processarDadosUsuario.processarDados(usuario);

		return usuario;
	}
}
