package br.com.musicianapp.Enum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

public enum Status {
	ATIVO("Ativo"),
	INATIVO("Inativo");
	
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
	
	@Converter(autoApply = true)
    public static class Mapeador implements AttributeConverter<Status, String> {

        @Override
        public String convertToDatabaseColumn(Status x) {
            return String.valueOf(x.getStatus());
        }

        @Override
        public Status convertToEntityAttribute(String y) {
            if (y == null) return null;
            if ("0".equals(y)) return ATIVO;
            if ("1".equals(y)) return INATIVO;
            throw new IllegalStateException("Valor inválido: " + y);
        }
    }
}
