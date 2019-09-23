package br.com.musicianapp.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.adapter.CupomAdapter;
import br.com.musicianapp.adapter.IAdapter;
import br.com.musicianapp.domain.Cupom;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.repository.CupomRepository;

@Service
public class CupomDao extends AbstractDao {
	@Autowired
	private CupomRepository cupomRepository;
	private List<EntidadeDominio> entidades;
	private Optional<Cupom> optCupom;
	private IAdapter<Cupom> adapter;
	
	public CupomDao() {
		adapter = new CupomAdapter<Cupom>();
	}
	
	@Override
	public EntidadeDominio salvar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntidadeDominio alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		entidades = new ArrayList<EntidadeDominio>();
		String parametro=super.getParametro().toLowerCase();
		adapter.setAdapter(entidade);
		Cupom cupom = adapter.getObject();
			if(parametro.equals("all")) {
				parametro=null;
				return consultarAll();
			} else if(parametro.equals("consid")){
				parametro = null;
				return consultaId(cupom);
			}
		return null;	
		}
	private List<EntidadeDominio> consultarAll(){
		List<Cupom> cupons = cupomRepository.findAll();
		for (Cupom cupom : cupons) {
			entidades.add(cupom);
		}
		return entidades;
	}
	private List<EntidadeDominio> consultaId(Cupom cupom){
		optCupom = cupomRepository.findById(cupom.getId());
		cupom = optCupom.get();
		entidades.add(cupom);
		return entidades;
	}

	@Override
	public void apagar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

	}

}
