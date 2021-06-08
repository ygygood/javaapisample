package lg.tmte.filecontrol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class fileControl {

	String path = "";
	String inputFileName = "input.txt";
	String outputFileName = "output.txt";
	
	BufferedReader br;
	BufferedWriter bw;
	FileInputStream fis;
	FileOutputStream fos;
	
	public fileControl() {
		path = System.getProperty("user.dir");
	}
	
	public void start() {
//		readTextByLine();
//		readTextByBytes();
//		copyInputToOutput();
		copyFilesToOutput();
	}
	
	// read line from input.txt(BufferedReader)
	public void readTextByLine() {
		String dirPath = path;
		File[] files = new File(dirPath).listFiles();
		
		for(File dir : files) {
			if(dir.getName().contentEquals("input")) {						// find input folder
				File file = new File(dir.getAbsoluteFile()+"//"+inputFileName);			// find input file
				try {
					br =  new BufferedReader(new FileReader(file));
					String line = "";
					while((line = br.readLine()) != null) {
						System.out.println(line);
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
		}
	}
	
	// read bytes from input.txt (FileInputStream)
	public void readTextByBytes() {
		String dirPath = path;
		File[] files = new File(dirPath).listFiles();
//		byte[] buffer = new byte[256];
		int data;
		String result = "";
		
		for(File dir : files) {
			if(dir.getName().contentEquals("input")) {						// find input folder
				File file = new File(dir.getAbsoluteFile()+"//"+inputFileName);			// find input file
				try {
					fis = new FileInputStream(file);
					while((data = fis.read()) != -1) {
						result += String.valueOf((char)data);						// byte to string
					}
					System.out.println(result);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						fis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	
	
	//Quiz. input을 읽어서 output 파일로 copy
	public void copyInputToOutput() {
		
		String inputDir = path+"//input//";
		String outputDir = path+"//output//";
		
		File inputFile = new File(inputDir+inputFileName);
		File outputFile = new File(outputDir+outputFileName);
		
		int data = 0;
		
		try {
			fis = new FileInputStream(inputFile);
			fos = new FileOutputStream(outputFile);
			
			while((data = fis.read()) != -1) {
				fos.write(data);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
//		try {
//			// 1줄씩 복사
//			br = new BufferedReader(new FileReader(inputFile));
//			bw = new BufferedWriter(new FileWriter(outputFile));
//			
//			String line="";
//			while((line = br.readLine()) != null) {
//				bw.write(line);
//				bw.newLine();
//			}
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				bw.close();
//				br.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		
	}
	
	//Quiz02. quiz02_input 폴더에 있는 파일을 읽어서 quiz02_ouput 파일로 복사
	public void copyFilesToOutput() {
		FileInputStream fis=null;
		DataOutputStream dos=null;
		
		String inputPath = path+"//quiz02_input//";
		String outputPath = path+"//quiz02_output//";
		
		File inputFilePath = new File(inputPath);
		
		File[] inputFiles = inputFilePath.listFiles();
		for(File file : inputFiles) {
			String fileName = file.getName();
			File tempFile;
			try {
				fis = new FileInputStream(file);
				tempFile = new File(outputPath+fileName);
				if(!tempFile.exists())	tempFile.createNewFile();
				dos = new DataOutputStream(new FileOutputStream(tempFile));
				int data=0;
				while((data = fis.read())!= -1) {
					dos.write((char)data);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					dos.close();
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	
	public static void main(String[] args) {
		new fileControl().start();
		System.exit(0);
	}
}
