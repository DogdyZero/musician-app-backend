package br.com.musicianapp.Business;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.Enum.StatusItem;
import br.com.musicianapp.adapter.IAdapter;
import br.com.musicianapp.adapter.ItemProdutoAdapter;
import br.com.musicianapp.daos.TrocaDao;
import br.com.musicianapp.domain.Cupom;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.ItemProduto;
import br.com.musicianapp.domain.Pessoa;
import br.com.musicianapp.domain.Troca;
import br.com.musicianapp.impl.ConsultasPadrao;
import br.com.musicianapp.repository.CupomRepository;

@Service
public class ProcessarNovoCupom implements IStrategyPreparToSave {

	@Autowired
	private TrocaDao trocaDao;
	
	@Override
	public EntidadeDominio processarDados(EntidadeDominio entidade) {
		IAdapter<ItemProduto> adapter = new ItemProdutoAdapter<ItemProduto>();
		adapter.setAdapter(entidade);
		ItemProduto item = adapter.getObject();
		
		if(item.getTroca()!=null) {
			if(item.getTroca().getStatusItem().equals(StatusItem.TROCA_APROVADA)) {
				Troca troca = item.getTroca();
				trocaDao.setParametro(ConsultasPadrao.TROCA_USUARIO);
				List<EntidadeDominio> entidades = trocaDao.consultar(troca);
				Pessoa pessoa = (Pessoa) entidades.get(0);
				
				// gerar cupom de troca
				Cupom cupomTroca = new Cupom();
				cupomTroca.setValor(item.getValorProduto());
				cupomTroca.setCodigo("testeCupom123");
				
				troca.setCupom(cupomTroca);
				Set<Cupom> listCupom = new HashSet<Cupom>();
				listCupom.add(cupomTroca);
				pessoa.setCupom(listCupom);
				
			}
		}
		return null;
	}

}
