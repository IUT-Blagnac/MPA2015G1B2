package View;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import Controller.PanelController;

/**
 * 
 * The CustomPanel is an abstract class used as a main pattern for the others
 * Panel. <br>
 * It is a view class that display a JTable containing data with a JScrollBar.
 * 
 * @author Groupe 1B2
 * @version Sprint 4 <br>
 */
public abstract class CustomPanel extends JPanel {

	protected DefaultTableModel model;
	protected JTable tableau;
	protected JButton add = new JButton("Add");
	protected JButton remove = new JButton("Remove");
	protected JButton save = new JButton("Save");
	protected JButton saveAs = new JButton("Save As ...");

	protected GridLayout grid = new GridLayout(5, 1);

	protected JPanel pantab = new JPanel();
	protected JPanel panLeft = new JPanel(new GridLayout(2, 1));
	protected JPanel panLeftCorner = new JPanel();
	protected JPanel panbut = new JPanel(grid);

	protected String[] title;
	protected String file;
	protected JFrame frame;
	protected JLabel checkLabel;

	protected static boolean finished = true;

	protected final PanelController controller;

	public CustomPanel() {
		throw new IllegalArgumentException("This constructor does not work");
	}

	/**
	 * This constructor create a JPanel which take as arguments a frame, a title
	 * and a controller.
	 * 
	 * @param frame
	 *            JFrame where the JPanel will be put
	 * @param title
	 *            JTable column's titles
	 * @param controller
	 *            Joins the view and the model
	 */
	public CustomPanel(JFrame frame, String[] title, PanelController controller) {
		super();

		this.file = file;
		this.title = title;
		this.frame = frame;

		this.controller = controller;

		// ArrayList<String[]> tmp = CSV.read(file);

		tableau = new JTable() {
			@Override
			public Component prepareRenderer(TableCellRenderer renderer,
					int row, int column) {
				Component component = super.prepareRenderer(renderer, row,
						column);
				int rendererWidth = component.getPreferredSize().width;
				TableColumn tableColumn = getColumnModel().getColumn(column);
				tableColumn.setPreferredWidth(Math.max(rendererWidth
						+ getIntercellSpacing().width,
						tableColumn.getPreferredWidth()));
				return component;
			}
		};
		
		// sort the tab
				tableau.setAutoCreateRowSorter(true);

		// tableau.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		class CustomTableModel extends DefaultTableModel {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column != 0;
			}
		}

		model = new CustomTableModel();

		model.setColumnIdentifiers(title);

		this.fillTable();

		model.addTableModelListener(new TableListener());

		tableau.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);

		tableau.setModel(model);

		this.add(pantab);
		this.add(panbut);

		// panLeft.add(panLeftCorner);
		// panLeft.add(panbut);

		pantab.add(new JScrollPane(tableau));

		panbut.setLayout(grid);
		grid.setVgap(10);
		this.addListeners();

		checkLabel = new JLabel(new ImageIcon("data/images/check.png"));

		// panbut.add(checkLabel);

		panbut.add(add);
		panbut.add(remove);
		panbut.add(save);
		panbut.add(saveAs);

	}

	protected void addListeners() {
		add.addActionListener(new AddListener());
		remove.addActionListener(new RemoveListener());
		save.addActionListener(new SaveListener());
		saveAs.addActionListener(new SaveAsListener());
	}

	public void fillTable() {
		int rowCount = model.getRowCount();
		if (rowCount > 0) {
			for (int i = model.getRowCount() - 1; i > -1; i--) {
				model.removeRow(i);
			}
		}
		for (int i = 1; i < controller.getData().size(); i++) {
			model.addRow(controller.getData().get(i).toArray());
		}
	}

	/**
	 * The AddListener class is an ActionListener.<br>
	 * It is associated to the Add Button which allows to add rows to the table.
	 */
	public class AddListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String id = controller.getNewID();

			model.addRow(new Object[] { id });

			controller.addDataById(id);
		}

	}

	public class SaveAsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			JFileChooser chooser = new JFileChooser();

			chooser.setDialogTitle("Please save your file");
			chooser.setFileFilter(new FileNameExtensionFilter("CSV files",
					"csv"));
			chooser.setSelectedFile(new File("my_csv_file.csv"));

			chooser.setCurrentDirectory(new File("My Exports" + File.separator));

			// Affichage et récupération de la réponse de l'utilisateur
			int answer = chooser.showDialog(chooser, "Enregistrer sous");

			if (answer == JFileChooser.APPROVE_OPTION) {

				String filepath = chooser.getSelectedFile().toString();

				controller.saveData(filepath);

			}

		}
	}

	/**
	 * The RemoveListener class is an ActionListener. It is associated to the
	 * Remove Button which allows to remove rows from the table.
	 */
	public class RemoveListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int[] tab;

			if (finished) {
				int result = JOptionPane.showConfirmDialog(frame,
						"Do you want to remove it ?");

				while ((tab = tableau.getSelectedRows()).length != 0
						&& result == JOptionPane.OK_OPTION) {
					model.removeRow(tab[0]);
					controller.removeByIndex(tab[0] + 1);
				}
			}
		}
	}

	/**
	 * The SaveListener class is an ActionListener. It is associated to the Save
	 * Button which allows to apply modifications made in the table to a CSV
	 * file.
	 */
	public class SaveListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			controller.saveData();
		}
	}

	/**
	 * The TableListener class is a TableModelListener. It updates the ArrayList
	 * according to the modifications made in the table.
	 */
	public class TableListener implements TableModelListener {

		@Override
		public void tableChanged(TableModelEvent arg0) { // TODO
			// Auto-generated method stub
			int row = tableau.getEditingRow();
			int column = tableau.getEditingColumn();

			System.out.println("Row selected : " + row + " Column selected : "
					+ column);
			
			
			if (row != -1 && column != -1) {
				controller.updateByIndex(row + 1, column,
						(String) model.getValueAt(row, column));
			}

		}

	}
	
	public JTable getTable(){
		return tableau;
	}
}
