package es.rf.curso.base;
//Calcula la suma de los 10 primeros numeros multiplos de 5
public class MultiplosDeCinco {
	public static void main(String[] args) {
		int num = 0, suma = 0, cont = 4;
		while(num<10) { //mi tope son 10 numeros
			cont++; //empiezo en 5 y voy mirando todos los siguientes numeros
			if(cont % 5 == 0) { //si son multiplos de cinco
				suma += cont; //lo sumo
				num++;
				System.out.println(cont);
			}			
		}
		System.out.println("total: " + suma);

	}

}
