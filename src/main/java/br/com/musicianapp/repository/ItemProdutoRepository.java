package br.com.musicianapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.musicianapp.domain.ItemProduto;

public interface ItemProdutoRepository extends JpaRepository<ItemProduto, Integer> {

}
