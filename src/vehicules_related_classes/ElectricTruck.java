package vehicules_related_classes;
// Assignment 1
// Written by: Alexander Meriakri #40310155
public class ElectricTruck extends Truck{
	protected double maxRange;
	private static int nbOfVehicles;
	
	public ElectricTruck() {
		super();
		this.maxRange = 0;
	}

	public ElectricTruck(String model, int yearOfProduction, String make, double maxCapacity,double maxRange) {
		super(model, yearOfProduction, make, maxCapacity);
		this.maxRange = maxRange;
	}

	public ElectricTruck(ElectricTruck otherT) {
		super(otherT);
		this.maxRange = otherT.maxRange;
	}

	
	public double getMaxRange() {
		return maxRange;
	}

	public void setMaxRange(double maxRange) {
		this.maxRange = maxRange;
	}

	// Increment the count of ElectricTruck instances whenever one is created.
	@Override
	public void incrementNbVehicles() {
		this.nbOfVehicles++;
	}

	@Override
	public int getNbVehicles() {
		
		return this.nbOfVehicles;
	}

	@Override
	public String getType() {
		return "ET";
	}
	
	public String toString() {
		String toReturn = super.toString() + String.format("Max range: %.2f km|",this.maxRange);

		return toReturn;
	}
	
	
}
