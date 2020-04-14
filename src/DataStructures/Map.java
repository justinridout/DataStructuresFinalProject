package DataStructures;
/*
 * Map class which uses a linked list as the core
 */

import POJOs.Client;

public class Map {

	// Variables
	
	Node head;
	int numOfClients;

	// Node is the core of the class
	// Has the next location in the list and has a variables for key value pairs
	static class Node {
		String key;
		Client value;
		Node next;

		// constructor sets the data but sets next to null since we are not inserting
		// just yet
		Node(String key, Client value) {
			this.key = key;
			this.value = value;
			next = null;
		}
	}

	public void insert(String key, Client value) {

		Node newNode = new Node(key, value); // creating new node to be inserted

		// Checks if there is a previous item in list, if not it sets the new node as
		// the first item
		if (!keyExists(key)) {

			if (this.head == null) {
				this.head = newNode;
				numOfClients++;
			}

			// Else we traverse the list until we reach the end and insert the new node at
			// the end
			else {
				Node traverse = this.head;
				while (traverse.next != null) {
					traverse = traverse.next;
					
				}

				traverse.next = newNode; // inserting the new node equal to the last location
				numOfClients++;
			}
	
		}

	}

	//Simply grabs the value out of the map with the given key
	public String getValue(String key) {
		//Checks if the key exists
		if (keyExists(key)) {
			
			Node traverse = this.head;
			//Checks if first locations is the key
			if(traverse.key.equals(key)) {
				return traverse.value.toString();
			}

			//traverses the list until the key is found
			while (traverse != null) {
				//checks if the key equals the key that is passed in
				if (traverse.key.equals(key)) {
					//returns the value
					return traverse.value.toString();
				}
				traverse = traverse.next;
			}
		}

		//If this executes just sends the key doesnt exist
		return "No Client with that email";
	}
	
	public Client getClient(String key) {
		//Checks if the key exists
		if (keyExists(key)) {
			
			Node traverse = this.head;
			//Checks if first locations is the key
			if(traverse.key.equals(key)) {
				return traverse.value;
			}

			//traverses the list until the key is found
			while (traverse != null) {
				//checks if the key equals the key that is passed in
				if (traverse.key.equals(key)) {
					//returns the value
					return traverse.value;
				}
				traverse = traverse.next;
			}
		}

		//If this executes just sends the key doesnt exist
		return null;
	}

	//Removes the key value from the map
	public String removeKey(String key) {
		String deletedKey = "Key does not exist";

		//Checks if key exist
		if (keyExists(key)) {
			Node traverse = this.head;
			//checks if first locations is the correct key
			if (traverse.key == key) {
				deletedKey = traverse.key;
				this.head = traverse.next;
				return deletedKey;
			}

			//traverses the map checking for the key
			while (traverse.next != null) {
				if (traverse.next.key == key) {
					//if found it breaks off the link
					deletedKey = traverse.next.key;
					traverse.next = traverse.next.next;
		
					return deletedKey;
				}
				traverse = traverse.next;
			}

		}
		return deletedKey;
	}

	//simply traverses the map checking if there is a key with the same value
	public boolean keyExists(String key) {

		if (this.head != null) {

			Node traverse = this.head;
			if(traverse.key.equals(key)) {
				return true;
			}

			while (traverse != null) {
				if (traverse.key.equals(key)) {
					return true;
				}
				traverse = traverse.next;
			}

			return false;
		}
		return false;
	}
	
	public String print() {
		String printString = "";
		Node traverse = this.head; // Creating this node to traverse the list to find the last element
		int numOfClients = 1;
		while (traverse != null) {
			printString += "Client #" + numOfClients + " " + traverse.value.toString() + "\n";
			traverse = traverse.next;
		}

		return printString;
	}
	
	public Client[] toArray() {
		Client[] clients = new Client[this.numOfClients];
		Node traverse = this.head;
		int index = 0;
		
		while (traverse != null) {
			clients[index] = traverse.value;
			traverse = traverse.next;
			index++;
		}
		
		return clients;
	}

}
