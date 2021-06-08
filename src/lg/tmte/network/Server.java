package lg.tmte.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private ServerSocket serverSocket;
	private Socket socket;
	private final int PORT = 8080;
	
	DataInputStream dis;
	DataOutputStream dos;
	InputStream is;
	OutputStream os;
	
	Server(){
		dos = null;
		dis = null;
		os = null;
		is = null;
		socket = null;
	}
	
	public void startServer() {
		try {
			serverSocket = new ServerSocket(PORT);
			while(true) {
				socket = serverSocket.accept();
				is = socket.getInputStream();
				dis = new DataInputStream(is);
				
				String input = dis.readUTF();
				System.out.println(input);
				
				os = socket.getOutputStream();
				dos = new DataOutputStream(os);
				dos.writeUTF(input+"1");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dis.close();
				is.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
//	public static void main(String[] args) {
//		new Server().startServer();
//	}
}
