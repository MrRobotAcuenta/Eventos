package application;

import clases.Persona;
import clases.ListaPersonas;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.List;
import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

public class VentanaClientesController {

    @FXML
    private TableView<Persona> tablaCliente;

    @FXML
    private TableColumn rutCL;

    @FXML
    private TableColumn numTicketsCL;

    @FXML
    private TableColumn nacimientoCL;

    @FXML
    private TableColumn nombreCL;

    @FXML
    private TextField nombreTF;

    @FXML
    private TextField rutTF;

    @FXML
    private Button agregarBtn;

    @FXML
    private Button modificarBtn;

    @FXML
    private Button eliminarBtn;

    @FXML
    private Button nuevoBtn;

    @FXML
    private TextField nacimientoTF;
    ObservableList<Persona> lista;
    private int posicion;

    @FXML
    void agregar(ActionEvent event) {
    	Persona nuevo = new Persona();
    	nuevo.setRut(rutTF.getText());
    	nuevo.setFechaNacimiento(nacimientoTF.getText());
    	nuevo.setNombre(nombreTF.getText());
    	lista.add(nuevo);
    	

    }

    @FXML
    void eliminar(ActionEvent event) {
    	lista.remove(posicion);
    }

    @FXML
    void modificar(ActionEvent event) {
    	Persona nuevo = new Persona();
    	nuevo.setRut(rutTF.getText());
    	nuevo.setFechaNacimiento(nacimientoTF.getText());
    	nuevo.setNombre(nombreTF.getText());
    	lista.set(posicion, nuevo);
    }

    @FXML
    void nuevo(ActionEvent event) {
    	rutTF.setText("");
        nacimientoTF.setText("");
        nombreTF.setText("");
        
        modificarBtn.setDisable(true);
        eliminarBtn.setDisable(true);
        agregarBtn.setDisable(false);

    }
    //listener tabla tickets
    private final ListChangeListener<Persona> selectorTabla =
            new ListChangeListener<Persona>() {
                @Override
                public void onChanged(ListChangeListener.Change<? extends Persona> c) {
                    ponerSeleccion();
                }
            };
            /**
             * PARA SELECCIONAR UNA CELDA DE LA TABLA "TicketsVendidos"
             */
            public Persona getTablaTicketSeleccionada() {
                if (tablaCliente != null) {
                    List<Persona> tabla = tablaCliente.getSelectionModel().getSelectedItems();
                    if (tabla.size() == 1) {
                        final Persona seleccion = tabla.get(0);
                        return seleccion;
                    }
                }
                return null;
            }

            
             // Método para poner en los textFields la tupla que selccionemos
            
            private void ponerSeleccion() {
                final Persona per = getTablaTicketSeleccionada();
                posicion = lista.indexOf(per);

                if (per != null) {

                    // Pongo los textFields con los datos correspondientes
                	
                    rutTF.setText(per.getRut());
                	nacimientoTF.setText(per.getFechaNacimiento());
                	nombreTF.setText(per.getNombre());
          

                    // Pongo los botones en su estado correspondiente
                    modificarBtn.setDisable(false);
                    eliminarBtn.setDisable(false);
                    agregarBtn.setDisable(true);

                }
            }
            //metodo para inicializar tabla
            private void inicializarTabla() {
            	rutCL.setCellValueFactory(new PropertyValueFactory<Persona, String>("asiento"));
            	numTicketsCL.setCellValueFactory(new PropertyValueFactory<Persona, Integer>("precio"));
            	nacimientoCL.setCellValueFactory(new PropertyValueFactory<Persona, String>("fecha"));
            	nombreCL.setCellValueFactory(new PropertyValueFactory<Persona, String>("id"));

                lista = FXCollections.observableArrayList();
                tablaCliente.setItems(lista);
            }
          
            public void initialize(URL url, ResourceBundle rb) {

                // Inicializamos la tabla
                this.inicializarTabla();

                // Ponemos estos dos botones para que no se puedan seleccionar
                modificarBtn.setDisable(true);
                eliminarBtn.setDisable(true);

                // Seleccionar las tuplas de la tabla de las personas
                final ObservableList<Persona> tablaSel = tablaCliente.getSelectionModel().getSelectedItems();
                tablaSel.addListener(selectorTabla);

                
            }

}

