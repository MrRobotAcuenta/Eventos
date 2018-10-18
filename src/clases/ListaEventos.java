package clases;

import java.util.*;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListaEventos {
	private ArrayList<Evento> eventos;
		
		//inicializa una nueva lista de Evento
		public ListaEventos() {
			eventos=new ArrayList <Evento> ();
		}
		
		public boolean existeEvento(String name) {
			
			for(int i=0; i< eventos.size(); i++){
				if(eventos.get(i).getNombre()==name){
					return true;
				}
			}
			
			return false;
		}

		//ingresa un Evento a la lista de Evento
		public void addEvento(Object input) {
			eventos.add((Evento)input);
			System.out.println(eventos.get(eventos.size()-1).getNombre());
		}
		
		//eliminar un Evento de la lista de Eventos
		public void removeEvento(String a) {
			System.out.println(eventos.size());
			for(int i=0;i<eventos.size();i++) {
				if(eventos.get(i).getNombre().equals(a)) {
					
					eventos.remove(i);
					System.out.println(eventos.get(eventos.size()-1).getNombre());
				}
			}
		}
		
		
		
		public int mostrarLista()throws IOException {
			BufferedReader lector= new BufferedReader( new InputStreamReader(System.in));
			System.out.println("Elija uno de los siguientes eventos para trabajar en el:\t\n");
			int cant=eventos.size();
			Evento aux;
			if(cant>0) {
				int i=1;
				for(int k=0; k<cant; k++) {
					aux=(Evento)eventos.get(k);
					System.out.println(i+") "+ aux.getNombre());
					i++;
				}
				int respuesta = Integer.parseInt(lector.readLine());
				respuesta-- ;
				return respuesta;
			}else {
				System.out.println("No se ha encontrado un evento previo pasaremos a agregar un evento nuevo.");
				return 0;
			}
		}
		
		public void readListaEventos(Connectar conexion) {
			ResultSet resultado;
			Evento aux;
			resultado=conexion.getQuery("select * from eventos");
			
			try {
				while(resultado.next()) {
					aux=new Evento();
					aux.setNombre(resultado.getString(1));
					aux.setTipo(resultado.getString(2));
					aux.setRestriccion(resultado.getBoolean(3));
					aux.setLugar(resultado.getString(4));
					//aux.setFecha(resultado.getString(5));
					
					aux.readPersonasEvento(conexion);
					aux.readResintoEvento(conexion);
					System.out.println(aux.getNombre());
					eventos.add(aux);
				}
			}
			catch(SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
