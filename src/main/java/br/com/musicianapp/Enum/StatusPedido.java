package br.com.musicianapp.Enum;

public enum StatusPedido {
	AGUARDANDO_APROVACAO("Aguardando aprovação"),
	EM_SEPARACAO("Em separação"),
	EM_TRANSPORTE("Em transporte"),
	ENTREGUE("Entregue");
	
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
