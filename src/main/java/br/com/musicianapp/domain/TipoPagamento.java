package br.com.musicianapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@Entity
@Component
@SequenceGenerator(name="tipo_pagamento_generator", sequenceName = "tipo_pagamento_pagamento_seq", allocationSize=50,initialValue=1)
@Inheritance(strategy=InheritanceType.JOINED)
@JsonTypeInfo(
		  use = JsonTypeInfo.Id.NAME, 
		  include = JsonTypeInfo.As.PROPERTY, 
		  property = "type")
		@JsonSubTypes({ 
		  @Type(value = Cartao.class, name = "cartao"), 
		  @Type(value = Cupom.class, name = "cupom") 
		})

public abstract class  TipoPagamento extends EntidadeDominio {
	@Id
	@Column(name="tpp_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_pagamento_generator")
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
