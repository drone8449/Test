package edu.handong.csee.java.webcrawler;

import java.io.*;

public class FileWriter {

	String filename = "";
	String output = "";
	
	public FileWriter(String filename, String output) {
		this.filename = filename;
		this.output = output;
	}
	
	public void getOutput() {
		
		PrintWriter writer = null;

		try {
			writer = new PrintWriter(filename);
			writer.write(output + "\n");
		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		writer.close();
	}
}
