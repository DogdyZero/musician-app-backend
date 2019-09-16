package br.com.musicianapp.Enum;

public enum StatusPedido {
	AGUARDANDO_APROVACAO("Aguardando Aprovação"),
	EM_SEPARACAO ("Em Separação"),
	EM_TRANSPORTE ("Em Transporte"),
	ENTREGUE("Em Entrega");
	
	private String status;

	private StatusPedido(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
