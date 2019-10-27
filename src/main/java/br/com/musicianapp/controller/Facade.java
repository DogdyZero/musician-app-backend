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
import br.com.musicianapp.daos.CupomDao;
import br.com.musicianapp.daos.EnderecoDao;
import br.com.musicianapp.daos.EstoqueDao;
import br.com.musicianapp.daos.GraficoDao;
import br.com.musicianapp.daos.IDAO;
import br.com.musicianapp.daos.ItemProdutoDao;
import br.com.musicianapp.daos.PedidoDao;
import br.com.musicianapp.daos.PessoaDao;
import br.com.musicianapp.daos.ProdutoDao;
import br.com.musicianapp.daos.TelefoneDao;
import br.com.musicianapp.daos.TrocaDao;
import br.com.musicianapp.daos.UsuarioDao;
import br.com.musicianapp.domain.Cartao;
import br.com.musicianapp.domain.Cupom;
import br.com.musicianapp.domain.Endereco;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Estoque;
import br.com.musicianapp.domain.ItemProduto;
import br.com.musicianapp.domain.Pedido;
import br.com.musicianapp.domain.Pessoa;
import br.com.musicianapp.domain.Produto;
import br.com.musicianapp.domain.Telefone;
import br.com.musicianapp.domain.Troca;
import br.com.musicianapp.domain.Usuario;
import br.com.musicianapp.grafico.GraficoPesquisa;
import br.com.musicianapp.impl.ConsultasPadrao;
import br.com.musicianapp.impl.IStyleQuery;
import br.com.musicianapp.impl.Resultado;

@Service
public class Facade implements IFacade,IStyleQuery{
	
	@Autowired private PessoaDao pessoaDao;
	@Autowired private TelefoneDao telefoneDao;
	@Autowired private CartaoDao cartaoDao;
	@Autowired private EnderecoDao enderecoDao;
	@Autowired private UsuarioDao usuarioDao;
	@Autowired private ProdutoDao produtoDao;
	@Autowired private PedidoDao pedidoDao;
	@Autowired private ItemProdutoDao itemProdutoDao;
	@Autowired private TrocaDao trocaDao;
	@Autowired private EstoqueDao estoqueDao;
	@Autowired private CupomDao cupomDao;
	@Autowired private GraficoDao graficoDao;

	
	@Autowired private CompletarDataCadastro completarDataCadastro;
	@Autowired private ValidarCpf validarCpf;
	@Autowired private ValidarExistencia validarExistencia;
	@Autowired private ValidarSenha validarSenha;
	@Autowired private ValidarTelefone validarTelefone;
	
	/*
	 * ELABORAR PRINCIPAIS REGRAS DE NEGOCIO
	 * 1 - VALIDAR O CPF
	 * 2 - VALIDAR O CODIGO DO PRODUTO
	 * 3 - VALIDAR SE O PRODUTO JÁ ESTA CADASTRADO
	 * 4 - CADASTRAR SENHA FORTE
	 * 5 - VALIDAR SE O CARTÃO DE CRÉDITO JÁ NÃO FOI CADASTRADO
	 * 6 - VALIDAR A QUANTIDADE DE DIGITOS DO TELEFONE
	 * 7 - VALIDAR SE O CEP ESTA CORRETO
	 * 8 - CADASTRAR O PRIMEIRO CARTÃO COMO PREFERENCIAL
	 * 9 - NÃO PERMITIR PAGAMETNOS ABAIXO DE 10,00
	 * 10 - VALIDAR SE O PRODUTO DEVOLVIDO ESTA EM CONDIÇÕES DE VENDA E RETORNA-LO PARA O ESTOQUE
	 * 11 - VALIDAR SE O USUARIO JÁ NÃO FOI CADASTRADO
	 * 12 - VALIDAR SE O USUARIO ESTA ATIVO AO FAZER LOGIN
	 * 13 - VALIDAR SE O PRODUTO ESTA DISPONIVEL PARA VENDA ANTES DE FINALIZAR A COMPRA
	 * 14 - VALIDAR SE TODO O PAGAMENTO FOI EFETUADO PARA LIBERAR PARA VENDA
	 * 15 - REGRAS DE GERENCIALMENTO E MUDANÇA DE STATUS DO PRODUTO PELO ADMISTRADOR
	 * 16 - NÃO PERMITIR VENDAS EFETUADAS ACIMA DA QUANTIDADE DE ESTOQUE
	 * 17 - CLIENTE PODE USAR UM CUPOM DE TROCA OU UM PROMOCIONAL
	 * 18 - GERAR CUPONS APÓS TROCA DO PRODUTO
	 * 19 - UM PRODUTO SÓ PODE TER O SEU VALOR ALTERADO SE TIVER DENTRO DA MARGEM DE LUCRO
	 * 20 - HISTORICO DE MUDANÇA DO PRODUTO A CADA TRANSACAO (COMPRA, VENDA, TROCA, ATIVAÇÃO, INATIVAÇÃO, ADICIONADA AO CARRINHO)
	 * 21 - O PRIMEIRO ENDEREÇO DEVE SER O ENDEREÇO DE COBRANÇA
	 * 22 - CRIAR REGRAS PARA RANKING DO CLIENTE (PONTUAÇÃO
	 * 23 - SOMENTE UM CUPOM PROMOCIONAL PODE SER USADO POR VEZ
	 * 24 - NÃO DEVERÁ SER ACEITO VENDAS COM VALOR INFERIOR A 10,00, SOMENTE SERÁ LIBERADO SE O CLIENTE USAR CUPOM
	 * 
	 */
	private IDAO dao;
	private Map<String,IDAO> daos;
	private Map<String, Map<String,List<IStrategy>>> rns;
	private ConsultasPadrao parametro;
	private StringBuilder sb;
	private Resultado resultado;
	private final String SALVAR= "SALVAR";
	
	private void startMaps() {
		resultado = new Resultado();
		sb = new StringBuilder();
		daos = new HashMap<String, IDAO>();
		rns = new HashMap<String, Map<String,List<IStrategy>>>();

		
		daos.put(Pessoa.class.getName(), pessoaDao);
		daos.put(Telefone.class.getName(), telefoneDao);
		daos.put(Cartao.class.getName(), cartaoDao);
		daos.put(Endereco.class.getName(), enderecoDao);
		daos.put(Usuario.class.getName(), usuarioDao);
		daos.put(Produto.class.getName(), produtoDao);
		daos.put(Pedido.class.getName(), pedidoDao);
		daos.put(ItemProduto.class.getName(), itemProdutoDao);
		daos.put(Troca.class.getName(), trocaDao);
		daos.put(Estoque.class.getName(), estoqueDao);
		daos.put(Cupom.class.getName(), cupomDao);
		daos.put(GraficoPesquisa.class.getName(), graficoDao);




		/*
		 * Regras para Salvar Cliente
		 */
		Map<String, List<IStrategy>> rnsPessoa = new HashMap<String,List<IStrategy>>();
		
		List<IStrategy> rnPessoa = new ArrayList<IStrategy>();
		rnPessoa.add(completarDataCadastro);
//		rnPessoa.add(validarExistencia);
//		rnPessoa.add(validarCpf);
//		rnPessoa.add(validarSenha);
		rnPessoa.add(validarTelefone);
		rnsPessoa.put(SALVAR,rnPessoa);
		
		
		Map<String, List<IStrategy>> rnsUsuario = new HashMap<String,List<IStrategy>>();
		List<IStrategy> rnUsuario = new ArrayList<IStrategy>();
		rnsUsuario.put(SALVAR,rnUsuario);

		
		Map<String, List<IStrategy>> rnsProduto = new HashMap<String,List<IStrategy>>();
		List<IStrategy> rnProduto = new ArrayList<IStrategy>();
		rnsProduto.put(SALVAR,rnProduto);
		
		Map<String, List<IStrategy>> rnsEstoque = new HashMap<String,List<IStrategy>>();
		List<IStrategy> rnEstoque = new ArrayList<IStrategy>();
		rnsProduto.put(SALVAR,rnEstoque);
		

		rns.put(Pessoa.class.getName(),rnsPessoa);
		rns.put(Usuario.class.getName(), rnsUsuario);		
		rns.put(Produto.class.getName(),rnsProduto);
		rns.put(Estoque.class.getName(),rnsEstoque);


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
	public Resultado salvar(EntidadeDominio entidade) {
		getDaoInstance(entidade);
		// aplicar regras
		
		String r  = executarRegras(entidade,SALVAR);
		if(r.length() < 1 || r==null){
			entidade = this.dao.salvar(entidade);
			if(entidade!=null) {
				resultado.addEntidadeList(entidade);
			}else {
				resultado.setResultado("Erro ao salvar informação no banco de dados!");
			}
			
		}
		resultado.setResultado(r);
		return resultado;

	}

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		getDaoInstance(entidade).alterar(entidade);
		return null;
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		return getDaoInstance(entidade).consultar(entidade);
	}

	@Override
	public Resultado apagar(EntidadeDominio entidade) {
		getDaoInstance(entidade).apagar(entidade);
		return null;

	}
	
	private String executarRegras(EntidadeDominio entidade, String regra) {
		Map<String,List<IStrategy>> rn = rns.get(entidade.getClass().getName());
		List<IStrategy> regras = rn.get(regra);
		if(regras!=null) {
			for (IStrategy strategies :regras) {
				String msg= strategies.processar(entidade);
				if (msg!=null && msg.length()>0) {
					sb.append(msg + "\n");
				}
			}
		}
		return sb.toString();
	}
	
	@Override
	public ConsultasPadrao getParametro() {
		AbstractDao absDao = (AbstractDao)dao;
		return absDao.getParametro();
	}
	@Override
	public void setParametro(ConsultasPadrao parametro) {
		this.parametro = parametro;
	}
	
	
}
