# Scribbage-Counter-Calculator
This is a Java class called Counter that represents a cribbage hand counter. It can calculate the number of points earned from a given hand and starter card, using methods to count pairs, runs, fifteens, flushes, and knobs. It utilizes other classes such as Card, Set, LinearNode, and PowerSet.

## Skills Learned
- Implementing and using classes in Java
- Implementing linked lists and sets using classes
- Creating and using PowerSet to generate the power set of a given array of elements
- Implementing algorithms for counting pairs, runs, and fifteens in a hand
- Implementing algorithms for checking flushes and his knobs

## Usage
To use the Counter class, create a new instance with the player's hand and starter card as arguments. Call any of the count methods to calculate points earned from the hand and starter card.

## Constants
The Counter class does not have any constants.

## Functions
- '**Counter(hand, starter)**': Initializes a new Counter object with the given hand and starter card.
- '**countPairsPoints()**': Counts the number of pairs in the hand and returns the number of points earned.
- '**countRunsPoints()**': Counts the number of runs in the hand and returns the number of points earned.
- '**countFifteensPoints()**': Counts the number of ways to make 15 with the cards in the hand and returns the number of points earned.
- '**countFlushPoints()**': Checks if the hand has a flush and returns the number of points earned.
- '**countHisKnobsPoints()**': Checks if the hand has a Jack that matches the suit of the starter card and returns the number of points earned.
- '**countPoints()**': Returns the total number of points earned by adding the number of points earned from each of the above methods.

## Limitations
The Counter class assumes that the hand and starter card are valid playing cards, and does not check for errors if invalid cards are passed as arguments. It also does not handle ties, which may occur if two players have hands with the same number of points.

## Possible Improvements
- Adding input validation to check for valid playing cards when initializing the Counter object. 
- Adding tie-breaking logic to handle ties between players with hands of the same point value. 
- Adding a method to print out the breakdown of points earned from each of the count methods.

## Conclusion
The Counter class provides a useful implementation of a cribbage hand counter that can calculate the number of points earned from a given hand and starter card. With some input validation and tie-breaking logic, it could be made even more robust and useful.
