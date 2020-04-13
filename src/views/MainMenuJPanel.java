package views;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuJPanel extends JPanel{
	
	JButton btnAddClient = new JButton("Add Client");
	JButton btnJoinClass = new JButton("Sign Up for Class");
	JButton btnShowClients = new JButton("Show All Clients");
	JButton btnShowRegisteredClients = new JButton("Show Registered Clients");


	public MainMenuJPanel() {
		JLabel title = new JLabel("Please select an option from the menu");
		
		ButtonListener bl = new ButtonListener();
		btnAddClient.addActionListener(bl);
		btnJoinClass.addActionListener(bl);
		btnShowClients.addActionListener(bl);
		btnShowRegisteredClients.addActionListener(bl);
		
		JPanel buttons = new JPanel();
		
		setLayout(new BorderLayout());
		add(title, BorderLayout.NORTH);
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.PAGE_AXIS));
		buttons.add(btnAddClient);
		buttons.add(btnJoinClass);
		buttons.add(btnShowClients);
		buttons.add(btnShowRegisteredClients);
		
		add(buttons, BorderLayout.CENTER);
		
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			JPanel panel = new JPanel();
			if(event.getSource() == btnAddClient) {
				panel = new AddClientPanel();
			}
			else if (event.getSource() == btnJoinClass) {
				panel = new JoinClassPanel();
			}
			else if (event.getSource() == btnShowClients) {
				panel = new ShowClientsPanel();
			}
			else if (event.getSource() == btnShowRegisteredClients) {
				panel = new ShowRegisterdPanel();
			}
			
			showNewPanel(panel);
		}
		
		public void showNewPanel(JPanel panel) {
			removeAll();
			setVisible(false);
			add(panel);
			validate();
			setVisible(true);
		}
		
	}
	
}
