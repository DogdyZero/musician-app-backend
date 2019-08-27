package br.com.musicianapp.Enum;

public enum Status {
	ATIVO("ativo"),
	INATIVO("inativo");
	
	private String status;

	private Status(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setPerfil(String status) {
		this.status = status;
	};
}
