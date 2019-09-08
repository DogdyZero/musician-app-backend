package br.com.musicianapp.Business;

import java.util.Set;

import org.springframework.stereotype.Service;

import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Pessoa;
import br.com.musicianapp.domain.Telefone;
import br.com.musicianapp.impl.AbstractAdapter;
import br.com.musicianapp.impl.TelefoneAdapter;
import br.com.musicianapp.impl.IAdapter;

@Service
public class ValidarTelefone implements IStrategy {
	
	private StringBuilder sb;
	private IAdapter<Telefone> adapter;
	
	public ValidarTelefone() {
		this.adapter = new TelefoneAdapter<Telefone>();
	}
	
	private void checkTelefoneList(Set<Telefone> telefones) {
		int i = 0;
		for(Telefone telefone : telefones) {
			String resultado = processarEstrategia(telefone);
			i++;
			if(resultado!=null)
				sb.append("Telefone " + i + " " +resultado);
		}
		
	}
	private String processarEstrategia(Telefone telefone) {
		String resultado = null;
		if(telefone.getDdd()!=null) {
			if(telefone.getDdd().length()<2 ||
					telefone.getDdd().length()>2) {
				resultado = "\no DDD informado é invalido";

			} else if(telefone.getNumero().length()<8||
					telefone.getNumero().length()>9) {
				resultado = "\no numero do telefone é invalido";
			} 
		}
		else {
			resultado =null;
		}
		return resultado;
	}

	
	@Override
	public String processar(EntidadeDominio entidade) {
		this.sb = new StringBuilder();
		
		adapter.setAdapter(entidade);
		
		if(adapter.getListObject()!=null){
			checkTelefoneList(adapter.getListObject());
		} else if(adapter.getObject()!=null) {
			processarEstrategia(adapter.getObject());
		} else {
			sb.append("Objeto Invalido");
		}
		
		return sb.toString();
		
		
	}

}
