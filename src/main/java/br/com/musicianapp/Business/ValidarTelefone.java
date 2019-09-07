package br.com.musicianapp.Business;

import java.util.Set;

import org.springframework.stereotype.Service;

import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Pessoa;
import br.com.musicianapp.domain.Telefone;

@Service
public class ValidarTelefone implements IStrategy {
	
	private final String PESSOA = Pessoa.class.getName();
	private final String TELEFONE = Telefone.class.getName();

	private Set<Telefone> telefones;
	private Telefone telefone;
	private StringBuilder sb;
	
	private void convertClass(EntidadeDominio entidade) {
		if(entidade instanceof Telefone) {
			this.telefone = Telefone.class.cast(entidade);
		} else if (entidade instanceof Pessoa) {
			this.telefones = Pessoa.class.cast(entidade).getTelefone();
		}
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
		convertClass(entidade);
		if(this.telefones!=null){
			checkTelefoneList(telefones);
		} else if(this.telefone!=null) {
			processarEstrategia(telefone);
		} else {
			sb.append("Objeto Invalido");
		}
		
		return sb.toString();
		
		
	}

}
