package clases;

import java.text.SimpleDateFormat;
import java.util.*;

public class Evento {
	private String nombre;
	private String tipo;
	private boolean restriccion;
	private String lugar;
	private Calendar fecha;
	private ListaPersonas personas;
	private Recinto asistentes;
	
	
	//inicializa un evento
	public Evento() {
		fecha= Calendar.getInstance();
		personas=new ListaPersonas();
		asistentes=new Recinto();
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
	public String getFecha() {
		SimpleDateFormat formato = new SimpleDateFormat("dd'/'MM'/'yyyy");
		return formato.format(fecha.getTime());
	}
	public void setFecha(String fechaNueva) {
		String[] array = fechaNueva.split("/");
		fecha.set(Integer.parseInt(array[2]), Integer.parseInt(array[1])-1, Integer.parseInt(array[0]));
		System.out.println(getFecha());
	}
	
	
	
	public boolean personaNuevaPersona(Persona p) {
		return personas.nuevaPersona(p);
	}
	public Persona personaEliminarPersona(String rutPersona) {
		return personas.eliminarPersona(rutPersona);
	}
	
	public Persona personaBuscarPersona(String rutPersona){
		return personas.buscarPersona(rutPersona);
	}
	public boolean personaModificarNombre(String rutPersona, String input) {
		return personas.modificarNombrePersona(rutPersona, input);
	}
	
	public boolean personaModificarFechaNacimiento(String rutPersona, String fechaNueva) {
		return personas.modificarFechaNacimiento(rutPersona, fechaNueva);
	}
	
	public boolean personaMayoriaEdad(String rutPersona) {
		return personas.mayoriaEdad(rutPersona);
	}
	
	
	
	public boolean personaExisteTicket(String rutPersona, int id) {
		return personas.existeTicket(rutPersona, id);
	}
	
	public boolean personaCompraTicket(Ticket input) {
		return personas.compraTicket(input);
	}
	
	public Ticket personaEliminarTicket(String rutPersona, int id) {
		return personas.eliminarTicket(rutPersona, id);
	}
	
	public boolean personaModificarPrecio(String rutPersona, int id, int precio) {
		return personas.modificarPrecio(rutPersona, id, precio);
	}
	
	public boolean personaModificarFechaEvento(String rutPersona, int id, String fechaNueva) {
		return personas.modificarFechaEvento(rutPersona, id, fechaNueva);
	}
	
	public void personaModificarFechaEvento(String fechaNueva) {
		personas.modificarFechaEvento(fechaNueva);
	}
	
	public void readPersonasEvento(Connectar conexion) {
		personas.readPersonasEvento(conexion, nombre);
	}
	
	public void writePersonasEvento(Connectar conexion) {
		personas.writePersonasEvento(conexion);
	}
	
	
	
	
	public boolean cupoAgregarCupo(Cupo input) {
		return asistentes.agregarCupo(input);
	}
	
	public Cupo cupoEliminarCupo(String asiento) {
		return asistentes.eliminarCupo(asiento);
	}
	
	public boolean cupoExisteCupo(String asiento) {
		return asistentes.existeCupo(asiento);
	}
	
	public boolean cupoModificarDisponible(String asiento, boolean nuevo) {
		return asistentes.modificarDisponible(asiento, nuevo);
	}
	
	public void readResintoEvento(Connectar conexion) {
		asistentes.readResintoEvento(conexion, nombre);
	}
	
	public void writeResintoEvento(Connectar conexion) {
		asistentes.writeResintoEvento(conexion);
	}
	
}
