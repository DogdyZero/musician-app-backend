package br.com.musicianapp.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.Enum.Status;
import br.com.musicianapp.domain.Cartao;
import br.com.musicianapp.domain.Endereco;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Pedido;
import br.com.musicianapp.domain.Pessoa;
import br.com.musicianapp.domain.Telefone;
import br.com.musicianapp.impl.ConsultasPadrao;
import br.com.musicianapp.impl.FactoryConsulta;
import br.com.musicianapp.repository.PessoaRepository;

@Service 
//@Transactional
public class PessoaDao extends AbstractDao {
	private final String CLASSE = Pessoa.class.getName();
	
	List<EntidadeDominio> entidades;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private FactoryConsulta fabrica;

	
	@PersistenceContext
	private EntityManager em;
	
	private Optional<Pessoa> optPessoa;
	
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
			pesBD.setNome(pessoa.getNome());
			//pesBD.setGenero(pessoa.getNome());
			//pesBD.setData(pessoa.getNome());
			
			if(pessoa.getTelefone()!=null) {
				pesBD = updateTelefone(pesBD, pessoa);
			}
			
			if(pessoa.getEndereco()!=null) {
				pesBD = updateEndereco(pesBD, pessoa);
			}
			if(pessoa.getCartao()!=null) {
				pesBD = updateCartao(pesBD, pessoa);
			}
//			if(pessoa.getCompra()!=null) {
//				
//			}
//			if(pessoa.getPedido()!=null) {
//				pesBD = updatePedido(pesBD, pessoa);
//			}
			
			
			return pessoaRepository.saveAndFlush(pesBD);
		}
		
		return null;	
		}
	
	private Pessoa updateTelefone(Pessoa pesBD,  Pessoa pessoaComNovoTelefone) {
		Set<Telefone> telsMem =pessoaComNovoTelefone.getTelefone();

		Set<Telefone> telBD = pesBD.getTelefone();
		
		for(Telefone tels: telsMem) {
			if(tels.getId()==0) {
				Telefone t = new Telefone(tels.getDdd(),tels.getNumero(),Status.ATIVO);
				telBD.add(t);
			}
		}
		
		pesBD.setTelefone(telBD);
		
		return pesBD;
	}
	private Pessoa updateEndereco(Pessoa pesBD, Pessoa pessoaComNovoEndereco ) {
		Set<Endereco> endsMem =pessoaComNovoEndereco.getEndereco();

		Set<Endereco> endBD = pesBD.getEndereco();
		
		for(Endereco ends: endsMem) {
			if(ends.getId()==0) {
				Endereco e = new Endereco(ends.getTipoLogradouro(),ends.getApelidoEndereco(), ends.getLogradouro(), ends.getNumero(),
						ends.getComplemento(), ends.getBairro(), ends.getCidade(), ends.getEstado(),ends.getCep(), Status.ATIVO);
				endBD.add(e);
			}
		}
		
		pesBD.setEndereco(endBD);
		
		return pesBD;
	}
	
	private Pessoa updateCartao(Pessoa pesBD, Pessoa pessoaComNovoCartao ) {
		Set<Cartao> cartoesMem =pessoaComNovoCartao.getCartao();

		Set<Cartao> carBD = pesBD.getCartao();
		
		for(Cartao cartao: cartoesMem) {
			if(cartao.getId()==0) {
				Cartao c = new Cartao(cartao.getNomeCartao(),cartao.getNumeroCartao(),cartao.getValidade(),  cartao.getCodSeguranca(),  
						cartao.getBandeira(),cartao.isPreferencial(), Status.ATIVO );
				carBD.add(c);
			}
			
		}
		
		pesBD.setCartao(carBD);
		
		return pesBD;
	}
	private Pessoa updatePedido(Pessoa pesBD, Pessoa pessoaComNovoPedido ) {
		List<Pedido> pedidosMem =pessoaComNovoPedido.getPedido();

		List<Pedido> pedBD = pesBD.getPedido();
		
		for(Pedido pedido: pedidosMem) {
			Pedido p = new Pedido();
			
			
			
			
			pedBD.add(p);
		}
		
		pesBD.setPedido(pedBD);
		
		return pesBD;
	}

	
	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		entidades = new ArrayList<EntidadeDominio>();
		ConsultasPadrao parametro=super.getParametro();
		if(entidade.getClass().getName().equals(CLASSE)) {
			Pessoa pessoa = (Pessoa)entidade;
			
			if(parametro.equals(ConsultasPadrao.PESSOA_TUDO)) {
				parametro=null;
				return consultarAll();
			}else if(parametro.equals(ConsultasPadrao.PESSOA_NOME)) {
				parametro = null;
				return consultaNomeLike(pessoa);
			} else if(parametro.equals(ConsultasPadrao.PESSOA_CPF)) {
				parametro = null;
				return consultaCpf(pessoa);
			} else if(parametro.equals(ConsultasPadrao.PESSOA_ID)){
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

	
	private List<EntidadeDominio> consultaNomeLike(Pessoa pessoa){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Pessoa> query = builder.createQuery(Pessoa.class);
		Root<Pessoa> from = query.from(Pessoa.class);
		
		Predicate predicado
		  = builder.like(from.get("nome"),  "%"+pessoa.getNome()+"%");
		query.where(predicado);
		List<Pessoa> results = em.createQuery(query).getResultList();

//		TypedQuery<Pessoa> typedQuery = em.createQuery(
//		    query.select(from )
//		    .where(
//		       builder.like(from.get("nome"), "%"+pessoa.getNome()+"%")
//		    )
//		);
//		List<Pessoa> results = typedQuery.getResultList();
		
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
