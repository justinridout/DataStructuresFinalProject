package views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DataStructures.LinkedList;
import DataStructures.Map;
import POJOs.Client;
import POJOs.Trainer;
import POJOs.TrainingClass;

public class AddClientPanel extends JPanel {

	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtAddress;
	private JTextField txtPhoneNumber;
	private JTextField txtEmail;
	private JComboBox<?> trainersDropDown;

	JButton btnClear = new JButton("Clear");
	JButton btnSubmit = new JButton("Submit");
	JButton btnMainMenu = new JButton("Main Menu");

	Map client;
	LinkedList RegClients;
	
	List<Trainer> trainers;

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnSubmit) {
				Client toAdd;

				if (txtEmail.getText().equals("") || txtFirstName.getText().equals("") || txtLastName.equals("")
						|| txtPhoneNumber.equals("") || txtAddress.equals("")) {
					JOptionPane.showMessageDialog(null, "All input fields must be completed");
				} else if (containsDigit(txtFirstName.getText()) || containsDigit(txtLastName.getText())) {
					JOptionPane.showMessageDialog(null, "Your name can not contain a number");
				} else if (!validEmail(txtEmail.getText())) {
					JOptionPane.showMessageDialog(null, "Email is not in correct format");
				} else if (!validPhone(txtPhoneNumber.getText())) {
					JOptionPane.showMessageDialog(null, "Phone Number is not in correct format");
				} else {
					Trainer t = trainers.get(trainersDropDown.getSelectedIndex());
					
					System.out.println(trainers.get(trainersDropDown.getSelectedIndex()));
					
					toAdd = new Client(txtFirstName.getText(), txtLastName.getText(), txtAddress.getText(),
							txtPhoneNumber.getText(), txtEmail.getText(), t);
					client.insert(toAdd.getEmail(), toAdd);
					JOptionPane.showMessageDialog(null, "Thank you for joining. Please register for a class now");

					removeAll();
					setVisible(false);
					VerifiedClientMenu newPanel = new VerifiedClientMenu(client, RegClients, trainers, toAdd);
					add(newPanel);
					validate();
					setVisible(true);
					repaint();
				}

			} else if (e.getSource() == btnClear) {
				clearAllFields();

			} else if (e.getSource() == btnMainMenu) {

				removeAll();
				ClientMainMenuPanel newPanel = new ClientMainMenuPanel(client, RegClients, trainers);
				add(newPanel);
				validate();
				setVisible(true);
				repaint();
			}

		}

		private void clearAllFields() {
			// TODO Auto-generated method stub
			txtFirstName.setText("");
			txtLastName.setText("");
			txtEmail.setText("");
			txtPhoneNumber.setText("");
			txtAddress.setText("");
		}

		// Checks if passed in string contains a number in it
		public final boolean containsDigit(String s) {
			boolean containsDigit = false;

			if (s != null && !s.isEmpty()) {
				for (char c : s.toCharArray()) {
					if (containsDigit = Character.isDigit(c)) {
						break;
					}
				}
			}

			return containsDigit;
		}

		public boolean validEmail(String email) {
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
					+ "A-Z]{2,7}$";

			Pattern pat = Pattern.compile(emailRegex);
			if (email == null)
				return false;
			return pat.matcher(email).matches();
		}

		public boolean validPhone(String ph) {
			Pattern p = Pattern.compile("[0-9]{10}");
			Matcher m = p.matcher(ph);
			return (m.find() && m.group().equals(ph));
		}
	}

	public AddClientPanel(Map clients, LinkedList reg, List<Trainer> trainers) {

		this.RegClients = reg;
		this.client = clients;
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

		JLabel lblAddClient = new JLabel("Add your imformation for being a client");
		add(lblAddClient, BorderLayout.NORTH);

		JLabel lblFirstName = new JLabel("First Name");
		form.add(lblFirstName, "4, 2, right, default");
		txtFirstName = new JTextField();
		form.add(txtFirstName, "6, 2, fill, default");
		txtFirstName.setColumns(10);

		JLabel lblLastName = new JLabel("Last Name");
		form.add(lblLastName, "4, 4, right, default");
		txtLastName = new JTextField();
		form.add(txtLastName, "6, 4, fill, default");
		txtLastName.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		form.add(lblEmail, "4, 6, right, default");
		txtEmail = new JTextField();
		form.add(txtEmail, "6, 6, fill, default");
		txtEmail.setColumns(10);

		JLabel lblAddress = new JLabel("Address");
		form.add(lblAddress, "4, 8, right, default");
		txtAddress = new JTextField();
		form.add(txtAddress, "6, 8, fill, default");
		txtAddress.setColumns(10);

		JLabel lblPhoneNumber = new JLabel("Phone Number");
		form.add(lblPhoneNumber, "4, 10, right, default");
		txtPhoneNumber = new JTextField();
		form.add(txtPhoneNumber, "6, 10, fill, default");
		txtPhoneNumber.setColumns(10);

		JLabel lblTrainingClass = new JLabel("Choose your Trainer");
		form.add(lblTrainingClass, "2, 12, right, default");
		trainersDropDown = new JComboBox(trainers.toArray());
		form.add(trainersDropDown, "4, 12, 3, 1, fill, default");

		ButtonListener bl = new ButtonListener();
		btnSubmit.addActionListener(bl);
		btnClear.addActionListener(bl);
		btnMainMenu.addActionListener(bl);

		form.add(btnSubmit, "2, 14");
		form.add(btnClear, "4, 14");

		add(form, BorderLayout.CENTER);

		form.add(btnMainMenu, "6, 14");

	}

}
