package curso.miniapi.S4_MiniApi2;

import java.util.List;

import curso.miniapi.S4_MiniApi2.controller.CountryController;
import curso.miniapi.S4_MiniApi2.modelos.Country;

/**
 * Clase principal que contiene el método main
 * @author m.corchero.blazquez
 *
 */
public class App {
	
	private static final String ID = "DE";
	
    /**
     * Lista los paises
     * @param countries
     */
	public static void listar(List<Country> countries) {
		countries.stream().forEach(System.out::println);
	}

	
	
    public static void main( String[] args ) throws Exception {
    	CountryController cCtr = new CountryController();
    	listar(cCtr.leerTodos());
    	
    	System.out.println("**************************");
    	
    	System.out.println(cCtr.leerUno(ID));
    	
    	System.out.println("**************************");
    	
    	Country datos = cCtr.leerUno(ID);
    	datos.setCountry_name("Modificado");    	
    	cCtr.actualizar(datos); 	
    	
    	System.out.println("**************************");
    	System.out.println(cCtr.leerUno(ID));
    	
    	System.out.println("**************************");
    	
    	Country countryElim = cCtr.leerUno(ID);
    	cCtr.eliminar(countryElim);
    	
    	System.out.println("**************************");
    	Country counInsert = new Country();
    	counInsert.setCountry_id("PH");
    	counInsert.setCountry_name("PRUEBAHIBERNATE");
    	counInsert.setRegion_id(5);
    	cCtr.insertar(counInsert);	   	
    	
    }

}
