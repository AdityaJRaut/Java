package serialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialize {

	public static void main(String[] args) throws IOException {
		Student s1 = new Student(1, "Aditya", 31);
		FileOutputStream fos = new FileOutputStream("Folder/ser.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s1);
		System.out.println("Object Written");
		oos.close();
		fos.close();
	}

}
