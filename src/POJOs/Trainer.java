package POJOs;

import java.util.ArrayList;
import java.util.List;

public class Trainer {

	private String firstName;
	private String lastName;
	private String password;
	private String phoneNumber;
	private List<TrainingClass> classes;
	
	public Trainer() {
		
	}
	
	public Trainer(String f, String l, String password, String p) {
		this.firstName = f;
		this.lastName = l;
		this.password = password;
		this.phoneNumber = p;
		this.classes = new ArrayList<TrainingClass>();
	}
	
	public Trainer(String f, String l, String password, String p, List<TrainingClass> c) {
		this.firstName = f;
		this.lastName = l;
		this.password = password;
		this.phoneNumber = p;
		this.classes = c;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<TrainingClass> getClasses() {
		return classes;
	}
	
	public TrainingClass[] getClassesArray() {
		TrainingClass[] t = new TrainingClass[this.classes.size()];
		
		for(int i = 0; i < this.classes.size(); i++) {
			t[i] = this.classes.get(i);
		}
		
		for(TrainingClass te : t) {
			System.out.print(te.toString());
		}
		
		return t;
	}

	public String getClassesDescription() {
		String printString = "";
		for (int i = 0; i < this.classes.size(); i++){
			printString += (i + 1) + ": Class Name: " + this.classes.get(i).getName() + ", Class Description: " + this.classes.get(i).getDescription() + "\n";
		}
		
		return printString;
	}

	public void setClasses(List<TrainingClass> classes) {
		this.classes = classes;
	}
	
	public void addClass(TrainingClass toAdd) {
		this.classes.add(toAdd);
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

}
