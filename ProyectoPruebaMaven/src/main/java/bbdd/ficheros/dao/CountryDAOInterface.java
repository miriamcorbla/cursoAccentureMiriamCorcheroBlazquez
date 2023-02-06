package bbdd.ficheros.dao;

import java.sql.SQLException;
import java.util.List;

import bbdd.ficheros.modelos.Country;

public interface CountryDAOInterface {
	
	public Country leerUno(String country_id) throws Exception;
	public List<Country> leerTodos() throws Exception;
	public int actualizar(Country country) throws SQLException; //update de country, y devuelvo las filas afectadas, por eso dev int
	public int delete(Country country) throws SQLException;
	public int delete(String country_id) throws SQLException;
	public Country insert(Country country) throws SQLException;
}
