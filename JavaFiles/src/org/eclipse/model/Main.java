package org.eclipse.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file = new File("fichier.txt");
		try {
			FileWriter fw = new FileWriter(file);
			fw.write("Hello world!\n");
			fw.write(86); // si pas de "" : prend en compte le code ascii
			fw.write('a');
//			BufferedWriter bw = new BufferedWriter(fw);
//			bw.newLine();
//			bw.write("Hello world, again");
//			bw.newLine();
//			bw.write("And happy new year");
//			bw.newLine();
//			bw.write("***");
//			bw.flush();
			fw.close();
			FileReader fr = new FileReader(file);
//			int str = fr.read();
//			while (str != -1) {
//				System.out.println(str);
//				System.out.println((char) str);
//				str=fr.read();
//			}
			BufferedReader br = new BufferedReader(fr);
//			String string = br.readLine();
//			while (string != null) {
//				System.out.println(string);
//				string = br.readLine();
//			}

			String string; // même chose, écrit plus simplement
			while ((string = br.readLine()) != null) {
				System.out.println(string);
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
