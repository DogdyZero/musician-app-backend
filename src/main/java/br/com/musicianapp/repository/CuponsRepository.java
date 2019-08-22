package br.com.musicianapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.musicianapp.domain.Cupom;

public interface CuponsRepository extends JpaRepository<Cupom, Integer>{

}
