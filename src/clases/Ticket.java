package clases;

import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Ticket {
	//atributos
	private String asiento;
	private int precio;
	private Calendar fechaEvento;// yeeeeeeeeeee
	private int idTicket;
	private String nameEvento;
	private String rut;
	
	public Ticket() {
		fechaEvento= Calendar.getInstance();
	}
	
	
	//getters & setters
	public String getNameEvento() {
		return nameEvento;
	}
	public void setNameEvento(String nombre) {
		this.nameEvento = nombre;
	}
	public String getAsiento() {
		return asiento;
	}
	public void setAsiento(String asiento) {
		this.asiento = asiento;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public void setIdTicket(int id) {
		idTicket=id;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut=rut;
	}
	public String getFechaEvento(){
		SimpleDateFormat formato = new SimpleDateFormat("dd'/'MM'/'yyyy");
		return formato.format(fechaEvento.getTime());
	}
	public void setFechaEvento(String fechaNueva){
		String[] array = fechaNueva.split("/");
		fechaEvento.set(Integer.parseInt(array[2]), Integer.parseInt(array[1])-1, Integer.parseInt(array[0]));
	}
	
	
	
	public int setIdTicket() {
		int numero;
		numero = (int) (Math.random() * 9999999) + 1;
		idTicket = numero;
		return idTicket;
	}
	public int getIdTicket() {
		return idTicket;
	}
	
	
}
