package br.com.musicianapp.controller.viewhelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.Business.ProcessarDadosProduto;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Produto;

@Service
public class CadastroProdutoVH {
	@Autowired private ProcessarDadosProduto processarDadosProduto;

	public EntidadeDominio prepararParaSalvar(Produto produto) {
		return (Produto) processarDadosProduto.processarDados(produto);
	}
}
