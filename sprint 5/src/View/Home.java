package View;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Controller.AuthentificationController;
import Controller.PanelController;

/**
 * 
 * The Home class permit to create a "Home" window. <br>
 * This window is divided in several tabs : A first tab "Home" with an exit
 * button <br>
 * An other tab with the list of projects <br>
 * An other tab with the list of subjects <br>
 * An other tab with the list of tutors <br>
 * An other tab with the list of students <br>
 * A last tab "About..." with credits.<br>
 *
 * 
 * @author Group 1B2
 * @version Sprint 4 <br>
 */
public class Home extends JFrame {
	//é~~é~~é~~é~~é~~é~~é~~é~~é~~é~~é~~é~~é~~é~~é~~é~~é~~é~~é~~é~~é~~é~~é~~é~~
	private boolean onProduction = false;;
	//é~~é~~é~~é~~é~~é~~é~~é~~é~~é~~é~~é~~é~~é~~é~~é~~é~~é~~é~~é~~é~~é~~é~~é~~
	private JTabbedPane tabbedPane = new JTabbedPane();
	private String text = "This project (OPTI) has been realised by Matthieu Mothay, Clément Serrano,\n Héloïse Badaroux, Alexandre Bontems, Jean Bouyssou"
			+ " and Thomas Sauvage\n as part of "
			+ "IT S3 MPA module at Blagnac's IUT.\n Sprint 3.\n Université Toulouse 2";
	
	private JTextPane textPane = new JTextPane();

	private HomePage homePage = new HomePage(new AuthentificationController(), this);
	private JPanel page2 = new JPanel();
	private PanelSubject pageSubjects;
	public PanelStudent pageStudents;
	public PanelGroup pageGroups;
	private PanelProject pageProjects;
	private PanelIntervenant pageTutors;	
	private JPanel topPanel = new JPanel();

	public Home(PanelController intervenantController,
			PanelController projectController,
			PanelController studentController, PanelController groupController,
			PanelController subjectController,
			AuthentificationController authentificationController) {
		super("1B2 Sprint 3");
		
		
		PanelController[] tabController = { groupController,
			subjectController, intervenantController, projectController };
		
		this.pageTutors = new PanelIntervenant(this, intervenantController);
		this.pageSubjects = new PanelSubject(this, subjectController);
		this.pageStudents = new PanelStudent(this, studentController);
		this.pageGroups = new PanelGroup(this, groupController, projectController, subjectController);
		this.pageProjects = new PanelProject(this, projectController, tabController, pageGroups);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.setResizable(false);

		textPane.setText(text);
		textPane.setEditable(false);

		topPanel.setLayout(new BorderLayout());
		getContentPane().add(topPanel);

		page2.add(textPane);
		this.add(tabbedPane, BorderLayout.NORTH);

		this.createUI();

		topPanel.add(tabbedPane, BorderLayout.CENTER);

		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		if (onProduction) {
			this.removeTabs();
		}
		homePage.focus();
	}

	/**
	 * This method create tabs.
	 */
	private void createUI() {

		page2.add(textPane);

		tabbedPane.addTab("Home", homePage);
		tabbedPane.addTab("Projects", pageProjects);
		tabbedPane.addTab("Subjects", pageSubjects);
		tabbedPane.addTab("Students", pageStudents);
		tabbedPane.addTab("Groups", pageGroups);
		tabbedPane.addTab("Tutors", pageTutors);
		tabbedPane.addTab("About ...", page2);

	}

	private void removeTabs() {
		for (int i = 1; i < 6; i += 1) {
			tabbedPane.removeTabAt(1);
		}
	}
	
	protected void refactor() {
		for (int i = 1; i < tabbedPane.getTabCount(); i += 1) {
			tabbedPane.removeTabAt(0);
		}
		this.createUI();
	}

	/*
	 * /** The main method creates the window.
	 * 
	 * @param args Main arguments
	 */
	/*
	 * public static void main(String[] args) { new Home(); }
	 */

	public static class Builder {
		private PanelController i;
		private PanelController p;
		private PanelController st;
		private PanelController su;
		private PanelController g;
		private AuthentificationController a;

		public Builder intervenantController(PanelController c) {
			this.i = c;
			return this;
		}

		public Builder projectController(PanelController c) {
			this.p = c;
			return this;
		}

		public Builder studentController(PanelController c) {
			this.st = c;
			return this;
		}

		public Builder groupController(PanelController c) {
			this.g = c;
			return this;
		}

		public Builder subjectController(PanelController c) {
			this.su = c;
			return this;
		}
		
		public Builder authentificationController(AuthentificationController c) {
			this.a = c;
			return this;
		}

		public Home build() {
			return new Home(this.i, this.p, this.st, this.g, this.su, this.a);
		}
	}
}
