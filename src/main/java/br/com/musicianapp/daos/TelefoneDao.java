package br.com.musicianapp.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.Enum.Status;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Telefone;
import br.com.musicianapp.repository.TelefoneRepository;

@Service
public class TelefoneDao implements IDAO {
	private final String CLASSE = Telefone.class.getName();

	@Autowired
	private TelefoneRepository telefoneRepository;
	
	private Optional<Telefone> optTelefone;

	private Telefone convertClass(EntidadeDominio entidade) {
		if(entidade.getClass().getName().equals(CLASSE)) {
			return (Telefone)entidade;
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
		Telefone telefone = convertClass(entidade);
		if(telefone!=null) {
			optTelefone = telefoneRepository.findById(telefone.getId());
			
			Telefone telBD = optTelefone.get();
			
			if(telBD.getId()==telefone.getId()) {
				if(telBD.getStatus().equals(Status.ATIVO)) {
					telBD.setStatus(Status.INATIVO);
				} else {
					telBD.setStatus(Status.ATIVO);
				}
				return telefoneRepository.save(telBD);
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
