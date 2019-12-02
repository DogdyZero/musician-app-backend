package br.com.musicianapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.musicianapp.domain.Frete;

public interface FreteRepository extends JpaRepository<Frete, Integer> {

}
