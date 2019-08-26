package br.com.musicianapp.Business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.musicianapp.daos.PessoaDao;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Pessoa;

@Service
public class ValidarExistencia implements IStrategy {
	
	public String processar(EntidadeDominio entidade) {
		
		Pessoa pessoa = (Pessoa) entidade;	
		PessoaDao pessoaDao = new PessoaDao();
		List<EntidadeDominio> pessoasList = new ArrayList<EntidadeDominio>();
		
		pessoasList = pessoaDao.consultar(pessoa);
		
		for(EntidadeDominio ent : pessoasList){
			Pessoa pes = (Pessoa) ent;
			if(pessoa.getCpf() == pes.getCpf()){
				return "CPF ja existente";
			}	
		}
		return null;
	}

}
