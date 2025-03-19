package utils;

import java.util.Scanner;

public class ScannerUtil {
	private static Scanner scanner = new Scanner(System.in);

	//created constructor private so that no instansiation is created
	private ScannerUtil() {
	}

	public static Scanner getScanner() {
		return scanner;
	}
}
