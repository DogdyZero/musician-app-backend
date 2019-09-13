package br.com.musicianapp.Enum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

public enum Perfil {
	CLIENTE ("CLIENTE"),
	ADMINISTRADOR("ADMINISTRADOR");
	
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
	
	@Converter(autoApply = true)
    public static class Mapeador implements AttributeConverter<Perfil, String> {

        @Override
        public String convertToDatabaseColumn(Perfil x) {
            return String.valueOf(x.getPerfil());
        }

        @Override
        public Perfil convertToEntityAttribute(String y) {
            if (y == null) return null;
            if ("0".equals(y)) return CLIENTE;
            if ("1".equals(y)) return ADMINISTRADOR;
            throw new IllegalStateException("Valor inválido: " + y);
        }
    }
	
	

}
