package application;

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
import clases.TicketsVendidos;

import java.util.List;
import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import clases.TicketCliente;

public class VentanaTicketsController {
	@FXML
    private TableView<TicketCliente> tablaTickets;
	 @FXML
	    private TableColumn asientoCl;

	    @FXML
	    private TableColumn precioCL;

	    @FXML
	    private TableColumn fechaCl;

	    @FXML
	    private TableColumn idCL;

	    @FXML
	    private TableColumn eventoCL;

	    @FXML
	    private TableColumn rutCL;


    @FXML
    private TextField asientoTF;

    @FXML
    private TextField precioTF;

    @FXML
    private Button agregarBtn;

    @FXML
    private Button modificarBtn;

    @FXML
    private Button eliminarBtn;

    @FXML
    private Button NuevoBtn;

    @FXML
    private TextField idTicketTF;

    @FXML
    private TextField nameEventoTF;

    @FXML
    private TextField rutTF;

    @FXML
    private TextField fechaEventoTF;
    ObservableList<TicketCliente> lista;
    private int posicion;

    @FXML
    void agregar(ActionEvent event) {
    	TicketCliente nuevo = new TicketCliente();
    	nuevo.setAsiento(asientoTF.getText());
    	nuevo.setPrecio(Integer.parseInt(precioTF.getText()));
    	nuevo.setFechaEvento(fechaEventoTF.getText());
    	nuevo.setIdTicket();
    	nuevo.setNameEvento(nameEventoTF.getText());
    	nuevo.setRut(rutTF.getText());
    	lista.add(nuevo);
    	

    }

    @FXML
    void eliminar(ActionEvent event) {
    	lista.remove(posicion);
    }

    @FXML
    void modificar(ActionEvent event) {
    	TicketCliente nuevo = new TicketCliente();
    	nuevo.setAsiento(asientoTF.getText());
    	nuevo.setPrecio(Integer.parseInt(precioTF.getText()));
    	nuevo.setFechaEvento(fechaEventoTF.getText());
    	nuevo.setIdTicket();
    	nuevo.setNameEvento(nameEventoTF.getText());
    	nuevo.setRut(rutTF.getText());
    	lista.set(posicion, nuevo);
    }

    @FXML
    void nuevo(ActionEvent event) {
    	asientoTF.setText("");
        precioTF.setText("");
        nameEventoTF.setText("");
        rutTF.setText("");
        modificarBtn.setDisable(true);
        eliminarBtn.setDisable(true);
        agregarBtn.setDisable(false);

    }
    //listener tabla tickets
    private final ListChangeListener<TicketCliente> selectorTabla =
            new ListChangeListener<TicketCliente>() {
                @Override
                public void onChanged(ListChangeListener.Change<? extends TicketCliente> c) {
                    ponerSeleccion();
                }
            };
            /**
             * PARA SELECCIONAR UNA CELDA DE LA TABLA "TicketsVendidos"
             */
            public TicketCliente getTablaTicketSeleccionada() {
                if (tablaTickets != null) {
                    List<TicketCliente> tabla = tablaTickets.getSelectionModel().getSelectedItems();
                    if (tabla.size() == 1) {
                        final TicketCliente seleccion = tabla.get(0);
                        return seleccion;
                    }
                }
                return null;
            }

            
             // Método para poner en los textFields la tupla que selccionemos
            
            private void ponerSeleccion() {
                final TicketCliente ticket = getTablaTicketSeleccionada();
                posicion = lista.indexOf(ticket);

                if (ticket != null) {

                    // Pongo los textFields con los datos correspondientes
                	String cadena;
                    asientoTF.setText(ticket.getAsiento());
                	precioTF.setText(cadena = String.valueOf(ticket.getPrecio()));
                	fechaEventoTF.setText(ticket.getFechaEvento());
                	ticket.setIdTicket();
                	nameEventoTF.setText(ticket.getNameEvento());
                	rutTF.setText(ticket.getRut());

                    // Pongo los botones en su estado correspondiente
                    modificarBtn.setDisable(false);
                    eliminarBtn.setDisable(false);
                    agregarBtn.setDisable(true);

                }
            }
            //metodo para inicializar tabla
            private void inicializarTabla() {
            	asientoCl.setCellValueFactory(new PropertyValueFactory<TicketCliente, String>("asiento"));
                precioCL.setCellValueFactory(new PropertyValueFactory<TicketCliente, String>("precio"));
                fechaCl.setCellValueFactory(new PropertyValueFactory<TicketCliente, Integer>("fecha"));
                idCL.setCellValueFactory(new PropertyValueFactory<TicketCliente, String>("id"));
                eventoCL.setCellValueFactory(new PropertyValueFactory<TicketCliente, String>("evento"));
                rutCL.setCellValueFactory(new PropertyValueFactory<TicketCliente, String>("rut"));

                lista = FXCollections.observableArrayList();
                tablaTickets.setItems(lista);
            }
          
            public void initialize(URL url, ResourceBundle rb) {

                // Inicializamos la tabla
                this.inicializarTabla();

                // Ponemos estos dos botones para que no se puedan seleccionar
                modificarBtn.setDisable(true);
                eliminarBtn.setDisable(true);

                // Seleccionar las tuplas de la tabla de las personas
                final ObservableList<TicketCliente> tablaSel = tablaTickets.getSelectionModel().getSelectedItems();
                tablaSel.addListener(selectorTabla);

                
            }
            
}
