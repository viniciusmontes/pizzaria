package model.entities;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private Long id;
	private Instant moment;

	private OrderStatus status;

	private Cliente cliente;

	private List<ItemDoPedido> itens = new ArrayList<>();

	public Pedido() {

	}

	public Pedido(Long id, Instant moment, OrderStatus status, Cliente cliente) {
		this.id = id;
		this.moment = moment;
		this.status = status;
		this.cliente = cliente;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void addItemDoPedido(ItemDoPedido item) {
		itens.add(item);
	}

	public void removeItemDoPedido(ItemDoPedido item) {
		itens.remove(item);
	}

	public double total() {
		double soma = 0.0;
		for (ItemDoPedido it : itens) {
			soma += it.subTotal();
		}
		return soma;
	}

	@Override
	public String toString() {
		Date date = Date.from(moment);
		StringBuilder sb = new StringBuilder();
		sb.append("Momento do pedido: ");
		sb.append(sdf.format(date) + "\n");
		sb.append("Status do Pedido: ");
		sb.append(status + "\n");
		sb.append("Cliente: ");
		sb.append(cliente + "\n");
		sb.append("Order items:\n");
		for (ItemDoPedido item : itens) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}

}
