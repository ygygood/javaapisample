package lg.tmte.thread;

public class ThreadTest {
	public static void main(String[] args) {
		
		RunnableThread r1 = new RunnableThread("Thread1");
		RunnableThread r2 = new RunnableThread("Thread2");
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		/*
		 *아래처럼 실행할 경우 출력이 순서대로 되지 않는다. 
		 * 
		 * */
		t1.start();
		t2.start();
		
	}
}


class RunnableThread implements Runnable{

//	private int cnt = 0;
	private String name = "";
	
	public RunnableThread(String name) {
		this.name = name;
	}
		
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<10; i++) {
			System.out.println("["+name+"]"+ i);
		}
	}
	
}
