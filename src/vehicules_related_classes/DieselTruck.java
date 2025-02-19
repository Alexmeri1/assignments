package vehicules_related_classes;

public class DieselTruck extends Truck{
	private static int nbOfVehicles;
	protected double tankCapacity;
	
	public DieselTruck() {
		super();
		this.tankCapacity = 0;
	}

	public DieselTruck(String model, int yearOfProduction, String make, double maxCapacity,double tankCapa) {
		super(model, yearOfProduction, make, maxCapacity);
		this.tankCapacity = tankCapa;
	}

	public DieselTruck(DieselTruck otherT) {
		super(otherT);
		this.tankCapacity = otherT.tankCapacity;
	}

	public double getTankCapa() {
		return tankCapacity;
	}

	public void setTankCapa(double tankCapa) {
		this.tankCapacity = tankCapa;
	}

	public String toString() {
		String toReturn = super.toString() + 
				String.format("Max fuel tank capacity: %.3f L|",this.tankCapacity);
		
		
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


	public boolean equals(Object other) {
		if(this == other) {
			return true;
		}

		if (other == null || this.getClass() != other.getClass()) {
			return false;
		}

		DieselTruck dt = (DieselTruck) other;
		return (this.make.equals(dt.make)
				&& this.model.equals(dt.model) && this.yearOfProduction == dt.yearOfProduction
				&& this.maxCapacity == dt.maxCapacity
				&& (Double.compare(this.tankCapacity,dt.tankCapacity) == 0 ) );
	}
}
