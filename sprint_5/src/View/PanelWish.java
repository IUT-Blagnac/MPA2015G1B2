package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Controller.PanelController;

/**
 * 
 * The PanelSubject is a class used to display a list of Subjects by Id,a name and a title. <br>
 * @see CustomPanel
 *
 * 
 * @author Groupe 1B2
 * @version Sprint 4 <br>
 */


public class PanelWish extends CustomPanel {
	
	public PanelWish(final JFrame frame, PanelController controller) {
		super(frame, new String[] {"id", "sujet","titre","ordre"}, controller);
		
		panbut.remove(remove);
		panbut.remove(add);
		
		class CustomTableModel extends DefaultTableModel {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column == 3;
			}
		}
		
		model = new CustomTableModel();

		model.setColumnIdentifiers(title);

		for (int i = 1; i < controller.getData().size(); i++) {
			model.addRow(controller.getData().get(i).toArray());
		}

		model.addTableModelListener(new TableListener());

		tableau.setModel(model);
		
		TableColumn wishColumn = tableau.getColumnModel().getColumn(3);
		
		final JComboBox<String> wishCombo = new JComboBox<String>();
		
		for(int i=1;i<=controller.getData().size();i++){
			wishCombo.addItem(""+i);
		}
		
		wishCombo.addItem("");
		
		wishCombo.setSelectedItem("");
		
		wishColumn.setCellEditor(new DefaultCellEditor(wishCombo));
		
		wishCombo.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!wishCombo.getSelectedItem().equals("")){
					for(int i =0; i<tableau.getRowCount();i++){
						if(wishCombo.getSelectedItem().equals(tableau.getValueAt(i,3))){
							JOptionPane.showConfirmDialog(frame, "This rank has already been attributed to another subject", "Error", JOptionPane.PLAIN_MESSAGE);
							wishCombo.setSelectedItem("");
							return;
						}
					}
				}
				
			}
		});

	}

	
}