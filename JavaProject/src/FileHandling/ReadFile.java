package FileHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("Folder/file1.txt");
		BufferedReader br = new BufferedReader(fr);
		String buffer;
		buffer = br.readLine();
		System.out.println(buffer);
		br.close();
		fr.close();

	}

}
