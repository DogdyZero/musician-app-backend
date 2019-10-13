package br.com.musicianapp.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.adapter.CupomAdapter;
import br.com.musicianapp.adapter.IAdapter;
import br.com.musicianapp.domain.Cupom;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.impl.FactoryConsulta;
import br.com.musicianapp.repository.CupomRepository;

@Service
public class CupomDao extends AbstractDao {
	@Autowired
	private CupomRepository cupomRepository;
	@Autowired
	private FactoryConsulta fabrica;
	private List<EntidadeDominio> entidades;
	private Optional<Cupom> optCupom;
	private IAdapter<Cupom> adapter;
	
	public CupomDao() {
		adapter = new CupomAdapter<Cupom>();
	}
	
	@Override
	public EntidadeDominio salvar(EntidadeDominio entidade) {
		return null;
	}

	@Override
	public EntidadeDominio alterar(EntidadeDominio entidade) {
		adapter.setAdapter(entidade);
		Cupom cupom = adapter.getObject();
		optCupom = cupomRepository.findById(cupom.getId());
		Cupom cupomBD = optCupom.get();
		cupomBD.setStatus(cupom.getStatus());		
		return cupomRepository.save(cupomBD);
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		return fabrica.fabricarConsulta(Cupom.class.cast(entidade), super.getParametro());
	}
	@Override
	public void apagar(EntidadeDominio entidade) {

	}

}
