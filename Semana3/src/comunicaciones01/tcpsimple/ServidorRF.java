package comunicaciones01.tcpsimple;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ServidorRF {
	
	public static final String SALUDO = "Servidor esperando en puerto";
	public static final int TIMEOUT = 10000;
	public static final int PUERTO = 6000;
	
	private static ServerSocket serverSocket;
	
	public static void main(String[] args) throws IOException{
		serverSocket = new ServerSocket(PUERTO);
		serverSocket.setSoTimeout(TIMEOUT);
		while(true) { 
			try {
				System.out.println(SALUDO + serverSocket.getLocalPort() + "..."); //mostramos el puerto del socket
				Socket server = serverSocket.accept(); //Dejamos al servidor en escucha
				System.out.println("Conexión desde " + server.getRemoteSocketAddress());
				DataInputStream in = new DataInputStream(server.getInputStream()); //datos que llegan
				System.out.println(in.readUTF());
				DataOutputStream out = new DataOutputStream(server.getOutputStream()); //datos que envio
				out.writeUTF("Gracias por conectarte a " + server.getLocalSocketAddress() + "\nAdiosito!");
				server.close(); //cierro el servidor
				break;
			}catch(SocketTimeoutException e) {
				System.out.println("Socket timed out!");				
			}catch(IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}	
}
