package br.com.musicianapp.Business;

import java.util.List;
import br.com.musicianapp.adapter.CarrinhoAdapter;
import br.com.musicianapp.adapter.IAdapter;
import br.com.musicianapp.domain.CarrinhoCompra;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.ItemProduto;

public class ProcessarDadosCarrinho implements IStrategyPreparToSave {

	private IAdapter<CarrinhoCompra> adapter;
	private List<ItemProduto> listProd;

	public ProcessarDadosCarrinho() {
		adapter = new CarrinhoAdapter<CarrinhoCompra>();
	}

	@Override
	public EntidadeDominio processarDados(EntidadeDominio entidade) {
		adapter.setAdapter(entidade);
		CarrinhoCompra carrinho = adapter.getObject();

		if (carrinho.getItemProduto() != null) {
			for (ItemProduto prod : carrinho.getItemProduto()) {
				if (prod.getQuantidade() > 1) {
					for (int i = 0; i < prod.getQuantidade(); i++) {
						prod.setQuantidade(1);
						listProd.add(prod);
					}
				} else {
					listProd.add(prod);
				}
			}
			carrinho.setItemProduto(listProd);
		}

		return (EntidadeDominio) carrinho;
	}

}
