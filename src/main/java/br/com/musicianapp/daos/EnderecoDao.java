package br.com.musicianapp.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.Enum.Status;
import br.com.musicianapp.adapter.EnderecoAdapter;
import br.com.musicianapp.adapter.IAdapter;
import br.com.musicianapp.domain.Endereco;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.impl.ConsultasPadrao;
import br.com.musicianapp.repository.EnderecoRepository;

@Service
public class EnderecoDao extends AbstractDao {
	private IAdapter<Endereco> adapter;
	private List<EntidadeDominio> entidades;
	public EnderecoDao() {
		adapter = new EnderecoAdapter<Endereco>();
	}

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	private Optional<Endereco> optTEndereco;

	
	@Override
	public EntidadeDominio salvar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntidadeDominio alterar(EntidadeDominio entidade) {
		adapter.setAdapter(entidade);
		if(adapter.getObject()!=null) {
			optTEndereco = enderecoRepository.findById(adapter.getObject().getId());
			
			Endereco endBD = optTEndereco.get();
			
			if(endBD.getId()==adapter.getObject().getId()) {
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
		entidades = new ArrayList<EntidadeDominio>();
		ConsultasPadrao parametro=super.getParametro();
		adapter.setAdapter(entidade);
		Endereco endereco = adapter.getObject();
			if(parametro.equals(ConsultasPadrao.ENDERECO_TUDO)) {
				parametro=null;
				return consultarAll();
			} else if(parametro.equals(ConsultasPadrao.ENDERECO_ID)){
				parametro = null;
				return consultaId(endereco);
			}
		return null;	
		}
	private List<EntidadeDominio> consultarAll(){
		List<Endereco> enderecos = enderecoRepository.findAll();
		for (Endereco end : enderecos) {
			entidades.add(end);
		}
		return entidades;
	}
	private List<EntidadeDominio> consultaId(Endereco endereco){
		optTEndereco = enderecoRepository.findById(endereco.getId());
		endereco = optTEndereco.get();
		entidades.add(endereco);
		return entidades;
	}
	
	@Override
	public void apagar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

	}

}
