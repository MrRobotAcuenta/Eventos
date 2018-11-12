package application;
	
import clases.Connectar;
import clases.ListaEventos;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;




public class Main extends Application {
	
	private static ListaEventos eventos=new ListaEventos();
	
	
	
	@Override
	public void start(Stage primaryStage)throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/application/VentanaPrincipal.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		Connectar conexion=new Connectar();
		eventos.readListaEventos(conexion);
		launch(args);
	}
}
