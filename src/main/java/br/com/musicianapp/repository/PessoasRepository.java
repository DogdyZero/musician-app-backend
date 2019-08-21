package br.com.musicianapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.musicianapp.domain.Pessoa;

public interface PessoasRepository extends JpaRepository<Pessoa, Integer>{
	public Pessoa findByNome(String nome);
}
