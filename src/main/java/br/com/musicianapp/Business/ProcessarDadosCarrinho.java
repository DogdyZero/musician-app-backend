package br.com.musicianapp.Business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.musicianapp.adapter.CarrinhoAdapter;
import br.com.musicianapp.adapter.IAdapter;
import br.com.musicianapp.domain.CarrinhoCompra;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.ItemProduto;

@Service
public class ProcessarDadosCarrinho implements IStrategyPreparToSave {

	private IAdapter<CarrinhoCompra> adapter;

	private List<ItemProduto> listProd;

	public ProcessarDadosCarrinho() {
		adapter = new CarrinhoAdapter<CarrinhoCompra>();
	}

	@Override
	public EntidadeDominio processarDados(EntidadeDominio entidade) {
		CarrinhoCompra carrinho = (CarrinhoCompra) entidade;

		if (carrinho.getItemProduto() != null) { 
			listProd = new ArrayList<ItemProduto>();
			List<ItemProduto> itens = carrinho.getItemProduto();
			for (ItemProduto prod : itens) {
				if (prod.getQuantidade() > 1) {
					for (int i = 0; i < prod.getQuantidade(); i++) {
						prod.setId(prod.getId());
						listProd.add(prod);
					}
				} else {
					listProd.add(prod);
				}
			}
		}

		for (ItemProduto ip : listProd) {
			ip.setQuantidade(1);
		}
		carrinho.setItemProduto(listProd);
//		listProd = null;

		return carrinho;
	}

}
