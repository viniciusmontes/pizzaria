package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.entities.OrderStatus;

public class PedidoFormController implements Initializable {
	
	@FXML
	private TextField tfNome;
	
	@FXML
	private TextField tfEmail;
	
	@FXML
	private TextField tfPedido;
	
	@FXML
	private ComboBox<OrderStatus> cbStatus;
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
}
