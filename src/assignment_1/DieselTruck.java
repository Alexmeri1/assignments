package assignment_1;

public class DieselTruck extends Truck{
	private static int nbOfVehicles;
	protected double tankCapa;
	
	public DieselTruck() {
		super();
		this.tankCapa = 0;
	}

	public DieselTruck(String model, int yearOfProduction, String make, double maxCapacity,double tankCapa) {
		super(model, yearOfProduction, make, maxCapacity);
		this.tankCapa = tankCapa;
	}

	public DieselTruck(DieselTruck otherT) {
		super(otherT);
		this.tankCapa = otherT.tankCapa;
	}

	public String toString() {
		String toReturn = super.toString() + 
				String.format("This Diesel truck has a max fuel tank capacity of %.3f liters\n",this.tankCapa);
		
		
		return toReturn;
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
		return "DT";
	}

}
