package DataStructures;

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

	//Function sorts the list based on the company name. Taking in the list as the paramater to get the first location
	/*private void sort() {

		Client temp = null;		//Setting temp to null. This will be used to swap data

		for (int ol = 0; ol <= size; ol++) {
			LinkedNode traverse = this.head; // Creating this node to traverse the list to find the last element
			while (traverse.next != null) {
				
				//does the comparison and swaps them accordingly 
				if (traverse.data.getCompany().compareTo(traverse.next.data.getCompany()) > 0) {
					temp = traverse.data;
					traverse.data = traverse.next.data;
					traverse.next.data = temp;
				}
				//goes to next node
				traverse = traverse.next;
			}

		}

	}*/

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