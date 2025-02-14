package driver;

import java.util.Scanner;

import client_related_classes.LeaseManager;
import client_related_classes.Client;
import vehicules_related_classes.Car;
import vehicules_related_classes.DieselTruck;
import vehicules_related_classes.ElectricCar;
import vehicules_related_classes.ElectricTruck;

public class Main {

	public static void main(String[] args) {
		boolean programEnd = false;
		Scanner sc = new Scanner(System.in);
		LeaseManager manager = new LeaseManager();
		System.out.println("Hello and welcome to RoyalRentals");
		int var = 0;
		displayIntialChoice();

		var = sc.nextInt();

		if (var == 1) {
			predefinedScenario();
		} else if (var == 2) {

			do {
				String choice = null;
				displayOptions();
				choice = sc.next();
				sc.nextLine();
				String secondChoice = null;
				switch (choice) {

				case "1":
					displayOptionsVehicles();
					secondChoice = sc.next();
					sc.nextLine();
					switch (secondChoice) {

					case "1":

						boolean exitLoop = false;

						do {
							// displayAddVehicles();

							System.out.println("""
									What type of vehicles do you want?
									Select from:
										1) Gasoline car
										2) Electric car
										3) Diesel truck
										4) Electric truck
										5) Back
									Your choice is ->: """);
							String choiceV = sc.next();
							sc.nextLine();
							switch (choiceV) {

							case "1":
								displayWarning();
								System.out.println(
										"Model *space* YearOfProduction *space* Make *space* MaxNumberOfPassanger");
								String newCar[] = sc.nextLine().split(" ");

								Car gc = new Car(newCar[0], Integer.valueOf(newCar[1]), newCar[2],
										Integer.valueOf(newCar[3]));

								manager.addVehicleToArray(gc);
								break;
							case "2":
								displayWarning();
								System.out.println(
										"Model *space* YearOfProduction *space* Make *space* MaxNumberOfPassanger *space* MaxRange (Km)");
								String newElectricCar[] = sc.nextLine().split(" ");

								ElectricCar ec = new ElectricCar(newElectricCar[0], Integer.valueOf(newElectricCar[1]),
										newElectricCar[2], Integer.valueOf(newElectricCar[3]),
										Double.valueOf(newElectricCar[4]));
								manager.addVehicleToArray(ec);

								break;
							case "3":
								displayWarning();
								System.out.println(
										"Model *space* YearOfProduction *space* Make *space* MaxCapacity (Kg) *space* TankCapacity (L)");
								String newDieselTruck[] = sc.nextLine().split(" ");

								DieselTruck dt = new DieselTruck(newDieselTruck[0], Integer.valueOf(newDieselTruck[1]),
										newDieselTruck[2], Double.valueOf(newDieselTruck[3]),
										Double.valueOf(newDieselTruck[4]));
								manager.addVehicleToArray(dt);

								break;
							case "4":
								displayWarning();
								System.out.println(
										"Model *space* YearOfProduction *space* Make *space* MaxCapacity (Kg) *space* MaxRange (Km)");
								String newElectricTruck[] = sc.nextLine().split(" ");

								ElectricTruck et = new ElectricTruck(newElectricTruck[0],
										Integer.valueOf(newElectricTruck[1]), newElectricTruck[2],
										Double.valueOf(newElectricTruck[3]), Double.valueOf(newElectricTruck[4]));
								manager.addVehicleToArray(et);
								break;
							case "5":
								exitLoop = true;
								break;
							default:
								System.err.println("Wrong input");
								break;
							}
						} while (!exitLoop);

						break;
					case "2":
						System.out.println("Among all the vehicles choose the 1 want you want to delete."
								+ "\nWrite the plate number off the appropriate car");
						manager.listAllVehiclesByCat();
						System.out.print("Your choice ->: ");
						String plateNbToDelete = sc.next();
						sc.nextLine();
						manager.deleteVehicle(plateNbToDelete);
						
						break;
					case "3":
						System.out.println("Among all the vehicles choose the 1 want you want to edit."
								+ "\nWrite the plate number off the appropriate car");
						manager.listAllVehiclesByCat();
						System.out.print("Your choice ->: ");
						String plateNbToEdit = sc.next();
						sc.nextLine();
						System.out.println(
								"Now write all the attributes (new AND old) of the vehicle, separeted by spaces.");
						String newVehicle = sc.nextLine();
						manager.editVehicle(plateNbToEdit,newVehicle);
						break;
					case "4":
						manager.listAllVehiclesByCat();
						break;
					case "5":
						break;
					default:
						System.err.println("Wrong input");
						break;
					}

					break;
				case "2":
					displayOptionsClient();
					secondChoice = sc.next();
					sc.nextLine();
					switch (secondChoice) {

					case "1":
						System.out.println("Enter the name of the client:");
						String name = sc.nextLine();
						manager.addClient(new Client(name));
						
						
						break;
					case "2":
						
						break;
					case "3":
//						displayEditClient();
						break;
					case "4":
						break;

					default:
						System.err.println("Wrong input");
						break;
					}
					break;
				case "3":
					displayOptionsLease();
					secondChoice = sc.next();
					sc.nextLine();
					switch (secondChoice) {

					case "1":
//						displayLeaseToClient();
						break;

					case "2":
//						displayReturnVToClient();
						break;
					case "3":
//						displayAllVLeasedByAClient();
						break;
					case "4":
//						displayAllLeasedVehicles();
						break;
					case "5":

						break;
					default:
						System.err.println("Wrong input");
						break;
					}
					;
					break;
				case "4":
					displayOptionsAdditional();
					secondChoice = sc.next();
					sc.nextLine();
					switch (secondChoice) {

					case "1":
//						displayTruckWithLargestCap();
						break;
					case "2":
//						displayCopyElectricTruck();
						break;

					default:

						break;
					}

					break;

				case "5":
					programEnd = true;
					break;

				default:
					System.err.println("Wrong input");
					break;
				}
				System.out.println(secondChoice);
			} while (!programEnd);

		} else {

			System.err.println("Invalid input");
		}

		System.out.println("\nThank you,\nGood bye!");
	}

	public static void displayIntialChoice() {
		System.out.print("""
				\nSelect from:
					1) Predefined Scenario
					2) Manual Testing
				Your choice is ->: """);
	}

	public static void displayOptions() {
		System.out.print("""
				\nSelect from:
					1) Vehicles management
					2) Client management
					3) Leasing operations
					4) Additional operations
					5) Exit
				Your choice is ->: """);
	}

	public static void displayOptionsVehicles() {
		System.out.print("""
				\nSelect from:
					1) Add a vehicles
					2) Delete a vehicles
					3) Edit a vehicles
					4) List all vehicles by category (electric trucks, diesel trucks, etc.)
					5) Back
				Your choice is ->: """);
	}

	public static void displayAddVehicles() {
		System.out.println("""
				What type of vehicles do you want?
				Select from:
					"GC": Gasoline car
					"EC": Electric car
					"DT":Diesel	truck
					"ET": Eletric truck
				Your choice is ->: """);
	}

	public static void displayWarning() {
		System.out.println("""
				Don't make an error here!
				Enter all your choices in 1 line, each choice followed by a space.
				""");
	}

//	
//	public static void displayDeleteVehicles() {
//		
//	}
//	
//	public static void displayEditVehicles(){
//		
//	}
//	
//	public static void displayListAllVehicles(){
//		
//	}

	public static void displayOptionsClient() {
		System.out.print("""
				\nSelect from:
					1) Add a client
					2) Delete a client
					3) Edit a client
					4) Back
				Your choice is ->: """);
	}

//	public static void displayAddClient() {
//		
//	}
//
//	public static void displayDeleteClient() {
//		
//	}
//
//	public static void displayEditClient() {
//		
//	}

	public static void displayOptionsLease() {
		System.out.print("""
				\nSelect from:
					1) Lease a vehicle to a client
					2) Return a vehicle from a client
					3) Show all vehicles leased by a client
					4) Show all leased vehicles (by all clients)
					5) Back
				Your choice is ->: """);
	}
//	public static void displayLeaseToClient(){
//		
//	}
//
//	public static void displayReturnVToClient(){
//		
//	}
//
//	public static void displayAllVLeasedByAClient(){
//		
//	}
//
//	public static void displayAllLeasedVehicles(){
//		
//	}

	public static void displayOptionsAdditional() {
		System.out.print("""
				\nSelect from:
					1) Display the truck with the largest capacity
					2) Create a copy of the electric trucks array
					3) Back
				Your choice is ->: """);
	}

//	public static void displayTruckWithLargestCap(){
//		
//	}
//	
//	public static void displayCopyElectricTruck(){
//		
//	}

	public static void predefinedScenario() {

		Car c1 = new Car();
		Car c2 = new Car("BMW", 2024, "BMW motors", 5);
		Car c3 = new Car(c2);
		Car c4 = new Car(c3);
		System.out.println(c1.getModel());

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
		Client Alex = new Client("Alex LePied");
		Client Vincent = new Client("Vincent-Boilette-LaCigarette");
		System.out.println(Vincent);

		Alex.addVehiclesToClient(ec2);
		System.out.println(Alex);
		Alex.removeVehiclesFromClient(ec2);

	}

}
