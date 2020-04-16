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
import POJOs.Client;
import POJOs.Trainer;
import POJOs.TrainingClass;
import views.TrainerLogInPanel.ButtonListener;

public class ClientSignInPanel extends JPanel {
	JButton btnSubmit = new JButton("Login");
	JButton btnBack = new JButton("Back");
	private JTextField txtEmail;

	Map clients;
	LinkedList registered;
	List<Trainer> trainers;

	public ClientSignInPanel(Map clients, LinkedList registered, List<Trainer> trainers) {
		this.clients = clients;
		this.registered = registered;
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

		JLabel title = new JLabel("Enter the email you signed up with:");
		add(title, BorderLayout.NORTH);
		
		JLabel lblEmail = new JLabel("Email:");
		form.add(lblEmail, "4, 4, right, default");
		txtEmail = new JTextField();
		form.add(txtEmail, "6, 4, fill, default");
		txtEmail.setColumns(10);
		
		ButtonListener bl = new ButtonListener();
		btnSubmit.addActionListener(bl);
		btnBack.addActionListener(bl);
		

		form.add(btnSubmit, "6, 8");
		form.add(btnBack, "6, 10");
		
		add(form, BorderLayout.CENTER);
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			JPanel panel = new JPanel();
			if(event.getSource() == btnSubmit) {
				String email = txtEmail.getText().toLowerCase();
				
				Client c;
				
				if(clients.keyExists(email)) {
					c = clients.getClient(email);
					panel = new VerifiedClientMenu(clients, registered, trainers, c);
					showNewPanel(panel);
				}
				else {
					JOptionPane.showMessageDialog(null, "There is no user under that email");
				}
				
				
			}
			else if (event.getSource() == btnBack) {
				panel = new ClientMainMenuPanel(clients, registered, trainers);
				showNewPanel(panel);
			}
			
			
		}
		
		public void showNewPanel(JPanel panel) {
			removeAll();
			setVisible(false);
			add(panel);
			validate();
			setVisible(true);
			repaint();
		}
		
	}
}
