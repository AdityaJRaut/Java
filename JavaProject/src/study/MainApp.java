package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class AndhraPradesh extends Region {
	@Override
	public Flower yourNationalFlower() {
		return new Lily();
	}
}

//Complete the classes below
abstract class Flower {
	public abstract String whatsYourName();
}

class Jasmine extends Flower {

	@Override
	public String whatsYourName() {
		// TODO Auto-generated method stub
		return "Jasmine";
	}
}

class Lily extends Flower {

	@Override
	public String whatsYourName() {
		// TODO Auto-generated method stub
		return "Lily";
	}
}

public class MainApp {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine().trim();
		Region region = null;
		switch (s) {
		case "WestBengal":
			region = new WestBengal();
			break;
		case "AndhraPradesh":
			region = new AndhraPradesh();
			break;
		}
		Flower flower = region.yourNationalFlower();
		System.out.println(flower.whatsYourName());
	}
}

class Region {

	public Flower yourNationalFlower() {
		return null;
	}
}

class WestBengal extends Region {
	@Override
	public Flower yourNationalFlower() {
		return new Jasmine();
	}
}