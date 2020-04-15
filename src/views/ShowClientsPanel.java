package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import DataStructures.LinkedList;
import DataStructures.Map;
import POJOs.Client;
import POJOs.Registration;
import POJOs.Trainer;
import POJOs.TrainingClass;
import views.SignUpPanel.ButtonListener;

public class ShowClientsPanel extends JPanel {
	
	JButton btnMainMenu = new JButton("Back");
	JButton btnViewClient = new JButton("View Client Details");

	Map clients;
	LinkedList RegClients;
	List<TrainingClass> trainingClasses;
	List<Trainer> trainers;
	Trainer verified;
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == btnMainMenu) {
				removeAll();
				setVisible(false);
				VerifiedTrainerMenu newPanel = new VerifiedTrainerMenu(clients, RegClients, trainingClasses, trainers, verified);
				add(newPanel);
				validate();
				setVisible(true);
				repaint();
			}
		}

	}
	
	public ShowClientsPanel(Map clients, LinkedList reg, List<TrainingClass> trainingClasses, List<Trainer> trainers, Trainer t) {
		this.clients = clients;
		this.RegClients = reg;
		this.trainingClasses = trainingClasses;
		this.trainers = trainers;
		this.verified = t;
		
		Client[] arrayClients = clients.toArray();
		
		JPanel clientsView = new JPanel();
		
		JLabel lblRegClient = new JLabel("All clients in the system");
		add(lblRegClient, BorderLayout.NORTH);
		
		JList list = new JList(arrayClients);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setVisibleRowCount(-1);
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(120, 140));
		add(listScroller);
		
		btnViewClient.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(list.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null, "Please select a name from the list");
					
				}
				else {
					Client c = arrayClients[list.getSelectedIndex()];
					JOptionPane.showMessageDialog(clientsView, "First Name: " + c.getFirstName() + " Last Name: " + c.getLastName()
					+"\n Address " + c.getAddress() + "\n Phone: " + c.getPhoneNumber() + " Email: " + c.getEmail()); 
				}
			}
			
		});
		
		ButtonListener bl = new ButtonListener();
		btnMainMenu.addActionListener(bl);
		
		clientsView.add(btnMainMenu, "6, 14");
		clientsView.add(btnViewClient, "6, 12");
		
		add(clientsView, BorderLayout.CENTER);
	}
}
