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

	protected Client allClients[] = null;

	public void addClient(Client c) {
		if (allClients == null) {
			allClients = new Client[1];
			allClients[0] = c;
		} else {
			Client[] newList = new Client[allClients.length + 1];
			for (int i = 0; i < allClients.length; i++) {
				newList[i] = allClients[i];
			}
			newList[allClients.length - 1] = c;
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

	private boolean isClientInArray(Client c) {
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
			System.err.println("Something wrong accured in addVehicleToArray");
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
//		allGasolineCars = newArrCar;
//		
//		
//
//		switch (v.getType()) {
//
//		case "GC":
//			Car[] newArrCar = null;
//			if (arr == null) {
//				newArrCar = new Car[1];
//				newArrCar[0] = (Car) v;
//			} else {
//				newArrCar = new Car[arr.length + 1];
//				for (int i = 0; i < arr.length; i++) {
//					newArrCar[i] = (Car) arr[i];
//				}
//				newArrCar[newArrCar.length - 1] = (Car) v;
//
//			}
//			allGasolineCars = newArrCar;
//			break;
//		case "EC":
//			ElectricCar[] newArrECar = null;
//			if (arr == null) {
//				newArrECar = new ElectricCar[1];
//				newArrECar[0] = (ElectricCar) v;
//			} else {
//				newArrECar = new ElectricCar[arr.length + 1];
//				for (int i = 0; i < arr.length; i++) {
//					newArrECar[i] = (ElectricCar) arr[i];
//				}
//				newArrECar[newArrECar.length - 1] = (ElectricCar) v;
//
//			}
//			allElectricCars = newArrECar;
//			break;
//		case "DT":
//			DieselTruck[] newArrDieselT = null;
//			if (arr == null) {
//				newArrDieselT = new DieselTruck[1];
//				newArrDieselT[0] = (DieselTruck) v;
//			} else {
//				newArrDieselT = new DieselTruck[arr.length + 1];
//				for (int i = 0; i < arr.length; i++) {
//					newArrDieselT[i] = (DieselTruck) arr[i];
//				}
//				newArrDieselT[newArrDieselT.length - 1] = (DieselTruck) v;
//
//			}
//			allDieselTrucks = newArrDieselT;
//			break;
//		case "ET":
//
//			ElectricTruck[] newArrET = null;
//			if (arr == null) {
//				newArrET = new ElectricTruck[1];
//				newArrET[0] = (ElectricTruck) v;
//			} else {
//				newArrET = new ElectricTruck[arr.length + 1];
//				for (int i = 0; i < arr.length; i++) {
//					newArrET[i] = (ElectricTruck) arr[i];
//				}
//				newArrET[newArrET.length - 1] = (ElectricTruck) v;
//
//			}
//			allElectricTrucks = newArrET;
//			break;
//		default:
//			System.err.println("Something wrong accured in addCarToArray");
//			break;
//		}
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
			System.err.println("Something wrong accured in deleteVehicle");
			break;
		}

//		
//		if (isVehiculeInArray(plateNb)) {
//			String typeOfPlate = plateNb.substring(0, 2);
//			switch (typeOfPlate) {
//
//			case "GC":
//				if (allGasolineCars.length == 1) {
//					allGasolineCars = null;
//				} else {
//
//					Car[] newCarArr = new Car[allGasolineCars.length - 1];
//					for (int i = 0, j = 0; i < allGasolineCars.length; i++) {
//						if (!allGasolineCars[i].getPlateNb().equals(typeOfPlate)) {
//							newCarArr[j] = (Car) allGasolineCars[i];
//							j++;
//						}
//
//					}
//					allGasolineCars = newCarArr;
//				}
//
//				break;
//			case "EC":
//				if (allElectricCars.length == 1) {
//					allElectricCars = null;
//				} else {
//					ElectricCar[] newECarArr = new ElectricCar[allElectricCars.length - 1];
//					for (int i = 0, j = 0; i < allElectricCars.length; i++) {
//						if (!allElectricCars[i].getPlateNb().equals(typeOfPlate)) {
//							newECarArr[j] = (ElectricCar) allElectricCars[i];
//							j++;
//						}
//
//					}
//					allElectricCars = newECarArr;
//				}
//				break;
//			case "DT":
//				if (allDieselTrucks.length == 1) {
//					allDieselTrucks = null;
//				} else {
//					DieselTruck[] newDieselTArr = new DieselTruck[allDieselTrucks.length - 1];
//					for (int i = 0, j = 0; i < allDieselTrucks.length; i++) {
//						if (!allDieselTrucks[i].getPlateNb().equals(typeOfPlate)) {
//							newDieselTArr[j] = (DieselTruck) allDieselTrucks[i];
//							j++;
//						}
//
//					}
//					allDieselTrucks = newDieselTArr;
//				}
//				break;
//			case "ET":
//				if (allElectricTrucks.length == 1) {
//					allElectricTrucks = null;
//				} else {
//					ElectricTruck[] newETArr = new ElectricTruck[allElectricTrucks.length - 1];
//					for (int i = 0, j = 0; i < allElectricTrucks.length; i++) {
//						if (!allElectricTrucks[i].getPlateNb().equals(typeOfPlate)) {
//							newETArr[j] = (ElectricTruck) allElectricTrucks[i];
//							j++;
//						}
//
//					}
//					allElectricTrucks = newETArr;
//				}
//				break;
//			default:
//				System.err.println("Something wrong happened in deleteVehicles");
//				break;
//			}
//
//		} else {
//			System.err.println("Vehicle not in the array");
//		}

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
			System.err.println("No Gasoline Cars");
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
			System.err.println("Diesel Trucks:");
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
			System.err.println("Something wrong accured in deleteVehicle");
			break;
		}

	}

	public static DieselTruck getLargestTruck(Vehicle[] array) {
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

}
