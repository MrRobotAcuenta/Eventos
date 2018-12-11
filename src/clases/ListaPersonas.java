package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ListaPersonas implements Estadistica {
	private ArrayList<Persona> listaPersonas;
	
	public ListaPersonas(){
		listaPersonas = new ArrayList<Persona>();
	}
	
	
	public Persona eliminarPersona(String rutPersona) {
		Connectar conexion=BDsingleton.getConnexion();
		Persona asistente;
		for(int i=0;i<listaPersonas.size();i++) {
			asistente=new Persona();
			asistente=listaPersonas.get(i);
			if(asistente.getRut().equals(rutPersona)) {
				conexion.setQuery("DELETE FROM `personas` WHERE rut='" + rutPersona + "'");
				return listaPersonas.remove(i);
			}
		}
		return null;
		
	}
	
	public Persona buscarPersona(String rutPersona) {
		Persona asistente;
		for(int i=0;i<listaPersonas.size();i++) {
			asistente=new Persona();
			asistente=listaPersonas.get(i);
			if(asistente.getRut().equals(rutPersona)) {
				return listaPersonas.get(i);
			}
		}
		return null;
	}
	
	public boolean nuevaPersona(Persona p) {
		Connectar conexion=BDsingleton.getConnexion();
		Persona asistente;
		for(int i=0;i<listaPersonas.size();i++) {
			asistente = new Persona();
			asistente=listaPersonas.get(i);
			if(asistente.getRut().equals(p.getRut())) {
				return false;
			}
		}
		//nuevaPersona.setFechaNacimiento(fechaNacimiento);
		listaPersonas.add(p);
		conexion.setQuery("INSERT INTO `personas` (`rut`, `fechaNacimiento`, `nombre`) VALUES ('" + p.getRut() + "', '" + p.getFechaNacimiento() + "', '" + p.getNombre() + "')");
		return true;
	}
	
	public boolean modificarNombrePersona(String rutPersona, String input) {
		Connectar conexion=BDsingleton.getConnexion();
		Persona asistente;
		for(int i=0;i<listaPersonas.size();i++) {
			asistente=new Persona();
			asistente=listaPersonas.get(i);
			if(asistente.getRut().equals(rutPersona)) {
				asistente.setNombre(input);
				conexion.setQuery("UPDATE `personas` SET nombre='" + input + "' WHERE rut='" + rutPersona + "'");
				return true;
			}
		}
		return false;
	}
	
	public boolean modificarFechaNacimiento(String rutPersona, String fechaNueva) {
		Connectar conexion=BDsingleton.getConnexion();
		Persona asistente;
		for(int i=0;i<listaPersonas.size();i++) {
			asistente=new Persona();
			asistente=listaPersonas.get(i);
			if(asistente.getRut().equals(rutPersona)) {
				asistente.setFechaNacimiento(fechaNueva);
				conexion.setQuery("UPDATE `personas` SET fechaNacimiento='" + fechaNueva + "' WHERE rut='" + rutPersona + "'");
				return true;
			}
		}
		return false;
	}
	
	public boolean mayoriaEdad(String rutPersona) {
		Persona asistente;
		for(int i=0;i<listaPersonas.size();i++) {
			asistente=new Persona();
			asistente=listaPersonas.get(i);
			if(asistente.getRut().equals(rutPersona)) {
				return asistente.mayoriaEdad();
			}
		}
		return false;
	}
	
	
	/*
	 				Metodos para manipular datos de la lista tickets
	 */
	
	
	public boolean existeTicket(String rutPersona, String id) {
		Persona asistente;
		for(int i=0;i<listaPersonas.size();i++) {
			asistente=new Persona();
			asistente=listaPersonas.get(i);
			if(asistente.getRut().equals(rutPersona)) {
				return asistente.existeTicket(id);
			}
		}
		return false;
	}
	
	public boolean compraTicket(TicketCliente input) {
		Persona asistente;
		for(int i=0;i<listaPersonas.size();i++) {
			asistente=new Persona();
			asistente=listaPersonas.get(i);
			if(asistente.getRut().equals(input.getRut())) {
				return asistente.compraTicket(input);
			}
		}
		
		return false;
	}
	
	public Ticket eliminarTicket(String rutPersona, String id) {
		Persona asistente;
		for(int i=0;i<listaPersonas.size();i++) {
			asistente=new Persona();
			asistente=listaPersonas.get(i);
			if(asistente.getRut().equals(rutPersona)) {
				return asistente.eliminarTicket(id);
			}
		}
		return null;
	}
	
	public boolean modificarPrecio(String rutPersona, String id, int precio) {
		Persona asistente;
		for(int i=0;i<listaPersonas.size();i++) {
			asistente=new Persona();
			asistente=listaPersonas.get(i);
			if(asistente.getRut().equals(rutPersona)) {
				return asistente.modificarPrecio(id, precio);
			}
		}
		return false;
	}
	
	public boolean modificarFechaEvento(String rutPersona, String id, String fechaNueva) {
		Persona asistente;
		for(int i=0;i<listaPersonas.size();i++) {
			asistente=new Persona();
			asistente=listaPersonas.get(i);
			if(asistente.getRut().equals(rutPersona)) {
				return asistente.modificarFechaTicket(id, fechaNueva);
			}
		}
		return false;
	}
	
	public void modificarFechaEvento(String fechaNueva) {
		Persona asistente;
		for(int i=0;i<listaPersonas.size();i++) {
			asistente=new Persona();
			asistente=listaPersonas.get(i);
			asistente.modificarFechaTicket(fechaNueva);
		}
	}
	
	
	
	/*
	 				Fin metodos lista Tickets
	 */
	
	
	public void readPersonasEvento(String nameEvento) {
		Connectar conexion=BDsingleton.getConnexion();
		ResultSet resultado;
		Persona aux;
		resultado=conexion.getQuery("select DISTINCT rut, fechaNacimiento, nombre from personas inner join tickets using (rut) inner join eventos using (nameEvento) where nameEvento='"+nameEvento+"'");
		
		try {
			while(resultado.next()) {
				aux=new Persona();
				aux.setRut(resultado.getString(1));
				aux.setFechaNacimiento(resultado.getString(2));
				aux.setNombre(resultado.getString(3));
				
				aux.readTicketVendidoPersona(nameEvento);
				listaPersonas.add(aux);
				System.out.println(listaPersonas.get(listaPersonas.size()-1).getNombre());
			}
		}
		catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
	public int porcentaje() {
		//cuenta cuantos clientes tienen más de 2 entradas
		int aux;
		aux=0;
		for(int i=0;i<cantidad();i++) {
			if(listaPersonas.get(i).cantidadTickets()>=2) {
				aux++;
			}
		}
		return (aux*cantidad())/100;
		}
	


	
	public int cantidad() {
		int cantidad;
		cantidad=listaPersonas.size();
		
		return cantidad;
	}
	
	
}