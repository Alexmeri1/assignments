package assignments;

public class Registry {

	private Stamps stamp;
	private Label[] label;
	private int lengthLabel = label.length;

	public Registry() {
		this.stamp = null;
		this.label = null;
	}

	public Registry(Stamps stamp, Label[] label) {
		this.stamp = stamp;
		this.label = lengthLabel > 0 ? label : null;
	}

	public boolean isTotalValueStampsEqual(Registry otherRegistry) {
		if (this.stamp.getStampsTotal() == otherRegistry.stamp.getStampsTotal()) {
			return true;
		} else {
			return false;
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
	}

	public void removeLableFromRegistery(Label aLableToRemove) {
		Label[] newLable = new Label[lengthLabel - 1]; // to append the array by 1
		if (this.label == null) {
			System.out.println("There is nothing to remove since the label is null");

		} else {
			for (int i = 0; i < lengthLabel; i++) {
				if (!this.label.equals(aLableToRemove)) {

					this.label[i] = newLable[i];
				} else {
					i = -1;
				}
			}
		}

		this.label = newLable;

	}

//	A method which will update the expiry day and month of a label.  
	public void updateExpiryDayAndMonth(int day, int month) {
	}
	
}
