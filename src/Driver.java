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

	static LinkedList registeredClients = new LinkedList();
	public static Map clients = new Map();
	static Scanner in = new Scanner(System.in);
	static Trainer me = new Trainer("Justin", "Ridout", "Test", "515-515-5151");
	
	public static void main(String[] args) {
		TrainingClass weights = new TrainingClass("Weight Training", "Build Strength");
		TrainingClass crossfit = new TrainingClass("Crossfit", "Nobody likes this");
		TrainingClass biking = new TrainingClass("Biking", "Fun Motivated Cardio");
		List<TrainingClass> justinsClasses = new ArrayList<TrainingClass>();
		justinsClasses.add(weights);
		justinsClasses.add(crossfit);
		justinsClasses.add(biking);
		
		
		me.setClasses(justinsClasses);
		List<Trainer> trainers = new ArrayList<Trainer>();
		trainers.add(me);
		
		System.out.println(justinsClasses);
		
		/*me.setClasses(justinsClasses);
		
		Client c = new Client("Justin", "Ridout", "123", "123", "123");
		clients.insert(c.getEmail(), c);
		Registration r = new Registration(c, LocalDate.parse("2020-03-12"), "Strength", weights);
		registeredClients.insertion(r);
		
		showMenu();*/
		
		JFrame frame = new JFrame();
		MainMenuPanel panel = new MainMenuPanel(clients, registeredClients, trainers);
		frame.add(panel);

		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
	}
	
	public static void showMenu() {
		int userInput = 0;
		while(userInput < 1 || userInput > 5) {
			System.out.println("Welcome! Please enter a number");
			System.out.println("1. New Client");
			System.out.println("2. Sign Up for Class");
			System.out.println("3. Show All Clients");
			System.out.println("4. Show All Registered Clients");
			System.out.println("5. Exit");
			userInput = in.nextInt();
			
			if (userInput < 1 || userInput > 5) {
				System.out.println("Invalid Number");
			}
		}
		
		if(userInput == 1) {
			newClient();
		}
		else if(userInput == 2) {
			registerClient();
		}
		else if(userInput == 3) {
			showAllClients();
		}
		else if(userInput == 4) {
			showAllRegistered();
		}
		else if(userInput == 5) {
			System.out.println("Good bye");
		}
		
	}

	private static void newClient() {
		Client c = new Client();
		String userEmail = "";
		in.nextLine();
		System.out.println("Welcome new Customer");
		System.out.println("Please enter your first name");
		c.setFirstName(in.nextLine().toLowerCase());
		System.out.println("Please enter your last name");
		c.setLastName(in.nextLine().toLowerCase());
		System.out.println("Please enter your Address");
		c.setAddress(in.nextLine());
		System.out.println("Please enter your Email");
		userEmail = in.nextLine();
		while (clients.keyExists(userEmail)) {
			System.out.println("That email is already registered");
			System.out.println("Please enter a different email");
			userEmail = in.nextLine();
		}
		c.setEmail(userEmail);
		System.out.println("Please enter your phone number");
		c.setPhoneNumber(in.nextLine());
		System.out.println("You are now in the system. Returning to Menu");
		
		clients.insert(c.getEmail(), c);
		
		showMenu();
	}
	
	private static void registerClient() {
		Registration r = new Registration();
		String userStringInput="";
		String userEmail = "";
		in.nextLine();
		
		do {
			System.out.println("Please enter the email you are registering as");
			userEmail = in.nextLine();
			
			if (!clients.keyExists(userEmail)) {
				System.out.println("No user under that email");
			}
		}while(!clients.keyExists(userEmail));
		
		Client c = clients.getClient(userEmail);
		
		r.setClient(c);
		
		int userInput = -1;
		while(userInput < 0 || userInput >= me.getClasses().size()) {
			System.out.println("Please select the class you want to participate in");
			System.out.println(me.getClassesDescription());
			userInput = in.nextInt();
			if(userInput < 0 || userInput >= me.getClasses().size()) {
				System.out.println("Invalid Class Number, Try Again");
			}
		}
		
		r.settClass(me.getClasses().get(userInput - 1));
		in.nextLine();
		System.out.println("Please enter a start date. (yyyy-mm-dd)");
		r.setStartDate(LocalDate.parse(in.nextLine()));
		
		System.out.println("Do you want to add an end date (y/n)?");
		userStringInput = in.nextLine();
		if(userStringInput.equals("y")) {
			System.out.println("Please enter an end date. (yyyy-mm-dd)");
			r.setEndDate(LocalDate.parse(in.nextLine()));
		}
		
		System.out.println("What do you wish to achieve during this class?");
		r.setGoal(in.nextLine());
		
		System.out.println("You are successfully registered! Returning to menu...");
		registeredClients.insertion(r);
		showMenu();
		
	}
	
	private static void showAllClients() {
		System.out.println(clients.print());
		showMenu();
	}
	
	private static void showAllRegistered() {
		System.out.println(registeredClients.print());
		showMenu();
		
	}

}
