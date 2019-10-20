package br.com.musicianapp.grafico;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Datasets {
	private String label;
	private String borderColor;
	private boolean fill;
	private List<Double> data;
	public String getBorderColor() {
		return borderColor;
	}
	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}
	public boolean isFill() {
		return fill;
	}
	public void setFill(boolean fill) {
		this.fill = fill;
	}
	public List<Double> getData() {
		return data;
	}
	public void setData(List<Double> data) {
		this.data = data;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
}
