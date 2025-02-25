package FileHandling;

import java.io.FileWriter;
import java.io.IOException;

public class CreateFile {

	public static void main(String[] args) throws IOException {
//		FileWriter fileWriter=new FileWriter("Folder/file1.txt");
//		fileWriter.write("File Handling");
//		
//		fileWriter.close();
//		System.out.println("Data Written to File");
		
		
		FileWriter fileWriter=new FileWriter("Folder/file2.txt",true); //append mode
		fileWriter.append(" Mahendra Singh Dhoni");
		
		fileWriter.close();
		System.out.println("Data Written to File");
	}
}
