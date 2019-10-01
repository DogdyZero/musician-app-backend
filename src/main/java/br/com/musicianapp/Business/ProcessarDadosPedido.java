package br.com.musicianapp.Business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.adapter.IAdapter;
import br.com.musicianapp.adapter.PedidoAdapter;
import br.com.musicianapp.domain.CarrinhoCompra;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Pedido;

@Service
public class ProcessarDadosPedido implements IStrategyPreparToSave {

	private IAdapter<Pedido> adapter;
	
	@Autowired
	private ProcessarDadosCarrinho processarDadosCarrinho;

	public ProcessarDadosPedido() {
		adapter = new PedidoAdapter<Pedido>();
	}

	@Override
	public EntidadeDominio processarDados(EntidadeDominio entidade) {
		adapter.setAdapter(entidade);
		Pedido pedido = adapter.getObject();
		
		if(pedido.getCarrinhoCompra() != null){
			pedido.setCarrinhoCompra((CarrinhoCompra)processarDadosCarrinho.processarDados(pedido));
		}
		
		return (EntidadeDominio) pedido;
	}

}
