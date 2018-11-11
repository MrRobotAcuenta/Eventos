package clases;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Persona  {
	private String rut;
	private String nombre;
	private Calendar fechaNacimiento;
	private TicketsVendidos tickets;
	
	public Persona() {
		tickets= new TicketsVendidos();
		fechaNacimiento= Calendar.getInstance();
	}
	

	public String getRut() {
		return rut;
	}
	
	public void setRut(String rut) {
		this.rut = rut;
	}
	
	public String getFechaNacimiento() {
		SimpleDateFormat formato = new SimpleDateFormat("dd'/'MM'/'yyyy");
		return formato.format(fechaNacimiento.getTime());
	}
	
	public void setFechaNacimiento(String fecha) {
		String[] array = fecha.split("/");
		fechaNacimiento.set(Integer.parseInt(array[2]), Integer.parseInt(array[1])-1, Integer.parseInt(array[0]));
	}
	
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
	
	public boolean compraTicket(TicketCliente input) {
		return tickets.agregarTicket(input);
	}
	
	
	public Ticket eliminarTicket(int id) {
		return tickets.eliminarTicket(id);
	}
	
	public boolean modificarPrecio(int id, int precio) {
		return tickets.modificarPrecio(id, precio);
	}
	
	public boolean modificarFechaTicket(int id, String fechaNueva) {
		return tickets.modificarFechaTicket(id, fechaNueva);
	}
	
	public void modificarFechaTicket(String fechaNueva) {
		tickets.modificarFechaTicket(fechaNueva);
	}
	
	
	/*
	 Fin metodos lista Tickets
	 */
	
	public boolean mayoriaEdad()
	{
		Calendar fechaActual = Calendar.getInstance();
		int diaActual = fechaActual.get(Calendar.DAY_OF_MONTH);
		int mesActual = fechaActual.get(Calendar.MONTH)+1;
		int anioActual = fechaActual.get(Calendar.YEAR);
		
		int diaNacimiento = fechaNacimiento.get(Calendar.DAY_OF_MONTH);
		int mesNacimiento = fechaNacimiento.get(Calendar.MONTH);
		int anioNacimiento = fechaNacimiento.get(Calendar.YEAR);
		
		if((anioActual - anioNacimiento)>=18) {
			System.out.println(anioActual - anioNacimiento);
			if((mesActual-mesNacimiento)>=0) {
				if((diaActual-diaNacimiento)<0) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public void readTicketVendidoPersona(Connectar conexion, String nameEvento) {
		tickets.readTicketsVendidosPersona(conexion, rut, nameEvento);
	}
	
	public void writeTicketVendidoPersona(Connectar conexion) {
		tickets.writeTicketsVendidosPersona(conexion);
	}

}
