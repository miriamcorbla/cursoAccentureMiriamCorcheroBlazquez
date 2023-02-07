package curso.miniapi.S4_MiniApi2.dao;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import curso.miniapi.S4_MiniApi2.modelos.Country;
import curso.miniapi.S4_MiniApi2.service.JPAUtil;

public class CountryDao {
	EntityManager manager = JPAUtil.getEntityManager();

	// guardar Country
	public void guardar(Country country) {
		manager.getTransaction().begin();
		manager.persist(country);
		manager.getTransaction().commit();		
	}

	// editar Country
	public void editar(Country country) {
		manager.getTransaction().begin();
		manager.merge(country);
		manager.getTransaction().commit();
	}

	// buscar Country
	public Country buscar(String id) {
		
		Country c = manager.find(Country.class, id);
		return c;
	}

	/// eliminar Country
	public void eliminar(String id) {
		Country c = manager.find(Country.class, id);
		manager.getTransaction().begin();
		manager.remove(c);
		manager.getTransaction().commit();
	}
	
	public void eliminar (Country country) {
		eliminar(country.getCountry_id());
	}

	// obtener todos los Country
	public List<Country> obtenerCountries() {
		List<Country> listaCategorias = new ArrayList<>();
		Query q = manager.createQuery("SELECT c FROM Country c");
		listaCategorias = (List<Country>) q.getResultList();
		return listaCategorias;
	}
}
