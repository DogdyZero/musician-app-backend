package br.com.musicianapp.grafico;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.musicianapp.domain.EntidadeDominio;

@Component
public class Grafico extends EntidadeDominio{
	private List<String> labels;
	private List<Datasets> datasets;
	public List<String> getLabels() {
		return labels;
	}
	public void setLabels(List<String> labels) {
		this.labels = labels;
	}
	public List<Datasets> getDatasets() {
		return datasets;
	}
	public void setDatasets(List<Datasets> datasets) {
		this.datasets = datasets;
	}
	
	
}
