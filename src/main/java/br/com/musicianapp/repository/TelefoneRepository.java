package br.com.musicianapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.musicianapp.domain.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Integer> {

}
