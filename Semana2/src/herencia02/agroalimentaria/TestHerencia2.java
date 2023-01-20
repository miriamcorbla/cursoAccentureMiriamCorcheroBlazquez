package herencia02.agroalimentaria;

/**
 * Clase principal que instancia los objetos y
 * muestra el resultado
 * @author m.corchero.blazquez
 *
 */
public class TestHerencia2 {
	public static void main(String[] args) {
		ProductoFresco prod1 = new ProductoFresco();
		ProductoRefrigerado prod3 = new ProductoRefrigerado();
		CongeladoAgua prod4 = new CongeladoAgua();
		CongeladoAire prod5 = new CongeladoAire();
		
		//CARGA DE DATOS
		
		//Producto fresco
		prod1.setFechaCaducidad("04Nov23");
		prod1.setLote(234);
		prod1.setFechaEnvasado("03Enero22");
		prod1.setPaisOrigen("ESP");
		
		//ProductoRefrigerado
		prod3.setCodigoOrganismoSA(3532);
		prod3.setFechaCaducidad("04Nov24");
		prod3.setLote(1234);
		
		//Producto congelado agua
		prod4.setFechaCaducidad("04Nov25");
		prod4.setLote(12435);
		prod4.setTemperaturaRecomendada(03);
		prod4.setSalinidad(30);
		
		//Producto congelado Aire
		prod5.setDioxCarbono(20);
		prod5.setFechaCaducidad("03Nov26");
		prod5.setLote(1234);
		prod5.setNitrogeno(98);
		prod5.setOxigeno(0);
		prod5.setTemperaturaRecomendada(3);
		prod5.setVaporAgua(20);
		
		//MUESTRA RESULTADO
		prod1.mostrar();
		prod3.mostrar();
		prod4.mostrar();
		prod5.mostrar();
	}

}
