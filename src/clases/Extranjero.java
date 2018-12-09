package clases;

public class Extranjero extends Cliente {
	private String Pais;
	@Override
	public int descuento() {
		//descuento si ya tiene un ticket comprado
		return 0;
	}
	public String getPais() {
		return Pais;
	}
	public void setPais(String pais) {
		Pais = pais;
	}
	

}
