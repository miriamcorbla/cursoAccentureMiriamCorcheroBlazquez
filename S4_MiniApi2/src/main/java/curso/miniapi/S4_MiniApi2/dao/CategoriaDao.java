package curso.miniapi.S4_MiniApi2.dao;

import java.util.ArrayList;
import java.util.List;



import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import curso.miniapi.S4_MiniApi2.modelos.Categoria;
import curso.miniapi.S4_MiniApi2.service.JPAUtil;

public class CategoriaDao {
	EntityManager manager = JPAUtil.getEntityManager();

	// guardar Categoria
	public void guardar(Categoria Categoria) {
		manager.getTransaction().begin();
		manager.persist(Categoria);
		manager.getTransaction().commit();		
	}

	// editar Categoria
	public void editar(Categoria Categoria) {
		manager.getTransaction().begin();
		manager.merge(Categoria);
		manager.getTransaction().commit();
	}

	// buscar Categoria
	public Categoria buscar(Long id) {
		
		Categoria c = manager.find(Categoria.class, id);
		return c;
	}

	/// eliminar Categoria
	public void eliminar(Long id) {
		Categoria c = manager.find(Categoria.class, id);
		manager.getTransaction().begin();
		manager.remove(c);
		manager.getTransaction().commit();
	}

	// obtener todos los Categoria
	public List<Categoria> obtenerCategorias() {
		List<Categoria> listaCategorias = new ArrayList<>();
		Query q = manager.createQuery("SELECT c FROM Categoria c");
		listaCategorias = (List<Categoria>) q.getResultList();
		return listaCategorias;
	}
}
