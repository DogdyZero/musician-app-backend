package br.com.musicianapp.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Pessoa;
import br.com.musicianapp.domain.Usuario;
import br.com.musicianapp.repository.PessoaRepository;

@Service
public class PessoaDao extends AbstractDao {
	private final String CLASSE = Pessoa.class.getName();
	List<EntidadeDominio> entidades;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	private Pessoa convertClass(EntidadeDominio entidade) {
		if(entidade.getClass().getName().equals(CLASSE)) {
			return (Pessoa)entidade;
		}
		return null;
	}
	
	@Override
	public void salvar(EntidadeDominio entidade) {
		Pessoa pessoa = convertClass(entidade);
		if(pessoa!=null)
		pessoaRepository.save(pessoa);
	}

	@Override
	public EntidadeDominio alterar(EntidadeDominio entidade) {
		Pessoa pessoa = convertClass(entidade);
		if(pessoa!=null)
			return pessoaRepository.save(pessoa);
		return null;	
		}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		entidades = new ArrayList<EntidadeDominio>();
		String parametro=super.getParametro().toLowerCase();
		if(entidade.getClass().getName().equals(CLASSE)) {
			Pessoa pessoa = (Pessoa)entidade;
			
			if(parametro.equals("all")) {
				parametro=null;
				return consultarAll();
			} else if(parametro.equals("consid")){
				parametro = null;
				System.out.println("Consulta com sucesso");
				return consultaId(pessoa);
			}
		}
		return null;
	}

	@Override
	public void apagar(EntidadeDominio entidade) {
		Pessoa pessoa = (Pessoa) entidade;
		pessoaRepository.deleteById(pessoa.getId());
	}
	
	private List<EntidadeDominio> consultarAll(){
		List<Pessoa> pessoas = pessoaRepository.findAll();
		for (Pessoa pes : pessoas) {
			entidades.add(pes);
		}
		return entidades;
	}
	
	private List<EntidadeDominio> consultaId(Pessoa pessoa){
		Optional<Pessoa> optionalPessoa = pessoaRepository.findById(pessoa.getId());
		pessoa = optionalPessoa.get();
		entidades.add(pessoa);
		return entidades;
	}

}
