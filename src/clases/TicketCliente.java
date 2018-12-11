package clases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TicketCliente extends Ticket {
	private String asiento;
	private int precio;
	private Calendar fechaEvento;
	private String idTicket;
	private String nameEvento;
	private String rut;

	public TicketCliente() {
		fechaEvento= Calendar.getInstance();
	}
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
	public void setIdTicket(String id) {
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



	public String setIdTicket() {
		int numero;
		String codigo;
		numero = (int) (Math.random() * 9999999) + 1;
		codigo = Integer.toString(numero);
		return codigo;
	}
	public String getIdTicket() {
		return idTicket;
	}
	@Override
	public int descuento() {
		//descuento en el caso de que la entrada se compre el dia del evento
		Calendar fechaActual = Calendar.getInstance();
		String cadenaFecha = String.format("%04d-%02d-%02d-%02d",fechaActual.get(Calendar.YEAR),fechaActual.get(Calendar.MONTH)+1,
		  fechaActual.get(Calendar.DAY_OF_MONTH));
		if(getFechaEvento().equals(fechaActual)) {
			return (precio*10)/100;
		}
		
		return precio;
	}





}
