package br.com.musicianapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.Business.CompletarDataCadastro;
import br.com.musicianapp.Business.IStrategy;
import br.com.musicianapp.Business.ValidarCpf;
import br.com.musicianapp.Business.ValidarExistencia;
import br.com.musicianapp.Business.ValidarSenha;
import br.com.musicianapp.Business.ValidarTelefone;
import br.com.musicianapp.daos.AbstractDao;
import br.com.musicianapp.daos.CartaoDao;
import br.com.musicianapp.daos.EnderecoDao;
import br.com.musicianapp.daos.IDAO;
import br.com.musicianapp.daos.PessoaDao;
import br.com.musicianapp.daos.TelefoneDao;
import br.com.musicianapp.daos.UsuarioDao;
import br.com.musicianapp.domain.Cartao;
import br.com.musicianapp.domain.Endereco;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Pessoa;
import br.com.musicianapp.domain.Telefone;
import br.com.musicianapp.domain.Usuario;
import br.com.musicianapp.impl.IStyleQuery;

@Service
public class Facade implements IFacade,IStyleQuery{
	
	@Autowired private PessoaDao pessoaDao;
	@Autowired private TelefoneDao telefoneDao;
	@Autowired private CartaoDao cartaoDao;
	@Autowired private EnderecoDao enderecoDao;
	@Autowired private UsuarioDao usuarioDao;
	
	@Autowired private CompletarDataCadastro completarDataCadastro;
	@Autowired private ValidarCpf validarCpf;
	@Autowired private ValidarExistencia validarExistencia;
	@Autowired private ValidarSenha validarSenha;
	@Autowired private ValidarTelefone validarTelefone;
	
	
	private IDAO dao;
	private Map<String,IDAO> daos;
	private Map<String, Map<String,List<IStrategy>>> rns;
	private String parametro;
	private StringBuilder sb;
	
	private final String SALVAR= "SALVAR";
	
	private void startMaps() {
		sb = new StringBuilder();
		daos = new HashMap<String, IDAO>();
		rns = new HashMap<String, Map<String,List<IStrategy>>>();

		daos.put(Pessoa.class.getName(), pessoaDao);
		daos.put(Telefone.class.getName(), telefoneDao);
		daos.put(Cartao.class.getName(), cartaoDao);
		daos.put(Endereco.class.getName(), enderecoDao);
		daos.put(Usuario.class.getName(), usuarioDao);

		Map<String,IStrategy> rnSalvarPessoa = new HashMap<String, IStrategy>();
		
		/*
		 * Regras para Salvar Cliente
		 */
		Map<String, List<IStrategy>> rnsCliente = new HashMap<String,List<IStrategy>>();
		
		List<IStrategy> rnSalvar = new ArrayList<IStrategy>();
		rnSalvar.add(completarDataCadastro);
//		rnSalvar.add(validarExistencia);
		rnSalvar.add(validarCpf);
		rnSalvar.add(validarSenha);
		rnSalvar.add(validarTelefone);
		rnsCliente.put(SALVAR,rnSalvar);
		
		rns.put(Pessoa.class.getName(), rnsCliente);		

	}
	private IDAO getDaoInstance(EntidadeDominio entidade) {
		startMaps();
		this.dao =daos.get(entidade.getClass().getName());
		if(parametro!=null) {
			AbstractDao absDao = (AbstractDao)dao;
			absDao.setParametro(parametro);
			parametro=null;
		}
		return this.dao;
	}
	@Override
	public EntidadeDominio salvar(EntidadeDominio entidade) {
		getDaoInstance(entidade);
		// aplicar regras
		Map<String,List<IStrategy>> rn = rns.get(entidade.getClass().getName());
		
		List<IStrategy> regras = rn.get(SALVAR);
		if(regras!=null) {
			for (IStrategy strategies :regras) {
				String msg= strategies.processar(entidade);
				if (msg!=null) {
					sb.append(msg + "\n");
				}
			}
		}
		if(sb==null)
			entidade = this.dao.salvar(entidade);
		
		return null;
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
		getDaoInstance(entidade).apagar(entidade);

	}
	@Override
	public String getParametro() {
		AbstractDao absDao = (AbstractDao)dao;
		return absDao.getParametro();
	}
	@Override
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	
	
}
