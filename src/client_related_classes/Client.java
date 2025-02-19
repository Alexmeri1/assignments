package client_related_classes;

import vehicules_related_classes.Vehicle;

import java.util.Optional;

public class Client {
	
	protected String name;
	protected int ID;
	private static int lastID = 0;

	protected Vehicle[] allCarsLeased = null;

	public Client() {
		
		this("No name");
	}

	public Client(String name) {
		this.name = name;
		this.ID = ++lastID;
	}
	
	public Client(Client c) {
		this(c.name);
		
	}
	
	public boolean equals(Object o) {
		if(this == o) {
			return true;
			
		}
		
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		Client c = (Client) o;
		
		return this.ID == c.ID && this.name.equals(c.name);
		
	}

	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void listAllVehiclesLeasedByClient() {
		
		if(allCarsLeased == null || allCarsLeased.length == 0) {
			System.out.printf("No cars leased by %s \n", this.name);
		}else {
			System.out.printf("%s has %d vehicles leased:\n",this.name, this.allCarsLeased.length + 1);
			for(int i = 0; i < allCarsLeased.length;i++) {
				System.out.println(allCarsLeased[i]);
			}
		}
		
	}
	
	public void addVehiclesToClient(Vehicle v) {
		
		Vehicle[] arrayAdded;

		if (this.allCarsLeased == null) {
			arrayAdded = new Vehicle[1];
		} else {
			arrayAdded = new Vehicle[this.allCarsLeased.length + 1];
			for (int i = 0; i < this.allCarsLeased.length; i++) {
				arrayAdded[i] = this.allCarsLeased[i];

			}
		}

		arrayAdded[arrayAdded.length - 1] = v;

		this.allCarsLeased = arrayAdded;

	}


	public void removeVehiclesFromClient(Vehicle v) {
		if (this.allCarsLeased == null || this.allCarsLeased.length == 0) {
			System.out.println("No cars to remove");
			return;
		}

		boolean exist = false;
		for (Vehicle car : this.allCarsLeased) {
			if (car.equals(v) && car.getPlateNb().equals(v.getPlateNb())) {
				exist = true;
				break;
			}
		}

		if (!exist) {
			System.err.println("The car wasn't found");
			return;
		}

		if (this.allCarsLeased.length == 1) {
			System.err.println("Now you have no cars");
			this.allCarsLeased = null;
			return;
		}

		Vehicle[] newArrayCars = new Vehicle[this.allCarsLeased.length - 1];
		int j = 0;
		for (int i = 0; i < this.allCarsLeased.length; i++) {
			if (!(this.allCarsLeased[i].equals(v) && this.allCarsLeased[i].getPlateNb().equals(v.getPlateNb()))) {
				newArrayCars[j++] = this.allCarsLeased[i];
			}
		}

		System.out.println("Car removed successfully");
		this.allCarsLeased = newArrayCars;
	}


	public int getClientID() {
		return this.ID;
	}

	
	public String toString() {
		String toReturn = String.format("Name: %s  ID#%d has:\n", this.name, this.ID);

		if (this.allCarsLeased == null) {
			toReturn += "No cars\n";
		} else {
			toReturn += String.format("%d cars\n\n", this.allCarsLeased.length);
			for (int i = 0; i < this.allCarsLeased.length ; i++) {
				toReturn += this.allCarsLeased[i].toString() +"\n";
			}
		}
		return toReturn;
	}

}
