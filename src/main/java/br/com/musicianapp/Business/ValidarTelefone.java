package br.com.musicianapp.Business;

import java.util.Set;

import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Pessoa;
import br.com.musicianapp.domain.Telefone;


public class ValidarTelefone implements IStrategy {
	
	@Override
	public String processar(EntidadeDominio entidade) {
		Pessoa pessoa = (Pessoa) entidade;
		Set<Telefone> telefones = pessoa.getTelefone();
		
		StringBuilder st = new StringBuilder();
		
		for(Telefone tel : telefones){
		if(tel.getNumero().length() < 8)
			st.append("Número de telefone inválido \n");
		if(tel.getDdd().length() < 2)
			st.append("DDD inválido \n");
		}
		return st.toString();
	}

}