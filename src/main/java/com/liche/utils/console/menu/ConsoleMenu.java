package com.liche.utils.console.menu;

import java.util.*;
import com.liche.utils.io.*;

public class ConsoleMenu {

	private List<String> options;
	
	public ConsoleMenu() {
		options=new ArrayList<>();
	}
	
	public void addOption(String text) {
		options.add(text);
	}

	public String run() {
		System.out.println("Introdueix una opció: ");
		
		for (int i=0; i<options.size(); i++) {
			System.out.print(i + "- " + options.get(i) + "\n");
		}
		
		int userOption = Input.readInt("", new Range(0, options.size()-1));
		return options.get(userOption);
	}
}
