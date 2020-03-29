package POJOs;

import java.util.List;

public class Trainer {

	public String firstName;
	public String lastName;
	public String phoneNumber;
	public List<TrainingClass> classes;
	
	public Trainer() {
		
	}
	
	public Trainer(String f, String l, String p) {
		this.firstName = f;
		this.lastName = l;
		this.phoneNumber = p;
	}
	
	public Trainer(String f, String l, String p, List<TrainingClass> c) {
		this.firstName = f;
		this.lastName = l;
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

	@Override
	public String toString() {
		return "Trainer [firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
				+ ", classes=" + classes + "]";
	}

}
