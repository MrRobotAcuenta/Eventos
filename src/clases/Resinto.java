package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Resinto {
	private ArrayList<Cupo> lugar;
	
	public Resinto() {
		lugar = new ArrayList<Cupo>();
	}
	public boolean existeCupo(String asiento) 
	{
		if(asiento != null)
		{
			for(int i=0; i< lugar.size(); i++)
			{
				if(lugar.get(i).getAsiento().equals(asiento))
				{
					return true;
				}
			}
		}
		return false;
	}
	public boolean modificarDisponible(String asiento, boolean nuevo)
	{
			for(int i=0; i< lugar.size(); i++)
			{
				if(lugar.get(i).getAsiento().equals(asiento))
				{
					lugar.get(i).setDisponible(nuevo);
					return true;
				}
			}
		
		return false;
	}
	public void agregarCupo(String evento, String asiento, boolean disponible) 
	{
		Cupo nuevo = new Cupo();
		nuevo.setNameEvento(evento);
		nuevo.setAsiento(asiento);
		nuevo.setDisponible(disponible);
		lugar.add(nuevo);	
	}
	public void eliminarCupo(String asiento){	
		for(int i=0; i<lugar.size() ; i++)
		{
			if(lugar.get(i).getAsiento().equals(asiento))
			{
				lugar.remove(i);		
			}
		}
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
			}
		}
		catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
