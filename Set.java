
public class Set<T> {
	
	private LinearNode<T> setStart;
	
	
	// Constructor which initializes setStart to null
	public Set() {
		
		setStart = null;
		
	}
	
	
	// Method which adds a new element to the set
	public void add(T element) {
		LinearNode <T> newNode = new LinearNode<T>(element);
		
		// If the set is empty we make the newNode the setStart
		if (setStart == null) {
			setStart = newNode;
		}
		
		else { // Otherwise we iterate through the list and add the new node as the last node
			LinearNode<T> current = setStart;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
            
		}
	}
	
	
	// Method to get the length of the set
	public int getLength() {
		int count = 0;
		LinearNode<T> current = setStart;
		
		while(current != null) { // Iterating through the list and incrementing count for every node
			count++;
			current = current.getNext();
		}
		
		return count; // Returning the count of the nodes

				
	}
	
	
	// Method to get an element at a certain index
	public T getElement(int i) {
		LinearNode<T> current = setStart;
		
		for (int j = 0; j < i;  j++) { // Iterating through the index till the desired node is reached
			current = current.getNext();
		}
		
		// Returning the element at the selected index
		return current.getElement();
	}
	
	
	// Method to see if the set contains a specific element
	public boolean contains(T element) {
		LinearNode<T> current = setStart;
		
		while (current != null) { // Iterating through the list
			if (current.getElement().equals(element)) { // If element is found we return true
				return true;
			}
			
			current = current.getNext();
		}
		
		return false; // Otherwise we return false
	}
	
	
	// Method to convert the set into a string
	public String toString() {
		
		if (setStart == null) { // If the set is empty we return an empty string
			return "";
		}
		
		// Start with the string representation of the starting element
		String result = setStart.getElement().toString();
		LinearNode<T> current = setStart.getNext();
		
		while (current != null) { // Iterating through the list and adding each element to the string
			result += " " + current.getElement().toString();
			current = current.getNext();
		}
		
		return result; //  Returning the result
	}
	
}
