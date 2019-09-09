package br.com.musicianapp.Business;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import br.com.musicianapp.Enum.Status;
import br.com.musicianapp.adapter.IAdapter;
import br.com.musicianapp.adapter.TelefoneAdapter;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Telefone;
import br.com.musicianapp.domain.Usuario;

@Service
public class ProcessarDadosTelefone implements IStrategyPreparToSave{
	private IAdapter<Telefone> adapter;
	public ProcessarDadosTelefone() {
		adapter = new TelefoneAdapter<Telefone>();
	}
	private Set<Telefone> checkTelefoneList(Set<Telefone> telefones) {
		Set<Telefone> lista = new HashSet<Telefone>();
		for(Telefone telefone : telefones) {
			telefone = processarDados(telefone);
			lista.add(telefone);
		}
		return lista;
	}
	private Telefone processarDados(Telefone telefone) {

		if(telefone.getStatus()==null)
			telefone.setStatus(Status.ATIVO);
		
		return telefone;
	}
	
	@Override
	public EntidadeDominio processarDados(EntidadeDominio entidade) {
		adapter.setAdapter(entidade);
		
		if(adapter.getListObject()!=null){
			if(entidade instanceof Usuario) {
				Usuario usuario = (Usuario)entidade;
				usuario.getPessoa().setTelefone(checkTelefoneList(adapter.getListObject()));
				return usuario;

			}
			
		} else if(adapter.getObject()!=null) {
			return processarDados(adapter.getObject());
		} else {
			return null;
		}
		return null;
				
	}

}
