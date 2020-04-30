/**************************************************************
* Name        : Final Project
* Author      : Justin Ridout
* Created     : 4/30/20
* Course      : CIS 152 Data Structures
* Version     : 1.0
* OS          : Windows 10
* Copyright   : This is my own original work based on
*               specifications issued by our instructor
* Description : This is a client tracker program for personal trainers
* Input		  : Asks the user for basic information based on the screen they are on
* Output	  : Outputs the current GUI screen of the application
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or 
* unmodified. I have not given other fellow student(s) access to
* my program.         
***************************************************************/

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;

import DataStructures.LinkedList;
import DataStructures.Map;
import POJOs.Client;
import POJOs.Registration;
import POJOs.Trainer;
import POJOs.TrainingClass;
import views.AddClientPanel;
import views.ClientMainMenuPanel;
import views.MainMenuPanel;
import views.SignUpPanel;

public class Driver {

	//Declaring the datastructures i use throughout the application
	static LinkedList registeredClients = new LinkedList();
	public static Map clients = new Map();
	static Scanner in = new Scanner(System.in);
	
	//Defining a person trainer so there is one in the application
	static Trainer me = new Trainer("Justin", "Ridout", "Test", "515-515-5151");
	
	public static void main(String[] args) {
		
		//Adding classes to that predefined trainer
		TrainingClass weights = new TrainingClass("Weight Training", "Build Strength");
		TrainingClass crossfit = new TrainingClass("Crossfit", "Nobody likes this");
		TrainingClass biking = new TrainingClass("Biking", "Fun Motivated Cardio");
		List<TrainingClass> justinsClasses = new ArrayList<TrainingClass>();
		justinsClasses.add(weights);
		justinsClasses.add(crossfit);
		justinsClasses.add(biking);
		me.setClasses(justinsClasses);
		
		//Making a list of trainers 
		List<Trainer> trainers = new ArrayList<Trainer>();
		trainers.add(me);
		
		System.out.println(justinsClasses);
		
		//running the main menu JPanel
		JFrame frame = new JFrame();
		MainMenuPanel panel = new MainMenuPanel(clients, registeredClients, trainers);
		frame.add(panel);

		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
	}
}
