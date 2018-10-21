package clases;

import java.text.SimpleDateFormat;
import java.util.*;

public class Evento {
	private String nombre;
	private String tipo;
	private boolean restriccion;
	private String lugar;
	//private Calendar fecha;
	private ListaPersonas personas;
	private Resinto asistentes;
	
	
	//inicializa un evento
	public Evento() {
		personas=new ListaPersonas();
		asistentes=new Resinto();
	}
	public Evento(String nombre,String tipo,String lugar) {
		this.nombre=nombre;
		this.tipo=tipo;
		this.lugar=lugar;
		personas=new ListaPersonas();
		asistentes=new Resinto();
	}

	


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public boolean isRestriccion() {
		return restriccion;
	}
	public void setRestriccion(boolean restriccion) {
		this.restriccion = restriccion;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	/*public String getFecha() {
		SimpleDateFormat formato = new SimpleDateFormat("'Fecha:' EEEE dd 'de' MMMM 'del' yyyy");
		return formato.format(fecha.getTime());
	}
	public void setFecha(String fechaNueva) {
		String[] array = fechaNueva.split("/");
		this.fecha.set(Calendar.DAY_OF_MONTH,Integer.parseInt(array[0]));
		this.fecha.set(Calendar.MONTH,Integer.parseInt(array[1])-1);
		this.fecha.set(Calendar.YEAR,Integer.parseInt(array[2]));
	}
	*/
	
	
	public boolean nuevaPersona(Persona p) {
		return personas.nuevaPersona(p);
	}
	public Persona eliminarPersona(String rutPersona) {
		return personas.eliminarPersona(rutPersona);
	}
	
	public Persona buscarPersona(String rutPersona){
		return personas.buscarPersona(rutPersona);
	}
	public boolean modificarNombrePersona(String rutPersona, String input) {
		return personas.modificarNombrePersona(rutPersona, input);
	}
	
	
	
	
	public boolean existeTicket(String rutPersona, int id) {
		return personas.existeTicket(rutPersona, id);
	}
	
	public boolean compraTicket(Ticket input) {
		return personas.compraTicket(input);
	}
	
	public Ticket eliminarTicket(String rutPersona, int id) {
		return personas.eliminarTicket(rutPersona, id);
	}
	
	public boolean modificarPrecio(String rutPersona, int id, int precio) {
		return personas.modificarPrecio(rutPersona, id, precio);
	}
	
	public void readPersonasEvento(Connectar conexion) {
		personas.readPersonasEvento(conexion, nombre);
	}
	
	
	
	
	public boolean agregarCupo(Cupo input) {
		return asistentes.agregarCupo(input);
	}
	
	public Cupo eliminarCupo(String asiento) {
		return asistentes.eliminarCupo(asiento);
	}
	
	public boolean existeCupo(String asiento) {
		return asistentes.existeCupo(asiento);
	}
	
	public boolean modificarDisponible(String asiento, boolean nuevo) {
		return asistentes.modificarDisponible(asiento, nuevo);
	}
	
	public void readResintoEvento(Connectar conexion) {
		asistentes.readResintoEvento(conexion, nombre);
	}
	
}
