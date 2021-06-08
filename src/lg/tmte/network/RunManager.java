package lg.tmte.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class RunManager {
	public static void main(String[] args) {
		ServerSocket serverSocket;
		DataInputStream dis;
		DataOutputStream dos;
		InputStream is;
		OutputStream os;
		try {
			serverSocket = new ServerSocket(8080);
			while(true) {
				Socket socket = serverSocket.accept();
				System.out.println("Connected");
				is = socket.getInputStream();
				dis = new DataInputStream(is);
				Thread thread = new Thread(new MultiServer(socket,dis.readUTF()));
				thread.start();
				thread.join();
				os = socket.getOutputStream();
				dos = new DataOutputStream(os);
				dos.writeUTF("done");
				socket.close();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class MultiServer implements Runnable{
	
	Socket socket;
	String id;
	
	public MultiServer(Socket socket, String id) {
		this.socket = socket;
		this.id = id;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("I'm "+id);
	}
}
