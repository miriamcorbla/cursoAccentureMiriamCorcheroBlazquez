package es.rf.curso.base;

public class Datos2 {
	static int dia = 10;
	static int nDni = 57443222;
	static double precio;
	static final boolean ACTIVO = true;
	
	public static void main(String[] args) {
		precio = 135.12;
		System.out.println("Dia\t"+dia+"\nDni\t"+nDni+
				"\nPrecio\t"+precio+"\nActivo?\t"+ACTIVO);
	}
}
