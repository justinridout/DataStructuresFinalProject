package views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DataStructures.LinkedList;
import DataStructures.Map;
import POJOs.Client;
import POJOs.Trainer;
import POJOs.TrainingClass;
import views.VerifiedTrainerMenu.ButtonListener;

public class VerifiedClientMenu extends JPanel{
	JButton btnRegister = new JButton("Register for a class");
	JButton btnMainMenu = new JButton("Main Menu");
	
	Map clients;
	LinkedList registered;
	List<Trainer> trainers;
	Client verified;
	
	public VerifiedClientMenu(Map clients, LinkedList registered, 
			List<Trainer> trainers, Client c) {
		
		this.trainers = trainers;
		this.clients = clients;
		this.registered = registered;
		this.verified = c;
		
		
		JLabel title = new JLabel("Please select an option from the menu");
		
		ButtonListener bl = new ButtonListener();
		btnMainMenu.addActionListener(bl);
		btnRegister.addActionListener(bl);
		
		JPanel buttons = new JPanel();

		setLayout(new BorderLayout());
		add(title, BorderLayout.NORTH);
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.PAGE_AXIS));
		
		buttons.add(btnRegister);
		buttons.add(btnMainMenu);
		
		add(buttons, BorderLayout.CENTER);
		
	}
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			JPanel panel = new JPanel();
			if (event.getSource() == btnMainMenu) {
				panel = new MainMenuPanel(clients, registered, trainers);
			} else if (event.getSource() == btnRegister) {
				panel = new SignUpPanel(clients, registered, trainers, verified);
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
