package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.PedidoDao;
import model.entities.Cliente;
import model.entities.OrderStatus;
import model.entities.Pedido;

public class PedidoDaoJDBC implements PedidoDao {

	private Connection conn;

	public PedidoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Pedido pedido) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO tb_pedido " + "(moment, status, cliente_id) " + "VALUES " + "(?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			Instant instant = Instant.now();
			st.setTimestamp(1, Timestamp.from(instant));
			st.setInt(2, pedido.getStatus().ordinal());
			st.setLong(3, pedido.getCliente().getId());

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					long id = rs.getInt(1);
					pedido.setId(id);
				}
				DB.closeResultSet(rs);
			} else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void remove(Pedido pedido) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PedidoDao> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	private Pedido instantiatePedido(ResultSet rs, Cliente cliente) throws SQLException {
		Pedido obj = new Pedido();
		obj.setId(rs.getLong("id"));
		obj.setMoment(rs.getTimestamp("moment").toInstant());
		obj.setStatus(OrderStatus.values()[rs.getInt("status")]);
		obj.setCliente(cliente);

		return obj;

	}

	private Cliente instantiateCliente(ResultSet rs) throws SQLException {
		Cliente obj = new Cliente();
		obj.setId(rs.getLong("id"));
		obj.setNome(rs.getString("nome"));
		obj.setEmail(rs.getString("email"));

		return obj;
	}

}
