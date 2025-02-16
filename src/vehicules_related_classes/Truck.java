package vehicules_related_classes;

abstract public class Truck extends Vehicle {

	protected double maxCapacity;
	
	public Truck() {
		super();
		this.maxCapacity = 0;
	}

	public Truck(String model, int yearOfProduction, String make, double maxCapacity) {
		super(model, yearOfProduction, make);
		this.maxCapacity = maxCapacity;
	}

	public Truck(Truck otherT) {
		super(otherT);
		this.maxCapacity = otherT.maxCapacity;
	}

	public double getMaxCapacity() {
		return this.maxCapacity;
	}

	public void setMaxCapacity(double newMax) {
		this.maxCapacity = newMax;
	}

	@Override
	public boolean equals(Object otherT) {
		if (this == otherT) {
			return true;
		}
		
		if (otherT == null || this.getClass() != otherT.getClass()) {
			return false;
		}

		Truck t = (Truck) otherT;

		return (this.make.equals(t.make)
				&& this.model.equals(t.model) && this.yearOfProduction == t.yearOfProduction
				&& (Double.compare(this.maxCapacity, t.maxCapacity) == 0));

	}

	@Override
	public String toString() {

		String toReturn = super.toString() + String.format("Max capacity: %.3f Kgs|", this.maxCapacity);

		return toReturn;

	}

}
