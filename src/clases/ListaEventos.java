package clases;

import java.util.*;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListaEventos {
	private ArrayList<Evento> eventos;
		
		//inicializa una nueva lista de Evento
		public ListaEventos() {
			eventos=new ArrayList <Evento> ();
		}
		
		public boolean existeEvento(String name) {
			Evento aux_evento;
			for(int i=0; i<eventos.size(); i++){
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre()==name){
					return true;
				}
			}
			
			return false;
		}

		//ingresa un Evento a la lista de Evento
		public boolean agregarEvento(Evento input) {
			Evento aux_evento;
			for(int i=0; i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(input.getNombre())) {
					return false;
				}
			}
			eventos.add(input);
			return true;
		}
		
		//eliminar un Evento de la lista de Eventos
		public Evento removeEvento(String name) {
			Evento aux_evento;
			for(int i=0;i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(name)) {
					return eventos.remove(i);
				}
			}
			return null;
		}
		
		public void modificarTipoEvento(String name, String input) {
			Evento aux_evento;
			for(int i=0;i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(name)) {
					aux_evento.setTipo(input);
				}
			}
		}
		
		public void modificarRestriccion(String name, boolean input) {
			Evento aux_evento;
			for(int i=0;i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(name)) {
					aux_evento.setRestriccion(input);
				}
			}
		}
		
		public void modificarLugarEvento(String name, String input) {
			Evento aux_evento;
			for(int i=0;i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(name)) {
					aux_evento.setLugar(input);
				}
			}
		}
		
		
		/*
					Metodos para manipular los datos de la lista de Personas
		 */
		
		
		public boolean eventoNuevaPersona(String name, Persona p) {
			Evento aux_evento;
			for(int i=0;i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(name)) {
					return aux_evento.nuevaPersona(p);	//si se encontró el evento, se ingresa a su propio metodo
				}
			}
			return false;	//si no lo encontró, retorna false
			
		}
		
		public Persona eventoEliminarPersona(String name, String rutPersona) {
			Evento aux_evento;
			for(int i=0;i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(name)) {
					return aux_evento.eliminarPersona(rutPersona);	//si se encontró el evento, se ingresa a su propio metodo
				}
			}
			return null;	//si no lo encontró, retorna null
		}
		
		public Persona eventoBuscarPersona(String name, String rutPersona){
			Evento aux_evento;
			for(int i=0;i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(name)) {
					return aux_evento.buscarPersona(rutPersona);	//si se encontró el evento, se ingresa a su propio metodo
				}
			}
			return null;	//si no lo encontró, retorna null
		}
		
		public boolean modificarNombrePersona(String name, String rutPersona, String input) {
			Evento aux_evento;
			for(int i=0;i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(name)) {
					return aux_evento.modificarNombrePersona(rutPersona, input);	//si se encontró el evento, se ingresa a su propio metodo
				}
			}
			return false;	//si no lo encontró, retorna false
			
		}
		
		public boolean PersonaExisteTicket(String name, String rutPersona, int id) {
			Evento aux_evento;
			for(int i=0;i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(name)) {
					return aux_evento.existeTicket(rutPersona, id);		//si se encontró el evento, se ingresa a su propio metodo
				}
			}
			return false;	//si no lo encontró, retorna false
		}
		
		public boolean PersonaCompraTicket(String name, Ticket input) {
			Evento aux_evento;
			for(int i=0;i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(name)) {
					return aux_evento.compraTicket(input);		//si se encontró el evento, se ingresa a su propio metodo
				}
			}
			return false;	//si no lo encontró, retorna false
		}
		
		public Ticket PersonaEliminarTicket(String name, String rutPersona, int id) {
			Evento aux_evento;
			for(int i=0;i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(name)) {
					return aux_evento.eliminarTicket(rutPersona, id);		//si se encontró el evento, se ingresa a su propio metodo
				}
			}
			return null;	//si no lo encontró, retorna null
		}
		
		public boolean PersonaModificarPrecioTicket(String name, String rutPersona, int id, int precio) {
			Evento aux_evento;
			for(int i=0;i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(name)) {
					return aux_evento.modificarPrecio(rutPersona, id, precio);		//si se encontró el evento, se ingresa a su propio metodo
				}
			}
			return false;	//si no lo encontró, retorna false
		}
		
		/*
		 			Fin metodos lista Personas
		 */

		
		
		
		
		
		
		
		/*
		 			Metodos para manipular datos del Recinto
		 */
		
		
		public boolean eventoAgregarCupo(String name, Cupo input) {
			Evento aux_evento;
			for(int i=0;i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(name)) {
					return aux_evento.agregarCupo(input);		//si se encontró el evento, se ingresa a su propio metodo
				}
			}
			return false;	//si no lo encontró, retorna false
		}
		
		public Cupo eventoEliminarCupo(String name, String asiento) {
			Evento aux_evento;
			for(int i=0;i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(name)) {
					return aux_evento.eliminarCupo(asiento);		//si se encontró el evento, se ingresa a su propio metodo
				}
			}
			return null;	//si no lo encontró, retorna false
		}
		
		public boolean eventoExisteCupo(String name, String asiento) {
			Evento aux_evento;
			for(int i=0;i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(name)) {
					return aux_evento.existeCupo(asiento);		//si se encontró el evento, se ingresa a su propio metodo
				}
			}
			return false;	//si no lo encontró, retorna false
		}
		
		public boolean eventoModificarDisponible(String name, String asiento, boolean nuevo) {
			Evento aux_evento;
			for(int i=0;i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(name)) {
					return aux_evento.modificarDisponible(asiento, nuevo);		//si se encontró el evento, se ingresa a su propio metodo
				}
			}
			return false;	//si no lo encontró, retorna false
		}
		
		
		/*
		 			Fin metodos del Recinto
		 */
		
		
		
		public int mostrarLista()throws IOException {
			BufferedReader lector= new BufferedReader( new InputStreamReader(System.in));
			System.out.println("Elija uno de los siguientes eventos para trabajar en el:\t\n");
			int cant=eventos.size();
			Evento aux;
			if(cant>0) {
				int i=1;
				for(int k=0; k<cant; k++) {
					aux=(Evento)eventos.get(k);
					System.out.println(i+") "+ aux.getNombre());
					i++;
				}
				int respuesta = Integer.parseInt(lector.readLine());
				respuesta-- ;
				return respuesta;
			}else {
				System.out.println("No se ha encontrado un evento previo pasaremos a agregar un evento nuevo.");
				return 0;
			}
		}
		
		public void readListaEventos(Connectar conexion) {
			ResultSet resultado;
			Evento aux;
			resultado=conexion.getQuery("select * from eventos");
			
			try {
				while(resultado.next()) {
					aux=new Evento();
					aux.setNombre(resultado.getString(1));
					aux.setTipo(resultado.getString(2));
					aux.setRestriccion(resultado.getBoolean(3));
					aux.setLugar(resultado.getString(4));
					//aux.setFecha(resultado.getString(5));
					
					aux.readPersonasEvento(conexion);
					aux.readResintoEvento(conexion);
					eventos.add(aux);
					System.out.println(eventos.get(eventos.size()-1).getNombre());
				}
			}
			catch(SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
