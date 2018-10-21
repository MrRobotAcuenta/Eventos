package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ListaPersonas {
	private ArrayList<Persona> listaPersonas;
	
	public ListaPersonas(){
		listaPersonas = new ArrayList<Persona>();
	}
	
	
	public Persona eliminarPersona(String rutPersona) {
		Persona aux_persona;
		for(int i=0;i<listaPersonas.size();i++) {
			aux_persona=new Persona();
			aux_persona=listaPersonas.get(i);
			if(aux_persona.getRut().equals(rutPersona)) {
				return listaPersonas.remove(i);
			}
		}
		return null;
		
	}
	
	public Persona buscarPersona(String rutPersona) {
		Persona aux_persona;
		for(int i=0;i<listaPersonas.size();i++) {
			aux_persona=new Persona();
			aux_persona=listaPersonas.get(i);
			if(aux_persona.getRut().equals(rutPersona)) {
				return listaPersonas.get(i);
			}
		}
		return null;
	}
	
	public boolean nuevaPersona(Persona p) {
		Persona aux_persona;
		for(int i=0;i<listaPersonas.size();i++) {
			aux_persona = new Persona();
			aux_persona=listaPersonas.get(i);
			if(aux_persona.getRut().equals(p.getRut())) {
				return false;
			}
		}
		//nuevaPersona.setFechaNacimiento(fechaNacimiento);
		listaPersonas.add(p);
		return true;
	}
	
	public boolean modificarNombrePersona(String rutPersona, String input) {
		Persona aux_persona;
		for(int i=0;i<listaPersonas.size();i++) {
			aux_persona=new Persona();
			aux_persona=listaPersonas.get(i);
			if(aux_persona.getRut().equals(rutPersona)) {
				aux_persona.setNombre(input);
				return true;
			}
		}
		return false;
	}
	
	
	/*
	 				Metodos para manipular datos de la lista tickets
	 */
	
	
	public boolean existeTicket(String rutPersona, int id) {
		Persona aux_persona;
		for(int i=0;i<listaPersonas.size();i++) {
			aux_persona=new Persona();
			aux_persona=listaPersonas.get(i);
			if(aux_persona.getRut().equals(rutPersona)) {
				return aux_persona.existeTicket(id);
			}
		}
		return false;
	}
	
	public boolean compraTicket(Ticket input) {
		Persona aux_persona;
		for(int i=0;i<listaPersonas.size();i++) {
			aux_persona=new Persona();
			aux_persona=listaPersonas.get(i);
			if(aux_persona.getRut().equals(input.getRut())) {
				return aux_persona.compraTicket(input);
			}
		}
		
		return false;
	}
	
	public Ticket eliminarTicket(String rutPersona, int id) {
		Persona aux_persona;
		for(int i=0;i<listaPersonas.size();i++) {
			aux_persona=new Persona();
			aux_persona=listaPersonas.get(i);
			if(aux_persona.getRut().equals(rutPersona)) {
				return aux_persona.eliminarTicket(id);
			}
		}
		return null;
	}
	
	public boolean modificarPrecio(String rutPersona, int id, int precio) {
		Persona aux_persona;
		for(int i=0;i<listaPersonas.size();i++) {
			aux_persona=new Persona();
			aux_persona=listaPersonas.get(i);
			if(aux_persona.getRut().equals(rutPersona)) {
				return aux_persona.modificarPrecio(id, precio);
			}
		}
		return false;
	}
	
	
	/*
	 				Fin metodos lista Tickets
	 */
	
	
	public void readPersonasEvento(Connectar conexion, String nameEvento) {
		ResultSet resultado;
		Persona aux;
		resultado=conexion.getQuery("select DISTINCT rut, fechaNacimiento, nombre from personas inner join tickets using (rut) inner join eventos using (nameEvento) where nameEvento='"+nameEvento+"'");
		
		try {
			while(resultado.next()) {
				aux=new Persona();
				aux.setRut(resultado.getString(1));
				//aux.setFechaNacimiento(resultado.getString(2));
				aux.setNombre(resultado.getString(3));
				
				aux.readTicketVendidoPersona(conexion, nameEvento);
				listaPersonas.add(aux);
				System.out.println(listaPersonas.get(listaPersonas.size()-1).getNombre());
			}
		}
		catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
