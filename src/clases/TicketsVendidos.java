package clases;

import clases.Connectar;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketsVendidos {
	private ArrayList<TicketCliente> registro;
	
	public TicketsVendidos() {
		registro = new ArrayList<TicketCliente>();
	}
	
	
	public boolean existeTicket(String id) {
		for(int i=0; i< registro.size(); i++) {
			if(registro.get(i).getIdTicket()==id) {
				return true;
			}
		}
		
		return false;
	}
	
	
	public boolean agregarTicket(TicketCliente nuevo) {
		Connectar conexion=BDsingleton.getConnexion();
		TicketCliente entrada;
		for(int i=0; i< registro.size(); i++) {
			entrada=new TicketCliente();
			entrada=registro.get(i);
			if(entrada.getIdTicket()==nuevo.getIdTicket()) {
				return false;
			}
		}
		registro.add(nuevo);
		conexion.setQuery("INSERT INTO `tickets` (`asiento`, `precio`, `fechaEvento`, `idTicket`, `nameEvento`, `rut`) VALUES ('" + nuevo.getAsiento() + "', '" + nuevo.getPrecio() + "', '" + nuevo.getFechaEvento() + "', '" + nuevo.getIdTicket() + "', '" + nuevo.getNameEvento() + "', '" + nuevo.getRut() + "')");
		return true;
				
	}
	
	public TicketCliente eliminarTicket(String id) {
		Connectar conexion=BDsingleton.getConnexion();
		TicketCliente entrada;
		for(int i=0; i<registro.size() ; i++) {
			entrada=new TicketCliente();
			entrada=registro.get(i);
			if(entrada.getIdTicket()==id) {
				conexion.setQuery("DELETE FROM `tickets` WHERE idTicket='" + id + "'");
				return registro.remove(i);
			}
		}
		return null;
	}
	
	
	public boolean modificarPrecio(String id, int precio) {
		Connectar conexion=BDsingleton.getConnexion();
		TicketCliente entrada;
		for(int i=0; i< registro.size(); i++) {
			entrada=new TicketCliente();
			entrada=registro.get(i);
			if(entrada.getIdTicket()==id) {
				entrada.setPrecio(precio);
				conexion.setQuery("UPDATE `tickets` SET precio='" + precio + "' WHERE idTicket='" + id + "'");
				return true;
			}
		}
		
		return false;
	}
	
	public boolean modificarFechaTicket(String id, String fechaNueva) {
		Connectar conexion=BDsingleton.getConnexion();
		TicketCliente entrada;
		for(int i=0; i< registro.size(); i++) {
			entrada=new TicketCliente();
			entrada=registro.get(i);
			if(entrada.getIdTicket()==id) {
				entrada.setFechaEvento(fechaNueva);
				conexion.setQuery("UPDATE `tickets` SET fechaEvento='" + fechaNueva + "' WHERE idTicket='" + id + "'");
				return true;
			}
		}
		
		return false;
	}
	
	public void modificarFechaTicket(String fechaNueva) {
		Connectar conexion=BDsingleton.getConnexion();
		TicketCliente entrada;
		for(int i=0; i< registro.size(); i++) {
			entrada=new TicketCliente();
			entrada=registro.get(i);
			entrada.setFechaEvento(fechaNueva);
			conexion.setQuery("UPDATE `tickets` SET fechaEvento='" + fechaNueva + "' WHERE idTicket='" + entrada.getIdTicket() + "'");
		}
	}
	
	
	public void readTicketsVendidosPersona(String rut, String nameEvento) {
		Connectar conexion=BDsingleton.getConnexion();
		ResultSet resultado;
		TicketCliente aux;
		resultado=conexion.getQuery("select asiento, precio, fechaEvento, idTicket, nameEvento, rut from tickets inner join personas using (rut) where rut='"+rut+"' AND nameEvento='"+nameEvento+"'");
		
		try {
			while(resultado.next()) {
				aux=new TicketCliente();
				aux.setAsiento(resultado.getString(1));
				aux.setPrecio(resultado.getInt(2));
				aux.setFechaEvento(resultado.getString(3));
				aux.setIdTicket(resultado.getString(4));
				aux.setNameEvento(resultado.getString(5));
				aux.setRut(resultado.getString(6));
				
				registro.add(aux);
				System.out.println(registro.get(registro.size()-1).getAsiento());
			}
		}
		catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getCantidad() {
		return registro.size();
	}
	
}