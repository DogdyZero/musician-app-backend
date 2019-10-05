package br.com.musicianapp.controller.viewhelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.Business.ProcessarDadosCarrinho;
import br.com.musicianapp.Business.ProcessarDadosPedido;
import br.com.musicianapp.domain.CarrinhoCompra;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Pedido;
import br.com.musicianapp.domain.Produto;

@Service
public class CadastroPedidoVH {
	@Autowired
	private ProcessarDadosCarrinho processarDadosCarrinhoCompra;

	// @Autowired private ProcessarDadosFrete processarDadosFrete;
	// @Autowired private ProcessarDadosPagamento processarDadosPagamento;
	// @Autowired
	// private ProcessarDadosPedido processarDadosPedido;

	public EntidadeDominio prepararSalvar(Pedido pedido) {

		return (Pedido) processarDadosCarrinhoCompra.processarDados(pedido);
	}

}
