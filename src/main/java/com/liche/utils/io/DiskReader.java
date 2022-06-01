package com.liche.utils.io;

import java.io.*;
import java.util.*;

public class DiskReader {

	private String fileName;

	public DiskReader(String fileName) {
		this.fileName = fileName;
	}

	public ArrayList<String[]> getCsvData() {
		ArrayList<String[]> csvArray = new ArrayList<String[]>();

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));) {

			ArrayList<String> lineList = new ArrayList<String>();
			String line;

			do {
				line = bufferedReader.readLine();

				if (line != null) {
					lineList.add(line);
				}

			} while (line != null);

			for (int i = 0; i < lineList.size(); i++) {
				csvArray.add(lineList.get(i).split(";"));
			}

		} catch (IOException e) {
			System.out.println("Error: " + e);
			;
		}

		return csvArray;
	}
}
