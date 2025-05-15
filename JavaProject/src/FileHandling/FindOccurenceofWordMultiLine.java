package FileHandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FindOccurenceofWordMultiLine {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		FileReader fr = new FileReader("Folder/file1.txt");
		BufferedReader br = new BufferedReader(fr);
		Scanner sc = new Scanner(System.in);
		String buffer;
		buffer = br.readLine();
		System.out.println("Enter search String");
		String search = sc.next();
		int index = buffer.indexOf(search);
		System.out.println(search + " found at index " + index);
		sc.close();
		br.close();
		fr.close();

	}

}
