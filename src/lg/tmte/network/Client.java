package lg.tmte.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	
	private final String SERVER_IP = "127.0.0.1";
	private final int PORT = 8080;
	Socket socket;
	
	public void startClient() {
		
		InputStream is = null;
		OutputStream os = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		Scanner scan = new Scanner(System.in);
		try {
			
			while(true) {
				try {
					socket = new Socket(SERVER_IP,PORT);
					os = socket.getOutputStream();
					dos = new DataOutputStream(os);
					dos.writeUTF(scan.nextLine());
					
					is = socket.getInputStream();
					dis = new DataInputStream(is);
					
					System.out.println("server reply :"+dis.readUTF());
					
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					socket.close();
				}
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dos.close();
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
//	public void sendText(DataOutputStream dos) throws IOException {
//		
//		Scanner scan = new Scanner(System.in);
//		while(true) {
//			dos.writeUTF(scan.nextLine());
//		}
//	}
	
	
	public static void main(String[] args) {
		new Client().startClient();
	}
}
