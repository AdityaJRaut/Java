package utils;

import java.util.Scanner;

public class ScannerUtil {
	private static Scanner scanner = new Scanner(System.in);

	public static Scanner getScanner() {
		return scanner;
	}

	// created constructor private so that no instansiation is created
	private ScannerUtil() {
	}
}
