package br.com.musicianapp.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.Enum.Status;
import br.com.musicianapp.domain.Endereco;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.repository.EnderecoRepository;

@Service
public class EnderecoDao implements IDAO {
	private final String CLASSE = Endereco.class.getName();

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	private Optional<Endereco> optTEndereco;

	private Endereco convertClass(EntidadeDominio entidade) {
		if(entidade.getClass().getName().equals(CLASSE)) {
			return (Endereco)entidade;
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
		Endereco endereco = convertClass(entidade);
		if(endereco!=null) {
			optTEndereco = enderecoRepository.findById(endereco.getId());
			
			Endereco endBD = optTEndereco.get();
			
			if(endBD.getId()==endereco.getId()) {
				if(endBD.getStatus().equals(Status.ATIVO)) {
					endBD.setStatus(Status.INATIVO);
				} else {
					endBD.setStatus(Status.ATIVO);
				}
				return enderecoRepository.save(endBD);
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
