package vehicules_related_classes;
// Assignment 1
// Written by: Alexander Meriakri #40310155

public class ElectricCar extends Car{
	// Tracks the total number of ElectricCar instances created
	private static int nbOfVehicles;
	protected double maxRange;


	public ElectricCar() {
		super();
		this.maxRange = 0.0;
	}

	public ElectricCar(ElectricCar otherEC) {
		super(otherEC);
		this.maxRange = otherEC.maxRange;
	}

	public ElectricCar(String model, int yearOfProduction, String make, int maxNbPass,double maxRange) {
		super(model, yearOfProduction, make, maxNbPass);
		this.maxRange = maxRange;
	}

	public void setMaxRange(double newRange) {
		this.maxRange = newRange;
	}
	
	public double getMaxRange() {
		return this.maxRange;
	}

	// Increases the count of ElectricCar objects
	@Override
	public void incrementNbVehicles() {

		nbOfVehicles++;

	}

	@Override
	public int getNbVehicles() {

		return this.nbOfVehicles;
	}

	@Override
	public String getType() {

		return "EC";
	}


	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}

		if (other == null || this.getClass() != other.getClass()) {
			return false;
		}

		ElectricCar ec = (ElectricCar) other;

		return (this.make.equals(ec.make)
				&& this.model.equals(ec.model) && this.yearOfProduction == ec.yearOfProduction
				&& this.maxNbPassangers == ec.maxNbPassangers
				&& (Double.compare(this.maxRange, ec.maxRange) == 0));
	}

	public String toString() {

		String toReturn = super.toString() + String.format("Max range: %.2f km|", this.maxRange);
		return toReturn;
	}
}
