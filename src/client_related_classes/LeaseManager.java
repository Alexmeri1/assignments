package client_related_classes;

import vehicules_related_classes.Car;
import vehicules_related_classes.DieselTruck;
import vehicules_related_classes.ElectricCar;
import vehicules_related_classes.ElectricTruck;
import vehicules_related_classes.Vehicle;

public class LeaseManager {

	protected Vehicle[] allCars = null;

	protected Vehicle[] allElectricCars = null;

	protected Vehicle[] allDieselTrucks = null;

	protected Vehicle[] allElectricTrucks = null;

	protected Client[] allClients = null;

	protected Vehicle[] allLeasedVehicles = null;

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

	public void listAllVehiclesForClient(int id) {
		Client c = ClientInArray(id);
		if(c == null) {
			System.out.println("Client not found");
		}
		c.listAllVehiclesLeasedByClient();

	}


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

	public void unLeaseVehicle(int cliendId,String plate) {

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

	public Vehicle[] getArrayDiselTruck(){
		return allDieselTrucks;
	}

	public Vehicle[] getArrayElectricTruck(){
		return allElectricTrucks;
	}

	public static DieselTruck getLargestTruck(Vehicle[] array) {

		if(array == null || array.length == 0) {
			return null;
		}
		int arraySize = array.length;
		int positionBeiggestTruck = 0;

		for (int i = 1; i < arraySize; i++) {
			if (((DieselTruck) array[i]).getMaxCapacity() > ((DieselTruck) array[positionBeiggestTruck])
					.getMaxCapacity()) {
				positionBeiggestTruck = i;
			}
		}

		return (DieselTruck) array[positionBeiggestTruck];
	}

	public static ElectricTruck[] copyVehicles(Vehicle[] v){

		if(v == null || v.length == 0) {
			return null;
		}

		ElectricTruck[] newArray = new ElectricTruck[v.length];

		for(int i = 0; i < v.length; i++) {
			newArray[i] = new ElectricTruck((ElectricTruck) v[i]);
		}
		return newArray;
	}

}
