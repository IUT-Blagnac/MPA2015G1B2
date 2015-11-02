package Utilitaires;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

import Model.Modelisable;

/**
 * Write/Read data in csv format.
 * @author Groupe 1B2
 * @version Sprint 4
 */
public class CSV {
	private static String separator = ";";
	/**
	 * Reads and returns all data entries contained in csv format at the specified filepath.
	 * @param filepath Path of the file to be read. 
	 * @return data ArrayList containing all read entries.
	 */
	public static ArrayList<String[]> read(String filepath) {
		
		ArrayList<String[]> res = new ArrayList<String[]>();
		
		try {			
			String line, lineParts[];
			BufferedReader reader = new BufferedReader(new FileReader(filepath));

			while((line = reader.readLine()) != null) {
				lineParts = line.split(CSV.separator, 6);
				res.add(lineParts);
			}
			
			reader.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	
		return res;
	}
	
	/**
	 * Writes all data contained in the ArrayList provided in the csv file found at the specified filepath. <br>
	 * Creates the file if necessary.
	 * @param data ArrayList of data to be written.
	 * @param filepath Path of the file to be written.
	 * @throws IOException Throw an IOException
	 */
	public static void write(ArrayList<Modelisable> data, String filepath) throws IOException {
		
		String content = "";
		File file = new File(filepath);
		
		if(!file.exists()) file.createNewFile();
		
		FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
		
		for(Modelisable entry : data) {
			String newline = entry.toCSV();
			content += newline + System.getProperty("line.separator");
		}
		
		fileWriter.write(content);
		fileWriter.close();
	}
}