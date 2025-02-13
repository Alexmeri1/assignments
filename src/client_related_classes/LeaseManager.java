package client_related_classes;

import vehicules_related_classes.Car;
import vehicules_related_classes.DieselTruck;
import vehicules_related_classes.ElectricCar;
import vehicules_related_classes.ElectricTruck;
import vehicules_related_classes.Vehicles;

public class LeaseManager {

	protected Car[] allGasolineCars;

	protected ElectricCar[] allElectricCars;

	protected DieselTruck[] allDieselTrucks;

	protected ElectricTruck[] allElectricTrucks;

	public boolean isVehiculeInArray(Vehicles[] array,Vehicles v) {
		
		switch(v.getType()){
		
		case "GC": //gasoline car
			
			break;
		case "EC":
			
			break;
		case "ET":
			
			break;
		case "DT":
			
			break;
		default:
			return true;
			
		}
		
		return false;
		
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
