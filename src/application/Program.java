package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import db.DB;
import model.dao.impl.PedidoDaoJDBC;
import model.entities.Cliente;
import model.entities.ItemDoPedido;
import model.entities.OrderStatus;
import model.entities.Pedido;
import model.entities.Produto;

public class Program {

	public static void main(String[] args) throws SQLException {

		Connection coon;

		Connection conn = DB.getConnection();

		PedidoDaoJDBC dao = new PedidoDaoJDBC(conn);

		Statement st = conn.createStatement();

		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		System.out.println("Entre com os dados do cliente : ");
		System.out.println("Insira o código : ");
		long id_cliente = sc.nextLong();
		System.out.println("Insira o nome: ");
		String nome = sc.next();
		System.out.println("Insira o email: ");
		String email = sc.next();

		Cliente cliente = new Cliente(id_cliente, nome, email);

		System.out.println("Entre com os dados do Pedido: ");
		System.out.println("Insira o código do Pedido: ");
		long id_pedido = sc.nextLong();
		System.out.println("Status do Pedido: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());

		Pedido pedido = new Pedido(id_pedido, Instant.now(), status, cliente);

		System.out.println("Quantos itens vai ter o pedido: ");

		int N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			System.out.println("Entre com os dados dos produtos: ");
			System.out.println("Nome do Produto: ");
			sc.nextLine();
			String nomes = sc.nextLine();
			System.out.println("Valor do produto: ");
			double preco = sc.nextDouble();
			System.out.println("Quantidade do produto: ");
			int quantidade = sc.nextInt();

			Produto produto = new Produto(nomes, preco);

			ItemDoPedido items = new ItemDoPedido(quantidade, preco, produto);

			pedido.addItemDoPedido(items);

		}

		dao.insert(pedido);
		System.out.println();
		System.out.println(pedido);

		sc.close();
	}
}