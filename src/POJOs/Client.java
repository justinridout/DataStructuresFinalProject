//This is the object for clients.
//Holds all the information that is requested when a client is created in the GUI

package POJOs;

public class Client {

	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private String email;
	private Trainer trainer;
	
	public Client() {
		
	}
	
	public Client(String f, String l, String add, String phone, String email, Trainer t) {
		this.firstName = f;
		this.lastName = l;
		this.address = add;
		this.phoneNumber = phone;
		this.email = email;
		this.trainer = t;
	}

	//Getters and setters
	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//To string. This is used in the trainers menu to view their clients 
	@Override
	public String toString() {
		return firstName + ", " + lastName;
	}
	
	public String displayInfo() {
		
		return null;
	}
	
	
}
