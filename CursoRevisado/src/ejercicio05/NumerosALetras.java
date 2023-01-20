package ejercicio05;

/**
 * Clase que convierte de numeros a letras
 * @author m.corchero.blazquez
 * @version 1.2
 */
public class NumerosALetras {
	//Hacer una clase que convierta de números a letras, definiendo num=72. Podéis hacer una primera version en donde 
	//los números del 11 al 15 salgan como diez y 
	//uno, diez y dos…. y una segunda version corregida.
	//72 = setenta y dos
	public static String convertirVerisonSwitch(int num) {
		String numero = String.valueOf(num);
		char[] digitos = numero.toCharArray();
		String nombre = "";
		switch(digitos[0]) {
		case '1': if(digitos[1] == '0') {
			nombre += "diez";
		}else {
			if(digitos[1] == '1') {
				nombre += "once";
			}else {
				nombre += "dieci";
			}
		}
			break;
		case '2': if(digitos[1] == '0') {
			nombre += "veinte";
		}else {
			nombre += "veinti";
		}
			break;
		case '3': nombre += "treinta";
			break;
		case '4': nombre += "cuarenta";
			break;
		case '5': nombre += "cincuenta";
			break;
		case '6': nombre += "sesenta";
			break;
		case '7': nombre += "setenta";
			break;
		case '8': nombre += "ochenta";
			break;
		case '9': nombre += "noventa";
			break;
		}
		nombre+=" y ";
		switch(digitos[1]) {
		case '0': if(digitos[0]!= '2' || digitos[0]!= '1') {
			nombre += "ta";
		}
			break;
		case '1': if(digitos[0] != '1') {
			nombre += "ta y uno";
		}
			break;
		case '2': nombre += "dos";
			break;
		case '3': nombre += "tres";
			break;
		case '4': nombre += "cuatro";
			break;
		case '5': nombre += "cinco";
			break;
		case '6': nombre += "seis";
			break;
		case '7': nombre += "siete";
			break;
		case '8': nombre += "ocho";
			break;
		case '9': nombre += "nueve";
			break;
		}
		return nombre;
	}
	public static void versionFinal (int num) {
		String[] parte1 = {"", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez", "once",
				"doce", "trece", "ctorce", "quince"};
		String[] parte2 = {"", "diez", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa"};
		int unidades;
		int decenas;
		unidades = num % 10;
		decenas = num / 10;
		String mensaje= "";
		if(num > 0) {
			if (num< 16) {
				mensaje = parte1[num];
			}else {
				mensaje = parte2[decenas];
				if(unidades>0) {
					mensaje += " y ";
					if(decenas == 2) {
						mensaje = "veinti";
					}
					if(decenas == 1) {
						mensaje = "dieci";
					}
					mensaje += parte1[unidades];
				}				
			}
		}
		System.out.println(mensaje);
	}
	
	
	public static void main(String[] args) {
		int num = 22;
		System.out.println("El numero es: " + convertirVerisonSwitch(num));
		versionFinal(num);
	}

}
