package br.com.musicianapp.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.Enum.Status;
import br.com.musicianapp.domain.Cartao;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.repository.CartaoRepository;

@Service
public class CartaoDao implements IDAO {
	private final String CLASSE = Cartao.class.getName();

	@Autowired
	private CartaoRepository cartaoRepository;
	
	private Optional<Cartao> optTCartao;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void apagar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

	}

}
