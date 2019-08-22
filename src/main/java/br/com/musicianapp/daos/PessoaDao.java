package br.com.musicianapp.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Pessoa;
import br.com.musicianapp.repository.PessoaRepository;

@Service
public class PessoaDao implements IDAO {
	private final String CLASSE = Pessoa.class.getName();
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	private Pessoa convertClass(EntidadeDominio entidade) {
		if(entidade.getClass().getName().equals(CLASSE)) {
			return (Pessoa)entidade;
		}
		return null;
	}
	
	@Override
	public EntidadeDominio salvar(EntidadeDominio entidade) {
		Pessoa pessoa = convertClass(entidade);
		if(pessoa!=null)
			return pessoaRepository.save(pessoa);
		return null;
	}

	@Override
	public EntidadeDominio alterar(EntidadeDominio entidade) {
		Pessoa pessoa = convertClass(entidade);
		if(pessoa!=null)
			return pessoaRepository.save(pessoa);
		return null;	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		// implementar a pesquisa
		
		System.out.println("Consulta com sucesso");
		return null;
	}

	@Override
	public void apagar(EntidadeDominio entidade) {
		Pessoa pessoa = convertClass(entidade);
		if(pessoa!=null)
			pessoaRepository.delete(pessoa);
	}

}
