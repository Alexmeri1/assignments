package assignments;

public class Label {

	private String types;
	private int ID;
	private int expiryDay;
	private int expiryMonth;

	public Label() {
		this.types = "Standard";  // Default parcel type
	    this.ID = 98000000;       // Default 8-digit ID starting with 98
	    this.expiryDay = 0;       // Invalid expiry day
	    this.expiryMonth = 0;     // Invalid expiry month
	}

	public Label(String type, int ID, int expDay, int expMonth) {

		this.types = type;
		this.ID = ID;
		this.expiryDay = (expDay < 1 || expDay > 31) ?  0 :expDay;
		this.expiryMonth = (expMonth < 1 || expMonth > 12) ? 0 : expMonth;
		

	}

	public Label(Label otherLabel) {
		this.types = otherLabel.types;
		this.ID = otherLabel.ID;
		this.expiryDay = otherLabel.expiryDay;
		this.expiryMonth = otherLabel.expiryMonth;

	}

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

	public String toString() {
		String expiryDayString = "";
		String expiryMonthString = "";
		String toString = "";
		if (this.getExpiryDay() >= 0 && this.getExpiryDay() <= 9) {
			expiryDayString = "0" + this.expiryDay;
		} else {
			expiryDayString = Integer.toString((this.expiryDay));
		}

		if (this.expiryMonth >= 0 && this.expiryMonth <= 9) {
			expiryMonthString = "0" + this.expiryMonth;
		} else {
			expiryMonthString = Integer.toString(this.expiryMonth);
		}

		toString = (this.getType() + " - " + this.getID() + " - " + expiryDayString + "//" + expiryMonthString);
		return toString;
	}
	
	public boolean equals(Label otherLabel) {
		if(this.toString().equals(otherLabel.toString() ) ) {
			return true;
		}else {
			return false;
		}
	}
}
