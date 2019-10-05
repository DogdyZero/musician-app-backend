package br.com.musicianapp.Business;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.Enum.Status;
import br.com.musicianapp.adapter.IAdapter;
import br.com.musicianapp.adapter.PedidoAdapter;
import br.com.musicianapp.domain.CarrinhoCompra;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.ItemProduto;
import br.com.musicianapp.domain.Pedido;
import br.com.musicianapp.domain.Telefone;
import br.com.musicianapp.domain.Usuario;

@Service
public class ProcessarDadosPedido implements IStrategyPreparToSave {

	private IAdapter<Pedido> adapter;

	@Autowired
	private ProcessarDadosCarrinho processarDadosCarrinho;

	public ProcessarDadosPedido() {
		adapter = new PedidoAdapter<Pedido>();
	}
	
	private List<Pedido> checkPedidoList(Set<Pedido> pedidos) {
		List<Pedido> lista = new ArrayList<>();
		for(Pedido pedido : pedidos) {
			pedido = processarDados(pedido);
			lista.add(pedido);
		}
		return lista;
	}
	private Pedido processarDados(Pedido pedido) {

		pedido.setCarrinhoCompra((CarrinhoCompra)processarDadosCarrinho.processarDados(pedido));
		
		return pedido;
	}

	@Override
	public EntidadeDominio processarDados(EntidadeDominio entidade) {
		adapter.setAdapter(entidade);

		if (adapter.getListObject() != null) {
			if (entidade instanceof Usuario) {
				Usuario usuario = (Usuario) entidade;
				usuario.getPessoa().setPedido(
						checkPedidoList(adapter.getListObject()));
				return usuario;

			}

		} else if (adapter.getObject() != null) {
			return processarDados(adapter.getObject());
		} else {
			return null;
		}
		return null;
	}

}
