package streams01;

import java.util.stream.Stream;

public class Iterate {

	public static void main(String[] args) {
		System.out.println("***** Impresion del 0 al 9 con Iterate");
		
		Stream.iterate(0,  n -> n + 1)
		.limit(10)
		.forEach(System.out::println);
	}
}
