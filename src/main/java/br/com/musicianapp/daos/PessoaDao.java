package br.com.musicianapp.daos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.Enum.Status;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Pessoa;
import br.com.musicianapp.domain.Telefone;
import br.com.musicianapp.repository.PessoaRepository;
import br.com.musicianapp.repository.TelefoneRepository;

@Service 
//@Transactional
public class PessoaDao extends AbstractDao {
	private final String CLASSE = Pessoa.class.getName();
	
	List<EntidadeDominio> entidades;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private Pessoa copyPessoa;
	private Optional<Pessoa> optPessoa;
	@Autowired private TelefoneRepository telefoneRepository;
	
	private Pessoa convertClass(EntidadeDominio entidade) {
		if(entidade.getClass().getName().equals(CLASSE)) {
			return (Pessoa)entidade;
		}
		return null;
	}
	
	@Override
	public EntidadeDominio salvar(EntidadeDominio entidade) {
		
		Pessoa pessoa = convertClass(entidade);
		if(pessoa!=null) {
			optPessoa = pessoaRepository.findById(pessoa.getId());
			Pessoa pes = optPessoa.get();
			Set<Telefone> telefones = pes.getTelefone(); // telefone banco
			
			Set<Telefone> telCopy = pessoa.getTelefone(); // telefone memória
			
			Set<Telefone> novoTel = new HashSet<Telefone>();
			for (Telefone t : telefones) {
				for(Telefone tMemory : telCopy) {
					if(!t.getNumero().equals(tMemory.getNumero())) {
						t.setNumero(tMemory.getNumero());
						novoTel.add(t);
					}

				}
			}
			pes.setTelefone(novoTel);
			em.merge(pes);

//			em.persist(pessoa);
			
			pessoa = pessoaRepository.save(pessoa);

		}
			
		return null;
	}

	@Override
	public EntidadeDominio alterar(EntidadeDominio entidade) {
		Pessoa pessoa = convertClass(entidade);
		
		if(pessoa!=null) {
			optPessoa = pessoaRepository.findById(pessoa.getId());
			Pessoa pesBD = optPessoa.get();
			
			Set<Telefone> saveTel = new HashSet<Telefone>();
			for(Telefone telBD: pesBD.getTelefone()) {
				for(Telefone telMem: pessoa.getTelefone()) {
					if(telMem.getNumero().equals(telBD.getNumero()) &&
							telMem.getStatus().equals(Status.INATIVO)){
						telBD.setStatus(Status.INATIVO);
					} else {
						telBD.setStatus(Status.ATIVO);
					}
					saveTel.add(telBD);
				}
			}
			
			pesBD.setTelefone(saveTel);
			pessoaRepository.save(pesBD);

		}
		
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
