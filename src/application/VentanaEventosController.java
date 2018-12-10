package application;

import clases.Evento;
import clases.ListaEventos;
import clases.TicketCliente;
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

public class VentanaEventosController {

    @FXML
    private TableView<Evento> tablaEvento;

    	@FXML
    	private TableColumn eventoCL;

    	@FXML
    	private TableColumn lugarCL;

    	@FXML
    	private TableColumn fechaCL;

    @FXML
    private TextField eventoTF;

    @FXML
    private TextField tipoTF;

    @FXML
    private TextField lugarTF;

    @FXML
    private Button agregarBtn;

    @FXML
    private Button modificarBtn;

    @FXML
    private Button eliminarBtn;

    @FXML
    private Button nuevoBtn;

    @FXML
    private TextField fechaTF;
    ObservableList<Evento> lista;
    private int posicion;

    @FXML
    void agregar(ActionEvent event) {
    	Evento nuevo = new Evento();
    	nuevo.setLugar(lugarTF.getText());
    	nuevo.setTipo(tipoTF.getText());
    	nuevo.setNombre(eventoTF.getText());
    	
    	lista.add(nuevo);
    	

    }

    @FXML
    void eliminar(ActionEvent event) {
    	lista.remove(posicion);
    }

    @FXML
    void modificar(ActionEvent event) {
    	Evento nuevo = new Evento();
    	nuevo.setLugar(lugarTF.getText());
    	nuevo.setTipo(tipoTF.getText());
    	nuevo.setNombre(eventoTF.getText());
    	lista.set(posicion, nuevo);
    }

    @FXML
    void nuevo(ActionEvent event) {
    	lugarTF.setText("");
        tipoTF.setText("");
        eventoTF.setText("");
        modificarBtn.setDisable(true);
        eliminarBtn.setDisable(true);
        agregarBtn.setDisable(false);

    }
    //listener tabla 
    private final ListChangeListener<Evento> selectorTabla =
            new ListChangeListener<Evento>() {
                @Override
                public void onChanged(ListChangeListener.Change<? extends Evento> c) {
                    ponerSeleccion();
                }
            };
            /**
             * PARA SELECCIONAR UNA CELDA DE LA TABLA 
             */
            public Evento getTablaTicketSeleccionada() {
                if (tablaEvento != null) {
                    List<Evento> tabla = tablaEvento.getSelectionModel().getSelectedItems();
                    if (tabla.size() == 1) {
                        final Evento seleccion = tabla.get(0);
                        return seleccion;
                    }
                }
                return null;
            }

            
             // Método para poner en los textFields la tupla que selccionemos
            
            private void ponerSeleccion() {
                final Evento ev = getTablaTicketSeleccionada();
                posicion = lista.indexOf(ev);

                if (ev != null) {

                    // Pongo los textFields con los datos correspondientes
                	String cadena;
                    lugarTF.setText(ev.getLugar());
                	tipoTF.setText(ev.getTipo());
                	eventoTF.setText(ev.getNombre());
                	
                	

                    // Pongo los botones en su estado correspondiente
                    modificarBtn.setDisable(false);
                    eliminarBtn.setDisable(false);
                    agregarBtn.setDisable(true);

                }
            }
            //metodo para inicializar tabla
            private void inicializarTabla() {
            	eventoCL.setCellValueFactory(new PropertyValueFactory<Evento, String>("evento"));
                lugarCL.setCellValueFactory(new PropertyValueFactory<Evento, String>("lugar"));
                fechaCL.setCellValueFactory(new PropertyValueFactory<Evento, String>("fecha"));
                

                lista = FXCollections.observableArrayList();
                tablaEvento.setItems(lista);
            }
          
            public void initialize(URL url, ResourceBundle rb) {

                // Inicializamos la tabla
                this.inicializarTabla();

                // Ponemos estos dos botones para que no se puedan seleccionar
                modificarBtn.setDisable(true);
                eliminarBtn.setDisable(true);

                // Seleccionar las tuplas de la tabla 
                final ObservableList<Evento> tablaSel = tablaEvento.getSelectionModel().getSelectedItems();
                tablaSel.addListener(selectorTabla);

              
                }
            }

