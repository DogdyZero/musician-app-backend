package br.com.musicianapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.musicianapp.domain.Cartao;

public interface CartoesRepository extends JpaRepository<Cartao, Integer> {

}
