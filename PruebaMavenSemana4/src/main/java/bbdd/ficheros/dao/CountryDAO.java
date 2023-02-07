package bbdd.ficheros.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bbdd.ficheros.modelos.Country;
import bbdd.ficheros.util.MontadorSQL;
import bbdd.ficheros.util.OracleJDBC;

public class CountryDAO implements CountryDAOInterface{

	public static final String SQL_LEER_TODOS_COUNTRY = "Select * from countries_mcb";
	public static final String SQL_LEER_COUNTRY_ID = "Select * from countries_mcb where country_id = ";
	public static final String SQL_LEER_COUNTRY_ID2 = "Select * from countries_mcb where country_id = ?";
	
	public static final String SQL_UPDATE_ID = "update countries_mcb set country_id = ?, country_name = ?, region_id = ? where country_id = ?";
	
	public static final String SQL_ELIMINAR_COUNTRY = "delete countries_mcb where country_id = ?";
	
	private Connection conn;
	
	public CountryDAO() throws SQLException {
		OracleJDBC ora = new OracleJDBC();
		conn = ora.abrirConexion();
	}
	
	@Override
	public Country leerUno(String country_id) throws Exception {
		ResultSet rs = null;
		try {
			//compruebo que haya leido algo y que solo haya leido uno
			Statement stm = conn.createStatement();
			//con preparedStatement
			PreparedStatement pst = conn.prepareStatement(SQL_LEER_COUNTRY_ID2);
			pst.setString(1, country_id); //es 1 porque el statment siempre empieza en 1 (no en 0). Si hubiese más ? pues sería 2, 3, 4... etc
			rs = pst.executeQuery();
			
			/*
			//sin usar preparedStatement
			rs = stm.executeQuery(SQL_LEER_COUNTRY_ID + "'" + country_id + "'");
			
			rs.next();
			return carga(rs);
			*/
			
			rs.next();
			return carga(rs);
			
		}catch(SQLException s) {
			throw new Exception("Error de Query! Tu query ha sido: " + SQL_LEER_COUNTRY_ID2
					+ "\n" + s.getMessage());
		}
	}

	@Override
	public List<Country> leerTodos() throws Exception {
		ResultSet rs = null;
		List<Country> salida = new ArrayList<Country>();
		try {
			Statement stm = conn.createStatement();
			rs = stm.executeQuery(SQL_LEER_TODOS_COUNTRY);
			
			while(rs.next()) { //rs apunta justamente a los datos
				salida.add(carga(rs));
			}
		}catch(SQLException s) {
			throw new Exception("Error de Query! Tu query ha sido: " + SQL_LEER_TODOS_COUNTRY
					+ "\n" + s.getMessage());
		}
		return salida;
	}

	@Override
	public int actualizar(Country country) throws SQLException {
		
		PreparedStatement ps = conn.prepareStatement(SQL_UPDATE_ID);
		ps.setString(1, country.getCountry_id());
		ps.setString(2, country.getCountry_name());
		ps.setString(3, country.getRegion_id());
		ps.setString(4, country.getCountry_id());
		return ps.executeUpdate();
	}
	
	
	@Override
	public int delete(Country country) throws SQLException {
		return delete(country.getCountry_id());

	}

	@Override
	public int delete(String country_id) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(SQL_ELIMINAR_COUNTRY);
		ps.setString(1, country_id);
		return ps.executeUpdate();
	}

	/**
	 * INSERT CON MONTA SQL
	 */
	@Override
	public Country insert(Country country) throws SQLException {
		String sqlInsert = "insert into countries_mcb values (" + montaSQL(country);
		Statement stm = conn.createStatement();
		stm.execute(sqlInsert);
		return country;
	}

	public Country carga(ResultSet rs) throws SQLException {
		Country ctr = new Country();
		ctr.setCountry_id(rs.getString("country_id"));
		ctr.setCountry_name(rs.getString("country_name"));
		ctr.setRegion_id(rs.getString("region_id"));
		return ctr;
	}
	
	public String montaSQL(Country country) {
		String salida = "";
		salida = MontadorSQL.addSalida(salida, "", country.getCountry_id(), ",");
		salida = MontadorSQL.addSalida(salida, "", country.getCountry_name(), ",");
		salida = MontadorSQL.addSalida(salida, "", country.getRegion_id(), ")");
		return salida;
	}
}
