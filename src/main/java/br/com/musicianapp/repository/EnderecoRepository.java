package br.com.musicianapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.musicianapp.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
