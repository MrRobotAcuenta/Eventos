package clases;

import java.util.Calendar;
import java.text.SimpleDateFormat;
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
		Ticket aux_ticket;
		for(int i=0; i< registro.size(); i++) {
			aux_ticket=new Ticket();
			aux_ticket=registro.get(i);
			if(aux_ticket.getIdTicket()==nuevo.getIdTicket()) {
				return false;
			}
		}
		registro.add(nuevo);
		return true;
				
	}
	
	public Ticket eliminarTicket(int id) {	
		for(int i=0; i<registro.size() ; i++) {
			if(registro.get(i).getIdTicket()==id) {
				return	registro.remove(i);
			}
		}
		return null;
	}
	
	
	public boolean modificarPrecio(int id, int precio) {
		for(int i=0; i< registro.size(); i++) {
			if(registro.get(i).getIdTicket()==id) {
				registro.get(i).setPrecio(precio);
				return true;
			}
		}
		
		return false;
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
				//aux.setFechaEvento(resultado.getString(3));
				aux.setIdTicket(resultado.getInt(4));//revisar
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
}