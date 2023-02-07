package bbdd.ficheros.util;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class MontadorSQLTest {
	MontadorSQL montador;

	private static final String SALIDA = "country_id = 'NL',";
	private static final String NOMBRE_CAMPO = "country_id"; 
	private static final String VALOR_ID = "NL";
	private static final String SEPARADOR = ",";
	private static final String SALIDA1 = "";
	
	private static final String SALIDA_CONCATENA = "country_id = 'NL', country_name = 'NETHERLANDS',";
	private static final String NOMBRE_CAMPO2 = "country_name";
	private static final String VALOR_NAME = "NETHERLANDS";
	private static final String SEPARADOR2 = ",";
	
	private static final String SALIDA_CONCATENA_FINAL = "country_id = 'NL', country_name = 'NETHERLANDS', region_id = 2";
	private static final String NOMBRE_CAMPO3 = "region_id";
	private static final int VALOR_REGION = 2;
	private static final String SEPARADOR3 = "";
	
	private static final String SALIDA_D = "pro_precioProd = 5.54";
	private static final String NOMBRE_CAMPO_DOUBLE = "pro_precioProd"; 
	private static final double VALOR_DOUBLE = 5.54;
	private static final String SEPARADOR_DOUBLE = "";
	private static final String SALIDA_INCIAL = "";
	
	private static final String SALIDA_L = "pro_stockProd = 59736282";
	private static final String NOMBRE_CAMPO_LONG = "pro_stockProd"; 
	private static final long VALOR_LONG = 59736282;
	private static final String SEPARADOR_LONG = "";
	private static final String SALIDA_INCIAL_LONG = "";
	
	private static final String SALIDA_CAD_VACIA = "'PR', 'PRUEBA', 3";
	private static final String NOMBRE_CAMPO_VACIO = ""; 
	private static final String VALOR_PARA_NCVACIO = "PR";
	private static final String VALOR_PARA_NCVACIO2 = "PRUEBA";
	private static final int VALOR_PARA_NCVACIO3 = 3;
	private static final String SEPARADOR_VACIO = ",";
	private static final String SEPARADOR_VACIO2 = "";
	private static final String SALIDA_INICIAL_VACIO = "";
	
	@Test
	void testAddSalidaSencillaString() {
		assertEquals(SALIDA, MontadorSQL.addSalida(SALIDA1, NOMBRE_CAMPO, VALOR_ID, SEPARADOR));		
	}
	
	@Test
	void testAddSalidaSencillaDouble() {
		assertEquals(SALIDA_D, MontadorSQL.addSalida(SALIDA_INCIAL, NOMBRE_CAMPO_DOUBLE, VALOR_DOUBLE, SEPARADOR_DOUBLE));		
	}
	
	@Test
	void testAddSalidaSencillaLong() {
		assertEquals(SALIDA_L, MontadorSQL.addSalida(SALIDA_INCIAL_LONG, NOMBRE_CAMPO_LONG, VALOR_LONG, SEPARADOR_LONG));		
	}
	
	@Test
	void testAddSalidaSencillaVacio() {
		String salida = MontadorSQL.addSalida(SALIDA_INICIAL_VACIO, NOMBRE_CAMPO_VACIO, VALOR_PARA_NCVACIO, SEPARADOR_VACIO);
		salida = MontadorSQL.addSalida(salida, NOMBRE_CAMPO_VACIO, VALOR_PARA_NCVACIO2, SEPARADOR_VACIO);
		assertEquals(SALIDA_CAD_VACIA, MontadorSQL.addSalida(salida, NOMBRE_CAMPO_VACIO, VALOR_PARA_NCVACIO3, SEPARADOR_VACIO2));		
	}

	
	@Test
	void testAddSalidaSencillaConcatenacionString() {
		String salida = MontadorSQL.addSalida(SALIDA1, NOMBRE_CAMPO, VALOR_ID, SEPARADOR);
		assertEquals(SALIDA_CONCATENA, MontadorSQL.addSalida(salida, NOMBRE_CAMPO2, VALOR_NAME, SEPARADOR2));		
	}
	
	@Test
	void testAddSalidaSencillaConcatenacionFINAL() {
		String salida = MontadorSQL.addSalida(SALIDA1, NOMBRE_CAMPO, VALOR_ID, SEPARADOR);
		String salida2 = MontadorSQL.addSalida(salida, NOMBRE_CAMPO2, VALOR_NAME, SEPARADOR2);
		//Probamos concatenacion triple y tipo int
		assertEquals(SALIDA_CONCATENA_FINAL, MontadorSQL.addSalida(salida2, NOMBRE_CAMPO3, VALOR_REGION, SEPARADOR3));		
	}
}
