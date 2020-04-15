package views;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DataStructures.LinkedList;
import DataStructures.Map;
import POJOs.Trainer;
import POJOs.TrainingClass;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ClientMainMenuPanel extends JPanel{
	
	JButton btnAddClient = new JButton("Client Sign Up");
	JButton btnJoinClass = new JButton("Sign Up for Class");
	JButton btnBack = new JButton("Back");
	
	Map clients;
	LinkedList registered;
	List<TrainingClass> classes;
	List<Trainer> trainers;


	public ClientMainMenuPanel(Map clients, LinkedList registered, List<TrainingClass> classes, List<Trainer> trainers) {
		
		this.trainers = trainers;
		this.clients = clients;
		this.registered = registered;
		this.classes = classes;
		
		JLabel title = new JLabel("Please select an option from the menu");
		
		ButtonListener bl = new ButtonListener();
		btnAddClient.addActionListener(bl);
		btnJoinClass.addActionListener(bl);
		btnBack.addActionListener(bl);
		
		
		JPanel buttons = new JPanel();
		
		setLayout(new BorderLayout());
		add(title, BorderLayout.NORTH);
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.PAGE_AXIS));
		buttons.add(btnAddClient);
		buttons.add(btnJoinClass);
		buttons.add(btnBack);
		
		
		add(buttons, BorderLayout.CENTER);
		
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			JPanel panel = new JPanel();
			if(event.getSource() == btnAddClient) {
				panel = new AddClientPanel(clients, registered, classes, trainers);
			}
			else if (event.getSource() == btnJoinClass) {
				panel = new SignUpPanel(clients, registered, classes, trainers);
			}
			else if (event.getSource() == btnBack) {
				panel = new MainMenuPanel(clients, registered, classes, trainers);
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
