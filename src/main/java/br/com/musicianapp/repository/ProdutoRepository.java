package br.com.musicianapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.musicianapp.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
