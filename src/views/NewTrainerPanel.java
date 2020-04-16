package views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import POJOs.Client;
import POJOs.Registration;
import POJOs.Trainer;
import POJOs.TrainingClass;
import views.SignUpPanel.ButtonListener;

public class NewTrainerPanel extends JPanel {
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtPassword;
	private JTextField txtPhoneNumber;
	
	JButton btnClear = new JButton("Clear");
	JButton btnSubmit = new JButton("Submit");
	JButton btnMainMenu = new JButton("Main Menu");
	
	Map clients;
	LinkedList RegClients;

	List<Trainer> trainers;

	public NewTrainerPanel(Map clients, LinkedList reg, List<Trainer> trainers) {
		
		this.clients = clients;
		this.RegClients = reg;

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

		JLabel title = new JLabel("Sign up to become a trainer!");
		add(title, BorderLayout.NORTH);
		
		JLabel lblFirstName = new JLabel("First Name");
		form.add(lblFirstName, "4, 2, right, default");
		txtFirstName = new JTextField();
		form.add(txtFirstName, "6, 2, fill, default");
		txtFirstName.setColumns(10);

		JLabel lblLastName = new JLabel("Last Name:");
		form.add(lblLastName, "4, 4, right, default");
		txtLastName = new JTextField();
		form.add(txtLastName, "6, 4, fill, default");
		txtLastName.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		form.add(lblPassword, "4, 6, right, default");
		txtPassword = new JTextField();
		form.add(txtPassword, "6, 6, fill, default");
		txtPassword.setColumns(10);

		JLabel lblPhone = new JLabel("Phone Number");
		form.add(lblPhone, "4, 8, right, default");
		txtPhoneNumber = new JTextField();
		form.add(txtPhoneNumber, "6, 8, fill, default");
		txtPhoneNumber.setColumns(10);
		
		ButtonListener bl = new ButtonListener();

		btnSubmit.addActionListener(bl);
		btnClear.addActionListener(bl);
		btnMainMenu.addActionListener(bl);

		form.add(btnSubmit, "2, 10");
		form.add(btnClear, "4, 10");
		form.add(btnMainMenu, "6, 12");

		add(form, BorderLayout.CENTER);

		
	}
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnSubmit) {
				Trainer toAdd;
				
				if (txtFirstName.getText().equals("") || txtLastName.getText().equals("") || txtPassword.equals("")
						|| txtPhoneNumber.equals("")) {
					JOptionPane.showMessageDialog(null, "All input fields must be completed");
				} 
				
				else if(containsDigit(txtFirstName.getText()) || containsDigit(txtLastName.getText())) {
					JOptionPane.showMessageDialog(null, "Your name can not contain a number");
				}
				else if(!validPhone(txtPhoneNumber.getText())) {
					JOptionPane.showMessageDialog(null, "Invalid Phone Number");
				}
				else {
					toAdd = new Trainer(txtFirstName.getText(), txtLastName.getText(), txtPassword.getText(), txtPhoneNumber.getText());
					trainers.add(toAdd);
					
					removeAll();
					setVisible(false);
					VerifiedTrainerMenu newPanel = new VerifiedTrainerMenu(clients, RegClients, trainers, toAdd);
					add(newPanel);
					validate();
					setVisible(true);
					repaint();
				}

				
			}
			else if (e.getSource() == btnClear) {
				clearAllFields();

			} else if (e.getSource() == btnMainMenu) {

				removeAll();
				setVisible(false);
				MainMenuPanel newPanel = new MainMenuPanel(clients, RegClients, trainers);
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
			txtPhoneNumber.setText("");
			txtPassword.setText("");
		}
		
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
		
		public boolean validPhone(String ph) {
			Pattern p = Pattern.compile("[0-9]{10}");
			Matcher m = p.matcher(ph);
			return (m.find() && m.group().equals(ph));
		}
		

	}
}
