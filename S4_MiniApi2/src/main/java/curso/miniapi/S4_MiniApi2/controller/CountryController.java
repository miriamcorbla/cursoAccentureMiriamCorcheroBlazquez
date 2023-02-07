package curso.miniapi.S4_MiniApi2.controller;

import java.sql.SQLException;
import java.util.List;

import curso.miniapi.S4_MiniApi2.dao.CountryDao;
import curso.miniapi.S4_MiniApi2.modelos.Country;

public class CountryController {
	
	CountryDao cDAO;
	public CountryController() throws SQLException {
		cDAO = new CountryDao();
	}
	
	public List<Country> leerTodos() throws Exception{
		return cDAO.obtenerCountries();
	}
	
	public Country leerUno(String country_id) throws Exception{
		return cDAO.buscar(country_id);
	}
	
	
	public void actualizar(Country country) throws SQLException {
		cDAO.editar(country);
	}
	
	public void eliminar(String country_id) throws SQLException {
		cDAO.eliminar(country_id);
	}
	
	public void eliminar(Country country) throws SQLException {
		cDAO.eliminar(country);
	}
	
	public void insertar(Country country) throws SQLException {
		cDAO.guardar(country);
	}


}
