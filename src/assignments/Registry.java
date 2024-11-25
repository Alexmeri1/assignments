package assignments;

public class Registry {

	private Stamps stamp;
	private Label[] label;
	private int lengthLabel;

	public Registry() {
		this.stamp = null;
		this.label = null;
	}

	public Registry(Stamps stamp, Label[] label) {
		this.stamp = stamp;
		this.label = label.length > 0 ? label : null;
		this.lengthLabel = (label != null) ? label.length : 0;
	}

	public boolean isTotalValueStampsEqual(Registry otherRegistry) {
		if (this.stamp.getStampsTotal() != otherRegistry.stamp.getStampsTotal()) {
			return false;
		} else {
			return true;
		}

	}

	public boolean isTwoStampCategoriesEqual(Registry otherRegistry) {
		if (this.stamp.equals(otherRegistry.stamp)) {
			return true;
		} else {
			return false;
		}

	}

	public int totalAmountOfMoneyInRegistryInStamp() {
		return this.stamp.getStampsTotal();
	}

	public int howManyLabelsInRegistry() {
		return this.lengthLabel;
	}

	public void addLabelToRegistery(Label aLabelToAdd) {
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
	}


	public void removeLableFromRegistery(int positionOfLabel) {

		if (this.label == null || this.label.length == 0) {
			System.out.println("There is nothing to remove since the label is null");
			return;
		}
		
		if (positionOfLabel < 0 || positionOfLabel >= this.label.length) {
	        System.out.println("Invalid label position.");
	        return;
	    }
		
		Label[] newLable = new Label[lengthLabel - 1]; // to remove the array by 1
		int newIndex = 0;
		
		for (int i = 0; i < lengthLabel; i++) {
			if (i != positionOfLabel) {

				newLable[newIndex] = this.label[i];
				newIndex++; 
			} 
		}

		this.label = newLable;
		// Update lengthLabel if necessary.
		this.lengthLabel = (label != null) ? label.length : 0;
		
	}

//	A method which will update the expiry day and month of a label.  
	public void updateExpiryDayAndMonth(int day, int month, int positionOfTheLabel) {
		this.label[positionOfTheLabel].setExpiryDay(day);
		this.label[positionOfTheLabel].setExpiryMonth(month);
	}

	public int addStampsToARegistry(int catA, int catB, int catC, int catD, int catE) {

		this.stamp.addStamps(catA, catB, catC, catD, catE);

		int stampTotal = this.stamp.getStampsTotal();
		
		return stampTotal;
	}

	public boolean equals(Registry otherReg) {
		int otherRegLengthLabel = (otherReg.label == null) ? 0 : otherReg.label.length;
		if ((this.stamp.getStampsTotal() != otherReg.stamp.getStampsTotal())
				|| (this.lengthLabel != otherRegLengthLabel)) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public String toString() {
		String toString = "";

		toString += this.stamp.toString() + "\n";

		if (lengthLabel < 1) {
			toString += "No prepaid labels\n";
		} else {
			for (int i = 0; i < lengthLabel; i++) {
				toString += this.label[i].toString() + "\n";

			}
		}

		return toString;
	}

	public String getStampsFromRegistry() {
		return this.stamp.toString();
	}

}
