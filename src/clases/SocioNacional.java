package clases;

public class SocioNacional extends Cliente {
	
	private boolean miembroVip;
	@Override
	public int descuento() {
		//descuento se aplica si tiente más de 3 tickets
		return 10;
		//si miembroVip es verdadero, se le suma un 10% adicional
	}
	public boolean isMiembroVip() {
		return miembroVip;
	}
	public void setMiembroVip(boolean miembroVip) {
		this.miembroVip = miembroVip;
	}

}
