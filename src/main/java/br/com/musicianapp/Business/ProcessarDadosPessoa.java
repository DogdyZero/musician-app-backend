package br.com.musicianapp.Business;

import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Pessoa;

public class ProcessarDadosPessoa implements IStrategyPreparToSave {

	private final String CLASSE =Pessoa.class.getName();
	@Override
	public EntidadeDominio processarDados(EntidadeDominio entidade) {
		if(entidade.getClass().getName().equals(CLASSE)) {
			Pessoa pessoa = Pessoa.class.cast(entidade);
			pessoa.setNome(pessoa.getNome().toUpperCase());
			if(pessoa.getCpf()!=null) {
				String[] email = pessoa.getEmail().split("@");
				pessoa.setEmail(email[0].toUpperCase()+"@"+email[1].toUpperCase());
			}
			if(pessoa.getCpf().length()>11) {
				String cpf = pessoa.getCpf();
				StringBuilder sb = new StringBuilder();
				sb.append(cpf.substring(0, 3));
				sb.append(cpf.substring(4, 7));
				sb.append(cpf.substring(8,11));
				sb.append(cpf.substring(12,14));

				pessoa.setCpf(sb.toString());
			}
			return (EntidadeDominio)pessoa;

		}
		return null;
	}

}
