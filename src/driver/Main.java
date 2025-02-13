package driver;

import java.util.Scanner;

import client_related_classes.Client;
import vehicules_related_classes.Car;
import vehicules_related_classes.DieselTruck;
import vehicules_related_classes.ElectricCar;
import vehicules_related_classes.ElectricTruck;

public class Main {

	public static void main(String[] args) {
		boolean programEnd = false;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Hello and welcome to RoyalRentals");
		
		do {
		String choice = null;
		displayOptions();
		choice = sc.next();
		sc.nextLine();
		switch(choice) {
		case "1":
			displayOptionsVehicles();
			break;
		case "2":
			displayOptionsClient();
			break;
		case "3":
			displayOptionsLease();
			break;
		case "4":
			displayOptionsAdditional();
			break;
		case "5":
			programEnd = true;
			break;
		default:
			System.err.println("Wrong input");
			break;
		}
		
		
		}while(!programEnd);
		
		System.out.println("Thank you,\nGood bye!");
	}
	
	public static void displayOptions() {
		System.out.println("""
				1) Vehicles management
				2) Client management
				3) Leasing operations
				4) Additional operations
				5) Exit
			Your choice is ->:""");
	}
	
	public static void displayOptionsVehicles() {
		System.out.println("""
				1) Add a vehicles
				2) Delete a vehicles
				3) Edit a vehicles
				4) List all vehicles by category (electric trucks, diesel trucks, etc.)
				5) Back
			Your choice is ->:""");
	}
	
	public static void displayOptionsClient() {
		System.out.println("""
				1) Add a client
				2) Delete a client
				3) Edit a client
				4) Back
			Your choice is ->:""");
	}
	
	public static void displayOptionsLease() {
		System.out.println("""
				1) Lease a vehicle to a client 
				2) Return a vehicle from a client 
				3) Show all vehicles leased by a client
				4) Show all leased vehicles (by all clients)
				5) Back
			Your choice is ->:""");
	}
	public static void displayOptionsAdditional() {
		System.out.println("""
				1) Display the truck with the largest capacity
				2) Create a copy of the electric trucks array
				3) Back
			Your choice is ->:""");
	}
	
	public static void predefinedScenario() {
		
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
		
		System.out.println();
		Client Alex = new Client("Alex");
		Client b = new Client("Alex");
		//System.out.println(c);
		
		Alex.addVehiclesToClient(ec2);
		System.out.println(Alex);
		Alex.removeVehiclesFromClient(ec2);
		
		
	}
	
	
}
