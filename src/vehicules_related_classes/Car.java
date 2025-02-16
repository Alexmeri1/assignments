package vehicules_related_classes;

public class Car extends Vehicle {

	protected int maxNbPassangers;
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
		if (this == null || this.getClass() != otherC.getClass()) {
			return false;
		}

		Car c = (Car) otherC;

		return (this.make.equals(c.make)
				&& this.model.equals(c.model) && this.yearOfProduction == c.yearOfProduction
				&& this.maxNbPassangers == c.maxNbPassangers);

	}

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

		return "GC";
	}
	
	
}
