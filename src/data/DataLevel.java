package data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DataLevel {

	public static void writer(String datos,String file) {
		File f;
		f = new File(file);

		// Escritura
		try {
			FileWriter w = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(w);
			PrintWriter wr = new PrintWriter(bw);
			wr.write(datos);
			wr.close();
			bw.close();
		} catch (IOException e) {
		}

	}

	public static String read(String name) {
		
		//Lectura
		
		String line = "";
		File doc = new File(name);
		Scanner obj;
		try {
			obj = new Scanner(doc);
			while (obj.hasNextLine())
				line = obj.nextLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return line;
	}

}
