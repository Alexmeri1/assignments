package assignment_1;

public class Driver {

	public static void main(String[] args) {

	

		Car c1 = new Car();
		Car c2 = new Car("BMW", 2024, "BMW motors", 5);
		Car c3 = new Car(c2);
		Car c4 = new Car(c3);
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);

		System.out.println(c1.equals(c3)); // false
		// System.out.println(c2.equals(c3)); // true

		ElectricTruck et1 = new ElectricTruck();
		ElectricTruck et2 = new ElectricTruck("Volvo", 2011, "car company", 1540, 500);
		ElectricTruck et3 = new ElectricTruck(et2);

		System.out.println(et1);
		System.out.println(et2);
		System.out.println(et3);
		
		DieselTruck dt1 = new DieselTruck();
		DieselTruck dt2 = new DieselTruck("Volvo", 2011, "car company", 1404, 1000);
		DieselTruck dt3 = new DieselTruck(dt2);

		System.out.println(dt1);
		System.out.println(dt2);
		System.out.println(dt3);

		ElectricCar ec1 = new ElectricCar();
		ElectricCar ec2 = new ElectricCar("Tesla", 2015, "Testla inc.", 15, 430);
		ElectricCar ec3 = new ElectricCar(ec2);

		System.out.println(ec1);
		System.out.println(ec2);
		System.out.println(ec3);
		
		
		Client c = new Client("Alex");
		//System.out.println(c);
		
		c.addVehiclesToClient(ec2);
		c.removeVehiclesFromClient(ec2);
		System.out.println(c);
		
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

//	public static ElectricTruck[] copyVehicles(ElectricTruck[] arrayToCopy) {
//			
//		
//	}
	
}
