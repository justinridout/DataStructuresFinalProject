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
	JButton btnLogin = new JButton("Client Login");
	JButton btnBack = new JButton("Back");
	
	Map clients;
	LinkedList registered;
	List<Trainer> trainers;


	public ClientMainMenuPanel(Map clients, LinkedList registered,  List<Trainer> trainers) {
		
		this.trainers = trainers;
		this.clients = clients;
		this.registered = registered;
		
		
		JLabel title = new JLabel("Please select an option from the menu");
		
		ButtonListener bl = new ButtonListener();
		btnAddClient.addActionListener(bl);
		btnLogin.addActionListener(bl);
		btnBack.addActionListener(bl);
		
		
		JPanel buttons = new JPanel();
		
		setLayout(new BorderLayout());
		add(title, BorderLayout.NORTH);
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.PAGE_AXIS));
		buttons.add(btnAddClient);
		buttons.add(btnLogin);
		buttons.add(btnBack);
		
		
		add(buttons, BorderLayout.CENTER);
		
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			JPanel panel = new JPanel();
			if(event.getSource() == btnAddClient) {
				panel = new AddClientPanel(clients, registered,trainers);
			}
			else if (event.getSource() == btnLogin) {
				panel = new ClientSignInPanel(clients, registered, trainers);
			}
			else if (event.getSource() == btnBack) {
				panel = new MainMenuPanel(clients, registered, trainers);
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
