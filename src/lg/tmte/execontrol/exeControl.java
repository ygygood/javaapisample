package lg.tmte.execontrol;

import java.io.IOException;

public class exeControl {
	public static void main(String[] args) {
		String exec = "C:\\ERICK\\test.exe";
		String argument = "ABC";
		
		try {
			Process process = new ProcessBuilder(exec,argument).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
