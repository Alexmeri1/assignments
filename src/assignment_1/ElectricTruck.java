package assignment_1;

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
		String toReturn = super.toString() + String.format("This electric truck has a max range of %.2f kilometers\n",this.maxRange);
		
		return toReturn;
	}
	
	
}
