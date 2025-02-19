package vehicules_related_classes;
// Assignment 1
// Written by: Alexander Meriakri #40310155
public abstract class Vehicle {
	protected String model;
	protected int yearOfProduction;
	protected String make;
	protected String plateNumber;

	// Default constructor: initializes the vehicle with default values.
	public Vehicle() {
		this("No model", 0, "No make");
	}

	// Parameterized constructor: initializes the vehicle with specific values and generates a unique plate number.
	public Vehicle(String model, int yearOfProduction, String make) {
		this.model = model;
		this.yearOfProduction = yearOfProduction;
		this.make = make;
		this.incrementNbVehicles();
		this.plateNumber = createPlateNb();
	}

	// Abstract method to increment the vehicle count for its specific type.
	abstract public void incrementNbVehicles();

	// Abstract method to retrieve the total count of vehicles for this type.
	abstract public int getNbVehicles();

	public Vehicle(Vehicle otherV) {
		this(otherV.model, otherV.yearOfProduction, otherV.make);
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setYearOfProduction(int yearNb) {
		this.yearOfProduction = yearNb;

	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getMake() {
		return this.make;
	}

	public String getModel() {
		return this.model;
	}

	public int getYearOfProd() {
		return this.yearOfProduction;
	}

	// Checks if this vehicle is equal to another based on make, model, and year of production.
	@Override
	public boolean equals(Object otherObj) {
		if (otherObj == this) {
			return true;
		}
		if (otherObj == null || otherObj.getClass() != this.getClass()) {
			return false;

		}

		Vehicle v = (Vehicle) otherObj;

		return (this.make.equals(v.make) && this.model.equals(v.model) && this.yearOfProduction == v.yearOfProduction);

	}

	abstract public String getType();

	public String getPlateNb() {
		return this.plateNumber;
	}

	// Generates a plate number by combining the vehicle type identifier and a formatted unique number.
	public final String createPlateNb() {

		String plateNb = this.getType() + this.getNumberForPlate();

		return plateNb;
	}

	// Formats the vehicle number into a four-character string. If the count exceeds a limit, the number is replaced with "xxxx".
	private String getNumberForPlate() {
		String number = "1";

		int orginalNb = this.getNbVehicles();

		if (orginalNb < 10) {
			number += "00" + orginalNb;
		} else if (orginalNb < 100) {
			number += "0" + orginalNb;
		} else if (orginalNb < 1000) {
			number += String.valueOf(orginalNb);
		} else {
			number += "xxxx";
		}

		return number;

	}

	// Returns a formatted string representation of the vehicle's attributes.
	public String toString() {

		String toReturn = String.format(
				"Model: %s | Year of production: %d | Make: %s | Plate number: %s |",
				this.model, this.yearOfProduction, this.make, this.plateNumber
		);


		return toReturn;
	}

}
