package clases;

import java.sql.*;

public class Connectar {
	
	private Connection conn=null;
	private static String user = "root";
	private static String pass = "";
	private static String url = "jdbc:mysql://localhost/venta";

	public Connectar() {
		try {
			Class.forName("com.mysql.jdbc.Connection");
			conn = (Connection)DriverManager.getConnection(url, user, pass);
			if(conn!=null) {
				System.out.println("Conexion a base de datos a "+ url + " ....ok");
				
			}
		}
		catch(SQLException ex) {
			System.out.println("Hubo un problema al conectar la base de datos");
		}
		catch(ClassNotFoundException ex) {
			System.out.println(ex);
		}
	}
	
	public ResultSet getQuery(String query) {
		Statement state=null;
		ResultSet resultado=null;
		
		try {
			state=(Statement) conn.createStatement();
			resultado=state.executeQuery(query);
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return resultado;
	}
	
	public void setQuery(String query) {
		Statement state=null;
		
		try {
			state=(Statement) conn.createStatement();
			state.execute(query);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
		
 		
	
}