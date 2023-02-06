package bbdd.ficheros.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bbdd.ficheros.modelos.Country;

public class OracleJDBC {

	private static Connection conn;
	public static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@95.17.8.252:1521:xe";
	public static final String DATABASE = "";
	public static final String USUARIO = "hr";
	public static final String PASSWORD = "hr";
	public static String SQL_LEER_TODOS = "Select * from Employees";

	
	public Connection abrirConexion() throws SQLException {
		System.out.println("------ORACLE JDBC Connection Testing-------");
		
		try {
			Class.forName(JDBC_DRIVER);
		}catch(ClassNotFoundException e) {
			System.out.println("Where is your oracle JDBC Driver?");
			e.printStackTrace();
			return null;
		}
		System.out.println("Driver Registered!");
		
		//CONSIGUE CONEXION
		conn = null;
		try {
			conn = DriverManager.getConnection(URL+DATABASE, USUARIO, PASSWORD);
		}catch(SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;
		}
		conn.setAutoCommit(false);
		return conn;
	}
	
	public static void cerrarConexion() throws SQLException {
		if(conn != null) {
			System.out.println("You made it, take control your database now!");
			conn.rollback(); //lo que no se haya commiteado, lo tira para atrás
			conn.close();
		}else {
			System.out.println("Failed to make connection!");
		}
	}
	
	public static void lecturaEmployees() throws SQLException {
		ResultSet rs = null;
		try {
			Statement stm = conn.createStatement();
			rs = stm.executeQuery(SQL_LEER_TODOS);
			while(rs.next()) { //rs apunta justamente a los datos
				System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
			}
		}catch(SQLException s) {
			System.out.println("Error de Query! Tu query ha sido: " + SQL_LEER_TODOS + 
					"\n" + s.getMessage());
		}finally {
			if(rs != null) {
				rs.close();
			}
		}
	}

}
