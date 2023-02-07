package bbdd.ficheros.controller;

import java.sql.SQLException;
import java.util.List;

import bbdd.ficheros.dao.CountryDAO;
import bbdd.ficheros.dao.CountryDAOInterface;
import bbdd.ficheros.modelos.Country;

public class CountryController {
	
	CountryDAOInterface cDAO;
	public CountryController() throws SQLException {
		cDAO = new CountryDAO();
	}
	
	public List<Country> leerTodos() throws Exception{
		return cDAO.leerTodos();
	}
	
	public Country leerUno(String country_id) throws Exception{
		return cDAO.leerUno(country_id);
	}
	
	
	public int actualizar(Country country) throws SQLException {
		return cDAO.actualizar(country);
	}
	
	public int eliminar(String country_id) throws SQLException {
		return cDAO.delete(country_id);
	}
	
	public int eliminar(Country country) throws SQLException {
		return cDAO.delete(country);
	}
	
	public Country insertar(Country country) throws SQLException {
		return cDAO.insert(country);
	}


}
