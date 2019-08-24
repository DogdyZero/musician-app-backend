package br.com.musicianapp.Enum;

public enum Perfil {
	CLIENTE("Cliente"),
	ADMINISTRADOR("Administrador");
	
	private String perfil;

	private Perfil(String perfil) {
		this.perfil = perfil;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	};
	
	

}
