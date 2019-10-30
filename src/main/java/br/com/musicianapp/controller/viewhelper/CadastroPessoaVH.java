package br.com.musicianapp.controller.viewhelper;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.Business.ProcessarDadosCartao;
import br.com.musicianapp.Business.ProcessarDadosEndereco;
import br.com.musicianapp.Business.ProcessarDadosPedido;
import br.com.musicianapp.Business.ProcessarDadosPessoa;
import br.com.musicianapp.Business.ProcessarDadosTelefone;
import br.com.musicianapp.Business.ProcessarDadosUsuario;
import br.com.musicianapp.adapter.AbstractAdapter;
import br.com.musicianapp.adapter.IAdapter;
import br.com.musicianapp.adapter.PedidoAdapter;
import br.com.musicianapp.adapter.UsuarioAdapter;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.ItemProduto;
import br.com.musicianapp.domain.Pedido;
import br.com.musicianapp.domain.Pessoa;
import br.com.musicianapp.domain.Usuario;

@Service
public class CadastroPessoaVH {
	private IAdapter<Usuario> adapter;
	@Autowired private ProcessarDadosPessoa processarDadosPessoa;
	@Autowired private ProcessarDadosEndereco processarDadosEndereco;
	@Autowired private ProcessarDadosCartao processarDadosCartao;
	@Autowired private ProcessarDadosTelefone processarDadosTelefone;
	@Autowired private ProcessarDadosUsuario processarDadosUsuario;
	@Autowired private ProcessarDadosPedido processarDadosPedido;
	@Autowired Set<Pedido> peds;
	
	public CadastroPessoaVH(){
		adapter = new UsuarioAdapter<Usuario>();
	}

	
	public EntidadeDominio prepararParaSalvar(EntidadeDominio entidade) {
		Usuario usuario = (Usuario) entidade;
		
		if(usuario.getPessoa() != null)
			usuario.setPessoa((Pessoa) processarDadosPessoa.processarDados(usuario));
		
		if(usuario.getPessoa().getEndereco() != null){
			usuario=(Usuario) processarDadosEndereco.processarDados(usuario);
		}
		
		if(usuario.getPessoa().getCartao() != null){
			usuario=(Usuario) processarDadosCartao.processarDados(usuario);
		}
		
		if(usuario.getPessoa().getTelefone() != null){
			usuario=(Usuario) processarDadosTelefone.processarDados(usuario);
		}
		
		if(usuario.getPessoa().getPedido() != null){			
			usuario=(Usuario) processarDadosPedido.processarDados(usuario);
		} 
		
//		if(usuario.getPessoa().getPedido()!=null) {
//			for (Pedido pedido : usuario.getPessoa().getPedido()) {
//				for (ItemProduto ip : pedido.getCarrinhoCompra().getItemProduto()) {
//					System.out.println("\n\n" + ip.getQuantidade() + " " + ip.getProduto().getNome());
//				}
//			}
//		}
//		
		
		return usuario;
	}
}
