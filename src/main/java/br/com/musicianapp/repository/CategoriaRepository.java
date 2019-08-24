package br.com.musicianapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.musicianapp.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
