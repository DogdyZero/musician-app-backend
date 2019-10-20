package br.com.musicianapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.musicianapp.grafico.Datasets;
import br.com.musicianapp.grafico.Grafico;

@CrossOrigin
@RestController
@RequestMapping("/grafico")
public class GraficoController {
	
	@PersistenceContext
	private EntityManager em;
	
	@RequestMapping
	public Object gerarGrafico() {
		StringBuilder sb = new StringBuilder();
		sb.append("select extract(month from ped_data) as mes, sum(ped_valor)"); 
		sb.append("from pedido");
		sb.append("where ped_data>='2019-01-01' and ped_data<'2019-12-12'");
		sb.append("group by mes");
		
		List<Object[]> result =  em.createQuery("select extract(month from data) , sum(total) from Pedido group by extract(month from data)").getResultList();
		List<String> meses  =  new ArrayList<String>();
		List<Double> valores = new ArrayList<Double>();
		
		for(Object[] obj : result) {
			int mes = (int)obj[0];
			String mesString = String.valueOf(mes);
			meses.add(mesString);
			double valor = (double) obj[1];
			valores.add(valor);
		}
		
		Grafico grafico = new Grafico();
		Datasets dataSet1 = new Datasets();
//		
		dataSet1.setBorderColor("#1E88E5");
		dataSet1.setFill(false);
		dataSet1.setLabel("Valores");
//		List<Integer> dadosTbl1 = new ArrayList<Integer>();
//		dadosTbl1.add(2000);
//		dadosTbl1.add(1500);
//		dadosTbl1.add(1900);
		dataSet1.setData(valores);
//		
//		Datasets dataSet2 = new Datasets();
//
//		
//		dataSet2.setBorderColor("#755555");
//		dataSet2.setFill(false);
//		dataSet2.setLabel("Teste2");
//		List<Integer> dadosTbl2 = new ArrayList<Integer>();
//		dadosTbl2.add(400);
//		dadosTbl2.add(500);
//		dadosTbl2.add(700);
//		dataSet2.setData(dadosTbl2);
//		
		List<Datasets> data = new ArrayList<Datasets>();
		data.add(dataSet1);
//		data.add(dataSet2);
//		
//		
		grafico.setDatasets(data);
//		
//		List<String> nomesCampos = new ArrayList<String>();
//		
//		nomesCampos.add("A");
//		nomesCampos.add("B");
//		nomesCampos.add("C");
		grafico.setLabels(meses);

		return grafico;
	}
	private List<Integer> getCount(){
		List<Object> result =  em.createQuery("select count(*) from  pedido").getResultList();
		result.forEach(p ->System.out.println(p));
		return null;
	}
	
}
