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
		Label[] newLable = new Label[lengthLabel + 1]; // to append the array by 1
		if (this.label == null) {
			// to not do useless steps
		} else {
			for (int i = 0; i < lengthLabel; i++) {
				this.label[i] = newLable[i];
			}
		}
		newLable[lengthLabel] = aLabelToAdd;

		this.label = newLable;
		this.lengthLabel = (label != null) ? label.length : 0;
	}

	public void removeLableFromRegistery(Label aLableToRemove) {
		Label[] newLable = new Label[lengthLabel - 1]; // to append the array by 1
		if (this.label == null) {
			System.out.println("There is nothing to remove since the label is null");

		} else {
			for (int i = 0; i < lengthLabel; i++) {
				if (!this.label[i].equals(aLableToRemove)) {

					this.label[i] = newLable[i];
				} else {
					i -= 1;
				}
			}
		}

		this.label = newLable;

	}

//	A method which will update the expiry day and month of a label.  
	public void updateExpiryDayAndMonth(int day, int month, Label aLable) {
		aLable.setExpiryDay(day);
		aLable.setExpiryMonth(month);
	}

	public int addStampsToARegistry(int catA, int catB, int catC, int catD, int catE) {

		this.stamp.addStamps(catA, catB, catC, catD, catE);

		return this.stamp.getStampsTotal();
	}

	public boolean equals(Stamps aStamp, Label[] labels) {
		if ((this.stamp.getStampsTotal() != aStamp.getStampsTotal()) || (this.lengthLabel != labels.length)) {
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
