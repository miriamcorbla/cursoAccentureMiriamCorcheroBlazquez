package es.rf.tienda.dominio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.rf.tienda.exception.DomainException;

/**
 * Clase prueba para dominio Categoria
 * @author m.corchero.blazquez
 * @version Feb2023
 *
 */
class CategoriaTest {
	
	Categoria categoria;
	static final int CAT_ID_AUTO = 1;
	static final int CAT_ID_CORRECTO = 9;
	static final int CAT_INCORR = -8;
	static final String NOMBRE_CORRECTO = "Nombre";
	static final String NOMBRE_INCORRECTO = "No";
	static final String DESCR_CORRECTO = "Descripcion categoria";
	

	@BeforeEach
	void inicio() throws DomainException {
		creacion();
	}
	
	@Test
	void creacion() throws DomainException {
		categoria = new Categoria();
	}

	/**
	 * Test que comprueba que el id de la categoria es autoincremental
	 * @throws DomainException 
	 */
	@BeforeAll
	static void testGetId_categoriaAuto() throws DomainException {
		Categoria categoria = new Categoria();
		assertEquals(CAT_ID_AUTO, categoria.getId_categoria());
	}
	
	/**
	 * Comprueba que tanto el set como el get funcionan correctamente
	 * al añadir un id de categoria correcto
	 * @throws DomainException 
	 */
	@Test
	void testGetId_categoria() throws DomainException{
		categoria.setId_categoria(CAT_ID_CORRECTO);
		assertEquals(CAT_ID_CORRECTO, categoria.getId_categoria());
	}
		
	
	/**
	 * Comprueba que tanto el set como el get funcionan correctamente
	 * al añadir un nombre correcto
	 * @throws DomainException 
	 */
	@Test
	void testGetCat_nombre() throws DomainException {
		categoria.setCat_nombre(NOMBRE_CORRECTO);
		assertEquals(NOMBRE_CORRECTO, categoria.getCat_nombre());
	}
	
	/**
	 * Comprueban que se lanza una excepción al introducir un nombre
	 * incorrecto 
	 */
	@Test
	void testGetCat_nombreError(){
		assertThrows(DomainException.class,
	            () -> { categoria.setCat_nombre(NOMBRE_INCORRECTO);});
	}


	@Test
	void testGetCat_descripcion() throws DomainException {
		categoria.setCat_descripcion(DESCR_CORRECTO);
		assertEquals(DESCR_CORRECTO, categoria.getCat_descripcion());
	}

}
