package com.liche.utils.io;

import java.util.*;

public class Input {

	public static Scanner scanner = new Scanner(System.in);

	public static byte readByte(String message) {
		byte userByte = -1;
		boolean ok = false;

		do {
			System.out.println(message);

			try {
				userByte = scanner.nextByte();
				ok = true;
			} catch (InputMismatchException e) {
				System.out.println("Error de format: " + e);
			} finally {
				scanner.nextLine();
			}
		} while (!ok);

		return userByte;
	}

	public static int readInt(String message) {
		int userInt = -1;
		boolean ok = false;

		do {
			System.out.println(message);

			try {
				userInt = scanner.nextInt();
				ok = true;
			} catch (InputMismatchException e) {
				System.out.println("Error de format: " + e);
			} finally {
				scanner.nextLine();
			}
		} while (!ok);

		return userInt;
	}
	
	public static int readPositiveInt(String message) {
		int userInt = -1;

		do {
			userInt=readInt(message);
			
			if (userInt<=0) {
				System.out.println("El número ha de ser positiu.");
			}
		}
		while (userInt<=0);

		return userInt;
	}

	public static int readInt(String message, Range range) {
		int userInt;

		do {
			userInt = readInt(message);

			if (!range.contains(userInt)) {
				System.out.println("Fora de rang.");
			}

		} while (!range.contains(userInt));

		return userInt;
	}

	public static float readFloat(String message) {
		float userFloat = -1;
		boolean ok = false;

		do {
			System.out.println(message);

			try {
				userFloat = scanner.nextFloat();
				ok = true;
			} catch (InputMismatchException e) {
				System.out.println("Error de format: " + e);
			} finally {
				scanner.nextLine();
			}
		} while (!ok);

		return userFloat;
	}

	public static double readDouble(String message) {
		double userDouble = -1;
		boolean ok = false;

		do {
			System.out.println(message);

			try {
				userDouble = scanner.nextDouble();
				ok = true;
			} catch (InputMismatchException e) {
				System.out.println("Error de format: " + e);
			} finally {
				scanner.nextLine();
			}
		} while (!ok);

		return userDouble;
	}

	public static char readChar(String message) {
		char[] userCharArray = null;
		boolean ok = false;

		do {
			System.out.println(message);

			try {
				userCharArray = scanner.next().toCharArray();

				if (userCharArray.length == 1) {
					ok = true;
				} else {
					System.out.println("Error de format, Introdueix només un caràcter: ");
				}
			} catch (Exception e) {
				System.out.println("Error de format: " + e);
			} finally {
				scanner.nextLine();
			}
		} while (!ok);

		return userCharArray[0];
	}

	public static String readString(String message) {
		String userString = "";
		boolean ok = false;

		do {
			System.out.println(message);

			try {
				userString = scanner.nextLine();
				ok = true;
			} catch (Exception e) {
				System.out.println("Error de format: " + e);
			}
		} while (!ok);

		return userString;
	}

	public static boolean readYesNo(String message) {
		char userChar;
		boolean isYes = false;
		boolean ok = false;

		do {
			userChar = readChar(message);

			if (userChar == 's') {
				ok = true;
				isYes = true;
			} else if (userChar == 'n') {
				ok = true;
			}
		} while (!ok);

		return isYes;
	}

}
