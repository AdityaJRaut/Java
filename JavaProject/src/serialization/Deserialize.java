package serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialize {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		Student s1=null;
		FileInputStream fis=new FileInputStream("Folder/ser.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		s1=(Student)ois.readObject();
		System.out.println(s1.toString());
		ois.close();
		fis.close();

	}

}
