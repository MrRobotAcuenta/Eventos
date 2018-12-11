package clases;


import java.util.*;
import java.io.*;
import java.sql.*;

public class ListaEventos implements Estadistica {
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
			//agregarEventoBD(input);
			return true;
		}
		
		//eliminar un Evento de la lista de Eventos
		public Evento removeEvento(String name) {
			Evento aux_evento;
			for(int i=0;i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(name)) {
					removeEventoBD(name);
					return eventos.remove(i);
				}
			}
			return null;
		}
		
		public void modificarTipoEvento(String name, String input) {
			Connectar conexion=new Connectar();
			Evento aux_evento;
			for(int i=0;i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(name)) {
					aux_evento.setTipo(input);
					conexion.setQuery("UPDATE `eventos` SET tipo='" + input + "' WHERE nameEvento='" + name + "'");
				}
			}
		}
		
		public void modificarRestriccion(String name, boolean input) {
			Connectar conexion=BDsingleton.getConnexion();
			Evento aux_evento;
			for(int i=0;i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(name)) {
					aux_evento.setRestriccion(input);
					int restriccion=0;			// Esto se utiliza para facilitar el traspaso del boolean a la BD
					if(input) {
						restriccion=1;
					}
					else {
						restriccion=0;
					}
					conexion.setQuery("UPDATE `eventos` SET restriccion='" + restriccion + "' WHERE nameEvento='" + name + "'");
				}
			}
		}
		
		public void modificarLugarEvento(String name, String input) {
			Connectar conexion=BDsingleton.getConnexion();
			Evento aux_evento;
			for(int i=0;i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(name)) {
					aux_evento.setLugar(input);
					conexion.setQuery("UPDATE `eventos` SET lugar='" + input + "' WHERE nameEvento='" + name + "'");
				}
			}
		}
		
		public boolean modificarFechaEvento(String name, String fechaNueva) {
			Connectar conexion=BDsingleton.getConnexion();
			Evento aux_evento;
			for(int i=0;i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(name)) {
					aux_evento.setFecha(fechaNueva);
					aux_evento.personaModificarFechaEvento(fechaNueva);
					conexion.setQuery("UPDATE `eventos` SET fecha='" + fechaNueva + "' WHERE nameEvento='" + name + "'");
					return true;
				}
			}
			return false;
		}
		
		
		/*
					Metodos para manipular los datos de la lista de Personas
		 */
		
		
		public boolean personaNuevaPersona(String name, Persona p) {
			Evento aux_evento;
			for(int i=0;i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(name)) {
					return aux_evento.personaNuevaPersona(p);	//si se encontró el evento, se ingresa a su propio metodo
				}
			}
			return false;	//si no lo encontró, retorna false
			
		}
		
		public Persona personaEliminarPersona(String name, String rutPersona) {
			Evento aux_evento;
			for(int i=0;i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(name)) {
					return aux_evento.personaEliminarPersona(rutPersona);	//si se encontró el evento, se ingresa a su propio metodo
				}
			}
			return null;	//si no lo encontró, retorna null
		}
		
		public Persona personaBuscarPersona(String name, String rutPersona){
			Evento aux_evento;
			for(int i=0;i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(name)) {
					return aux_evento.personaBuscarPersona(rutPersona);		//si se encontró el evento, se ingresa a su propio metodo
				}
			}
			return null;	//si no lo encontró, retorna null
		}
		
		public boolean personaModificarNombre(String name, String rutPersona, String nombrePersona) {
			Evento aux_evento;
			for(int i=0;i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(name)) {
					return aux_evento.personaModificarNombre(rutPersona, nombrePersona);	//si se encontró el evento, se ingresa a su propio metodo
				}
			}
			return false;	//si no lo encontró, retorna false
			
		}
		
		public boolean personaModificarFechaNacimiento(String name, String rutPersona, String fechaNueva) {
			Evento aux_evento;
			for(int i=0;i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(name)) {
					return aux_evento.personaModificarFechaNacimiento(rutPersona, fechaNueva);		//si se encontró el evento, se ingresa a su propio metodo
				}
			}
			return false;	//si no lo encontró, retorna false
		}
		
		public boolean personaExisteTicket(String name, String rutPersona, String id) {
			Evento aux_evento;
			for(int i=0;i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(name)) {
					return aux_evento.personaExisteTicket(rutPersona, id);		//si se encontró el evento, se ingresa a su propio metodo
				}
			}
			return false;	//si no lo encontró, retorna false
		}
		
		public boolean personaCompraTicket(String name, TicketCliente input) {
			Evento aux_evento;
			for(int i=0;i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(name)) {
					return aux_evento.personaCompraTicket(input);		//si se encontró el evento, se ingresa a su propio metodo
				}
			}
			return false;	//si no lo encontró, retorna false
		}
		
		public Ticket personaEliminarTicket(String name, String rutPersona, String id) {
			Evento aux_evento;
			for(int i=0;i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(name)) {
					return aux_evento.personaEliminarTicket(rutPersona, id);		//si se encontró el evento, se ingresa a su propio metodo
				}
			}
			return null;	//si no lo encontró, retorna null
		}
		
		public boolean personaModificarPrecioTicket(String name, String rutPersona, String id, int precio) {
			Evento aux_evento;
			for(int i=0;i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(name)) {
					return aux_evento.personaModificarPrecio(rutPersona, id, precio);		//si se encontró el evento, se ingresa a su propio metodo
				}
			}
			return false;	//si no lo encontró, retorna false
		}
		
		public boolean personaModificarFechaEvento(String name, String rutPersona, String id, String fechaNueva) {
			Evento aux_evento;
			for(int i=0;i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(name)) {
					return aux_evento.personaModificarFechaEvento(rutPersona, id, fechaNueva);		//si se encontró el evento, se ingresa a su propio metodo
				}
			}
			return false;	//si no lo encontró, retorna false
		}
		
		
		public boolean personaMayoriaEdad(String name, String rutPersona) {
			Evento aux_evento;
			for(int i=0;i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(name)) {
					return aux_evento.personaMayoriaEdad(rutPersona);		//si se encontró el evento, se ingresa a su propio metodo
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
		
		
		public boolean cupoAgregarCupo(String name, Cupo input) {
			Evento aux_evento;
			for(int i=0;i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(name)) {
					return aux_evento.cupoAgregarCupo(input);		//si se encontró el evento, se ingresa a su propio metodo
				}
			}
			return false;	//si no lo encontró, retorna false
		}
		
		public Cupo cupoEliminarCupo(String name, String asiento) {
			Evento aux_evento;
			for(int i=0;i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(name)) {
					return aux_evento.cupoEliminarCupo(asiento);		//si se encontró el evento, se ingresa a su propio metodo
				}
			}
			return null;	//si no lo encontró, retorna false
		}
		
		public boolean cupoExisteCupo(String name, String asiento) {
			Evento aux_evento;
			for(int i=0;i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(name)) {
					return aux_evento.cupoExisteCupo(asiento);		//si se encontró el evento, se ingresa a su propio metodo
				}
			}
			return false;	//si no lo encontró, retorna false
		}
		
		public boolean cupoModificarDisponible(String name, String asiento, boolean nuevo) {
			Evento aux_evento;
			for(int i=0;i<eventos.size();i++) {
				aux_evento=new Evento();
				aux_evento=eventos.get(i);
				if(aux_evento.getNombre().equals(name)) {
					return aux_evento.cupoModificarDisponible(asiento, nuevo);		//si se encontró el evento, se ingresa a su propio metodo
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
		
		public void readListaEventos() {
			Connectar conexion=BDsingleton.getConnexion();
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
					aux.setFecha(resultado.getString(5));
					
					aux.readPersonasEvento();
					aux.readResintoEvento();
					eventos.add(aux);
				}
			}
			catch(SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void agregarEventoBD(Evento input) {
			Connectar conexion=BDsingleton.getConnexion();
			int restriccion=0;			// Esto se utiliza para facilitar el traspaso del boolean a la BD
			if(input.isRestriccion()) {
				restriccion=1;
			}
			else {
				restriccion=0;
			}
			conexion.setQuery("INSERT INTO `eventos` (`nameEvento`, `tipo`, `restriccion`, `lugar`, `fecha`) VALUES ('" + input.getNombre() + "', '" + input.getTipo() + "', '" + restriccion + "', '" + input.getLugar() + "', '" + input.getFecha() + "')");
		}
		
		public void removeEventoBD(String name) {
			Connectar conexion=BDsingleton.getConnexion();
			conexion.setQuery("DELETE FROM `eventos` WHERE nameEvento='" + name + "'");
		}

		@Override
		public int porcentaje() {
			int aux;
			
			return (precio*10)/100;
			
		}

		@Override
		public int cantidad() {
			int cantidad;
			cantidad=eventos.size();
			
			return cantidad;
		}
}