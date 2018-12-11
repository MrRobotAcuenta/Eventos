package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class VentanaPrincipalController {

    @FXML
    private Button btnClientes;
    @FXML
    private Button btnEventos;
    @FXML
    private Button btnTickets;
    private int posicionTabla;

    @FXML
    void botonIrCliente(ActionEvent event) throws IOException {
    	
    	Parent parent = FXMLLoader.load(getClass().getResource("/application/VentanaCliente.fxml"));
    	Stage stage = new Stage();
    	Scene scene = new Scene(parent);
    	stage.setScene(scene);
    	stage.show();

    }

    @FXML
    void botonIrEvento(ActionEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/application/VentanaEventos.fxml"));
    	Stage stage = new Stage();
    	Scene scene = new Scene(parent);
    	stage.setScene(scene);
    	stage.show();

    }

    @FXML
    void botonIrTicket(ActionEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/application/VentanaTickets.fxml"));
    	Stage stage = new Stage();
    	Scene scene = new Scene(parent);
    	stage.setScene(scene);
    	stage.show();
    }

}
