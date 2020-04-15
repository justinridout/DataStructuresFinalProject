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
import POJOs.Trainer;
import POJOs.TrainingClass;
import views.ClientMainMenuPanel.ButtonListener;

public class MainMenuPanel extends JPanel{

	private JButton btnClient = new JButton("Clients Click Here");
	private JButton btnTrainer = new JButton("Trainers Click Here");
	
	Map clients;
	LinkedList registered;
	List<TrainingClass> classes;
	List<Trainer> trainers;
	
	public MainMenuPanel(Map clients, LinkedList registered, List<TrainingClass> classes, List<Trainer> trainers) {
		
		this.clients = clients;
		this.registered = registered;
		this.classes = classes;
		this.trainers = trainers;
		
		JLabel title = new JLabel("Please select an option from the menu");
		
		ButtonListener bl = new ButtonListener();
		btnClient.addActionListener(bl);
		btnTrainer.addActionListener(bl);
		
		JPanel buttons = new JPanel();
		
		setLayout(new BorderLayout());
		add(title, BorderLayout.NORTH);
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.PAGE_AXIS));
		buttons.add(btnClient);
		buttons.add(btnTrainer);
		
		add(buttons, BorderLayout.CENTER);
	}
	
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			JPanel panel = new JPanel();
			if(event.getSource() == btnClient) {
				panel = new ClientMainMenuPanel(clients, registered, classes, trainers);
			}
			else if (event.getSource() == btnTrainer) {
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
