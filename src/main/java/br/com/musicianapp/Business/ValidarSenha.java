package br.com.musicianapp.Business;

import org.springframework.stereotype.Service;

import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Usuario;
import br.com.musicianapp.domain.Pessoa;

@Service
public class ValidarSenha implements IStrategy {
	
	@Override
	public String processar(EntidadeDominio entidade) {

//		
//		if(entidade instanceof Pessoa) {
//			Pessoa pessoa = (Pessoa) entidade;
//			return (pessoa.getUsuario().getSenha().matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,50})"))
//					? null : "Senha inválida, deve conter pelo menos 8 caracteres incluindo letras maiusculas, minusculas e sinais\n";
//		}
//		else if(entidade instanceof Usuario){
//			Usuario login = (Usuario)entidade;
//			return (login.getSenha().matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,50})"))
//					? null : "Senha inválida, deve conter pelo menos 8 caracteres incluindo letras maiusculas, minusculas e sinais\n";
//		
//		} else {
			return null;

//		}
	}

}
