package br.com.musicianapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.musicianapp.domain.CarrinhoCompra;

public interface CarrinhoCompraRepository extends JpaRepository<CarrinhoCompra, Integer> {

}
