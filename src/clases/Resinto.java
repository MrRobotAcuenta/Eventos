package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Resinto {
	private ArrayList<Cupo> lugar;
	
	public Resinto() {
		lugar = new ArrayList<Cupo>();
	}
	
	public boolean agregarCupo(Cupo nuevo) {
		Cupo aux_cupo;
		for(int i=0; i<lugar.size();i++) {
			aux_cupo=new Cupo();
			aux_cupo=lugar.get(i);
			if(aux_cupo.getAsiento().equals(nuevo.getAsiento())) {
				return false;
			}
		}
		lugar.add(nuevo);
		return true;
	}
	
	public Cupo eliminarCupo(String asiento) {	
		Cupo aux_cupo;
		for(int i=0; i<lugar.size();i++) {
			aux_cupo=new Cupo();
			aux_cupo=lugar.get(i);
			if(aux_cupo.getAsiento().equals(asiento)) {
				return lugar.remove(i);
			}
		}
		return null;
	}
	
	public boolean existeCupo(String asiento) {
		Cupo aux_cupo;
		for(int i=0; i<lugar.size(); i++) {
			aux_cupo=new Cupo();
			aux_cupo=lugar.get(i);
			if(aux_cupo.getAsiento().equals(asiento)) {
					return true;
			}
		}
		return false;
	}
	
	public boolean modificarDisponible(String asiento, boolean nuevo) {
		Cupo aux_cupo;
		for(int i=0; i< lugar.size(); i++) {
			aux_cupo=new Cupo();
			aux_cupo=lugar.get(i);
			if(aux_cupo.getAsiento().equals(asiento)) {
				aux_cupo.setDisponible(nuevo);
				return true;
			}
		}
		return false;
	}

	
	public void readResintoEvento(Connectar conexion, String nameEvento) {
		ResultSet resultado;
		Cupo aux;
		resultado=conexion.getQuery("select nameEvento, asiento, disponible from cupo inner join eventos using (nameEvento) where nameEvento='"+nameEvento+"'");
		
		try {
			while(resultado.next()) {
				aux=new Cupo();
				aux.setNameEvento(resultado.getString(1));
				aux.setAsiento(resultado.getString(2));
				aux.setDisponible(resultado.getBoolean(3));
				lugar.add(aux);
				System.out.println(lugar.get(lugar.size()-1).getAsiento()+" "+lugar.get(lugar.size()-1).isDisponible());
			}
		}
		catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
