package client_related_classes;

import vehicules_related_classes.Car;
import vehicules_related_classes.DieselTruck;
import vehicules_related_classes.ElectricCar;
import vehicules_related_classes.ElectricTruck;
import vehicules_related_classes.Vehicle;
// Assignment 1
// Written by: Alexander Meriakri #40310155
public class LeaseManager {

	// Array to hold all gasoline cars available
	protected Vehicle[] allCars = null;

	// Array to hold all electric cars available
	protected Vehicle[] allElectricCars = null;

	// Array to hold all diesel trucks available
	protected Vehicle[] allDieselTrucks = null;

	// Array to hold all electric trucks available
	protected Vehicle[] allElectricTrucks = null;

	// Array to hold all clients registered
	protected Client[] allClients = null;

	// Array to hold all vehicles currently leased by clients.
	protected Vehicle[] allLeasedVehicles = null;

	// Adds a new client to the list of clients.
	public void addClient(Client c) {

		if (allClients == null) {
			allClients = new Client[1];
			allClients[0] = c;

		} else {

			Client[] newList = new Client[allClients.length + 1];
			for (int i = 0; i < allClients.length; i++) {
				newList[i] = allClients[i];
			}

			newList[allClients.length] = c;
			allClients = newList;

		}

	}

	// Displays a list of all vehicles that are currently leased or indicates if no vehicles are leased.
	public void listAllLeasedVehicles() {
		if(allLeasedVehicles == null || allLeasedVehicles.length == 0) {
			System.out.println("No vehicles leased");
		}
		else {
			System.out.println("Vehicles leased:");
			for(int i = 0; i < allLeasedVehicles.length; i++) {
				System.out.println("#" + i + " " + allLeasedVehicles[i]);
			}
		}
		System.out.println();
	}

	// Shows all vehicles leased by the client with the specified ID or displays an error if the client is not found.
	public void listAllVehiclesForClient(int id) {
		Client c = ClientInArray(id);
		if(c == null) {
			System.out.println("Client not found");
		}
		c.listAllVehiclesLeasedByClient();

	}


	// Displays all registered clients and their information or indicates if no clients are available.
	public void listAllClients() {

		if (allClients == null || allClients.length == 0) {
			System.out.println("No clients yet");
			return;
		} else {

			for (Client client : allClients) {
				System.out.printf("Client name: %s | ID: %d%n", client.getName(), client.getClientID());
			}

		}

	}

	// Searches for and returns the client with the specified ID from the client array, or null if not found.
	private Client ClientInArray(int id) {

		if (allClients == null || allClients.length == 0) {
			return null;
		} else {
			for (int i = 0; i < allClients.length; i++) {
				if (allClients[i].getClientID() == id) {
					return allClients[i];
				}
			}
		}
		return null;

	}

	// Updates the name of a client with the specified ID if the client exists, otherwise displays an error.
	public void editClientName(int id, String name) {

		if (allClients == null || allClients.length == 0) {
			System.out.println("No clients to remove");
		} else if (allClients.length == 1) {
			if (allClients[0].getClientID() == id) {
				allClients[0].setName(name);
			} else {
				System.out.println("Client not found");
			}

		} else {
			for (int i = 0; i < allClients.length; i++) {
				if (allClients[i].getClientID() == id) {
					allClients[i].setName(name);
					System.out.println("Name set");
					return;
				}
			}
			System.out.println("Client was not found");
		}

	}

	// Checks if a vehicle with the given plate number is currently leased.
	private boolean isVehicleLeased(String plate) {
		if (allLeasedVehicles == null || allLeasedVehicles.length == 0) {
			return false;
		} else {
			for (int i = 0; i < allLeasedVehicles.length; i++) {
				if (allLeasedVehicles[i].getPlateNb().equals(plate)) {
					return true;
				}
			}

		}

		return false;
	}

	// Adds a vehicle to the array of leased vehicles.
	private void addVehicleToLeasedArray(Vehicle v) {

		if(allLeasedVehicles == null|| allLeasedVehicles.length == 0) {
			allLeasedVehicles = new Vehicle[1]; 
			allLeasedVehicles[0] = v;
			return;
		}else {
			Vehicle[] newArr = new Vehicle[allLeasedVehicles.length +1]; 
			for(int i = 0; i < allLeasedVehicles.length; i++) {
				newArr[i] = allLeasedVehicles[i];
			}
			
			newArr[newArr.length - 1] = v;
			allLeasedVehicles = newArr;
		}
		
		
	}

	// Removes a vehicle from the list of leased vehicles for a specific client based on the client ID and vehicle plate number.
	public void unLeaseVehicle(int cliendId, String plate) {

		if (!isVehicleLeased(plate)) {
			System.out.println("Vehicle is not leased");
			return;
		}

		Client c = ClientInArray(cliendId);
		if (c == null) {
			System.out.println("Client not in array");
			return;

		}

		Vehicle v = getVehicleFromArray(allLeasedVehicles, plate);
		c.removeVehiclesFromClient(v);
		allLeasedVehicles = deleteCarFromArray(allLeasedVehicles, plate);

	}

	// Assigns a vehicle to a client for leasing based on the client ID and the vehicle's plate number.
	public void leaseVehicle(int id, String plate) {
		Client c = ClientInArray(id);
		if (c == null) {
			System.out.println("Client not in array");
			return;
		}

		if (isVehicleLeased(plate)) {
			System.out.println("Vehicle is leased");
			return;
		}

		String type = plate.substring(0, 2);
		switch (type) {

		case "GC":
			Vehicle car = getVehicleFromArray(allCars, plate);
			if (car != null) {
				addVehicleToLeasedArray(car);
				c.addVehiclesToClient(car);
			} else {
				System.out.println("Car not found");
			}
			break;
		case "EC":
			Vehicle eCar = getVehicleFromArray(allElectricCars, plate);
			if (eCar != null) {
				addVehicleToLeasedArray(eCar);
				c.addVehiclesToClient(eCar);
			} else {
				System.out.println("Car not found");
			}
			break;
		case "DT":

			Vehicle truck = getVehicleFromArray(allDieselTrucks, plate);
			if (truck != null) {
				addVehicleToLeasedArray(truck);
				c.addVehiclesToClient(truck);
			} else {
				System.out.println("Car not found");
			}
			break;
		case "ET":
			Vehicle eTruck = getVehicleFromArray(allElectricTrucks, plate);
			if (eTruck != null) {
				addVehicleToLeasedArray(eTruck);
				c.addVehiclesToClient(eTruck);
			} else {
				System.out.println("Car not found");
			}
			break;

		default:
			break;

		}

	}

	// Deletes a client from the list based on the client ID or displays an error if the client is not found.
	public void deleteClient(int clientID) {

		if (allClients == null || allClients.length == 0) {

			System.out.println("No clients to remove");

		} else if (allClients.length == 1) {

			if (allClients[0].getClientID() == clientID) {

				allClients = null;
				return;

			}
			System.out.println("Client not found");

		} else {

			Client[] newList = new Client[allClients.length - 1];
			int i, j;

			for (i = 0, j = 0; i < allClients.length; i++) {

				if (!(allClients[i].getClientID() == clientID)) {

					newList[j] = allClients[i];

					j++;
				}

			}
			if (i == j) {
				System.out.println("Car not found");
			} else {
				allClients = newList;
			}

		}

	}

	// Adds a new vehicle to the appropriate vehicle category based on its type.
	public void addVehicle(Vehicle v) {
		System.out.println(v.getType());
		switch (v.getType()) {

		case "GC":
			allCars = addCarToArray(allCars, v);
			break;
		case "EC":
			allElectricCars = addCarToArray(allElectricCars, v);
			break;
		case "DT":
			allDieselTrucks = addCarToArray(allDieselTrucks, v);
			break;
		case "ET":
			allElectricTrucks = addCarToArray(allElectricTrucks, v);
			break;
		default:
			System.out.println("Something wrong accured in addVehicle");
			break;
		}

	}

	// Adds a vehicle to the specified array of vehicles and returns the updated array.
	private static Vehicle[] addCarToArray(Vehicle[] arr, Vehicle v) {

		Vehicle[] newArrCar = null;

		if (arr == null) {
			newArrCar = new Vehicle[1];
		} else {
			newArrCar = new Vehicle[arr.length + 1];
			for (int i = 0; i < arr.length; i++) {
				newArrCar[i] = arr[i];
			}
		}
		newArrCar[newArrCar.length - 1] = v;
		return newArrCar;

	}

	// Deletes a vehicle from its respective category based on the given plate number.
	public void deleteVehicle(String plateNb) {
		String typeOfPlate = plateNb.substring(0, 2);
		Vehicle[] arr = null;
		switch (typeOfPlate) {
		case "GC":
			allCars = deleteCarFromArray(allCars, plateNb);
			break;
		case "EC":
			allElectricCars = deleteCarFromArray(allElectricCars, plateNb);
			break;
		case "DT":
			allDieselTrucks = deleteCarFromArray(allDieselTrucks, plateNb);
			break;
		case "ET":
			allElectricTrucks = deleteCarFromArray(allElectricTrucks, plateNb);
			break;
		default:
			System.out.println("Something wrong accured in deleteVehicle");
			break;
		}

	}

	// Removes a vehicle with the specified plate number from the given array and returns the updated array.
	private static Vehicle[] deleteCarFromArray(Vehicle[] allCars, String plateNb) {
		if (allCars == null)
			return allCars;

		if (getVehicleFromArray(allCars, plateNb) != null) {
			if (allCars.length == 1) {
				return null;
			} else {

				Vehicle[] newCarArr = new Vehicle[allCars.length - 1];
				for (int i = 0, j = 0; i < allCars.length; i++) {
					if (!allCars[i].getPlateNb().equals(plateNb)) {
						newCarArr[j] = allCars[i];
						j++;
					}

				}
				return newCarArr;
			}
		} else {
			// car not found
		}

		return allCars;
	}

	// Searches for and returns a vehicle with the given plate number from the specified array.
	private static Vehicle getVehicleFromArray(Vehicle[] allCars, String plateNb) {
		if (allCars == null) {
			return null;
		} else {
			for (int i = 0; i < allCars.length; i++) {
				if (allCars[i].getPlateNb().equals(plateNb)) {
					return allCars[i];
				}
			}
		}
		return null;
	}

	// Displays all vehicles grouped by category, or indicates if a category is empty
	public void listAllVehiclesByCat() {

		if (allCars == null || allCars.length == 0) {
			System.out.println("No Gasoline Cars");
		} else {
			System.out.println("Gasoline Cars:");
			for (int i = 0; i < allCars.length; i++) {

				System.out.println("#" + i + " " + allCars[i]);
			}

		}
		System.out.println();
		if (allElectricCars == null || allElectricCars.length == 0) {
			System.out.println("No Electric Cars");
		} else {
			System.out.println("Electric Cars:");
			for (int i = 0; i < allElectricCars.length; i++) {

				System.out.println("#" + i + " " + allElectricCars[i]);
			}

		}
		System.out.println();
		if (allDieselTrucks == null || allDieselTrucks.length == 0) {
			System.out.println("No Diesel Trucks");
		} else {
			System.out.println("Diesel Trucks:");
			for (int i = 0; i < allDieselTrucks.length; i++) {

				System.out.println("#" + i + " " + allDieselTrucks[i]);
			}

		}
		System.out.println();
		if (allElectricTrucks == null || allElectricTrucks.length == 0) {
			System.out.println("No Electric Trucks");
		} else {
			System.out.println("Electric Trucks:");
			for (int i = 0; i < allElectricTrucks.length; i++) {

				System.out.println("#" + i + " " + allElectricTrucks[i]);
			}

		}
		System.out.println();
	}

	// Updates the details of a vehicle based on its plate number and new data provided
	public void editVehicle(String plateNb, String newV) {

		String typeOfPlate = plateNb.substring(0, 2);
		String[] carParts = newV.split(";");
		Vehicle[] arr = null;
		switch (typeOfPlate) {
		case "GC": {
			Car car = (Car) getVehicleFromArray(allCars, plateNb);
			car.setModel(carParts[0]);
			car.setYearOfProduction(Integer.valueOf(carParts[1].trim()));
			car.setMake(carParts[2]);
			car.setMaxNbPassangers(Integer.valueOf(carParts[3].trim()));
			break;
		}
		case "EC":
			ElectricCar electricCar = (ElectricCar) getVehicleFromArray(allElectricCars, plateNb);
			electricCar.setModel(carParts[0]);
			electricCar.setYearOfProduction(Integer.valueOf(carParts[1]));
			electricCar.setMake(carParts[2]);
			electricCar.setMaxNbPassangers(Integer.valueOf(carParts[3]));
			electricCar.setMaxRange(Double.valueOf(carParts[4]));
			break;
		case "DT":
			DieselTruck dieselTruck = (DieselTruck) getVehicleFromArray(allDieselTrucks, plateNb);
			dieselTruck.setModel(carParts[0]);
			dieselTruck.setYearOfProduction(Integer.valueOf(carParts[1]));
			dieselTruck.setMake(carParts[2]);
			dieselTruck.setMaxCapacity(Double.valueOf(carParts[3]));
			dieselTruck.setTankCapa(Double.valueOf(carParts[4]));
			break;
		case "ET":
			ElectricTruck electricTruck = (ElectricTruck) getVehicleFromArray(allElectricTrucks, plateNb);
			electricTruck.setModel(carParts[0]);
			electricTruck.setYearOfProduction(Integer.valueOf(carParts[1]));
			electricTruck.setMake(carParts[2]);
			electricTruck.setMaxCapacity(Double.valueOf(carParts[3]));
			electricTruck.setMaxRange(Double.valueOf(carParts[4]));
			break;
		default:
			System.out.println("Something wrong accured in deleteVehicle");
			break;
		}

	}

	// Returns the array of all diesel trucks.
	public Vehicle[] getArrayDiselTruck() {
		return allDieselTrucks;
	}

	// Returns the array of all electric trucks.
	public Vehicle[] getArrayElectricTruck() {
		return allElectricTrucks;
	}



}
