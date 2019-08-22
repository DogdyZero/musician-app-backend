package br.com.musicianapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.daos.CartaoDao;
import br.com.musicianapp.daos.EnderecoDao;
import br.com.musicianapp.daos.IDAO;
import br.com.musicianapp.daos.PessoaDao;
import br.com.musicianapp.daos.TelefoneDao;
import br.com.musicianapp.domain.Cartao;
import br.com.musicianapp.domain.Endereco;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Pessoa;
import br.com.musicianapp.domain.Telefone;

@Service
public class Facade implements IFacade{
	
	@Autowired private PessoaDao pessoaDao;
	@Autowired private TelefoneDao telefoneDao;
	@Autowired private CartaoDao cartaoDao;
	@Autowired private EnderecoDao enderecoDao;

	private Map<String,IDAO> daos;
	
	private void startMaps() {
		daos = new HashMap<String, IDAO>();
		daos.put(Pessoa.class.getName(), pessoaDao);
		daos.put(Telefone.class.getName(), telefoneDao);
		daos.put(Cartao.class.getName(), cartaoDao);
		daos.put(Endereco.class.getName(), enderecoDao);
	}
	private IDAO getDaoInstance(EntidadeDominio entidade) {
		startMaps();
		return daos.get(entidade.getClass().getName());
	
	}
	@Override
	public EntidadeDominio salvar(EntidadeDominio entidade) {
		return getDaoInstance(entidade).salvar(entidade);
	}

	@Override
	public EntidadeDominio alterar(EntidadeDominio entidade) {
		return getDaoInstance(entidade).alterar(entidade);
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		return getDaoInstance(entidade).consultar(entidade);
	}

	@Override
	public void apagar(EntidadeDominio entidade) {
		getDaoInstance(entidade).salvar(entidade);

	}
	
	
	
	
	
}
