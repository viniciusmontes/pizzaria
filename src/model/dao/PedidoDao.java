package model.dao;

import java.util.List;

import model.entities.Pedido;

public interface PedidoDao {

	void insert(Pedido pedido);

	void remove(Pedido pedido);

	List<PedidoDao> findAll();

}
