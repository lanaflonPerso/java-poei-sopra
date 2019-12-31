package org.eclipse.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			FileWriter inputWriter = new FileWriter("input.txt");
			BufferedWriter bwInput = new BufferedWriter(inputWriter);
			bwInput.write("Bonjour");
			bwInput.newLine();
			bwInput.write("John Wick");
			bwInput.newLine();
			bwInput.write("Hello world");
			bwInput.newLine();
			bwInput.write("97");
			bwInput.close();
			inputWriter.close();

			FileReader inputReader = new FileReader("input.txt");
			BufferedReader brInput = new BufferedReader(inputReader);
			FileWriter outputWriter = new FileWriter("output.txt");
			BufferedWriter bwOutput = new BufferedWriter(outputWriter);

			String string;
			while ((string = brInput.readLine()) != null) {
				bwOutput.write(""+string.length());
				bwOutput.newLine();
			}
			
			bwOutput.close();
			outputWriter.close();
			brInput.close();
			inputReader.close();
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
