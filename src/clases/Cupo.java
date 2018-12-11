package clases;

public class Cupo extends Ticket {
	public Boolean disponible;
	private String nameEvento;
	private Boolean tieneDescuento;
	
	public String getNameEvento() {
		return nameEvento;
	}
	public void setNameEvento(String nombre) {
		this.nameEvento = nombre;
	}
	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}
	@Override
	public int descuento() {
		if(tieneDescuento) {
		return 1;
		}
		return 0;
		
	}
	
	
}

