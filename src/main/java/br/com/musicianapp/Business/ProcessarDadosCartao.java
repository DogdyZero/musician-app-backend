package br.com.musicianapp.Business;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import br.com.musicianapp.Enum.Status;
import br.com.musicianapp.adapter.CartaoAdapter;
import br.com.musicianapp.adapter.IAdapter;
import br.com.musicianapp.domain.Cartao;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Usuario;

@Service
public class ProcessarDadosCartao implements IStrategyPreparToSave{
	private IAdapter<Cartao> adapter;
	public ProcessarDadosCartao() {
		adapter = new CartaoAdapter<Cartao>();
	}
	private Set<Cartao> checkCartaoList(Set<Cartao> cartoes) {
		Set<Cartao> lista = new HashSet<Cartao>();
		for(Cartao cartao : cartoes) {
			cartao = processarDados(cartao);
			lista.add(cartao);
		}
		return lista;
	}
	private Cartao processarDados(Cartao cartao) {
		if(cartao.getStatus()==null)
			cartao.setStatus(Status.ATIVO);
		
		return cartao;
	}
	
	@Override
	public EntidadeDominio processarDados(EntidadeDominio entidade) {
		adapter.setAdapter(entidade);
		
		if(adapter.getListObject()!=null){
			if(entidade instanceof Usuario) {
				Usuario usuario = (Usuario)entidade;
				usuario.getPessoa().setCartao(checkCartaoList(adapter.getListObject()));
				return usuario;

			}
			
		} else if(adapter.getObject()!=null) {
			return processarDados(adapter.getObject());
		} else {
			return null;
		}
		return null;
				
	}

}
