//This class is to hold a client when they sign up for a class
//This holds the client object and all the information asked when 
//Signing up for a class 

package POJOs;
import java.time.LocalDate;

public class Registration {

	private Client client;
	private LocalDate startDate;
	private LocalDate endDate;
	private String goal;
	public TrainingClass tClass;
	
	public Registration() {
		
	}
	
	public Registration(Client c, LocalDate s, String goal, TrainingClass t) {
		this.client = c;
		this.startDate = s;
		this.goal = goal;
		this.tClass = t;
	}
	
	public Registration(Client c, LocalDate s, LocalDate e, String goal, TrainingClass t) {
		this.client = c;
		this.startDate = s;
		this.endDate = e;
		this.goal = goal;
		this.tClass = t;
	}

	//Getters and setters
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public TrainingClass gettClass() {
		return tClass;
	}

	public void settClass(TrainingClass tClass) {
		this.tClass = tClass;
	}

	//Used on the registered clients trainer panel
	@Override
	public String toString() {
		return client.getFirstName() + ", " + client.getLastName() + ", Start: " + this.getStartDate();
	}
	
	
	
}
