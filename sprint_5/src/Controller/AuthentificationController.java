package Controller;

import java.math.BigInteger;
import java.util.ArrayList;

import Utilitaires.CSV;

/**
 * Controller class for the user authentification.
 * Reads the existing users and login from the .pass file.
 * @author Groupe 1B2
 * @version Sprint 4
 */
public class AuthentificationController {

	/**
	 * Constructor for the AuthentificationController class
	 */
	public AuthentificationController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Return an entry String into a crypted String
	 * @param arg String that will be crypted
	 * @return The crypted String
	 */
	public String toHex(String arg) {
		return String.format("%040x", new BigInteger(1, arg.getBytes()));
	}

	/**
	 * Define the rights that the user will have.
	 * For now it does nothing but displays a message depending on your authentification.
	 * @param input Contains the login and the password from the user
	 * @return The rights that are attributed to the user
	 */
	public String getRights(String input) {

		ArrayList<String[]> file = CSV.read("data/pass.pass");

		String user = input.split("\\\\")[0];
		String pass = input.split("\\\\")[1];

		for (String[] cursor : file) {
			if (cursor[0].equals(user) && cursor[1].equals(pass)) {
				return cursor[2];
			}
		}
		return null;
	}

}
