package br.com.musicianapp.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Troca {
	@Id
	private int id;
	
}
