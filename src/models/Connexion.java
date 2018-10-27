package models;

import java.sql.*;

public class Connexion {
	
	private static Connection conn;
	
	public static void ouvrir_Connexion(String lien_db, String user, String pass){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(lien_db, user, pass);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void fermer_Connexion(){
		try {
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConn() {
		return conn;
	}

}