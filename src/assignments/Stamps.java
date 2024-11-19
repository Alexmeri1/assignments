package assignments;

public class Stamps {

	private final int[] valueOfcategoryI = { 2, 5, 10, 15, 20 };
	private int[] amountOfCatergoryI = new int[5];
	private int lengthOfAmountOfCat = amountOfCatergoryI.length;

	public Stamps() {
		for(int i = 0; i < lengthOfAmountOfCat; i++) {
			this.amountOfCatergoryI[i] = 0;
		} 
	}
	
	public Stamps(int catA, int catB, int catC, int catD, int catE) {
		int catI[] = { catA, catB, catC, catD, catE };

		for (int i = 0; i < lengthOfAmountOfCat; i++) {
			this.amountOfCatergoryI[i] = catI[i];
		}

	}

	public Stamps(Stamps original) {
		for (int i = 0; i < lengthOfAmountOfCat; i++) {
			this.amountOfCatergoryI[i] = original.amountOfCatergoryI[i];
		}
	}

	public void setAmountOfCatergoryA(int newAmount) {
		this.amountOfCatergoryI[0] = newAmount;
	}

	public void setAmountOfCatergoryB(int newAmount) {
		this.amountOfCatergoryI[1] = newAmount;
	}

	public void setAmountOfCatergoryC(int newAmount) {
		this.amountOfCatergoryI[2] = newAmount;
	}

	public void setAmountOfCatergoryD(int newAmount) {
		this.amountOfCatergoryI[3] = newAmount;
	}

	public void setAmountOfCatergoryE(int newAmount) {
		this.amountOfCatergoryI[4] = newAmount;
	}

	public int getAmountOfCategoryA() {
		return this.amountOfCatergoryI[0];
	}

	public int getAmountOfCategoryB() {
		return this.amountOfCatergoryI[1];
	}

	public int getAmountOfCategoryC() {
		return this.amountOfCatergoryI[2];
	}

	public int getAmountOfCategoryD() {
		return this.amountOfCatergoryI[3];
	}

	public int getAmountOfCategoryE() {
		return this.amountOfCatergoryI[4];
	}

	public void addStamps(int catA, int catB, int catC, int catD, int catE) {
		int catI[] = { catA, catB, catC, catD, catE };

		for (int i = 0; i < lengthOfAmountOfCat; i++) {
			this.amountOfCatergoryI[i] += catI[i];
		}
	}

	public int getStampsTotal() {
		int totalPrice = 0;
		for (int i = 0; i < lengthOfAmountOfCat; i++) {
			totalPrice += amountOfCatergoryI[i] * valueOfcategoryI[i];
		}
		return totalPrice;
	}
	
	 @Override
	public String toString() {
		String stringToReturn = "";
		for (int i = 0; i < lengthOfAmountOfCat; i++) {
			stringToReturn += (amountOfCatergoryI[i] + " x $" + valueOfcategoryI[i]);
			stringToReturn += ( i != lengthOfAmountOfCat -1) ? " + " : "";
		}

		return stringToReturn;
	}
	 
	public boolean equals(Stamps otherStamp) {
		if (this.toString().equals(otherStamp.toString())) {
			return true;
		} else {
			return true;
		}
	}
}
