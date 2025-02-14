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

	public void deleteVehicles(Vehicles v) {

		if (isVehiculeInArray(v)) {

			switch (v.getType()) {

			case "GC":
				Car[] newCarArr = new Car[allGasolineCars.length - 1];
				for (int i = 0, j = 0; i < allGasolineCars.length; i++) {
					if (!allGasolineCars[i].equals(v)) {
						newCarArr[j] = allGasolineCars[i];
						j++;
					}

				}

				break;
			case "EC":
				ElectricCar[] newECarArr = new ElectricCar[allElectricCars.length - 1];
				for (int i = 0, j = 0; i < allElectricCars.length; i++) {
					if (!allElectricCars[i].equals(v)) {
						newECarArr[j] = allElectricCars[i];
						j++;
					}

				}
				break;
			case "DT":
				DieselTruck[] newDieselTArr = new DieselTruck[allDieselTrucks.length - 1];
				for (int i = 0, j = 0; i < allDieselTrucks.length; i++) {
					if (!allDieselTrucks[i].equals(v)) {
						newDieselTArr[j] = allDieselTrucks[i];
						j++;
					}

				}
				break;
			case "ET":
				ElectricTruck[] newETArr = new ElectricTruck[allElectricTrucks.length - 1];
				for (int i = 0, j = 0; i < allElectricTrucks.length; i++) {
					if (!allElectricTrucks[i].equals(v)) {
						newETArr[j] = allElectricTrucks[i];
						j++;
					}

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

	private boolean isVehiculeInArray(Vehicles v) {

		switch (v.getType()) {

		case "GC":
			if (allGasolineCars == null) {
				System.err.println("Array empty");
			} else {
				for (int i = 0; i < allGasolineCars.length; i++) {
					if (allGasolineCars[i].equals(v)) {
						return true;
					}

				}
			}

			break;
		case "EC":
			if (allElectricCars == null) {
				System.err.println("Array empty");
			} else {
				for (int i = 0; i < allElectricCars.length; i++) {
					if (allElectricCars[i].equals(v)) {
						return true;
					}

				}
			}
			break;
		case "ET":
			if (allElectricTrucks == null) {
				System.err.println("Array empty");
			} else {
				for (int i = 0; i < allElectricTrucks.length; i++) {
					if (allElectricTrucks[i].equals(v)) {
						return true;
					}

				}
			}
			break;
		case "DT":

			if (allDieselTrucks == null) {
				System.err.println("Array empty");
			} else {
				for (int i = 0; i < allDieselTrucks.length; i++) {
					if (allDieselTrucks[i].equals(v)) {
						return true;
					}

				}
			}
			break;
		default:
			System.err.println("Something wrong happened in isVehiculeInArray");
			return false;

		}

		return false;

	}

	public void listAllVehiclesByCat() {
		if (allGasolineCars == null) {
			System.out.println("No Gasoline Cars");
		} else {
			System.out.println("Gasoline Cars:");
			for (int i = 0; i < allGasolineCars.length; i++) {

				System.out.println("#" + i + " " + allGasolineCars[i]);
			}
			System.out.println();
		}
		if (allElectricCars == null) {
			System.out.println("No Electric Cars");
		} else {
			System.out.println("Electric Cars:");
			for (int i = 0; i < allElectricCars.length; i++) {

				System.out.println("#" + i + " " + allElectricCars[i]);
			}
			System.out.println();
		}
		if (allDieselTrucks == null) {
			System.out.println("No Diesel Trucks");
		} else {
			System.out.println("Diesel Trucks:");
			for (int i = 0; i < allDieselTrucks.length; i++) {

				System.out.println("#" + i + " " + allDieselTrucks[i]);
			}
			System.out.println();
		}
		if (allElectricTrucks == null) {
			System.out.println("No Electric Trucks");
		} else {
			System.out.println("Electric Trucks:");
			for (int i = 0; i < allElectricTrucks.length; i++) {

				System.out.println("#" + i + " " + allElectricTrucks[i]);
			}
			System.out.println();
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
