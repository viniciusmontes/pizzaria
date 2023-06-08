package db;

import model.dao.PedidoDao;
import model.dao.impl.PedidoDaoJDBC;

public class DaoFactory {

	public static PedidoDao createPedidoDao() {
		return new PedidoDaoJDBC(DB.getConnection());
	}

}
