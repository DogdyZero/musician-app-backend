package br.com.musicianapp.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.musicianapp.Enum.OrigemCupom;
import br.com.musicianapp.Enum.Status;
import br.com.musicianapp.Enum.StatusItem;
import br.com.musicianapp.domain.Cupom;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.ItemProduto;
import br.com.musicianapp.domain.Pessoa;
import br.com.musicianapp.domain.Troca;
import br.com.musicianapp.impl.ConsultasPadrao;
import br.com.musicianapp.impl.LoggerResourceImpl;
import br.com.musicianapp.impl.Resultado;

@RestController
@CrossOrigin
@RequestMapping("/item")
public class ItemProdutoController {
	@Autowired
	private Facade facade;
	
	@Autowired
	private ItemProduto item;

	@Autowired
	private Troca troca;
	
	@Autowired
	private Cupom cupom;
	
	@Autowired
	private LoggerResourceImpl logger;
	
	@PutMapping("{id}")
	public ItemProduto alterarPedido(@RequestBody ItemProduto item, @PathVariable int id){
		logger.salvarLoggerResource(id,ItemProdutoController.class, item, "alterarPedido");

		if(item.getTroca().getStatusItem().equals(StatusItem.TROCA_SOLICITADA)) {
			item.setId(id);
			this.facade.alterar(item);
		} else if(item.getTroca().getStatusItem().equals(StatusItem.TROCA_APROVADA)) {
			item.getTroca().setStatusItem(StatusItem.TROCA_APROVADA);
			item.setId(id);
			Resultado resultado = this.facade.alterar(item);
			ItemProduto itemAlterado = (ItemProduto) resultado.getEntidades().get(0);
			this.facade.setParametro(ConsultasPadrao.TROCA_USUARIO);
			List<EntidadeDominio> entidades = facade.consultar(itemAlterado.getTroca());
			Pessoa pessoa = (Pessoa) entidades.get(0);
			
			Set<Cupom> cupons = pessoa.getCupom();
			
			cupom.setOrigemCupom(OrigemCupom.TROCA);
			cupom.setValor(item.getValorProduto());
			cupom.setStatus(Status.ATIVO);
			String valorProd = Double.toString(item.getValorProduto());
			cupom.setCodigo("CUP"+valorProd.substring(0, valorProd.length()-2));
			
			cupons.add(cupom);
			pessoa.setCupom(cupons);
			facade.alterar(pessoa);
		} else if(item.getTroca().getStatusItem().equals(StatusItem.TROCA_NEGADA)) {
			item.setId(id);
			this.facade.alterar(item);
		}
		return null;
	}
	@GetMapping
	public List<ItemProduto> consultarPedido(){
		this.facade.setParametro(ConsultasPadrao.ITEM_PRODUTO_TRADE);
		List<EntidadeDominio> entidades = facade.consultar(this.item);
		List<ItemProduto> itens = new ArrayList<ItemProduto>();
		for (EntidadeDominio ent : entidades) {
			
			itens.add((ItemProduto)ent);
		}
		return itens;	
	}
	
	@GetMapping("{id}")
	public List<Pessoa> consultarUsuarioTroca(){
		this.facade.setParametro(ConsultasPadrao.CARTAO_ID);
		List<EntidadeDominio> entidades = facade.consultar(this.item);
		List<Pessoa> itens = new ArrayList<Pessoa>();
		for (EntidadeDominio ent : entidades) {
			
			itens.add((Pessoa)ent);
		}
		return itens;	
	}
		
}
