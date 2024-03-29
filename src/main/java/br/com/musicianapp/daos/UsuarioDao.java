package br.com.musicianapp.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.adapter.IAdapter;
import br.com.musicianapp.adapter.UsuarioAdapter;
import br.com.musicianapp.domain.CarrinhoCompra;
import br.com.musicianapp.domain.Cartao;
import br.com.musicianapp.domain.Cupom;
import br.com.musicianapp.domain.Endereco;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.FormaPagamento;
import br.com.musicianapp.domain.ItemProduto;
import br.com.musicianapp.domain.Pedido;
import br.com.musicianapp.domain.Produto;
import br.com.musicianapp.domain.Usuario;
import br.com.musicianapp.impl.ConsultasPadrao;
import br.com.musicianapp.repository.UsuarioRepository;

@Service
public class UsuarioDao extends AbstractDao {
	private List<EntidadeDominio> entidades;
	private IAdapter<Usuario> adapter;
	private Usuario usuario;
	private Optional<Usuario> optUsuario;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private EnderecoDao endDao;
	@Autowired
	private CartaoDao cartaoDao;
	@Autowired
	private CupomDao cupomDao;
	@Autowired
	private PedidoDao pedidoDao;
	@Autowired
	private ProdutoDao produtoDao;

	public UsuarioDao() {
		this.adapter = new UsuarioAdapter<Usuario>();
	}

	@Override
	public EntidadeDominio salvar(EntidadeDominio entidade) {
		IAdapter<Usuario> adapter = new UsuarioAdapter<Usuario>();
		adapter.setAdapter(entidade);

		return usuarioRepository.save(adapter.getObject());

	}

	@Override
	public EntidadeDominio alterar(EntidadeDominio entidade) {
		Usuario usuario = (Usuario) entidade;
//		adapter.setAdapter(entidade);
//		Usuario usuario = adapter.getObject();
		optUsuario = usuarioRepository.findById(usuario.getId());
		Usuario usuBD = optUsuario.get();
		usuBD.setSenha(usuario.getSenha());

		if (usuario.getPessoa() != null) {
			if (usuario.getPessoa().getPedido() != null) {
				usuBD = updatePedido(usuBD, usuario);
			}
		}

		return usuarioRepository.saveAndFlush(usuBD);
	}

	private Usuario updatePedido(Usuario usuBD, Usuario usuarioComNovoPedido) {
		List<Pedido> pedidosMem = usuarioComNovoPedido.getPessoa().getPedido();
		List<Pedido> pedBD = usuBD.getPessoa().getPedido();
		
		for (Pedido pedido : pedidosMem) {
			if (pedido.getId() == 0) {

				Endereco endereco = pedido.getFrete().getEndereco();

				endDao.setParametro(ConsultasPadrao.ENDERECO_ID);
				List<EntidadeDominio> updateEndereco = endDao
						.consultar(endereco);

				endereco = (Endereco) updateEndereco.get(0);

				List<FormaPagamento> formas = pedido.getPagamento()
						.getFormaPagamento();

				for (FormaPagamento forma : formas) {
					if (forma.getTipoPagamento() instanceof Cartao) {
						Cartao cartao = (Cartao) forma.getTipoPagamento();
						cartaoDao.setParametro(ConsultasPadrao.CARTAO_ID);
						List<EntidadeDominio> updateCartao = cartaoDao
								.consultar(cartao);

						cartao = (Cartao) updateCartao.get(0);

						forma.setTipoPagamento(cartao);

						forma.setTipoPagamento(cartao);

					} else if (forma.getTipoPagamento() instanceof Cupom) {
						Cupom cupom = (Cupom) forma.getTipoPagamento();
						cupomDao.setParametro(ConsultasPadrao.CUPOM_ID);
						List<EntidadeDominio> updateCartao = cupomDao
								.consultar(cupom);

						cupom = (Cupom) updateCartao.get(0);
						forma.setTipoPagamento(cupom);
					}

				}

				List<ItemProduto> itens = new ArrayList<ItemProduto>();
						itens = pedido.getCarrinhoCompra()
						.getItemProduto();
				List<ItemProduto> listIP = new ArrayList<ItemProduto>();
				CarrinhoCompra car = new CarrinhoCompra();
				double valorCompra=0;
				for (ItemProduto ip : itens) {
					if (ip.getId() == 0) {
						ItemProduto itemProduto = new ItemProduto();
						// itemProduto.setCodigoBarras(ip.getCodigoBarras());
						// itemProduto.setValorProduto(ip.getValorProduto());
						// itemProduto.setDtCadastro(ip.getDtCadastro());
						// itemProduto.setStatusItem(ip.getStatusItem());
						valorCompra += ip.getValorProduto()*ip.getQuantidade();
						itemProduto.setValorProduto(ip.getValorProduto());
						itemProduto.setQuantidade(ip.getQuantidade());
						Produto prod = ip.getProduto();
						produtoDao.setParametro(ConsultasPadrao.PRODUTO_ID);
						List<EntidadeDominio> updateProd = produtoDao
								.consultar(prod);
						itemProduto.setProduto((Produto) updateProd.get(0));
						ip = itemProduto;
						listIP.add(ip);
						
					}
					System.out.println("ALO ALO\n\n\n\n");
				}
				car.setItemProduto(listIP);

				Pedido p = new Pedido();
				p.setData(pedido.getData());
				p.setStatusPedido(pedido.getStatusPedido());
				p.setCarrinhoCompra(car);
				// p.getCarrinhoCompra().setItemProduto(listIP);
				p.getCarrinhoCompra().setTotalCarrinho(valorCompra);
				p.setFrete(pedido.getFrete());
				p.getFrete().setEndereco(endereco);
				p.setPagamento(pedido.getPagamento());
				p.setTotal(valorCompra + p.getFrete().getCalculoFrete());
				System.out.println("Pedido TOTAL:\n\n " + p.getTotal());
				pedBD.add(p);

			}
		}

		usuBD.getPessoa().setPedido(pedBD);

		return usuBD;

	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		entidades = new ArrayList<EntidadeDominio>();
		ConsultasPadrao parametro = super.getParametro();

		adapter.setAdapter(entidade);

		if (adapter.getObject() != null) {

			if (parametro.equals(ConsultasPadrao.USUARIO_ID)) {
				parametro = null;
				return consultarPorID(adapter.getObject());
			} else if (parametro.equals(ConsultasPadrao.USUARIO_LOGIN)) {
				parametro = null;
				return validarAcesso(adapter.getObject());
			} else if (parametro.equals(ConsultasPadrao.USUARIO_TUDO)) {
				parametro = null;
				return consultarTodos();
			} else if (parametro.equals(ConsultasPadrao.USUARIO_HASH)) {
				parametro = null;
				return consultarHash(adapter.getObject());
			}
		}
		return null;
	}

	private List<EntidadeDominio> consultarPorID(Usuario usuario) {
		Optional<Usuario> optionalUsuario = usuarioRepository.findById(usuario
				.getId());
		usuario = optionalUsuario.get();
		entidades.add(usuario);
		System.out.println("Resultado: " + usuario.getLogin());
		return entidades;
	}

	private List<EntidadeDominio> validarAcesso(Usuario usuario) {
		usuario = usuarioRepository.findByLoginAndSenha(usuario.getLogin(),
				usuario.getSenha());
		if (usuario != null) {
			entidades.add(usuario);
			return entidades;
		}
		return null;
	}

	private List<EntidadeDominio> consultarTodos() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		for (Usuario user : usuarios) {
			entidades.add(user);
		}
		return entidades;
	}

	private List<EntidadeDominio> consultarHash(Usuario usuario) {
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
