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

public class VerifiedTrainerMenu extends JPanel {

	JButton btnShowClients = new JButton("Show Your Clients");
	JButton btnShowRegisteredClients = new JButton("Show Your Registered Clients");
	JButton btnAddTrainingClass = new JButton("Add new class");
	JButton btnViewClasses = new JButton("View Your Classes");
	JButton btnMainMenu = new JButton("Main Menu");

	Map clients;
	LinkedList registered;
	List<TrainingClass> classes;
	List<Trainer> trainers;
	Trainer verified;

	public VerifiedTrainerMenu(Map clients, LinkedList registered, List<TrainingClass> classes,
			List<Trainer> trainers, Trainer t) {
		this.trainers = trainers;
		this.clients = clients;
		this.registered = registered;
		this.classes = classes;
		this.verified = t;

		JLabel title = new JLabel("Please select an option from the menu");

		ButtonListener bl = new ButtonListener();
		btnMainMenu.addActionListener(bl);
		btnShowClients.addActionListener(bl);
		btnShowRegisteredClients.addActionListener(bl);
		btnAddTrainingClass.addActionListener(bl);
		btnViewClasses.addActionListener(bl);

		JPanel buttons = new JPanel();

		setLayout(new BorderLayout());
		add(title, BorderLayout.NORTH);
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.PAGE_AXIS));
		
		
		buttons.add(btnShowClients);
		buttons.add(btnShowRegisteredClients);
		buttons.add(btnAddTrainingClass);
		buttons.add(btnViewClasses);
		buttons.add(btnMainMenu);

		add(buttons, BorderLayout.CENTER);
	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			JPanel panel = new JPanel();
			if (event.getSource() == btnMainMenu) {
				panel = new MainMenuPanel(clients, registered, classes, trainers);
			} else if (event.getSource() == btnShowClients) {
				panel = new ShowClientsPanel(clients, registered, classes, trainers, verified);
			} else if (event.getSource() == btnShowRegisteredClients) {
				panel = new ShowRegisteredClientsPanel(clients, registered, classes, trainers, verified);
			}else if(event.getSource() == btnAddTrainingClass) {
				panel = new AddTrainingClassesPanel(clients, registered, classes, trainers, verified);
			}else if(event.getSource() == btnViewClasses) {
				panel = new ViewTrainingClassesPanel(clients, registered, classes, trainers, verified);
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
