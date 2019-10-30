package br.com.musicianapp.daos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.grafico.Datasets;
import br.com.musicianapp.grafico.Grafico;
import br.com.musicianapp.grafico.GraficoPesquisa;

@Service
public class GraficoDao extends AbstractDao {
	@PersistenceContext
	private EntityManager em;
	

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		GraficoPesquisa pesquisa = (GraficoPesquisa)entidade;

		
//		String queryJoin="join pedido.carrinhoCompra as carrinhoCompra" + 
//				"join carrinhoCompra.itemProduto as itemProduto " + 
//				"join itemProduto.produto as produto " + 
//				"join produto.grupoPrecificacao as grupoPrecificacao";
		
		
		Query query = (Query) em.createQuery(""
				+ "select to_char(pedido.data,'YYYY/MM') as data, "
				+ "sum(grupoPrecificacao.custoCompra) as custo, "
				+ "sum(itemProduto.valorProduto) as venda from Pedido as pedido "
				+ "join pedido.carrinhoCompra as carrinhoCompra "
				+ "join carrinhoCompra.itemProduto as itemProduto "
				+ "join itemProduto.produto as produto "
				+ "join produto.grupoPrecificacao as grupoPrecificacao "
				+ "where pedido.data>= :dataInicio and pedido.data< :dataFinal "
				+ "group by to_char(pedido.data,'YYYY/MM') "
				+ "order by data");
		
		query.setParameter("dataInicio",pesquisa.getDataInicial());
		query.setParameter("dataFinal",pesquisa.getDataFinal());

		List<Object[]> result = query.getResultList();
		
		List<String> meses  =  new ArrayList<String>();
		List<Double> valores = new ArrayList<Double>();
		List<Double> valores2 = new ArrayList<Double>();

		
		for(Object[] obj : result) {
			String mes = (String)obj[0];
			double valor = (double) obj[1];
			double valor2 = (double) obj[2];
			String[] separador = mes.split("/");
			meses.add(separador[1]+"/"+separador[0]);
			valores.add(valor);
			valores2.add(valor2);

		}
		/*
		 * caso o resultado seja 1 unico mês cria uma query resultado diário
		 */
		if(meses.size()==1) {
			
			query = (Query) em.createQuery(""
					+ "select pedido.data,  "
					+ "sum(grupoPrecificacao.custoCompra) as custo, "
					+ "sum(itemProduto.valorProduto) as venda from Pedido as pedido "
					+ "join pedido.carrinhoCompra as carrinhoCompra "
					+ "join carrinhoCompra.itemProduto as itemProduto "
					+ "join itemProduto.produto as produto "
					+ "join produto.grupoPrecificacao as grupoPrecificacao "
					+ "where pedido.data>= :dataInicio and pedido.data< :dataFinal "
					+ "group by pedido.data "
					+ "order by pedido.data");
			
			query.setParameter("dataInicio",pesquisa.getDataInicial());
			query.setParameter("dataFinal",pesquisa.getDataFinal());

			result = query.getResultList();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			meses = new ArrayList<String>();
			valores = new ArrayList<Double>();
			valores2 = new ArrayList<Double>();
			for(Object[] obj : result) {
				Date data = (Date)obj[0];
				double valor = (double) obj[1];
				double valor2 = (double) obj[2];
				String dataString = sdf.format(data);
				meses.add(dataString);
				valores.add(valor);
				valores2.add(valor2);
			}
			
		}
		
		Grafico grafico = new Grafico();
		Datasets dataSet1 = new Datasets();

		dataSet1.setBorderColor("#1E88E5");
		dataSet1.setFill(false);
		dataSet1.setLabel("Custo");
		dataSet1.setData(valores);

		Datasets dataSet2 = new Datasets();

		dataSet2.setBorderColor("#755555");
		dataSet2.setFill(false);
		dataSet2.setLabel("Vendas");

		dataSet2.setData(valores2);

		List<Datasets> data = new ArrayList<Datasets>();
		data.add(dataSet1);
		data.add(dataSet2);

		grafico.setDatasets(data);

		grafico.setLabels(meses);
		
		List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
		entidades.add(grafico);
		return entidades;
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
	public void apagar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		
	}

}
