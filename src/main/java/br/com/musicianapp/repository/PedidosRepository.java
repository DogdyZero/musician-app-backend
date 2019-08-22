package br.com.musicianapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.musicianapp.domain.Pedido;

public interface PedidosRepository extends JpaRepository<Pedido, Integer> {

}
