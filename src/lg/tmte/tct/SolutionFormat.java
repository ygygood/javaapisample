package lg.tmte.tct;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class SolutionFormat {
	
	final String inputPath = "INFILE\\";
	final String locationFileName = "LOCATION.TXT";
	
	HashMap<String,Bus> busMap;
	
	
	public void start() {
		
		busMap = new HashMap<String,Bus>();
		
	// get inputs
		getInfos() ;
		print();
		
	}
	
	public void getInfos() {
		
		BufferedReader br = null;
		StringTokenizer stk;
		
		try {
			br = new BufferedReader(new FileReader(new File(inputPath+locationFileName)));
			String line = "";
			while((line=br.readLine()) != null) {
				System.out.println("line:"+line);
				stk = new StringTokenizer(line,"#");
				String time = stk.nextToken();
				if(time.equals("PRINT")) {
					break;
				}else {
					while(stk.hasMoreElements()) {
						String temp = stk.nextToken();
						System.out.println(temp);
						busMap.put(temp.split(",")[0],new Bus(temp.split(",")[0],temp.split(",")[1]));
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void print() {
		Iterator itr = busMap.keySet().iterator();
		while(itr.hasNext()) {
			String key = (String)itr.next();
			System.out.println(busMap.get(key).toString());
		}
	}
	
	public static void main(String[] args) {
		new SolutionFormat().start();
	}
}

class Bus{
	String name = "";
	String location = "";
	
	public Bus(String name, String location) {
		this.name = name;
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Bus [name=" + name + ", location=" + location + "]";
	}
}
