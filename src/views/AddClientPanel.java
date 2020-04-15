package views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DataStructures.LinkedList;
import DataStructures.Map;
import POJOs.Client;
import POJOs.Trainer;
import POJOs.TrainingClass;

public class AddClientPanel extends JPanel{

	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtAddress;
	private JTextField txtPhoneNumber;
	private JTextField txtEmail;
	
	JButton btnClear = new JButton("Clear");
	JButton btnSubmit = new JButton("Submit");
	JButton btnMainMenu = new JButton("Main Menu");
	
	Map client;
	LinkedList RegClients;
	List<TrainingClass> trainingClasses;
	List<Trainer> trainers;
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnSubmit) {
				Client toAdd;
				
				if(txtEmail.getText().equals("") || txtFirstName.getText().equals("") || txtLastName.equals("") || txtPhoneNumber.equals("") || txtAddress.equals("")) {
					JOptionPane.showMessageDialog(null, "All input fields must be completed");
				}
				else if(containsDigit(txtFirstName.getText()) || containsDigit(txtLastName.getText())) {
					JOptionPane.showMessageDialog(null, "Your name can not contain a number");
				}
				else {
					toAdd = new Client(txtFirstName.getText(), txtLastName.getText(), txtAddress.getText(), txtPhoneNumber.getText(), txtEmail.getText());
					client.insert(toAdd.getEmail(), toAdd);
					
					removeAll();
					ThankYouPanel newPanel = new ThankYouPanel(client, RegClients, trainingClasses, trainers);
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
				ClientMainMenuPanel newPanel = new ClientMainMenuPanel(client, RegClients, trainingClasses, trainers);
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
		
		//Checks if passed in string contains a number in it
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
		
		
	}
	
	public AddClientPanel(Map clients, LinkedList reg, List<TrainingClass> trainingClasses, List<Trainer> trainers) {
		
		this.RegClients = reg;
		this.trainingClasses = trainingClasses;
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
		
		ButtonListener bl = new ButtonListener();
		btnSubmit.addActionListener(bl);
		btnClear.addActionListener(bl);
		btnMainMenu.addActionListener(bl);

		form.add(btnSubmit, "6, 12");
		form.add(btnClear, "6, 14");

		add(form, BorderLayout.CENTER);

		form.add(btnMainMenu, "6, 16");
		
	}
	
	
	
	
}
