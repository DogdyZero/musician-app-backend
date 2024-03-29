package br.com.musicianapp.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.Enum.Status;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Telefone;
import br.com.musicianapp.impl.FactoryConsulta;
import br.com.musicianapp.repository.TelefoneRepository;

@Service
public class TelefoneDao extends AbstractDao {
	private final String CLASSE = Telefone.class.getName();

	@Autowired
	private TelefoneRepository telefoneRepository;
	
	@Autowired
	private FactoryConsulta fabrica;
	
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
				telBD = telefone;
				telBD.setStatus(Status.ATIVO);
				return telefoneRepository.save(telBD);
			}
		}
		return null;
	}
	
	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		return fabrica.fabricarConsulta(Telefone.class.cast(entidade), super.getParametro());
	}

	@Override
	public void apagar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

	}

}
