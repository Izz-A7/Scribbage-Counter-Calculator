
public class Counter {

	// Initializing instance variables
	private PowerSet<Card> cardps;
	private Card Starter;
	private Card[] hand;
	
	// Creating the constructor
	public Counter(Card[] hand, Card starter) {
		// Initializing starter card and the hand
		this.Starter = starter;
		this.hand = new Card[hand.length - 1];
		for (int i = 0, j = 0; i < hand.length; i++) {
			
			// Skip the starter card when creating the hand array
			if (hand[i].getSuit() == Starter.getSuit() && hand[i].getLabel() == Starter.getLabel()) {
				continue;
			}

			this.hand[j] = hand[i];
			j++;
		
		}
		
		// Creating the PowerSet of all possible subsets of the hand
		this.cardps = new PowerSet<>(hand);
	}
	
	
	// Method to count points from pairs
	private int countPairsPoints() {
		int numPairs = 0; // Initializing number of pairs to 0 to begin with
		
		// Iterating through all the subsets of the hand
		for (int i = 0; i < cardps.getLength(); i++) {
			// Get the current subset
			Set <Card> subset = cardps.getSet(i);
			// Filtering out any subsets that are smaller or larger than 2
			if (subset.getLength() == 2) {
				// If the subset has two cards which have the same label then we increment numPairs
				if (subset.getElement(0).getLabel() == subset.getElement(1).getLabel()) {
					numPairs++;
				}
			}				
		}

		return numPairs * 2; // Returning numPairs * 2 since each pair is worth two points
		
	}
	
	
	// Method to count points from runs. NOTE: I didn't use the provided code, but Professor Sarlo said it was only there to help/optional
	private int countRunsPoints() {
		// Initializing variables
		Set<Card> subset;
		int largest = 0;
		int length = 0;
		int runCount = 0;
		int[] sequence;
		boolean isSequence;
		
		
		// Iterating through each subset
		for (int i = 0; i < cardps.getLength(); i++) {
			// Getting current subset and its length
			subset = cardps.getSet(i);
			length = subset.getLength();
			
			// If the subset is too short or smaller than the largest run we skip it
			if (length < largest || length < 3) {
				continue;
			}
			
			// Create an array of the run ranks for cards in the subset
			sequence = new int[length];
			for (int j = 0; j < length; j++) {
				sequence[j] = subset.getElement(j).getRunRank();
			}
			
			// Sorting the array in ascending order
			for (int f = 0; f < length - 1; f++) {
				int minIndex = f;
				for (int k = f + 1; k < length; k++) {
					if (sequence[k]< sequence[minIndex]) {
						minIndex = k;
					}
				}
				int temp = sequence[f];
				sequence[f] = sequence[minIndex];
				sequence[minIndex] = temp;
			}
			
			// Checking to see if the sorted array is a sequence
			isSequence = true;
			for (int j = 1; j < length; j++) {

				if (sequence[j] - j != sequence[0]) {
					isSequence = false;
					break;
				}

			}
			
			// If it isn't a sequence skip
			if (! isSequence) {
				continue;
			}

			// If the current sequence isn't as big as the largest we reset the runCount
			if (largest != length) {
				runCount = 0;
			}
			
			// If the code gets this far we add the length into the runCount and make it the largest
			runCount += length;
			largest = length;
		}
		
		return runCount; // Returning runCount
	}
	
	
	// Method to count points from fifteens
	private int countFifteensPoints() {
		// Initializing variables
		int numOfFifteens = 0;
		Set<Card> subset;
		int currSum;
		
		// Iterating through all possible subsets and checking if the sum of their rank is equal to 15
		for (int i = 0; i < cardps.getLength(); i++) {
			subset = cardps.getSet(i);
			
			// Calculating sum of the ranks in the current subset
			currSum = 0;
			for (int j = 0; j < subset.getLength(); j++) {
				currSum += subset.getElement(j).getFifteenRank();
			}
			
			// If the sum is 15 we increment numOfFifteens
			if (currSum == 15) {
				numOfFifteens++;
			}
		}
		return numOfFifteens * 2; // Returning numOfFifteens * 2 since each 15 is worth 2 points
	}
	
	
	// Method to count points from flushes
	private int countFlushPoints() {
		// Getting suit of first card in hand
		String suit = this.hand[0].getSuit();
		
		// Checking if other cards in the hand have the same suit
		for (int i = 1; i < this.hand.length; i++) {
			if (this.hand[i].getSuit() != suit) {
				return 0; // If not we return zero
			}
		}
		
		// If it doesn't return 0 and the Starter suit equals the suit of the other cards
		if (this.Starter.getSuit() == suit) {
			return 5; // return 5
		}
		
		return 4; // Otherwise we return 4
	}
	
	
	// Method to count his knobs points
	private int countHisKnobsPoints() {
		String suit = Starter.getSuit();
		Card card;
		
		// Iterating though the hand to find a Jack
		for (int i = 0; i < this.hand.length; i++) {
			card = this.hand[i];
			// if there is a Jack and the starter suit is the same suit as the Jack we return one
			if (card.getLabel() == "J" && card.getSuit() == suit) {
				return 1;
			}
		}

		return 0; // Otherwise we return 0
	}
	
	
	// Method to count all the points
	public int countPoints() {
		// Initializing points to 0
		int points = 0;
		
		// adding all the helper method returns to the points
		points += countPairsPoints();
		points += countRunsPoints();
		points += countFifteensPoints();
		points += countFlushPoints();
		points += countHisKnobsPoints();
		
		System.out.println(countPairsPoints());
		System.out.println(countRunsPoints());
		System.out.println(countFifteensPoints());
		System.out.println(countFlushPoints());
		System.out.println(countHisKnobsPoints());


		return points; // returning final point count
	}
}
