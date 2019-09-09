package br.com.musicianapp.Business;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import br.com.musicianapp.Enum.Status;
import br.com.musicianapp.adapter.EnderecoAdapter;
import br.com.musicianapp.adapter.IAdapter;
import br.com.musicianapp.domain.Endereco;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Usuario;

@Service
public class ProcessarDadosEndereco implements IStrategyPreparToSave {

	private IAdapter<Endereco> adapter;
	public ProcessarDadosEndereco() {
		adapter = new EnderecoAdapter<Endereco>();
	}
	private Set<Endereco> checkEnderecoList(Set<Endereco> enderecos) {
		Set<Endereco> lista = new HashSet<Endereco>();
		for(Endereco endereco : enderecos) {
			endereco = processarDados(endereco);
			lista.add(endereco);
		}
		return lista;
	}
	private Endereco processarDados(Endereco endereco) {
		if(endereco.getApelidoEndereco()!=null)
			endereco.setApelidoEndereco(endereco.getApelidoEndereco().toUpperCase());
		
		if(endereco.getLogradouro()!=null)
			endereco.setLogradouro(endereco.getLogradouro().toUpperCase());
		
		if(endereco.getTipoLogradouro()!=null)
			endereco.setTipoLogradouro(endereco.getTipoLogradouro().toUpperCase());
		
		if(endereco.getCidade()!=null)
			endereco.setCidade(endereco.getCidade().toUpperCase());
		
		if(endereco.getBairro()!=null)
			endereco.setBairro(endereco.getBairro().toUpperCase());
		
		if(endereco.getCidade()!=null)
			endereco.setCidade(endereco.getCidade().toUpperCase());

		if(endereco.getCep()!=null) {
			String cep[]=endereco.getCep().split("-");
			endereco.setCep(cep[0]+cep[1]);
		}
		if(endereco.getStatus()==null)
			endereco.setStatus(Status.ATIVO);
		
		return endereco;
	}
	
	@Override
	public EntidadeDominio processarDados(EntidadeDominio entidade) {
		adapter.setAdapter(entidade);
		
		if(adapter.getListObject()!=null){
			if(entidade instanceof Usuario) {
				Usuario usuario = (Usuario)entidade;
				usuario.getPessoa().setEndereco(checkEnderecoList(adapter.getListObject()));
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
