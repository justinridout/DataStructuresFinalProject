package views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DataStructures.LinkedList;
import DataStructures.Map;
import POJOs.Trainer;
import POJOs.TrainingClass;
import views.AddClientPanel.ButtonListener;

public class ThankYouPanel extends JPanel{

	JButton btnMainMenu = new JButton("Main Menu");
	
	Map client;
	LinkedList RegClients;
	List<TrainingClass> trainingClasses;
	List<Trainer> trainers;
	
	public ThankYouPanel(Map clients, LinkedList reg, List<TrainingClass> trainingClasses, List<Trainer> trainers) {
		
		this.RegClients = reg;
		this.trainingClasses = trainingClasses;
		this.client = clients;
		this.trainers = trainers;
		
		JPanel panel = new JPanel();
		
		JLabel title = new JLabel("Information Submitted!");
		add(panel, BorderLayout.NORTH);
		

		ButtonListener bl = new ButtonListener();
		btnMainMenu.addActionListener(bl);
		
		panel.add(btnMainMenu, "6, 16");
		
		add(panel, BorderLayout.CENTER);

		
		
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			removeAll();
			ClientMainMenuPanel newPanel = new ClientMainMenuPanel(client, RegClients, trainingClasses, trainers);
			add(newPanel);
			validate();
			setVisible(true);
			repaint();
			
		}
		
		
	}
	
}
