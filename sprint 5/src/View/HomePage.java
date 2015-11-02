/**
 * 
 */
package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.AuthentificationController;

/**
 * JPanel for the Home frame launch tab
 * @author Groupe 1B2
 * @version Sprint 4
 */
public class HomePage extends JPanel {

	private JButton exit;
	private JTextField loginField;
	private JPasswordField passField;
	private JButton submit;
	private JPanel upperPanel;
	private JPanel littlePanel;
	private JPanel lowerPanel;
	private JPanel mediumPanel;
	private JLabel notifLabel;
	private ResetFieldKey resetListenerKey;
	private FocusListener focusListener;
	private Home home;
	AuthentificationController controller;

	/**
	 * Set the JPanel with the AuthentificationController
	 * Create the components of the JPanel
	 * @param controller Controller for the HomePage class
	 * @param home 
	 * 
	 */
	public HomePage(AuthentificationController controller, Home home) {

		this.controller = controller;
		this.home = home;
		this.setLayout(new GridLayout(3, 1));

		exit = new JButton("Exit");
		submit = new JButton("Connexion");
		
		loginField = new JTextField("Login");
		passField = new JPasswordField("Password");
		
		upperPanel = new JPanel(new BorderLayout());
		littlePanel = new JPanel(new FlowLayout());
		mediumPanel = new JPanel();
		lowerPanel = new JPanel();
		notifLabel = new JLabel("Please connect yourself");
		
		resetListenerKey = new ResetFieldKey();
		focusListener = new FocusListener();
		
		loginField.setPreferredSize(new Dimension(200, 30));
		passField.setPreferredSize(new Dimension(200, 30));

		this.createUI();
	}

	/**
	 * Add the components of the JPanel which have been created in the constructor
	 */
	private void createUI() {

		this.add(upperPanel);
		this.add(mediumPanel);
		this.add(lowerPanel);

		
		
		littlePanel.add(loginField);
		littlePanel.add(passField);
		littlePanel.add(submit);
			
		upperPanel.add(littlePanel,BorderLayout.SOUTH);
		
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String rights = controller.getRights(loginField.getText()
						+ "\\" + String.valueOf(passField.getPassword()));

				if (rights == null) {
					notifLabel.setText("Wrong login/password");
				} else if (rights.equals("admin")) {
					littlePanel.remove(loginField);
					littlePanel.remove(passField);
					littlePanel.remove(submit);
					notifLabel.setText("Hello, our dear admin ! You can now use the app through the different tabs");
					home.refactor();
				} else {
					notifLabel.setText("Hello !");
				}
			}
		});

		mediumPanel.add(notifLabel);
		
		loginField.addFocusListener(focusListener);
		loginField.addKeyListener(resetListenerKey);
		
		passField.addFocusListener(focusListener);
		passField.addKeyListener(resetListenerKey);


		lowerPanel.add(exit);
		
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	class ResetFieldKey extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode()==10) {
				submit.doClick();
			}
		}
	}
	
	class FocusListener extends FocusAdapter{
		public void focusGained(FocusEvent fEvt) {
		    JTextField tField = (JTextField)fEvt.getSource();
		    tField.selectAll();
		  }
	}

	public void focus() {
		loginField.requestFocusInWindow();
	}

}
