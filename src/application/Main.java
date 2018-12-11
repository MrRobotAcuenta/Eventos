package application;
	
import clases.Evento;
import clases.ListaEventos;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;




public class Main extends Application {
	
	
	
	
	@Override
	public void start(Stage primaryStage)throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/application/VentanaPrincipal.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
