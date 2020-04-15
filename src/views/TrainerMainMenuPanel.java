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

public class TrainerMainMenuPanel extends JPanel {

	JButton btnNewTrainer = new JButton("New Trainer");
	JButton btnExistingTrainer = new JButton("ExistingTrainer");
	JButton btnBack = new JButton("Back");

	Map clients;
	LinkedList registered;
	List<TrainingClass> classes;
	List<Trainer> trainers;
	
	
	public TrainerMainMenuPanel(Map clients, LinkedList registered, List<TrainingClass> classes, List<Trainer> trainers) {

		this.clients = clients;
		this.registered = registered;
		this.classes = classes;
		this.trainers = trainers;

		JLabel title = new JLabel("Please select an option from the menu");

		ButtonListener bl = new ButtonListener();
		btnNewTrainer.addActionListener(bl);
		btnExistingTrainer.addActionListener(bl);
		btnBack.addActionListener(bl);

		JPanel buttons = new JPanel();

		setLayout(new BorderLayout());
		add(title, BorderLayout.NORTH);
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.PAGE_AXIS));
		buttons.add(btnNewTrainer);
		buttons.add(btnExistingTrainer);
		buttons.add(btnBack);
		
		add(buttons, BorderLayout.CENTER);
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			JPanel panel = new JPanel();
			if(event.getSource() == btnNewTrainer) {
				panel = new NewTrainerPanel(clients, registered, classes, trainers);
			}
			else if (event.getSource() == btnExistingTrainer) {
				panel = new TrainerLogInPanel(clients, registered, classes, trainers);
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
