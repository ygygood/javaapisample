package lg.tmte.thread;

import java.util.Scanner;

public class ThreadController {
	public static void main(String[] args) {
		Runnable th1 = new AddThread();
		Thread thread = new Thread(th1);
		thread.start();
		System.out.println("end");
	}	
}


class AddThread implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("I'm Thread");
		}
	}
	
}
