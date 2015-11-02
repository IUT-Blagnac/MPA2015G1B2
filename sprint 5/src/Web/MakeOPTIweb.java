package Web;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import Utilitaires.CSV;

public class MakeOPTIweb {

	private static final String path = "data/web/";

	public static void main(String[] args) {

		System.setProperty("file.encoding", "UTF-8");

		String head = loadFile(path + "head.html");
		String tail = loadFile(path + "tail.html");
		
		String credits = loadFile(path + "credits.html");

		String acceuil = loadFile(path + "acceuil.html");

		String headProjets = loadFile(path + "head_projets.html");
		String tailProjets = loadFile(path + "tail_projets.html");

		String headSujets = loadFile(path + "head_sujets.html");
		String tailSujets = loadFile(path + "tail_sujets.html");

		String headEtudiants = loadFile(path + "head_etudiants.html");
		String tailEtudiants = loadFile(path + "tail_etudiants.html");

		String headIntervenants = loadFile(path + "head_intervenants.html");
		String tailIntervenants = loadFile(path + "tail_intervenants.html");

		ArrayList<String[]> projects = CSV.read("data/projets2014_2015.csv");
		ArrayList<String[]> subjects = CSV.read("data/sujets2014_2015.csv");
		ArrayList<String[]> students = CSV.read("data/etudiants2014_2015.csv");
		ArrayList<String[]> supervisors = CSV
				.read("data/intervenants2014_2015.csv");

		String str = "";
		String item = "";
		int i = 0;
		for (String[] cursor : projects) {

			if (i == 0) {
				i = 1;
				continue;
			}

			str += "<li>\n<p>\n<b>[" + getContent(cursor[2], subjects, 1, 0)
					+ "]</b> " + getContent(cursor[2], subjects, 2, 0);

			str += "</p>\n<p>\n<b>Client :</b> "
					+ getContent(cursor[3], supervisors, 2, 0) + " "
					+ getContent(cursor[3], supervisors, 1, 0);

			str += "</p>\n<p>\n<b>Superviseur :</b> "
					+ getContent(cursor[4], supervisors, 2, 0) + " "
					+ getContent(cursor[4], supervisors, 1, 0);

			str += "</p>\n<p>\n<b>Groupe " + cursor[1] + " :</b> ";

			String[] prenoms = getContents(cursor[1], students, 3, 0)
					.split("/");
			String[] noms = getContents(cursor[1], students, 2, 0).split("/");
			int cpt = 0;
			boolean passed = false;
			while (cpt < prenoms.length) {
				if (passed) {
					str += " - ";
				}
				str += prenoms[cpt] + " " + noms[cpt];
				passed = true;
				cpt += 1;
			}
			str += "</p>\n</li>";
		}

		String contentProjects = str;

		str = "";
		item = "";
		i = 0;
		for (String[] cursor : subjects) {

			if (i == 0) {
				i = 1;
				continue;
			}

			str += "<li data-find=\"[" + cursor[1] + "]\">";

			str += "<a href=\"#projets\">[" + cursor[1] + "]<br/>";

			str += "<div style=\"white-space:normal;\">\n<span><b>" + cursor[2]
					+ "</b>";

			str += "</span><span class=\"ui-li-count\">"
					+ getContent(cursor[0], projects, 1, 2)
					+ "</span>\n</div>\n\n</a>\n</li>";

		}

		String contentSujets = str;

		str = "";
		item = "";
		i = 0;
		for (String[] cursor : students) {

			if (i == 0) {
				i = 1;
				continue;
			}

			str += "<li data-find=\"" + cursor[3] + " " + cursor[2] + "\">";

			str += "<a href=\"#projets\">" + cursor[2] + " " + cursor[3]
					+ "<span class=\"ui-li-count\" title=\"Groupe\">Groupe "
					+ cursor[0] + "</span>\n</a>\n</li>";

		}

		String contentEtudiants = str;

		str = "";
		item = "";
		i = 0;
		for (String[] cursor : supervisors) {

			if (i == 0) {
				i = 1;
				continue;
			}

			str += "<li data-find=\"" + cursor[2] + " " + cursor[1]
					+ "\">\n<a href=\"#projets\">";
			str += cursor[2] + " " + cursor[1];
			str += "<span class=\"ui-li-count\" style=\"right: 120px !important;\" title=\"Client\">";
			int n = count(cursor[0], projects, 3);
			str += String.valueOf(n)
					+ "</span>\n<span class=\"ui-li-count\" title=\"Superviseur\">";
			n = count(cursor[0], projects, 4);
			str += String.valueOf(n) + "</span>\n</a>\n</li>";
		}

		String contentIntervenants = str;

		try

		{
			String html = "";
			FileWriter fw = new FileWriter("OPTIweb/test/index.html");

			html += head;

			html += acceuil;
			
			html += credits;

			html += headProjets;
			html += contentProjects;
			html += tailProjets;

			html += headSujets;
			html += contentSujets;
			html += tailSujets;

			html += headEtudiants;
			html += contentEtudiants;
			html += tailEtudiants;

			html += headIntervenants;
			html += contentIntervenants;
			html += tailIntervenants;

			html += tail;

			fw.write(html);

			fw.close();
		} catch (IOException exception) {
			System.out
					.println("An error occurred please contact the administrator : "
							+ exception.getMessage());
		}

	}

	private static int count(String id, ArrayList<String[]> data, int idId) {

		int somme = 0;

		for (String[] cursor : data) {
			if (cursor[idId].equals(id)) {
				somme += 1;
			}
		}

		return somme;
	}

	private static String getContent(String id, ArrayList<String[]> data,
			int idContent, int idId) {
		String item = "";
		boolean passed = false;
		for (String[] cursor : data) {
			if (cursor[idId].equals(id)) {
				if (passed) {
					item += " - ";
				}
				item += cursor[idContent];
				passed = true;
			}
		}

		return item;
	}

	private static String getContents(String id, ArrayList<String[]> data,
			int idContent, int idId) {
		String item = "";
		boolean passed = false;
		for (String[] cursor : data) {
			if (cursor[idId].equals(id)) {
				if (passed) {
					item += "/";
				}
				item += cursor[idContent];
				passed = true;
			}
		}

		return item;
	}

	private static String loadFile(String filepath) {

		String str = "";

		try {

			BufferedReader in = new BufferedReader(new InputStreamReader(
					new FileInputStream(filepath), "UTF8"));

			String ligne;

			while ((ligne = in.readLine()) != null) {
				str += ligne + "\n";
			}

			in.close();

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}

		return str;
	}
}
