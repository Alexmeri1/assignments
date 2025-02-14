package client_related_classes;

import vehicules_related_classes.Car;
import vehicules_related_classes.DieselTruck;
import vehicules_related_classes.ElectricCar;
import vehicules_related_classes.ElectricTruck;
import vehicules_related_classes.Vehicles;

public class LeaseManager {

	protected static Car[] allGasolineCars = null;

	protected static ElectricCar[] allElectricCars = null;

	protected static DieselTruck[] allDieselTrucks = null;

	protected static ElectricTruck[] allElectricTrucks = null;

	protected static Client allClients[] = null;

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

	public void deleteClient(Client c) {
		if (allClients == null) {
			System.err.println("No clients to remove");
		} else if (allClients.length == 1) {
			allClients = null;
		} else if (isClientInArray(c)) {
			System.out.println("Client not in the array");
		} else {
			Client[] newList = new Client[allClients.length - 1];
			for (int i = 0, j = 0; i < allClients.length; i++) {
				if (!allClients[i].equals(c)) {
					newList[j] = allClients[i];
					j++;
				}

			}
			allClients = newList;
		}

	}

	private static boolean isClientInArray(Client c) {
		if (allClients == null) {

			System.out.println("Array empty");
			return false;

		} else {

			for (int i = 0; i < allClients.length; i++) {

				if (allClients[i].equals(c)) {
					return true;
				}
			}
		}
		return false;
	}

	public void addVehicleToArray(Vehicles v) {

		switch (v.getType()) {

		case "GC":
			System.out.println(v.getType());
			addCarToArray(allGasolineCars, v);
			break;
		case "EC":
			System.out.println(v.getType());
			addCarToArray(allElectricCars, v);
			break;
		case "DT":
			addCarToArray(allDieselTrucks, v);
			System.out.println(v.getType());
			break;
		case "ET":
			addCarToArray(allElectricTrucks, v);
			System.out.println(v.getType());
			break;
		default:
			System.err.println("Something wrong accured in addVehicleToArray");
			break;
		}

	}

	private static void addCarToArray(Vehicles[] arr, Vehicles v) {

		switch (v.getType()) {

		case "GC":
			Car[] newArrCar = null;
			if (arr == null) {
				newArrCar = new Car[1];
				newArrCar[0] = (Car) v;
			} else {
				newArrCar = new Car[arr.length + 1];
				for (int i = 0; i < arr.length; i++) {
					newArrCar[i] = (Car) arr[i];
				}
				newArrCar[newArrCar.length] = (Car) v;

			}
			allGasolineCars = newArrCar;
			break;
		case "EC":
			ElectricCar[] newArrECar = null;
			if (arr == null) {
				newArrECar = new ElectricCar[1];
				newArrECar[0] = (ElectricCar) v;
			} else {
				newArrECar = new ElectricCar[arr.length + 1];
				for (int i = 0; i < arr.length; i++) {
					newArrECar[i] = (ElectricCar) arr[i];
				}
				newArrECar[newArrECar.length] = (ElectricCar) v;

			}
			allElectricCars = newArrECar;
			break;
		case "DT":
			DieselTruck[] newArrDieselT = null;
			if (arr == null) {
				newArrDieselT = new DieselTruck[1];
				newArrDieselT[0] = (DieselTruck) v;
			} else {
				newArrDieselT = new DieselTruck[arr.length + 1];
				for (int i = 0; i < arr.length; i++) {
					newArrDieselT[i] = (DieselTruck) arr[i];
				}
				newArrDieselT[newArrDieselT.length] = (DieselTruck) v;

			}
			allDieselTrucks = newArrDieselT;
			break;
		case "ET":

			ElectricTruck[] newArrET = null;
			if (arr == null) {
				newArrET = new ElectricTruck[1];
				newArrET[0] = (ElectricTruck) v;
			} else {
				newArrET = new ElectricTruck[arr.length + 1];
				for (int i = 0; i < arr.length; i++) {
					newArrET[i] = (ElectricTruck) arr[i];
				}
				newArrET[newArrET.length] = (ElectricTruck) v;

			}
			allElectricTrucks = newArrET;
			break;
		default:
			System.err.println("Something wrong accured in addCarToArray");
			break;
		}
	}

	public void deleteVehicle(String plateNb) {

		if (isVehiculeInArray(plateNb)) {
			String typeOfPlate = plateNb.substring(0, 2);
			switch (typeOfPlate) {

			case "GC":
				if (allGasolineCars.length == 1) {
					allGasolineCars = null;
				} else {

					Car[] newCarArr = new Car[allGasolineCars.length - 1];
					for (int i = 0, j = 0; i < allGasolineCars.length; i++) {
						if (!allGasolineCars[i].getPlateNb().equals(typeOfPlate)) {
							newCarArr[j] = (Car) allGasolineCars[i];
							j++;
						}

					}
					allGasolineCars = newCarArr;
				}

				break;
			case "EC":
				if (allElectricCars.length == 1) {
					allElectricCars = null;
				} else {
					ElectricCar[] newECarArr = new ElectricCar[allElectricCars.length - 1];
					for (int i = 0, j = 0; i < allElectricCars.length; i++) {
						if (!allElectricCars[i].getPlateNb().equals(typeOfPlate)) {
							newECarArr[j] = (ElectricCar) allElectricCars[i];
							j++;
						}

					}
					allElectricCars = newECarArr;
				}
				break;
			case "DT":
				if (allDieselTrucks.length == 1) {
					allDieselTrucks = null;
				} else {
					DieselTruck[] newDieselTArr = new DieselTruck[allDieselTrucks.length - 1];
					for (int i = 0, j = 0; i < allDieselTrucks.length; i++) {
						if (!allDieselTrucks[i].getPlateNb().equals(typeOfPlate)) {
							newDieselTArr[j] = (DieselTruck) allDieselTrucks[i];
							j++;
						}

					}
					allDieselTrucks = newDieselTArr;
				}
				break;
			case "ET":
				if (allElectricTrucks.length == 1) {
					allElectricTrucks = null;
				} else {
					ElectricTruck[] newETArr = new ElectricTruck[allElectricTrucks.length - 1];
					for (int i = 0, j = 0; i < allElectricTrucks.length; i++) {
						if (!allElectricTrucks[i].getPlateNb().equals(typeOfPlate)) {
							newETArr[j] = (ElectricTruck) allElectricTrucks[i];
							j++;
						}

					}
					allElectricTrucks = newETArr;
				}
				break;
			default:
				System.err.println("Something wrong happened in deleteVehicles");
				break;
			}

		} else {
			System.err.println("Vehicle not in the array");
		}

	}

	private boolean isVehiculeInArray(String plateNB) {

		String typeOfPlate = plateNB.substring(0, 2);

		switch (typeOfPlate) {

		case "GC":
			if (allGasolineCars == null) {
				System.err.println("Array is empty");
			} else {
				for (int i = 0; i < allGasolineCars.length; i++) {
					if (allGasolineCars[i].getPlateNb().equals(plateNB)) {
						return true;
					}
				}
			}
			break;
		case "EC":
			if (allElectricCars == null) {
				System.err.println("Array is empty");
			} else {
				for (int i = 0; i < allElectricCars.length; i++) {
					if (allElectricCars[i].getPlateNb().equals(plateNB)) {
						return true;
					}
				}
			}
			break;
		case "DT":
			if (allDieselTrucks == null) {
				System.err.println("Array is empty");
			} else {
				for (int i = 0; i < allDieselTrucks.length; i++) {
					if (allDieselTrucks[i].getPlateNb().equals(plateNB)) {
						return true;
					}
				}
			}
			break;
		case "ET":
			if (allElectricTrucks == null) {
				System.err.println("Array is empty");
			} else {
				for (int i = 0; i < allElectricTrucks.length; i++) {
					if (allElectricTrucks[i].getPlateNb().equals(plateNB)) {
						return true;
					}
				}
			}
			break;
		default:

			return false;

		}
		return false;
	}

	public void listAllVehiclesByCat() {
		if (allGasolineCars == null) {
			System.err.println("No Gasoline Cars");
		} else {
			System.out.println("Gasoline Cars:");
			for (int i = 0; i < allGasolineCars.length; i++) {

				System.out.println("#" + i + " " + allGasolineCars[i]);
			}
			System.out.println();
		}
		if (allElectricCars == null) {
			System.err.println("No Electric Cars");
		} else {
			System.out.println("Electric Cars:");
			for (int i = 0; i < allElectricCars.length; i++) {

				System.out.println("#" + i + " " + allElectricCars[i]);
			}
			System.out.println();
		}
		if (allDieselTrucks == null) {
			System.err.println("No Diesel Trucks");
		} else {
			System.err.println("Diesel Trucks:");
			for (int i = 0; i < allDieselTrucks.length; i++) {

				System.out.println("#" + i + " " + allDieselTrucks[i]);
			}
			System.out.println();
		}
		if (allElectricTrucks == null) {
			System.err.println("No Electric Trucks");
		} else {
			System.out.println("Electric Trucks:");
			for (int i = 0; i < allElectricTrucks.length; i++) {

				System.out.println("#" + i + " " + allElectricTrucks[i]);
			}
			System.out.println();
		}
	}

	public void editVehicle(String plateNbToEdit, String newV) {

		if (isVehiculeInArray(plateNbToEdit)) {
			String typeOfPlate = plateNbToEdit.substring(0, 2);

			switch (typeOfPlate) {
			case "GC":
				String[] carParts = newV.split(" ");
				for (int i = 0; i < allGasolineCars.length; i++) {
					if (allGasolineCars[i].getPlateNb().equals(plateNbToEdit)) {

						allGasolineCars[i].setModel(carParts[0]);
						allGasolineCars[i].setYearOfProduction(Integer.valueOf(carParts[1]));
						allGasolineCars[i].setMake(carParts[2]);
						allGasolineCars[i].setMaxNbPassangers(Integer.valueOf(carParts[3]));
						break;
					}
				}
				break;
			case "EC":
				String[] eCarParts = newV.split(" ");
				for (int i = 0; i < allElectricCars.length; i++) {
					if (allElectricCars[i].getPlateNb().equals(plateNbToEdit)) {

						allElectricCars[i].setModel(eCarParts[0]);
						allElectricCars[i].setYearOfProduction(Integer.valueOf(eCarParts[1]));
						allElectricCars[i].setMake(eCarParts[2]);
						allElectricCars[i].setMaxNbPassangers(Integer.valueOf(eCarParts[3]));
						allElectricCars[i].setMaxRange(Double.valueOf(eCarParts[4]));
						break;
					}
				}
				break;
			case "DT":
				String[] truckParts = newV.split(" ");
				for (int i = 0; i < allDieselTrucks.length; i++) {
					if (allDieselTrucks[i].getPlateNb().equals(plateNbToEdit)) {

						allDieselTrucks[i].setModel(truckParts[0]);
						allDieselTrucks[i].setYearOfProduction(Integer.valueOf(truckParts[1]));
						allDieselTrucks[i].setMake(truckParts[2]);
						allDieselTrucks[i].setMaxCapacity(Double.valueOf(truckParts[3]));
						allDieselTrucks[i].setTankCapa(Double.valueOf(truckParts[4]));
						break;
					}
				}
				break;
			case "ET":
				String[] eTruckParts = newV.split(" ");
				for (int i = 0; i < allElectricTrucks.length; i++) {
					if (allElectricTrucks[i].getPlateNb().equals(plateNbToEdit)) {

						allElectricTrucks[i].setModel(eTruckParts[0]);
						allElectricTrucks[i].setYearOfProduction(Integer.valueOf(eTruckParts[1]));
						allElectricTrucks[i].setMake(eTruckParts[2]);
						allElectricTrucks[i].setMaxCapacity(Double.valueOf(eTruckParts[3]));
						allElectricTrucks[i].setMaxRange(Double.valueOf(eTruckParts[4]));
						break;
					}
				}
				break;
			default:
				break;
			}

		} else {
			System.err.println("Car not found ");
		}

	}

	public static DieselTruck getLargestTruck(DieselTruck[] array) {
		int arraySize = array.length;
		int positionBeiggestTruck = 0;
		for (int i = 1; i < arraySize; i++) {
			if (array[i].getMaxCapacity() > array[positionBeiggestTruck].getMaxCapacity()) {
				positionBeiggestTruck = i;
			}
		}

		return new DieselTruck(array[positionBeiggestTruck]);
	}

}
