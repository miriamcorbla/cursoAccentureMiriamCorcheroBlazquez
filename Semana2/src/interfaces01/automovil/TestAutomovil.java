package interfaces01.automovil;

import java.util.ArrayList;

public class TestAutomovil {
	
	public static void main(String[] args) {
		ArrayList<Automovil> automoviles = new ArrayList<>();
		automoviles.add(new Camion(16, 240, 00123, 8, 200000, 70000));
		automoviles.add(new Coche(5, 200, 01234, 4, "rojo", 4, "Renault"));
		automoviles.add(new Moto(6, 240, 1233, 2, 40));
		
		for(Automovil a : automoviles) {
			System.out.println(a.anuncio());
			if (a instanceof Coche) {
				((Coche) a).activarReductora(true);
			}
		}	
	}

}
