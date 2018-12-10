package clases;


import java.sql.*;
import java.util.HashMap;
import java.util.Map;


public class Recinto {
	private Map<String, Cupo> lugar;
	
	public Recinto() {
		lugar = new HashMap<String, Cupo>();
	}
	
	public boolean agregarCupo(Cupo nuevo) {
		Connectar conexion=BDsingleton.getConnexion();
		String asiento=nuevo.getAsiento();
		if(lugar.containsKey(asiento)) {
			return false;
		}
		lugar.put(asiento, nuevo);
		
		int disponible=0;			// Esto se utiliza para facilitar el traspaso del boolean a la BD
		if(nuevo.getDisponible()) {
			disponible=1;
		}
		else {
			disponible=0;
		}
		conexion.setQuery("INSERT INTO `cupo` (`nameEvento`, `asiento`, `disponible`) VALUES ('" + nuevo.getNameEvento() + "', '" + nuevo.getAsiento() + "', '" + disponible + "')");
		return true;
	}
	
	public Cupo eliminarCupo(String asiento) {
		Connectar conexion=BDsingleton.getConnexion();
		conexion.setQuery("DELETE FROM `cupo` WHERE asiento='" + asiento + "'");
		return lugar.remove(asiento);
	}
	
	public boolean existeCupo(String asiento) {
		return lugar.containsKey(asiento);
	}
	
	public boolean modificarDisponible(String asiento, boolean nuevo) {
		Connectar conexion=BDsingleton.getConnexion();
		Cupo sitio=new Cupo();
		sitio=lugar.get(asiento);
		if(sitio!=null) {
			sitio.setDisponible(nuevo);
			
			int disponible=0;			// Esto se utiliza para facilitar el traspaso del boolean a la BD
			if(nuevo) {
				disponible=1;
			}
			else {
				disponible=0;
			}
			conexion.setQuery("UPDATE `cupo` SET disponible='" + disponible + "' WHERE asiento='" + asiento + "'");
			return true;			
		}
		return false;
	}

	
	public void readResintoEvento(String nameEvento) {
		Connectar conexion=BDsingleton.getConnexion();
		ResultSet resultado;
		Cupo sitio;
		String key;
		resultado=conexion.getQuery("select nameEvento, asiento, disponible from cupo inner join eventos using (nameEvento) where nameEvento='"+nameEvento+"'");
		
		try {
			while(resultado.next()) {
				sitio=new Cupo();
				sitio.setNameEvento(resultado.getString(1));
				sitio.setAsiento(resultado.getString(2));
				key=sitio.getAsiento();
				sitio.setDisponible(resultado.getBoolean(3));
				lugar.put(key, sitio);
				System.out.println(lugar.get(key).getAsiento()+" "+lugar.get(key).getDisponible());
			}
		}
		catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
