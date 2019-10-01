package br.com.musicianapp.Business;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.adapter.IAdapter;
import br.com.musicianapp.adapter.PessoaAdapter;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Pedido;
import br.com.musicianapp.domain.Pessoa;

@Service
public class ProcessarDadosPessoa implements IStrategyPreparToSave {

	private IAdapter<Pessoa> adapter;

	@Autowired
	private ProcessarDadosPedido processarDadosPedido;
	
	@Autowired
	Set<Pedido> peds;
	

	public ProcessarDadosPessoa() {
		adapter = new PessoaAdapter<Pessoa>();
	}

	@Override
	public EntidadeDominio processarDados(EntidadeDominio entidade) {
		adapter.setAdapter(entidade);
		Pessoa pessoa = adapter.getObject();
		
		if(pessoa.getNome()!=null) {
			pessoa.setNome(pessoa.getNome().toUpperCase());
		}

		if(pessoa.getEmail()!=null) {
			String[] email = pessoa.getEmail().split("@");
			pessoa.setEmail(email[0].toUpperCase()+"@"+email[1].toUpperCase());
		}
		if(pessoa.getCpf()!=null) {
			if(pessoa.getCpf().length()>11) {
				String cpf = pessoa.getCpf();
				StringBuilder sb = new StringBuilder();
				sb.append(cpf.substring(0, 3));
				sb.append(cpf.substring(4, 7));
				sb.append(cpf.substring(8,11));
				sb.append(cpf.substring(12,14));
				
				pessoa.setCpf(sb.toString());
			}
		}
		if(pessoa.getPedido() != null){
			for (Pedido ped  : pessoa.getPedido()) {	
				peds.add((Pedido) processarDadosPedido.processarDados(ped));
			}
			pessoa.setPedido(peds);
		}
		
		return (EntidadeDominio)pessoa;

		
	}
}
