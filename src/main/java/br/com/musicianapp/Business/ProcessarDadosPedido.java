package br.com.musicianapp.Business;

import org.springframework.stereotype.Service;

import br.com.musicianapp.adapter.IAdapter;
import br.com.musicianapp.adapter.PedidoAdapter;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Pedido;

@Service
public class ProcessarDadosPedido implements IStrategyPreparToSave {

	private IAdapter<Pedido> adapter;

	public ProcessarDadosPedido() {
		adapter = new PedidoAdapter<Pedido>();
	}

	@Override
	public EntidadeDominio processarDados(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
