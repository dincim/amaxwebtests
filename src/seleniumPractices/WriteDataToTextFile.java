package seleniumPractices;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteDataToTextFile {

	public static void main(String[] args) throws IOException {
		
		String fileName ="out.txt";
		
		try {
			
			PrintWriter outputStream = new PrintWriter(fileName);
			outputStream.println("Hi there file!");
			outputStream.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		FileWriter fw = new FileWriter("C:\\SeleniumPractice\\Test123.txt");
		
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write("Hello World ");
		bw.write("123");
		bw.close();

	}

}
