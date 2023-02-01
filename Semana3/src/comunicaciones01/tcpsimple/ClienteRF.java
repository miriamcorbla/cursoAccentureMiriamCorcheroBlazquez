package comunicaciones01.tcpsimple;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.UnknownHostException;

public class ClienteRF {
	public static final int PUERTO = 443;
	public static final String DIRECCION = "www.recursosformacion.com";
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("Conectando a " + DIRECCION + " por puerto" + PUERTO); //mostrando por pantalla dir y port
		Socket client = new Socket(DIRECCION, PUERTO); //creo el socket cliente y enlazo con dir de server y port de server
		
		System.out.println("Conectado a " + client.getRemoteSocketAddress()); //muestro conectado a socket server
		OutputStream outToServer = client.getOutputStream(); //preparo la salida
		
		DataOutputStream out = new DataOutputStream(outToServer);
		out.writeUTF("Saluditos desde: " + client.getLocalSocketAddress()); //mensaje que quiero enviar
		
		InputStream inFromServer = client.getInputStream(); //Preparo la entrada
		DataInputStream in = new DataInputStream(inFromServer); //paso de input que son bytes a data
		int lectura = in.read();
		while(lectura != -1) {
			try {
				System.out.println(lectura); //imprimo lo que recibo
				lectura = in.read();			
			}catch(IOException e){
				e.printStackTrace();
				break;
				
			}
		}
		
		client.close();
	}
}
