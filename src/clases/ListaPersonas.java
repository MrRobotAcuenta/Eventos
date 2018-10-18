package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ListaPersonas {
	private ArrayList<Persona> listaPersonas;
	
	public ListaPersonas(){
		listaPersonas = new ArrayList<Persona>();
	}
	public void addPersona (Object input) {
		listaPersonas.add((Persona)input);
	}
	
	public Persona eliminarPersona(String rutPersona) {
				
		for(int i=0;i<listaPersonas.size();i++) {
			if(listaPersonas.get(i).getRut().equals(rutPersona)) 
			{
				Persona eliminada = buscarPersona(rutPersona);
				listaPersonas.remove(i);
				return eliminada;
			}
		}
		return null;
		
	}
	
	public Persona buscarPersona(String rutPersona) {
		for(int i=0;i<listaPersonas.size();i++) {
			if(listaPersonas.get(i).getRut().equals(rutPersona)) {
				return listaPersonas.get(i);
			}
		}
		return null;
	}
	
	public boolean nuevaPersona(String rut, String nombre, String fechaNacimiento) {
		Persona nuevaPersona = new Persona();
		if (buscarPersona(rut)!= null) {
			return false;
		}
		nuevaPersona.setRut(rut);
		nuevaPersona.setNombre(nombre);
		//nuevaPersona.setFechaNacimiento(fechaNacimiento);
		
		listaPersonas.add(nuevaPersona);
		return true;
	}
	
	
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
				System.out.println(aux.getNombre());
				listaPersonas.add(aux);
			}
		}
		catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
