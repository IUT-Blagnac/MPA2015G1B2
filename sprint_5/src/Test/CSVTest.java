package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import Model.Intervenant;
import Model.Modelisable;
import Model.Subject;
import Utilitaires.CSV;

/**Test JUnit for the CSV class.
 * @author Groupe 1B2
 * @version Sprint 4
 */
public class CSVTest extends TestCase {
	static String programmeATester = "CSV";
	Process executionProgrammeATester;
	BufferedReader ecranProgrammeATester;
	BufferedWriter clavierProgrammeATester;

	String finDeLigne = System.getProperty("line.separator");


	public static void main(String[] args) {
		if (args.length > 0) {
			programmeATester = args[0];
		}
		System.out.println("Tests du programme : " + programmeATester);
		junit.textui.TestRunner.run(new TestSuite(CSVTest.class));

	}

	protected void setUp() throws IOException {
		executionProgrammeATester = Runtime.getRuntime().exec(
				"java.exe -cp .;bin " + programmeATester);
		ecranProgrammeATester = new BufferedReader(new InputStreamReader(
				executionProgrammeATester.getInputStream()));
		clavierProgrammeATester = new BufferedWriter(new OutputStreamWriter(
				executionProgrammeATester.getOutputStream()));
	}

	public void test_write() {
		ArrayList<Modelisable> data = new ArrayList<Modelisable>();
		data.add(new Subject("this", "is", "a"));
		data.add(new Subject("test", "a", "ment"));

		try {
			CSV.write(data, "test.csv");

			Scanner scan = new Scanner(new File("test.csv"));
			String content = "";
			String expected = "this;is;atest;a;ment";
			while (scan.hasNextLine()) {
				content += scan.nextLine();
			}

			scan.close();
			assertEquals("Affiche : " + expected, expected, content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void test_read() throws Exception {
		ArrayList<Modelisable> data = new ArrayList<Modelisable>();
		data.add(new Subject("this", "is", "a"));
		data.add(new Subject("test", "a", "ment"));

		CSV.write(data, "test.csv");
		ArrayList<String[]> arrToTest = CSV.read("test.csv");

		String content = "";
		String expected = "thisisatestament";
		for (String[] entry : arrToTest) {
			for (int i = 0; i < entry.length; i++) {
				content += entry[i];
			}
		}

		assertEquals("Affiche : " + expected, expected, content);
	}
}
