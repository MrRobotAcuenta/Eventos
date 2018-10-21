package clases;

import java.text.SimpleDateFormat;
import java.util.*;

public class Persona {
	private String rut;
	private String nombre;
	//private Calendar fechaNacimiento;
	private TicketsVendidos tickets;
	
	public Persona() {
		tickets= new TicketsVendidos();
	}
	public Persona(String rut, String nombre) {
		this.rut=rut;
		this.nombre=nombre;
		tickets= new TicketsVendidos();
	}
	
	

	public String getRut() {
		return rut;
	}
	
	public void setRut(String rut) {
		this.rut = rut;
	}
	
	/*public String getFechaNacimiento() {
		SimpleDateFormat formato = new SimpleDateFormat("'Fecha:' EEEE dd 'de' MMMM 'del' yyyy");
		return formato.format(fechaNacimiento.getTime());
	}
	
	public void setFechaNacimiento(String fechaNacimiento) {
		String[] array = fechaNacimiento.split("/");
		this.fechaNacimiento.set(Calendar.DAY_OF_MONTH,Integer.parseInt(array[0]));
		this.fechaNacimiento.set(Calendar.MONTH,Integer.parseInt(array[1])-1);
		this.fechaNacimiento.set(Calendar.YEAR,Integer.parseInt(array[2]));
	}
	*/
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	/*
	 Metodos para manipular datos de la lista tickets
	 */
	
	
	public boolean existeTicket(int id) {
		return tickets.existeTicket(id);
	}
	
	public boolean compraTicket(Ticket input) {
		return tickets.agregarTicket(input);
	}
	
	
	public Ticket eliminarTicket(int id) {
		return tickets.eliminarTicket(id);
	}
	
	public boolean modificarPrecio(int id, int precio) {
		return tickets.modificarPrecio(id, precio);
	}
	
	
	/*
	 Fin metodos lista Tickets
	 */
	
	/*public boolean mayoriaEdad()
	{
		Calendar fechaActual = Calendar.getInstance();
		int diaActual = fechaActual.get(Calendar.DAY_OF_MONTH);
		int mesActual = fechaActual.get(Calendar.MONTH)+1;
		int anioActual = fechaActual.get(Calendar.YEAR);
		
		int anioNacimiento = fechaNacimiento.get(Calendar.DAY_OF_MONTH);
		int mesNacimiento = fechaNacimiento.get(Calendar.MONTH);
		int diaNacimiento = fechaNacimiento.get(Calendar.YEAR);
		
		if((anioActual - anioNacimiento)>=18) {
			if((mesActual-mesNacimiento)>=0) {
				if((diaActual-diaNacimiento)<0) {
					return true;
				}
			}
		}
		
		return false;
	}
	*/
	public void readTicketVendidoPersona(Connectar conexion, String nameEvento) {
		tickets.readTicketsVendidosPersona(conexion, rut, nameEvento);
	}
	
}