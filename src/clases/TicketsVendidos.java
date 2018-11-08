package clases;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketsVendidos {
	private ArrayList<Ticket> registro;
	
	public TicketsVendidos() {
		registro = new ArrayList<Ticket>();
	}
	
	
	public boolean existeTicket(int id) {
		for(int i=0; i< registro.size(); i++) {
			if(registro.get(i).getIdTicket()==id) {
				return true;
			}
		}
		
		return false;
	}
	
	
	public boolean agregarTicket(Ticket nuevo) {
		Ticket entrada;
		for(int i=0; i< registro.size(); i++) {
			entrada=new Ticket();
			entrada=registro.get(i);
			if(entrada.getIdTicket()==nuevo.getIdTicket()) {
				return false;
			}
		}
		registro.add(nuevo);
		return true;
				
	}
	
	public Ticket eliminarTicket(int id) {
		Ticket entrada;
		for(int i=0; i<registro.size() ; i++) {
			entrada=new Ticket();
			entrada=registro.get(i);
			if(entrada.getIdTicket()==id) {
				return registro.remove(i);
			}
		}
		return null;
	}
	
	
	public boolean modificarPrecio(int id, int precio) {
		Ticket entrada;
		for(int i=0; i< registro.size(); i++) {
			entrada=new Ticket();
			entrada=registro.get(i);
			if(entrada.getIdTicket()==id) {
				entrada.setPrecio(precio);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean modificarFechaTicket(int id, String fechaNueva) {
		Ticket entrada;
		for(int i=0; i< registro.size(); i++) {
			entrada=new Ticket();
			entrada=registro.get(i);
			if(entrada.getIdTicket()==id) {
				entrada.setFechaEvento(fechaNueva);
				return true;
			}
		}
		
		return false;
	}
	
	public void modificarFechaTicket(String fechaNueva) {
		Ticket entrada;
		for(int i=0; i< registro.size(); i++) {
			entrada=new Ticket();
			entrada=registro.get(i);
			entrada.setFechaEvento(fechaNueva);
		}
	}
	
	
	public void readTicketsVendidosPersona(Connectar conexion, String rut, String nameEvento) {
		ResultSet resultado;
		Ticket aux;
		resultado=conexion.getQuery("select asiento, precio, fechaEvento, idTicket, nameEvento, rut from tickets inner join personas using (rut) where rut='"+rut+"' AND nameEvento='"+nameEvento+"'");
		
		try {
			while(resultado.next()) {
				aux=new Ticket();
				aux.setAsiento(resultado.getString(1));
				aux.setPrecio(resultado.getInt(2));
				aux.setFechaEvento(resultado.getString(3));
				aux.setIdTicket(resultado.getInt(4));
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
	
	public void writeTicketsVendidosPersona(Connectar conexion) {
		Ticket entrada;
		for(int i=0;i<registro.size();i++) {
			entrada=new Ticket();
			entrada=registro.get(i);
			conexion.setQuery("INSERT INTO `tickets` (`asiento`, `precio`, `fechaEvento`, `idTicket`, `nameEvento`, `rut`) VALUES ('" + entrada.getAsiento() + "', '" + entrada.getPrecio() + "', '" + entrada.getFechaEvento() + "', '" + entrada.getIdTicket() + "', '" + entrada.getNameEvento() + "', '" + entrada.getRut() + "') ON DUPLICATE KEY UPDATE asiento=VALUES(asiento), precio=VALUES(precio), fechaEvento=VALUES(fechaEvento), idTicket=VALUES(idTicket), nameEvento=VALUES(nameEvento), rut=VALUES(rut)");
		}
	}
}