package assignments;
//---------------------------------------------------------

//Assignment 4 
//Written by: Alexander Meriakri #40310155
//For COMP 248 Section P – Fall 2024 
//---------------------------------------------------------

/*
This class constructs the Registry using the other two classes as attributes. The default constructor sets the stamp to a default
stamp and the label to null. The other constructor takes a stamp and an array of labels. There is a method that returns true if 2
stamps have the same total value, another method return true if both have the same exact categories. A method that returns the total
value inside a stamp. A method that returns the amount of labels in the registry. A method to add a label and one to remove a label.
A method to update an expiry month and day. A method to add stamps to a registry. A method that tells if 2 registries are the same.
A method to display everything inside the registry and lastly a method that returns the toString of Stamps.
 */
public class Registry {
	// Variable Stamps that holds a stamp
	private Stamps stamp;
	// Variable Label that holds an array of labels
	private Label[] label;
	// An int that stores the length of of the array
	private int lengthLabel;

	// Default constructor that creates a default stamp, and has 0 labels
	public Registry() {
		this.stamp = new Stamps();
		this.label = null;
		this.lengthLabel = 0;
	}

	// Constructor that takes 1 stamp and an array of labels (can be a empty array)
	public Registry(Stamps stamp, Label[] label) {
		this.stamp = stamp;
		// if the length of the label is smaller than 1 then it sets it to null
		this.label = label.length > 0 ? label : null;
		// If the label is null then set the length to 0 if not set it to the length
		this.lengthLabel = (label != null) ? label.length : 0;

	}

	// Returns true if 2 stamps have the same total value
	public boolean isTotalValueStampsEqual(Registry otherRegistry) {
		if (this.stamp.getStampsTotal() != otherRegistry.stamp.getStampsTotal()) {
			return false;
		} else {
			return true;
		}

	}

	// Returns true if 2 stamps have the same amounts
	public boolean isTwoStampCategoriesEqual(Registry otherRegistry) {

		if (this.stamp.equals(otherRegistry.stamp)) {
			return true;
		} else {
			return false;
		}

	}

	// returns the total amount of the stamp
	public int totalAmountOfMoneyInRegistryInStamp() {
		return this.stamp.getStampsTotal();
	}

	// Returns the amount of labels
	public int howManyLabelsInRegistry() {
		return this.lengthLabel;
	}

	// Method to add a label to a registry and return the new total length
	public int addLabelToRegistery(Label aLabelToAdd) {
		// Create a new array with length increased by 1 to accommodate the new label
		Label[] newLabelArray = new Label[lengthLabel + 1];

		if (this.label != null) {
			// Copy existing labels to the new array
			for (int i = 0; i < lengthLabel; i++) {
				newLabelArray[i] = this.label[i];
			}
		}

		// Add the new label at the end of the new array
		newLabelArray[lengthLabel] = aLabelToAdd;

		// Assign the new array to the instance variable
		this.label = newLabelArray;

		// Update the length to reflect the new array size
		this.lengthLabel = newLabelArray.length;

		// return the new size
		return this.lengthLabel;
	}

	// Method to remove a label from the registry and return true if it was
	// successful
	public boolean removeLableFromRegistery(int positionOfLabel) {

		// Checks if the label is null or if the length is 0 (its the same)
		if (this.label == null || this.label.length == 0) {
			System.out.println("There is nothing to remove since the label is null");
			return false;
		}
		// checks if the position is more than 0 and if the position is in the range
		if (positionOfLabel < 0 || positionOfLabel >= this.label.length) {
			System.out.println("Invalid label position.");
			return false;
		}

		Label[] newLable = new Label[lengthLabel - 1]; // to remove the array by 1
		int newIndex = 0; // To keep track off the position even after we skip 1 label

		for (int i = 0; i < lengthLabel; i++) {
			// if the position is the given value, skips it
			if (i != positionOfLabel) {

				newLable[newIndex] = this.label[i];
				// When will not be called there will be a difference of 1 between newIndex and
				// i
				newIndex++;
			}
		}
		// Set the label to the new label
		this.label = newLable;
		// Update lengthLabel if necessary.
		this.lengthLabel = (label != null) ? label.length : 0;
		// return true since everything went well
		return true;
	}

//	A method which will update the expiry day and month of a label.  
	public void updateExpiryDayAndMonth(int day, int month, int positionOfTheLabel) {
		this.label[positionOfTheLabel].setExpiryDay(day);
		this.label[positionOfTheLabel].setExpiryMonth(month);
	}

	// Method to add stamps to the registry
	public int addStampsToARegistry(int catA, int catB, int catC, int catD, int catE) {

		this.stamp.addStamps(catA, catB, catC, catD, catE);

		// get the total value of all the stamps
		int stampTotal = this.stamp.getStampsTotal();

		// return the total value
		return stampTotal;
	}

	// Checks if 2 registries are the same
	public boolean equals(Registry otherReg) {
		// gets the length of the other registry
		int otherRegLengthLabel = (otherReg.label == null) ? 0 : otherReg.label.length;

		// checks if the they dont have the same value and if they dont have the same
		// length, if so then they aren't the same. if not they are the same
		if ((this.stamp.getStampsTotal() != otherReg.stamp.getStampsTotal())
				|| (this.lengthLabel != otherRegLengthLabel)) {
			return false;
		} else {
			return true;
		}

	}

	// have to override it because the method is the same as the default toString()
	// that java provides
	@Override
	//This methods returns a string with the stamp's info as well as the info about the label.s
	public String toString() {
		String toString = "";
		
		//Starts by adding the stamps info followed by \n to pass a line
		toString += this.stamp.toString() + "\n";

		//if the length is smaller than 1 then there are no labels
		if (lengthLabel < 1) {
			toString += "No prepaid labels\n";
		} else {
			// for each label print the info followed by a \n to skip a line
			for (int i = 0; i < lengthLabel; i++) {
				toString += this.label[i].toString() + "\n";

			}
		}
		//returns the final string
		return toString;
	}
	
	//returns the stamp.String()
	public String getStampsFromRegistry() {
		return this.stamp.toString();
	}

}
