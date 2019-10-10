package br.com.musicianapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.musicianapp.domain.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {

}
