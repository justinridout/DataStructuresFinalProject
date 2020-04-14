package DataStructures;

import java.time.LocalDate;

import POJOs.Registration;

/**
 * LinkedList class 
 * @author Justin Ridout
 */
public class LinkedList {
	
	//Variables 
	int size = 0;
	LinkedNode head;

	//Node is the core of the class
	//Has the next location in the list and has a variable for can class
	static class LinkedNode {
		Registration data;
		LinkedNode next;

		//constructor sets the data but sets next to null since we are not inserting just yet
		LinkedNode(Registration d) {
			data = d;
			next = null;
		}
	}

	public void insertion(Registration d) {

		LinkedNode newNode = new LinkedNode(d); //creating new node to be inserted

		// Checks if there is a previous item in list, if not it sets the new node as
		// the first item
		if (this.head == null) {
			this.head = newNode;
		}

		//Else we traverse the list until we reach the end and insert the new node at the end
		else {
			LinkedNode traverse = this.head; 
			while (traverse.next != null) {
				traverse = traverse.next;
			}

			traverse.next = newNode; // inserting the new node equal to the last location
		}
		//updating size and calling the sort function
		size++;

	}


	//method just deletes the element in the first location
	public Registration deletion() {
		//checks if the list has anything in it
		if (!this.isEmpty()) {
			//Just breaks off the first node from the rest of the list
			LinkedNode temp = this.head;
			this.head = temp.next;

			Registration data = temp.data;
			size--;

			return data;
		}
		return null;
	}

	//Deletes an element in the list by Client
	public Registration deleteByClientEmail(String index) {

		Registration data = null;	
		LinkedNode traverse = this.head; // Creating this node to traverse the list to find the last element

		//Checks if list is empty
		if (!this.isEmpty()) {
			//if the first location is the element that user wants to delete
			if (traverse.data.getClient().getEmail() == index) {
				data = traverse.data;
				this.head = traverse.next;

				size--;
				return data;
			}

			//if first element wasnt the correct element
			//While loop traverses the list checking until correct company is found or list hits the end
			while (traverse.next != null) {

				if (traverse.next.data.getClient().getEmail() == index) {
					data = traverse.next.data;
					traverse.next = traverse.next.next;
					size--;
					return data;
				}
				traverse = traverse.next;
			}
		}

		return data;

	}

	// Function checks the size of the array
	// If size is anything but 0, false is returned
	public boolean isEmpty() {
		boolean empty = false;

		if (this.size == 0) {
			empty = true;
		}

		return empty;
	}

	//Just returns the size
	public int size() {
		return size;
	}

	//traverses the list while adding company names to the prints string. print string is returned
	public String print() {
		String printString = "";
		int count = 1;
		LinkedNode traverse = this.head; // Creating this node to traverse the list to find the last element
		while (traverse != null) {
			printString += count + ": " + traverse.data.toString() + "\n";
			traverse = traverse.next;
			count++;
		}

		return printString;
	}
	
	public Registration[] toArray(){
		Registration[] r = new Registration[this.size];
		LinkedNode traverse = this.head;
		
		int index = 0;
		while (traverse != null) {
			r[index] = traverse.data;
			traverse = traverse.next;
			index++;
		}
		
		bubbleSort(r);
		return r;
	}
	
	public void bubbleSort(Registration[] r) {
		Registration[] temp = new Registration[this.size];
		
		for(int i = 0; i < this.size - 1; i++) {
			for(int il = 0; il < this.size-i-1; il++) {
				if(r[il].getStartDate().compareTo(r[il+1].getStartDate()) > 0) {
					Registration t = r[il];
					r[il] = r[il + 1];
					r[il+1] = t;
				}
			}
		}
		
	}

	
	//Searches the list by company name
	public Registration searchByClientEmail(String index) {
		Registration data = null;
		LinkedNode traverse = this.head; // Creating this node to traverse the list to find the last element
		
		//Checks if list is empty
		if (!this.isEmpty()) {
			
			//checks if first location is the correct company 
			if (traverse.data.getClient().getEmail() == index) {
				data = traverse.data;

				return data;
			}

			//else while loop traverses the loop until the company is found or end of list is hit
			while (traverse.next != null) {
				if (traverse.next.data.getClient().getEmail() == index) {
					data = traverse.next.data;

					return data;
				}
				traverse = traverse.next;
			}
		}

		return data;
	}
}
