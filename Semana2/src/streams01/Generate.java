package streams01;

import java.util.Random;
import java.util.stream.Stream;

public class Generate {

	public static void main(String[] args) {
		Random rand = new Random();
		System.out.println("*** Usando Generate ***");
		Stream.generate(() -> rand.nextInt(100)).limit(20)
				.forEach(System.out::println);
	}

}
