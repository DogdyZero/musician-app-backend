package br.com.musicianapp.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Pessoa;
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
			return pessoaRepository.saveAndFlush(pessoa);
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
			}else if(parametro.equals("nome")) {
				parametro = null;
				return consultaNomeLike(pessoa);
			} else if(parametro.equals("cpf")) {
				parametro = null;
				return consultaCpf(pessoa);
			} else if(parametro.equals("consid")){
				parametro = null;
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
	@PersistenceContext
	  private EntityManager em;
	
	private List<EntidadeDominio> consultaNomeLike(Pessoa pessoa){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Pessoa> query = builder.createQuery(Pessoa.class);
		Root<Pessoa> from = query.from(Pessoa.class);
		
		TypedQuery<Pessoa> typedQuery = em.createQuery(
		    query.select(from )
		    .where(
		       builder.like(from.get("nome"), "%"+pessoa.getNome()+"%")
		    )
		);
		List<Pessoa> results = typedQuery.getResultList();
		entidades.addAll(results);
		return entidades;
	}
	private List<EntidadeDominio> consultaCpf(Pessoa pessoa){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Pessoa> query = builder.createQuery(Pessoa.class);
		Root<Pessoa> from = query.from(Pessoa.class);
		
		
		Predicate predicado
		  = builder.equal(from.get("cpf"), pessoa.getCpf());
		
		query.where(predicado);
		List<Pessoa> results = em.createQuery(query).getResultList();
		
//		TypedQuery<Pessoa> typedQuery = em.createQuery(
//		    query.select(from )
//		    .where(
//		       builder.like(from.get("cpf"), pessoa.getCpf())
//		    )
//		);
//		List<Pessoa> results = typedQuery.getResultList();
		entidades.addAll(results);
		return entidades;
	}

}
