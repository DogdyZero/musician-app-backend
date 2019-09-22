package br.com.musicianapp.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.Enum.Status;
import br.com.musicianapp.adapter.CartaoAdapter;
import br.com.musicianapp.adapter.IAdapter;
import br.com.musicianapp.domain.Cartao;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.repository.CartaoRepository;

@Service
public class CartaoDao extends AbstractDao {
	private final String CLASSE = Cartao.class.getName();

	@Autowired
	private CartaoRepository cartaoRepository;
	private List<EntidadeDominio> entidades;
	private Optional<Cartao> optTCartao;
	private IAdapter<Cartao> adapter;
	
	public CartaoDao() {
		adapter = new CartaoAdapter<Cartao>();
	}
	
	private Cartao convertClass(EntidadeDominio entidade) {
		if(entidade.getClass().getName().equals(CLASSE)) {
			return (Cartao)entidade;
		}
		return null;
	}
	
	@Override
	public EntidadeDominio salvar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntidadeDominio alterar(EntidadeDominio entidade) {
		Cartao cartao = convertClass(entidade);
		if(cartao!=null) {
			optTCartao = cartaoRepository.findById(cartao.getId());
			
			Cartao cartaoBD = optTCartao.get();
			
			if(cartaoBD.getId()==cartao.getId()) {
				if(cartaoBD.getStatus().equals(Status.ATIVO)) {
					cartaoBD.setStatus(Status.INATIVO);
				} else {
					cartaoBD.setStatus(Status.ATIVO);
				}
				return cartaoRepository.save(cartaoBD);
			}
		}
		return null;
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		entidades = new ArrayList<EntidadeDominio>();
		String parametro=super.getParametro().toLowerCase();
		adapter.setAdapter(entidade);
		Cartao cartao = adapter.getObject();
			if(parametro.equals("all")) {
				parametro=null;
				return consultarAll();
			} else if(parametro.equals("consid")){
				parametro = null;
				return consultaId(cartao);
			}
		return null;	
		}
	private List<EntidadeDominio> consultarAll(){
		List<Cartao> cartoes = cartaoRepository.findAll();
		for (Cartao cartao : cartoes) {
			entidades.add(cartao);
		}
		return entidades;
	}
	private List<EntidadeDominio> consultaId(Cartao cartao){
		optTCartao = cartaoRepository.findById(cartao.getId());
		cartao = optTCartao.get();
		entidades.add(cartao);
		return entidades;
	}

	@Override
	public void apagar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

	}

}
