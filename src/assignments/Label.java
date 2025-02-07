package assignments;
//---------------------------------------------------------

//Assignment 4 
//Written by: Alexander Meriakri #40310155
//For COMP 248 Section P – Fall 2024 
//---------------------------------------------------------
/*
This Class creates a label. The default constructor assigns default values, a constructor that expects the type, an id, 
an expiry day and month. If the month or day is outside the range assigns 0 and a copy constructor. A method that returns
the type, another to get the ID, another to get expiry day and another to get the expiry month. A method that allows you to change
the expiry day and  another to set the month. A to string that displays all the info about the lavel and an equals method that 
returns if 2 labels are the same
*/

public class Label {

	// String that holds the type of the label
	private String types;
	// Int that hold the id
	private int ID;
	// int that hold the expiry day
	private int expiryDay;
	// int that hold the expiry month
	private int expiryMonth;

	// Default constructor that sets all the values to the standard ones
	public Label() {
		this.types = "Standard"; // Default type
		this.ID = 98000000; // Default 8-digit ID starting with 98 followed by 6 0's
		this.expiryDay = 0; // Invalid expiry day
		this.expiryMonth = 0; // Invalid expiry month
	}

	// Constructor that gets the type, id, expiry day and expiry month
	public Label(String type, int ID, int expDay, int expMonth) {

		this.types = type;
		this.ID = ID;
		// If the expiry day in under 1 or over 31 then it sets it to 0, if not to
		// whatever the user said
		this.expiryDay = (expDay < 1 || expDay > 31) ? 0 : expDay;
		// If the expiry month in under 1 or over 12 then it sets it to 0, if not to
		// whatever the user said
		this.expiryMonth = (expMonth < 1 || expMonth > 12) ? 0 : expMonth;

	}

	// Copy constructor
	public Label(Label otherLabel) {

		this.types = otherLabel.types;
		this.ID = otherLabel.ID;
		this.expiryDay = otherLabel.expiryDay;
		this.expiryMonth = otherLabel.expiryMonth;

	}

	// The following methods are getters that return the value stored
	public String getType() {

		return this.types;
	}

	public int getID() {
		return this.ID;
	}

	public int getExpiryDay() {
		return this.expiryDay;
	}

	public int getExpiryMonth() {
		return this.expiryMonth;
	}

	// The following are setters to change the day and the month
	public void setExpiryDay(int newDay) {
		this.expiryDay = (newDay < 1 || newDay > 31) ? 0 : newDay;
	}

	public void setExpiryMonth(int newMonth) {
		this.expiryMonth = (newMonth < 1 || newMonth > 12) ? 0 : newMonth;
	}

	// have to override it because the method is the same as the default toString()
	// that java provides
	@Override
	// Method that returns a string with the type, the id, the day and the month. if
	// the month/day are single digit adds a zero before
	public String toString() {
		// String for the expiry day
		String expiryDayString = "";
		// String for the expiry month
		String expiryMonthString = "";
		// String for the final output
		String toString = "";

		// If single digit add a 0, if not just change the variable to a String, since
		// it's an int
		if (getExpiryDay() >= 0 && getExpiryDay() <= 9) {
			expiryDayString = "0" + getExpiryDay();
		} else {
			expiryDayString = Integer.toString((this.expiryDay));
		}

		// If single digit add a 0, if not just change the variable to a String, since
		// it's an int
		if (this.expiryMonth >= 0 && this.expiryMonth <= 9) {
			expiryMonthString = "0" + this.expiryMonth;
		} else {
			expiryMonthString = Integer.toString(this.expiryMonth);
		}

		// Construct the string here
		toString = (this.getType() + " - " + this.getID() + " - " + expiryDayString + "/" + expiryMonthString);
		return toString;
	}

	// Returns true if 2 labels are the same, meaning that they have the exact same
	// type, id , and date
	public boolean equals(Label otherLabel) {
		if (this.toString().equals(otherLabel.toString())) {
			return true;
		} else {
			return false;
		}
	}
}
