package clases;

public abstract class Ticket {
	//private int id;
	private String asiento;
	
	
	/*public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}*/
	public String getAsiento() {
		return asiento;
	}
	public void setAsiento(String asiento) {
		this.asiento = asiento;
	}
	public abstract int descuento();
}
