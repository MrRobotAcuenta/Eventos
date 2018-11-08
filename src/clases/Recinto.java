package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Recinto {
	private ArrayList<Cupo> lugar;
	
	public Recinto() {
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
		Cupo sitio;
		resultado=conexion.getQuery("select nameEvento, asiento, disponible from cupo inner join eventos using (nameEvento) where nameEvento='"+nameEvento+"'");
		
		try {
			while(resultado.next()) {
				sitio=new Cupo();
				sitio.setNameEvento(resultado.getString(1));
				sitio.setAsiento(resultado.getString(2));
				sitio.setDisponible(resultado.getBoolean(3));
				lugar.add(sitio);
				System.out.println(lugar.get(lugar.size()-1).getAsiento()+" "+lugar.get(lugar.size()-1).isDisponible());
			}
		}
		catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeResintoEvento(Connectar conexion) {
		Cupo sitio;
		int disponible=0;
		for(int i=0;i<lugar.size();i++) {
			sitio=new Cupo();
			sitio=lugar.get(i);
			if(sitio.isDisponible()) {
				disponible=1;
			}
			else {
				disponible=0;
			}
			conexion.setQuery("INSERT INTO `cupo` (`nameEvento`, `asiento`, `disponible`) VALUES ('" + sitio.getNameEvento() + "', '" + sitio.getAsiento() + "', '" + disponible + "') ON DUPLICATE KEY UPDATE nameEvento=VALUES(nameEvento), asiento=VALUES(asiento), disponible=VALUES(disponible)");
		}
		
	}
	
}
