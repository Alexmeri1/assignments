package client_related_classes;

import vehicules_related_classes.Vehicle;

public class Client {
	
	protected String name;
	protected int ID;
	private static int lastID = 0;

	protected Vehicle[] allCars = null;

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
	
	public static void createClient(String name) {
		new Client(name);
	}
	
	public boolean equals(Object o) {
		if(this == o) {
			return true;
			
		}
		
		if (this == null || this.getClass() != o.getClass()) {
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

	public void addVehiclesToClient(Vehicle v) {
		Vehicle[] arrayAdded;

		if (this.allCars == null) {
			arrayAdded = new Vehicle[1];
		} else {
			arrayAdded = new Vehicle[this.allCars.length + 1];
			for (int i = 0; i < this.allCars.length; i++) {
				arrayAdded[i] = this.allCars[i];

			}
		}

		arrayAdded[arrayAdded.length - 1] = v;

		this.allCars = arrayAdded;

	}

	public void removeVehiclesFromClient(Vehicle v) {

		Vehicle[] newArrayCars = null;
		
		if (this.allCars == null) {
			System.out.println("No cars to remove");
		} else {
			boolean exist = false;
			for (Vehicle car : this.allCars) {
				
				//Here we also want the plate numbers to match
				if (car.equals(v) && car.getPlateNb().equals(v.getPlateNb())) {
					exist = true;
					break;
				}
			}
			if (this.allCars.length == 1 && exist == true) {
				System.err.println("Now you have no cars");
				this.allCars = null;
			} else if (exist) {
				newArrayCars = new Vehicle[this.allCars.length + 1];
				for (int i = 0, j = 0; i < this.allCars.length; i++) {
					if (!this.allCars[i].equals(v)) {
						newArrayCars[i] = this.allCars[i];
						j++;
					}
				}
					System.out.println("car removed succesfully ");
					this.allCars = newArrayCars;
			} else {
				System.err.println("The car wasn't found");
				//so do nothing
			}

		}
		
		

	}
	
	public int getClientID() {
		return this.ID;
	}

	public String toString() {
		String toReturn = String.format("Name: %s  ID#%d has:\n", this.name,this.ID);

		if (this.allCars == null) {
			toReturn += "No cars\n";
		} else {
			toReturn += String.format("%d cars\n\n", this.allCars.length);
			for (int i = 0; i < this.allCars.length ; i++) {
				toReturn += this.allCars[i].toString() +"\n";
			}
		}
		return toReturn;
	}

}
