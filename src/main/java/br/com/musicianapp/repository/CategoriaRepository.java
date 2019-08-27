package br.com.musicianapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.musicianapp.domain.CategoriaInstrumento;

public interface CategoriaRepository extends JpaRepository<CategoriaInstrumento, Integer>{

}
