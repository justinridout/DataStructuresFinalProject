package views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import DataStructures.LinkedList;
import DataStructures.Map;
import POJOs.Trainer;
import POJOs.TrainingClass;

public class AddTrainingClassesPanel extends JPanel {

	private JTextField txtClassName;
	private JTextField txtClassDesc;

	JButton btnClear = new JButton("Clear");
	JButton btnSubmit = new JButton("Submit");
	JButton btnMainMenu = new JButton("Back");

	Map clients;
	LinkedList RegClients;
	List<Trainer> trainers;
	Trainer t;

	public AddTrainingClassesPanel(Map clients, LinkedList reg, List<Trainer> trainers, Trainer t) {
		this.clients = clients;
		this.RegClients = reg;
		this.trainers = trainers;
		this.t = t;

		JPanel form = new JPanel();

		form.setLayout(new FormLayout(
				new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default"), },
				new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, }));

		JLabel lblRegClient = new JLabel("Sign up for a Class!");
		add(lblRegClient, BorderLayout.NORTH);

		JLabel lblClassName = new JLabel("Training Class Name");
		form.add(lblClassName, "4, 2, right, default");
		txtClassName = new JTextField();
		form.add(txtClassName, "6, 2, fill, default");
		txtClassName.setColumns(10);

		JLabel lblClassDesc = new JLabel("Class Description");
		form.add(lblClassDesc, "4, 4, right, default");
		txtClassDesc = new JTextField();
		form.add(txtClassDesc, "6, 4, fill, default");
		txtClassDesc.setColumns(10);

		ButtonListener bl = new ButtonListener();

		btnSubmit.addActionListener(bl);
		btnClear.addActionListener(bl);
		btnMainMenu.addActionListener(bl);

		form.add(btnSubmit, "2, 14");
		form.add(btnClear, "4, 14");
		form.add(btnMainMenu, "6, 14");

		add(form, BorderLayout.CENTER);

	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnSubmit) {
				TrainingClass toAdd;

				if (txtClassName.getText().equals("") || txtClassDesc.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "All input fields must be completed");
				} else {
					toAdd = new TrainingClass(txtClassName.getText(), txtClassDesc.getText());
					t.addClass(toAdd);
					JOptionPane.showMessageDialog(null, "Information submitted!");
					removeAll();
					setVisible(false);
					VerifiedTrainerMenu newPanel = new VerifiedTrainerMenu(clients, RegClients, trainers, t);
					add(newPanel);
					validate();
					setVisible(true);
					repaint();

				}
			} else if (e.getSource() == btnClear) {
				clearAllFields();

			} else if (e.getSource() == btnMainMenu) {

				removeAll();
				setVisible(false);
				VerifiedTrainerMenu newPanel = new VerifiedTrainerMenu(clients, RegClients, trainers, t);
				add(newPanel);
				validate();
				setVisible(true);
				repaint();
			}

		}

		private void clearAllFields() {
			// TODO Auto-generated method stub
			txtClassName.setText("");
			txtClassDesc.setText("");
		}
	}

}
