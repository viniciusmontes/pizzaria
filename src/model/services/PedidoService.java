package model.services;

import db.DaoFactory;
import model.dao.PedidoDao;
import model.entities.Pedido;

public class PedidoService {

	private PedidoDao dao = DaoFactory.createPedidoDao();

	public void insert(Pedido obj) {
		if (obj.getId() == null) {
			dao.insert(obj);
		} else {
			System.out.println("erro");
		}
	}

	

}
