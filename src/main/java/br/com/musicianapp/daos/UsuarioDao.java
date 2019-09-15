package br.com.musicianapp.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.adapter.IAdapter;
import br.com.musicianapp.adapter.UsuarioAdapter;
import br.com.musicianapp.domain.CarrinhoCompra;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Frete;
import br.com.musicianapp.domain.ItemProduto;
import br.com.musicianapp.domain.Pagamento;
import br.com.musicianapp.domain.Pedido;
import br.com.musicianapp.domain.Usuario;
import br.com.musicianapp.repository.UsuarioRepository;

@Service
public class UsuarioDao extends AbstractDao {
	private List<EntidadeDominio> entidades;
	private IAdapter<Usuario> adapter;
	private Usuario usuario;
	private Optional<Usuario> optUsuario;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public UsuarioDao() {
		this.adapter = new UsuarioAdapter<Usuario>();
	}
	
	@Override
	public EntidadeDominio salvar(EntidadeDominio entidade) {
		IAdapter<Usuario> adapter = new UsuarioAdapter<Usuario>();
		adapter.setAdapter(entidade);
		
		return 	usuarioRepository.save(adapter.getObject());

	}

	@Override
	public EntidadeDominio alterar(EntidadeDominio entidade) {
		adapter.setAdapter(entidade);
		Usuario usuario = adapter.getObject();
		optUsuario = usuarioRepository.findById(usuario.getId());
		Usuario usuBD = optUsuario.get();

		if(usuario.getPessoa().getPedido()!=null) {
			usuBD = updatePedido(usuBD, usuario);
		}
		
		
		
		
		return usuarioRepository.saveAndFlush(usuBD);
	}
	
	private Usuario updatePedido(Usuario usuBD, Usuario usuarioComNovoPedido ) {
		
		List<ItemProduto> item = new ArrayList<ItemProduto>();

		
		
		Set<Pedido> pedidosMem =usuarioComNovoPedido.getPessoa().getPedido();

		Set<Pedido> pedBD = usuBD.getPessoa().getPedido();
		
		for(Pedido pedido: pedidosMem) {
//			CarrinhoCompra carrinho = new CarrinhoCompra();
//			Frete frete = new Frete();
//			Pagamento pagamento = new Pagamento();	
//			
//			frete.setEndereco(pedido.getFrete().getEndereco());
			
			Pedido p = new Pedido();
			p.setCarrinhoCompra(pedido.getCarrinhoCompra());
			p.setFrete(pedido.getFrete());
			p.setPagamento(pedido.getPagamento());
			p.setTotal(pedido.getTotal());
			pedBD.add(p);
		}
		
		usuBD.getPessoa().setPedido(pedBD);
		
		return usuBD;
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
