package clases;

import clases.Connectar;

public class BDsingleton {
	
	private static Connectar conn=null;
	
	private BDsingleton() {
		
	}
	
	public static Connectar getConnexion() {
		if(conn==null) {
			conn=new Connectar();
		}
		
		return conn;
	}
}
