package assignments;

public class Stamps {

	private final int[] valueOfcategoryI = { 2, 5, 10, 15, 20 };
	private int[] amountOfCategoryI = new int[5];
	private int lengthOfAmountOfCat = amountOfCategoryI.length;

	public Stamps() {
		for(int i = 0; i < lengthOfAmountOfCat; i++) {
			this.amountOfCategoryI[i] = 0;
		} 
	}
	
	public Stamps(int catA, int catB, int catC, int catD, int catE) {
		int catI[] = { catA, catB, catC, catD, catE };

		for (int i = 0; i < lengthOfAmountOfCat; i++) {
			this.amountOfCategoryI[i] = catI[i];
		}

	}

	public Stamps(Stamps original) {
		for (int i = 0; i < lengthOfAmountOfCat; i++) {
			this.amountOfCategoryI[i] = original.amountOfCategoryI[i];
		}
	}

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

	public void addStamps(int catA, int catB, int catC, int catD, int catE) {
	    int[] catI = { catA, catB, catC, catD, catE };

	    // Ensure that the length matches the array length to avoid index issues
	    int minLength = Math.min(lengthOfAmountOfCat, catI.length);

	    for (int i = 0; i < minLength; i++) {
	        this.amountOfCategoryI[i] += catI[i];
	    }
	}

	public int getStampsTotal() {
		int totalPrice = 0;
		for (int i = 0; i < lengthOfAmountOfCat; i++) {
			totalPrice += amountOfCategoryI[i] * valueOfcategoryI[i];
		}
		return totalPrice;
	}
	
	 @Override
	public String toString() {
		String stringToReturn = "";
		for (int i = 0; i < lengthOfAmountOfCat; i++) {
			stringToReturn += (amountOfCategoryI[i] + " x $" + valueOfcategoryI[i]);
			stringToReturn += ( i != lengthOfAmountOfCat -1) ? " + " : "";
		}

		return stringToReturn;
	}
	 
	public boolean equals(Stamps otherStamp) {
		if (this.toString().equals(otherStamp.toString())) {
			return true;
		} else {
			return false;
		}
	}
}
