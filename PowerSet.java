
public class PowerSet<T> {
	
	// Creating private set to hold the power set
	private Set<T>[] set;
	
	// Creating constructor that takes an array of elements to create the power set
	public PowerSet(T[] elements) {	
		// Getting length of the array and initializing size
		int n = elements.length;
		int size = 1;

		// Calculating the size of the power set
		for (int i = 0; i < n; i++) {
			size *= 2;
		}
		
		// Initializing the array
		set = new Set[size];
		
		// Calculating the elements of the power set
		for (int i = 0; i < size; i++) { // Iterating through each possible subset of elements
			// Creating a new Set object for this subset
			set[i] = new Set<T>();

			// Iterating through each element in the original array
			for (int j = 0; j < n; j++) {
				// Checking to see if the j-th element should be included in this subset
				if (((i >> j) & 1) == 1) {
					// If so we add it to the Set object for this subset
					set[i].add(elements[j]);
				}
				
			}
		}
	}
	
	
	// Defining a method to get the length of the power set
	public int getLength() {
		return set.length;
	}
	
	
	// Defining a method to get a set from the power set
	public Set<T> getSet(int i) {
		return set[i];
	}
}
