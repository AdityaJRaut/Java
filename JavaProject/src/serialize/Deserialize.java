package serialize;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialize {

	public static void main(String[] args) throws IOException {
		Student s1 = null;
		FileInputStream fis=new FileInputStream("Folder/ser.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		try {
			s1=(Student)ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			
			e.printStackTrace();
		}
		System.out.println(s1.toString());
		ois.close();
		fis.close();

	}

}
