package lg.tmte.thread;

import java.util.ArrayList;
import java.util.Random;

public class RunnableTest {
	public static void main(String[] args) {
		System.out.println("start main method");
		
		Runnable r = new ConcreteRunnable();
		ArrayList<Thread> threadList = new ArrayList<Thread>();
		
		for(int i=0; i<10; i++) {
			Thread test = new Thread(r);
			test.start();
			threadList.add(test);
		}
		
		for(Thread t : threadList) {
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	// 쓰레드 처리가 끝날떄 까지 기다림 
		}
		
		System.out.println("End main Method");
	}
}


class ConcreteRunnable implements Runnable{

	private int index = 0;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Random r = new Random(System.currentTimeMillis());
		
		long s = r.nextInt(3000);	// 3sec
		try {
			Thread.sleep(s);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		addIndex();
	}
	
	synchronized void addIndex() {
		index++;
		System.out.println("current index value : "+index);
	}
	
}
