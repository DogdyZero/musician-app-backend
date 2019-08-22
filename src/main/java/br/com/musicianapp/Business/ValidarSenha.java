package br.com.musicianapp.Business;

import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Login;
import br.com.musicianapp.domain.Pessoa;



public class ValidarSenha implements IStrategy {
	
	@Override
	public String processar(EntidadeDominio entidade) {

		
		if(entidade instanceof Pessoa) {
			Pessoa pessoa = (Pessoa) entidade;
			return (pessoa.getLogin().getSenha().matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,50})"))
					? null : "Senha inválida, deve conter pelo menos 8 caracteres incluindo letras maiusculas, minusculas e sinais\n";
		}
		else {
			Login login = (Login)entidade;
			return (login.getSenha().matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,50})"))
					? null : "Senha inválida, deve conter pelo menos 8 caracteres incluindo letras maiusculas, minusculas e sinais\n";
		
		}
	}

}
