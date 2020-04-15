package views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
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

public class TrainerLogInPanel extends JPanel {

	JButton btnSubmit = new JButton("Login");
	JButton btnBack = new JButton("Back");
	private JTextField txtFirstName;
	private JTextField txtPassword;

	Map clients;
	LinkedList registered;
	List<TrainingClass> classes;
	List<Trainer> trainers;

	public TrainerLogInPanel(Map clients, LinkedList registered, List<TrainingClass> classes, List<Trainer> trainers) {

		this.clients = clients;
		this.registered = registered;
		this.classes = classes;
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
		
		JLabel title = new JLabel("Enter Login Information:");
		add(title, BorderLayout.NORTH);
		
		
		JLabel lblFirstName = new JLabel("First Name:");
		form.add(lblFirstName, "4, 4, right, default");
		txtFirstName = new JTextField();
		form.add(txtFirstName, "6, 4, fill, default");
		txtFirstName.setColumns(10);

		
		JLabel lblPassword = new JLabel("Enter Password (Case sensitive):");
		form.add(lblPassword, "4, 6, right, default");
		txtPassword = new JTextField();
		form.add(txtPassword, "6, 6, fill, default");
		txtPassword.setColumns(10);

		
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
				String firstName = txtFirstName.getText().toLowerCase();
				String password = txtPassword.getText();
				Trainer t;
				
				System.out.println(trainers.get(0));
				
				for(int i = 0; i < trainers.size(); i++) {
					t = trainers.get(i);
					
					if(t.getFirstName().toLowerCase().equals(firstName)) {
						if(t.getPassword().equals(password)) {
							panel = new VerifiedTrainerMenu(clients, registered, classes, trainers, t);
						}
						
						else {
							JOptionPane.showMessageDialog(null, "Password was incorrect");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "No Trainer in the system by that name");
					}
				}
				
				
			}
			else if (event.getSource() == btnBack) {
				panel = new TrainerMainMenuPanel(clients, registered, classes, trainers);
			}
			
			showNewPanel(panel);
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
