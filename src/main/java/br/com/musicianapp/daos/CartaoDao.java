package br.com.musicianapp.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.Enum.Status;
import br.com.musicianapp.adapter.CartaoAdapter;
import br.com.musicianapp.adapter.IAdapter;
import br.com.musicianapp.domain.Cartao;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.impl.FactoryConsulta;
import br.com.musicianapp.repository.CartaoRepository;

@Service
public class CartaoDao extends AbstractDao {
	private final String CLASSE = Cartao.class.getName();

	@Autowired
	private CartaoRepository cartaoRepository;
	@Autowired
	private FactoryConsulta fabrica;
	
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
				cartaoBD = cartao;
				cartaoBD.setStatus(Status.ATIVO);
				return cartaoRepository.save(cartaoBD);
			}
		}
		return null;
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		return fabrica.fabricarConsulta(Cartao.class.cast(entidade), super.getParametro());
	}

	@Override
	public void apagar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

	}

}
