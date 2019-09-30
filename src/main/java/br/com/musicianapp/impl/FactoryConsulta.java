package br.com.musicianapp.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.daos.consultas.CartaoConsultaImpl;
import br.com.musicianapp.daos.consultas.CupomConsultaImpl;
import br.com.musicianapp.daos.consultas.TelefoneConsultaImpl;
import br.com.musicianapp.domain.Cartao;
import br.com.musicianapp.domain.Cupom;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Telefone;

@Service
public class FactoryConsulta {
	private Map<String,Map<ConsultasPadrao,String>> mapaMetodos;
	private Map<String,Object> objConsultaImpl;
	
	/*
	 * Injeção das classes de consulta
	 */
	@Autowired private TelefoneConsultaImpl telImpl;
	@Autowired private CartaoConsultaImpl cartaoImpl;
	@Autowired private CupomConsultaImpl cupomImpl;

	
	public FactoryConsulta() {
		mapaMetodos = new HashMap<String, Map<ConsultasPadrao,String>>();
		
		/*
		 * Mapa de Metodos Telefone
		 */
		Map<ConsultasPadrao,String>metodosTelefone = new HashMap<ConsultasPadrao, String>();
		
		metodosTelefone.put(ConsultasPadrao.TELEFONE_TUDO, "pesquisarTodos");
		metodosTelefone.put(ConsultasPadrao.TELEFONE_ID, "pesquisarPorId");
		
		/*
		 * Mapa de Metodos Cartao
		 */
		Map<ConsultasPadrao,String>metodosCartao = new HashMap<ConsultasPadrao, String>();
		
		metodosCartao.put(ConsultasPadrao.CARTAO_TUDO, "pesquisarTodos");
		metodosCartao.put(ConsultasPadrao.CARTAO_ID, "pesquisarPorId");
		
		/*
		 * Mapa de Metodos Cupom
		 */
		Map<ConsultasPadrao,String>metodosCupom = new HashMap<ConsultasPadrao, String>();
		
		metodosCupom.put(ConsultasPadrao.CUPOM_TUDO, "pesquisarTodos");
		metodosCupom.put(ConsultasPadrao.CUPOM_ID, "pesquisarPorId");

		/*
		 * Mapa de metodos principais
		 */
		mapaMetodos.put(Telefone.class.getName(), metodosTelefone);
		mapaMetodos.put(Cartao.class.getName(), metodosCartao);
		mapaMetodos.put(Cupom.class.getName(), metodosCupom);

	}

	/*
	 * Mapa com as classes de consulta
	 */
	private void createImpl() {
		objConsultaImpl = new HashMap<String, Object>();
		objConsultaImpl.put(Telefone.class.getName(), telImpl);
		objConsultaImpl.put(Cartao.class.getName(), cartaoImpl);
		objConsultaImpl.put(Cupom.class.getName(), cupomImpl);

	}
	
	/*
	 * Método feito via reflection na qual instancia as classes de consulta e chama os métodos respectivos
	 * todos os métodos devem ter um único parametro com a classe da respectiva classe de consulta
	 * caso seja necessário passar zero ou mais de um parametro deverá ser feito manualmente 
	 */
	public List<EntidadeDominio> fabricarConsulta(EntidadeDominio entidade, ConsultasPadrao consultaPadrao ){
		createImpl();
		List<EntidadeDominio> entidades=null;
		try {
			String nomeClasse = entidade.getClass().getName();
			Map<ConsultasPadrao,String> mapa = mapaMetodos.get(nomeClasse);
			Object objImpl = objConsultaImpl.get(nomeClasse);

			String nomeMetodo = mapa.get(consultaPadrao);
			
			
			Class<?> clazz = objImpl.getClass();
			
			Method metodo = clazz.getMethod(nomeMetodo,entidade.getClass());
			return (List<EntidadeDominio>) metodo.invoke(objImpl,entidade);
			
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return entidades;	
	}
}
