package edu.n3.exercise_1;

import java.io.*;
import com.liche.utils.io.Input;

public class App {

	public static void main(String[] args) {
		App app = new App();
		app.launch();
	}

	private void launch() {
		
		encrypt("src//main//resources//llistat.txt", "src//main//resources//llistat.aes");
		encrypt("src//main//resources//iu.properties", "src//main//resources//iu.aes");
		encrypt("src//main//resources//persona.ser", "src//main//resources//persona.aes");
		
		decrypt("src//main//resources//llistat.aes", "src//main//resources//llistat2.txt");
		decrypt("src//main//resources//iu.aes", "src//main//resources//iu2.properties");
		decrypt("src//main//resources//persona.aes", "src//main//resources//persona2.ser");


	}

	private void encrypt(String originFileName, String encryptedFileName) {
		String originFile = getFile(originFileName);
		String encryptedFile="";
		
		try {
			encryptedFile = AES.encrypt(originFile, Input.readString("Introduïu la contrasenya per xifrar " + originFileName + ": "));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		createFile(encryptedFileName, encryptedFile);
		System.out.println("Xifrat a " + encryptedFileName + ".");
	}

	private void decrypt(String encryptedFileName, String finalFileName) {
		
		String encryptedFile = getFile(encryptedFileName);
		String finalFile="";
		
		try {
			finalFile = AES.decrypt(encryptedFile, Input.readString("Introduïu la contrasenya per desxifrar " + encryptedFileName + ": "));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		createFile(finalFileName, finalFile);
		System.out.println("Desxifrat  a " + finalFileName + ".");
	}

	private String getFile(String fileName) {
		String archive = "";
		int intByte;

		try (FileInputStream fileInputStream = new FileInputStream(fileName)) {

			while ((intByte=fileInputStream.read())!=-1) {
				archive+=(char)intByte;
			}
		
		} catch (Exception e) {
			e.getStackTrace();
		}

		return archive;
	}

	private void createFile(String fileName, String data) {
		byte[] byteArray = data.getBytes();

		try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
			fileOutputStream.write(byteArray);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
