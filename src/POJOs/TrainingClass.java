package POJOs;

public class TrainingClass {

	public String name;
	public String description;
	
	public TrainingClass(String n, String desc) {
		this.name = n;
		this.description = desc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return name + ", " + description;
	}
	
	
}
