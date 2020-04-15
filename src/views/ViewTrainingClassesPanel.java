package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import DataStructures.LinkedList;
import DataStructures.Map;
import POJOs.Trainer;
import POJOs.TrainingClass;
import views.ShowRegisteredClientsPanel.ButtonListener;

public class ViewTrainingClassesPanel extends JPanel {

	JButton btnBack = new JButton("Back");

	Map clients;
	LinkedList RegClients;
	List<TrainingClass> trainingClasses;
	List<Trainer> trainers;
	Trainer verfied;

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btnBack) {
				removeAll();
				setVisible(false);
				VerifiedTrainerMenu newPanel = new VerifiedTrainerMenu(clients, RegClients, trainingClasses, trainers,
						verfied);
				add(newPanel);
				validate();
				setVisible(true);
				repaint();
			}
		}

	}

	public ViewTrainingClassesPanel(Map clients, LinkedList reg, List<TrainingClass> trainingClasses,
			List<Trainer> trainers, Trainer t) {
		this.clients = clients;
		this.RegClients = reg;
		this.trainingClasses = trainingClasses;
		this.trainers = trainers;
		this.verfied = t;

		JPanel classesView = new JPanel();

		JLabel lblRegClient = new JLabel("All your classes");
		add(lblRegClient, BorderLayout.NORTH);
		
		JList list = new JList(t.getClassesArray());
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setVisibleRowCount(-1);
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(120, 140));
		add(listScroller);
		
		ButtonListener bl = new ButtonListener();
		btnBack.addActionListener(bl);
		
		classesView.add(btnBack, "6, 14");
		
		add(classesView, BorderLayout.CENTER);
	}
}
