package views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
import POJOs.Client;
import POJOs.Registration;
import POJOs.Trainer;
import POJOs.TrainingClass;
import views.AddClientPanel.ButtonListener;

public class SignUpPanel extends JPanel {
	private JTextField txtStartDate;
	private JTextField txtEndDate;
	private JTextField txtGoal;
	private JTextField txtEmail;
	private JComboBox<?> trainingClassDropDown;
	
	// Add list to select trainer from

	JButton btnClear = new JButton("Clear");
	JButton btnSubmit = new JButton("Submit");
	JButton btnMainMenu = new JButton("Main Menu");

	Map clients;
	LinkedList RegClients;
	List<TrainingClass> trainingClasses;
	List<Trainer> trainers;

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnSubmit) {
				Client toAdd;
				Registration regToAdd;

				if (txtEmail.getText().equals("") || txtStartDate.getText().equals("") || txtEndDate.equals("")
						|| txtGoal.equals("")) {
					JOptionPane.showMessageDialog(null, "All input fields must be completed");
				} else {
					if (isValidDate(txtStartDate.getText()) && isValidDate(txtEndDate.getText())) {
						if (clients.keyExists(txtEmail.getText())) {
							if (trainingClassDropDown.getSelectedIndex() != -1) {
								TrainingClass t = trainingClasses.get(trainingClassDropDown.getSelectedIndex());
								toAdd = clients.getClient(txtEmail.getText());
								regToAdd = new Registration(toAdd, LocalDate.parse(txtStartDate.getText()),
										LocalDate.parse(txtEndDate.getText()), txtGoal.getText(), t);

								RegClients.insertion(regToAdd);

								removeAll();
								setVisible(false);
								ThankYouPanel newPanel = new ThankYouPanel(clients, RegClients, trainingClasses, trainers);
								add(newPanel);
								validate();
								setVisible(true);
								repaint();
								
							} else {
								JOptionPane.showMessageDialog(null, "Please select a Training Class");
							}

						} else {
							JOptionPane.showMessageDialog(null, "Nobody Registered Under that email, Please Register");

							removeAll();
							setVisible(false);
							AddClientPanel newPanel = new AddClientPanel(clients, RegClients, trainingClasses, trainers);
							add(newPanel);
							validate();
							setVisible(true);
							repaint();
						}
					} else {
						JOptionPane.showMessageDialog(null, "One of the date fields is not in correct format");
					}

				}
			}
			else if (e.getSource() == btnClear) {
				clearAllFields();

			} else if (e.getSource() == btnMainMenu) {

				removeAll();
				setVisible(false);
				ClientMainMenuPanel newPanel = new ClientMainMenuPanel(clients, RegClients, trainingClasses, trainers);
				add(newPanel);
				validate();
				setVisible(true);
				repaint();
			}
			
		}

		private void clearAllFields() {
			// TODO Auto-generated method stub
			txtEmail.setText("");
			txtStartDate.setText("");
			txtEndDate.setText("");
			txtGoal.setText("");
		}

	}

	public SignUpPanel(Map clients, LinkedList reg, List<TrainingClass> trainingClasses, List<Trainer> trainers) {

		this.clients = clients;
		this.RegClients = reg;
		this.trainingClasses = trainingClasses;
		this.trainers = trainers;

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

		JLabel lblEmail = new JLabel("Email you are signed up under");
		form.add(lblEmail, "4, 2, right, default");
		txtEmail = new JTextField();
		form.add(txtEmail, "6, 2, fill, default");
		txtEmail.setColumns(10);

		JLabel lblStartDate = new JLabel("Start Date (yyyy-mm-dd)");
		form.add(lblStartDate, "4, 4, right, default");
		txtStartDate = new JTextField();
		form.add(txtStartDate, "6, 4, fill, default");
		txtStartDate.setColumns(10);

		JLabel lblEndDate = new JLabel("End Date (yyyy-mm-dd)");
		form.add(lblEndDate, "4, 6, right, default");
		txtEndDate = new JTextField();
		form.add(txtEndDate, "6, 6, fill, default");
		txtEndDate.setColumns(10);

		JLabel lblGoal = new JLabel("Enter your goal");
		form.add(lblGoal, "4, 8, right, default");
		txtGoal = new JTextField();
		form.add(txtGoal, "6, 8, fill, default");
		txtGoal.setColumns(10);

		JLabel lblTrainingClass = new JLabel("Class");
		form.add(lblTrainingClass, "2, 10, right, default");
		trainingClassDropDown = new JComboBox(trainingClasses.toArray());
		form.add(trainingClassDropDown, "4, 10, 3, 1, fill, default");

		ButtonListener bl = new ButtonListener();

		btnSubmit.addActionListener(bl);
		btnClear.addActionListener(bl);
		btnMainMenu.addActionListener(bl);

		form.add(btnSubmit, "2, 14");
		form.add(btnClear, "4, 14");
		form.add(btnMainMenu, "6, 14");

		add(form, BorderLayout.CENTER);

	}

	public boolean isValidDate(String inDate) {

		if (inDate.length() != 10) {
			return false;
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(inDate.trim());
		} catch (ParseException pe) {
			return false;
		}
		return true;
	}
}
