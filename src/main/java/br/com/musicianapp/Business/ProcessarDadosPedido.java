package br.com.musicianapp.Business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.Enum.StatusPedido;
import br.com.musicianapp.adapter.IAdapter;
import br.com.musicianapp.adapter.PedidoAdapter;
import br.com.musicianapp.domain.CarrinhoCompra;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Pedido;
import br.com.musicianapp.domain.Usuario;

@Service
public class ProcessarDadosPedido implements IStrategyPreparToSave {

	private int i = 1;
	private IAdapter<Pedido> adapter;

	@Autowired
	private ProcessarDadosCarrinho processarDadosCarrinho;

	public ProcessarDadosPedido() {
		adapter = new PedidoAdapter<Pedido>();
	}

//	private List<Pedido> checkPedidoList(Set<Pedido> pedidos) {
//		List<Pedido> lista = new ArrayList<>();
//		for (Pedido pedido : pedidos) {
//			if (i == 1) {
//				pedido = processarDados(pedido);
//				lista.add(pedido);
//				i++;
//			}
//		}
//		i = 1;
//		return lista;
//	}

	private List<Pedido> processarDados(Pedido pedido) {
		List<Pedido> peds = new ArrayList<Pedido>(); 
		System.out.println("Entrou 1 vez");
		pedido.setData(new Date());
		pedido.setStatusPedido(StatusPedido.AGUARDANDO_APROVACAO);
		pedido.setCarrinhoCompra((CarrinhoCompra) processarDadosCarrinho
				.processarDados(pedido.getCarrinhoCompra()));
		peds.add(pedido);
		return peds;
	}

	@Override
	public EntidadeDominio processarDados(EntidadeDominio entidade) {
		Usuario user = (Usuario) entidade;

		if (user.getPessoa().getPedido() != null) {
				user.getPessoa().setPedido(
						processarDados(user.getPessoa().getPedido().get(user.getPessoa().getPedido().size()-1)));
				return user;


//		} else if (adapter.getObject() != null) {
//			return processarDados(adapter.getObject());
		} else {
			return null;
		}
	}

}
