package vehicules_related_classes;
// Assignment 1
// Written by: Alexander Meriakri #40310155

public class Car extends Vehicle {

	// Maximum number of passengers this car can hold
	protected int maxNbPassangers;
	// Static counter to keep track of the number of Car objects created
	private static int nbOfVehicles;

	public Car() {
		super();
		this.maxNbPassangers = 0;
	}

	public Car(String model, int yearOfProduction, String make, int maxNbPass) {
		super(model, yearOfProduction, make);
		this.maxNbPassangers = maxNbPass;
	}

	public Car(Car otherC) {
		super(otherC);
		this.maxNbPassangers = otherC.maxNbPassangers;
	}

	public int getMaxNbPassangers() {
		return this.maxNbPassangers;
	}

	public void setMaxNbPassangers(int newAmount) {
		this.maxNbPassangers = newAmount;
	}


	@Override
	public String toString() {
		String toReturn = super.toString() + String.format("%d passangers|", this.maxNbPassangers);

		return toReturn;
	}

	@Override
	public boolean equals(Object otherC) {
		if (this == otherC) {
			return true;
		}
		if (otherC == null || this.getClass() != otherC.getClass()) {
			return false;
		}

		Car c = (Car) otherC;

		return (this.make.equals(c.make)
				&& this.model.equals(c.model) && this.yearOfProduction == c.yearOfProduction
				&& this.maxNbPassangers == c.maxNbPassangers);

	}

	// Increments the counter tracking the total number of Car objects
	@Override
	public void incrementNbVehicles() {
		nbOfVehicles++;
	}

	// Returns the total number of Car objects created
	@Override
	public int getNbVehicles() {
		return this.nbOfVehicles;
	}

	// Returns the type of the vehicle as a string identifier
	@Override
	public String getType() {
		return "GC";
	}

}
