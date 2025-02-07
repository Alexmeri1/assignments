package assignments;
//---------------------------------------------------------

//Assignment 4 
//Written by: Alexander Meriakri #40310155
//For COMP 248 Section P – Fall 2024 
//---------------------------------------------------------
/*
This class allows to create stamps that have 5 values, which correspond to different monetary values (2,5,10,15,20 )
It has a default constructor that puts all the values to 0, a constructor that sets the value to whatever the user decides
It has getters and setters for all the individual values, a method to increase them all at once, a method that returns 
the stamps total value, a toString method that return all the stamps in order and an equals method that tells you if 
2 sets of stamps are equal based on if they have the exact same values 
*/

public class Stamps {

	// Array to store the given values
	private final int[] valueOfcategoryI = { 2, 5, 10, 15, 20 };
	// Array to store the how many of each value the stamp has
	private int[] amountOfCategoryI = new int[5];
	// To make my life easier
	private int lengthOfAmountOfCat = amountOfCategoryI.length;

	// Default constructor
	public Stamps() {
		// Setting all the values to zero, could be skipped since new int[5] makes them
		// 0 to begin with
		for (int i = 0; i < lengthOfAmountOfCat; i++) {
			this.amountOfCategoryI[i] = 0;
		}
	}

	// Constructor that assigns the given values to the correspond placement in the
	// array
	public Stamps(int catA, int catB, int catC, int catD, int catE) {

		// To be able to go thru them all in the for loop
		int catI[] = { catA, catB, catC, catD, catE };

		// Assign the corresponding values
		for (int i = 0; i < lengthOfAmountOfCat; i++) {
			this.amountOfCategoryI[i] = catI[i];
		}

	}

	// Copy constructor
	public Stamps(Stamps original) {
		for (int i = 0; i < lengthOfAmountOfCat; i++) {
			this.amountOfCategoryI[i] = original.amountOfCategoryI[i];
		}
	}

	// The following are setters with the correspond letter

	public void setAmountOfCatergoryA(int newAmount) {
		this.amountOfCategoryI[0] = newAmount;
	}

	public void setAmountOfCatergoryB(int newAmount) {
		this.amountOfCategoryI[1] = newAmount;
	}

	public void setAmountOfCatergoryC(int newAmount) {
		this.amountOfCategoryI[2] = newAmount;
	}

	public void setAmountOfCatergoryD(int newAmount) {
		this.amountOfCategoryI[3] = newAmount;
	}

	public void setAmountOfCatergoryE(int newAmount) {
		this.amountOfCategoryI[4] = newAmount;
	}

	// The following are getters with the correspond letter
	public int getAmountOfCategoryA() {
		return this.amountOfCategoryI[0];
	}

	public int getAmountOfCategoryB() {
		return this.amountOfCategoryI[1];
	}

	public int getAmountOfCategoryC() {
		return this.amountOfCategoryI[2];
	}

	public int getAmountOfCategoryD() {
		return this.amountOfCategoryI[3];
	}

	public int getAmountOfCategoryE() {
		return this.amountOfCategoryI[4];
	}

	// Method that adds stamp values to an existing stamp
	public void addStamps(int catA, int catB, int catC, int catD, int catE) {
		int[] catI = { catA, catB, catC, catD, catE };

		// Ensure that the length matches the array length to avoid index issues, had
		// bugs
		int minLength = Math.min(lengthOfAmountOfCat, catI.length);

		for (int i = 0; i < minLength; i++) {
			this.amountOfCategoryI[i] += catI[i];
		}
	}

	// Return the total of the stamps
	public int getStampsTotal() {
		// String that holds the total
		int totalPrice = 0;
		for (int i = 0; i < lengthOfAmountOfCat; i++) {
			totalPrice += amountOfCategoryI[i] * valueOfcategoryI[i];
		}
		return totalPrice;
	}

	// have to override it because the method is the same as the default toString()
	// that java provides
	@Override
	// Method that returns a string with all the values, with the correspond amount
	public String toString() {
		// String that needs to be returned
		String stringToReturn = "";
		for (int i = 0; i < lengthOfAmountOfCat; i++) {
			// Starts with the amount followed by x followed by $ and the right value
			stringToReturn += (amountOfCategoryI[i] + " x $" + valueOfcategoryI[i]);
			// If it is the last item do not add + but if not add +'s
			stringToReturn += (i != lengthOfAmountOfCat - 1) ? " + " : " ";
		}

		return stringToReturn;
	}

	// Checks if two stamps are the same
	public boolean equals(Stamps otherStamp) {

		// If the toString() is the same for both then they have the same amounts for
		// each corresponding value
		if (this.toString().equals(otherStamp.toString())) {
			return true;
		} else {
			return false;
		}
	}
}
