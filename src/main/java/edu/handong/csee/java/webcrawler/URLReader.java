package edu.handong.csee.java.webcrawler;

import java.io.*;
import java.net.*;

public class URLReader {
	
	String path = "";
	String output = "";

	public URLReader(String path) {
		this.path = path;
	}

	public String getOutput() throws Exception{

		URL address = new URL(path);
		BufferedReader reader = new BufferedReader(new InputStreamReader(address.openStream()));

		String input = "";
		
		while ((input = reader.readLine()) != null) {
			output = output+input;
		}
		
		reader.close();

		return output;
	}
}
