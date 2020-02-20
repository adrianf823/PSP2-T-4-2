package Ejercicios_4_5;

import java.io.BufferedReader;
import java.io.IOException;

import org.apache.commons.net.pop3.POP3MessageInfo;
import org.apache.commons.net.pop3.POP3SClient;

public class Main {

	private static void RecuperarCabeceras(POP3MessageInfo[] men, POP3SClient pop3) throws IOException {
		for (int i = 0; i < men.length; i++) {
			System.out.println("Mensaje: "+(i+1));
			POP3MessageInfo msginfo=men[i];
			
			System.out.println("Cabecera del mensaje: ");
			BufferedReader reader=(BufferedReader) pop3.retrieveMessageTop(msginfo.number,0);
			String linea;
			while((linea=reader.readLine())!=null)
				System.out.println(linea.toString());
			reader.close();
		}
	}

	private static void RecuperarMensaje(POP3MessageInfo[] men, POP3SClient pop3) throws IOException {
		for (int i = 0; i < men.length; i++) {
			System.out.println("Mensaje: "+(i+1));
			POP3MessageInfo msginfo=men[i];
			
			System.out.println("Mensaje: ");
			BufferedReader reader=(BufferedReader) pop3.retrieveMessage(msginfo.number);
			String linea;
			while((linea=reader.readLine())!=null)
				System.out.println(linea.toString());
			reader.close();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String server="pop.gmail.com";
		String username="fralg100@gmail.com";
		String password="canoncien100";
		int puerto = 995;

		POP3SClient pop3=new POP3SClient(true);
		
		try {
			pop3.connect(server,puerto);
			System.out.println("Conexion realizada  al servidor POP3 "+server);
			
			if(!pop3.login(username, password))
				System.err.println("Error al hacer login");
			else {
				POP3MessageInfo[] men=pop3.listMessages();

				if(men==null)
					System.out.println("Imposible recuperar mensajes");
				else
					System.out.println("N de mensajes: "+men.length);

				System.out.println(pop3.getReplyString());

				RecuperarMensaje(men, pop3);
				pop3.logout();
			}
			pop3.disconnect();
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
		System.exit(0);
	}

}