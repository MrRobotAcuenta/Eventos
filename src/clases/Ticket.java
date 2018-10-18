package clases;

import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Ticket {
	//atributos
	private String asiento;
	private int precio;
	//private Calendar fechaEvento; //sera cambiado a una variable date
	private int idTicket;
	private String nameEvento;
	private String rut;
	public Ticket(String asiento,int precio,String nameEvento,String rut) {
		this.asiento=asiento;
		this.precio=precio;
		this.idTicket=idTicket;
		this.nameEvento=nameEvento;
		this.rut=rut;
		
	}
	public Ticket() {
		asiento="";
		precio=0;
		//idTicket=setIdTicket();
		nameEvento="";
		rut="";
		
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
	//sera cambiado a variable de tipo date
	/*public String getFechaEvento()
	{
		SimpleDateFormat formato = new SimpleDateFormat("'Fecha:' EEEE dd 'de' MMMM 'del' yyyy");
		return formato.format(fechaEvento.getTime());
	}
	public void setFechaEvento(String fechaNueva)
	{
		String[] array = fechaNueva.split("/");
		this.fechaEvento.set(Calendar.DAY_OF_MONTH,Integer.parseInt(array[0]));
		this.fechaEvento.set(Calendar.MONTH,Integer.parseInt(array[1])-1);
		this.fechaEvento.set(Calendar.YEAR,Integer.parseInt(array[2]));
	}
	*/
	//sera cambiado a variable de tipo date
	//public int getIdTicket() {
		//return idTicket;
	//}
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
