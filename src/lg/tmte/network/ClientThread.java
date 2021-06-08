package lg.tmte.network;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientThread {
	
//	Runnable r1 = new RunnableThread("Thread1");
//	Runnable r2 = new RunnableThread("Thread2");
//	
//	Thread t1 = new Thread(r1);
//	Thread t2 = new Thread(r2);
	
	/*
	 * Bus Info Arr
	 * */
	
	public void start() {
		
		String[] bus01Arr = {"40","50","88","98","145"};
		String[] bus02Arr = {"30","54","78","128","133"};
		String[] bus03Arr = {"20","22","45","87","100"};

		Runnable r1 = new ClientServer("127.0.0.1",8089,"BUS01",bus01Arr);
		Runnable r2 = new ClientServer("127.0.0.1",8089,"BUS02",bus02Arr);
		Runnable r3 = new ClientServer("127.0.0.1",8089,"BUS03",bus03Arr);
		
	}
	
	public static void main(String[] args) {
		new ClientThread().start();
	}
}


class ClientServer implements Runnable{

	String SERVERIP = "";
	int PORT;
	String busName = "";
	Socket socket = null;
	String[] arr = null;
	
	DataOutputStream dos = null;
	OutputStream os = null;
	
	public ClientServer(String SERVERIP, int PORT, String busName,String[] arr) {
		this.SERVERIP = SERVERIP;
		this.PORT = PORT;
		this.busName = busName;
		this.arr = arr;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true) {
				socket = new Socket(SERVERIP,PORT);
				os = socket.getOutputStream();
				dos = new DataOutputStream(os);
				/* 파일을 읽어서 버스번호가 맞는 것만 계속 보낸다. */
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}


class Bus implements Comparable<Bus>{
	String name;
	String location;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
	public Bus(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}

	@Override
	public String toString() {
		return "Bus [name=" + name + ", location=" + location + "]";
	}

	@Override
	public int compareTo(Bus o) {
		// TODO Auto-generated method stub
		return o.getLocation().compareTo(this.getLocation()) >= 0 ? -1 : 1;
	}
}