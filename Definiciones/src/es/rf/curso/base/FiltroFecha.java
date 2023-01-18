package es.rf.curso.base;

public class FiltroFecha {
	public static Boolean esCorrectoV1(int dia, int mes, int anio) {
		return ((dia>=1 && dia<=30) && (mes>=1 && mes<=12) && (anio>=0 && anio<=2023));
	}
	
	public static Boolean esCorrectoV2(int dia, int mes, int anio) {
		int dias = 0;
		switch(mes) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			dias = 31;
			break;
		case 2: 
			dias = 28;
			break;
		case 4: case 6: case 9:
			dias = 30;
			break;
		}
		return ((dia>=1 && dia<=dias) && (mes>=1 && mes<=12) && (anio>=0 && anio<=2023));
	}
	
	public static Boolean esCorrectoV3(int dia, int mes, int anio) {
		int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int dias = diasMes[mes-1];
		return ((dia>=1 && dia<=dias) && (mes>=1 && mes<=12) && (anio>=0 && anio<=2023));	
	}
	
	public static Boolean esCorrectoV4(int dia, int mes, int anio) {
		//Cualquier año divisible por 4 es un año bisiesto: 29 días
		int diasBisiesto = 28;
		if(mes == 2) {
			if(((anio % 4) == 0) && ((anio%100)!= 0)) {
				System.out.println("Es bisiesto");
				diasBisiesto = 29;
			}else {
				System.out.println("No es bisiesto");
			}
		}
		int[] diasMes = {31, diasBisiesto, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int dias = diasMes[mes-1];	
		return ((dia>=1 && dia<=dias) && (mes>=1 && mes<=12) && (anio>=0 && anio<=2023));	
	}
	
	public static void main(String[] args) {
		int dia = 31, mes = 8, anio = 2015;
		System.out.println("¿Es la fecha correcta?");
		
		//PRIMERA VERSION - ASMIENDO MESES DE 30 DIAS
		System.out.println("**********");
		System.out.println("Version 1");
		System.out.println(esCorrectoV1(dia, mes, anio));
		
		//SEGUNDA VERSION - DIAS REALES SIN ARRAYS
		System.out.println("**********");
		System.out.println("Version 2");
		System.out.println(esCorrectoV2(dia, mes, anio));
		
		//TERCERA VERSION - DIAS REALES CON ARRAYS
		System.out.println("**********");
		System.out.println("Version 3");
		System.out.println(esCorrectoV3(dia, mes, anio));
		
		//CUARTA VERSION - DIAS REALES CON BISIESTOS
		System.out.println("**********");
		System.out.println("Version 4");
		System.out.println(esCorrectoV4(dia, mes, anio));
	}

}
