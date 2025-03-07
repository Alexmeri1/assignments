package driver;
// Assignment 1
// Written by: Alexander Meriakri #40310155

// This is the main application class for the RoyalRentals system.
// It manages client interactions for vehicle rentals using predefined scenarios or manual testing.

import java.util.Scanner;

import client_related_classes.LeaseManager;
import client_related_classes.Client;
import vehicules_related_classes.Car;
import vehicules_related_classes.DieselTruck;
import vehicules_related_classes.ElectricCar;
import vehicules_related_classes.ElectricTruck;
import vehicules_related_classes.Vehicle;

public class RoyalRentalsApplication {

    // Scanner object to handle user inputs.
    private Scanner sc = new Scanner(System.in);

    // LeaseManager object that handles core client-vehicle leasing relationships.
    private LeaseManager manager = new LeaseManager();

    public static void main(String[] args) {
        // Application entry point
        RoyalRentalsApplication application = new RoyalRentalsApplication();
        application.run();
    }


    private void run() {

        System.out.println("Hello and welcome to RoyalRentals");

        displayIntialChoice(); // Displays the initial menu choices to the user.

        String c = getUserInput();
        switch (c) {
            case "1": {
                processPredefinedScenario(); // Runs a hardcoded set of operations.
                break;
            }
            case "2": {
                processManualTesting(); // Allows the user to interact manually with the system.
                break;
            }
            default:
                System.out.println("Wrong input"); // Handles invalid input.
        }

        System.out.println("\nThank you,\nGood bye!");
    }

    // Runs a predefined scenario for testing
    private void processPredefinedScenario() {

        // Creating various types of vehicles for testing.
        Car c1 = new Car();
        Car c2 = new Car("BMW", 2024, "BMW motors", 5);
        Car c3 = new Car(c2);

        ElectricTruck et1 = new ElectricTruck();
        ElectricTruck et2 = new ElectricTruck("Volvo", 2011, "car company", 1540, 500);
        ElectricTruck et3 = new ElectricTruck("Cool", 2020, "car", 1000, 510);

        DieselTruck dt1 = new DieselTruck();
        DieselTruck dt2 = new DieselTruck("Volvo", 2011, "car company", 1404, 1000);
        DieselTruck dt3 = new DieselTruck("Ram", 2020, "car", 16000, 10000);

        ElectricCar ec1 = new ElectricCar();
        ElectricCar ec2 = new ElectricCar("Tesla", 2015, "Testla inc.", 15, 430);
        ElectricCar ec3 = new ElectricCar(ec2);

        Client Alex = new Client("Alex LePied");
        Client Vincent = new Client("Vincent-Boilette-LaCigarette");
        Client idk = new Client();


        System.out.println(Alex);
        System.out.println(Vincent);
        System.out.println(idk);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        System.out.println(et1);
        System.out.println(et2);
        System.out.println(et3);

        System.out.println(dt1);
        System.out.println(dt2);
        System.out.println(dt3);

        System.out.println(ec1);
        System.out.println(ec2);
        System.out.println(ec3);

        // Testing the equals method for vehicle comparison.
        System.out.println(ec1.equals(c2)); // Should return false as types differ.
        System.out.println(ec1.equals(ec2)); // Should return false as objects are different.
        System.out.println(ec2.equals(ec3)); // Should return true as ec3 is a copy of ec2.

        // Creating arrays to manage and organize the vehicles.
        Vehicle[] manyCars = {c1, c2, c3};
        Vehicle[] manyElectricCars = {ec1, ec2, ec3};
        Vehicle[] manyDieselTrucks = {dt1, dt2, dt3};
        Vehicle[] manyElectricTrucks = {et1, et2, et3};
        Vehicle[] manyVehicles = {c1, c2, c3, ec1, ec2, ec3, dt1, dt2, dt3, et1, et2, et3};

        // Finding the largest diesel truck and printing it.
        System.out.println("Largest truck is: ");
        System.out.println(getLargestTruck(manyDieselTrucks));
        System.out.println();
        
        // Creating a copy of electric trucks and displaying them both.
        Vehicle[] copyElec = copyVehicles(manyElectricTrucks);
        System.out.println("Copy vs \nOriginal");
        for (int i = 0; i < copyElec.length; i++) {
            System.out.println(copyElec[i] + "\n" + manyElectricTrucks[i]);
        }


        manager.addClient(Alex);
        manager.addVehicle(ec2);
        manager.addVehicle(dt3);
        manager.addVehicle(et1);
        manager.addVehicle(c1);


        // Leasing operations to test adding, listing, and removing leased vehicles.
        manager.leaseVehicle(Alex.getClientID(), ec2.getPlateNb()); // Leasing the vehicle ec2 to client Alex.
        manager.listAllLeasedVehicles(); // Displaying all leased vehicles across clients.
        manager.unLeaseVehicle(Alex.getClientID(), ec2.getPlateNb()); // Returning the leased vehicle from Alex.

        	
    }

    // Provides a menu-driven interface for manual testing of the application's features.
    private void processManualTesting() {
        boolean runs = true;
        String choice = null;
        do {

            displayOptions();
            choice = getUserInput();
            switch (choice) {
                case "1": {

                    processOptionsVehicles();
                    break;
                }
                case "2": {
                    processOptionsClient();

                    break;
                }
                case "3": {
                    processOptionsLease();
                    break;
                }
                case "4": {
                    processOptionsAdditional();
                    break;
                }
                case "5": {
                    runs = false;
                    break;
                }

                default:
                    System.err.println("Wrong input");
            }

        } while (runs);

    }

    // Provides features, like finding the largest truck
    // and creating a copy of the electric truck array.
    private void processOptionsAdditional() {

        boolean runs = true;
        String choice;
        do {
            displayOptionsAdditional();
            choice = getUserInput();

            switch (choice) {
                case "1": {

                    Vehicle largestTruck = getLargestTruck(manager.getArrayDiselTruck());
                    if (largestTruck == null) {
                        System.out.println("No trucks");
                    } else {
                        System.out.println("The largest truck is :\n" + largestTruck);
                    }
                    break;
                }
                case "2": {
                    Vehicle[] elecCopy = copyVehicles(manager.getArrayElectricTruck());
                    if (elecCopy == null) {
                        System.out.println("No electric trucks");

                    } else {
                        System.out.println("The copied array is:");
                        for (int i = 0; i < elecCopy.length; i++) {
                            System.out.println(elecCopy[i]);
                        }
                    }
                    break;
                }
                case "3": {
                    runs = false;
                    break;

                }

                default:
                    System.err.println("Wrong input");
            }
        } while (runs);


    }

    // Handles leasing operations such as leasing a vehicle, returning a leased vehicle,
    // and viewing vehicles leased by a client or all clients.
    private void processOptionsLease() {

        boolean runs = true;
        String choice;
        do {
            displayOptionsLease();
            choice = getUserInput();

            switch (choice) {
                case "1": {
                    System.out.println("Write the ID of the client, semi colon (;), plate number of the vehicles\n");
                    manager.listAllVehiclesByCat();
                    manager.listAllClients();
                    String[] idAndPlate = (getUserInput().trim()).split(";");
                    manager.leaseVehicle(Integer.valueOf(idAndPlate[0]), idAndPlate[1]);

                    break;
                }
                case "2": {
                    System.out.println("Write the ID of the client, semi colon (;), plate number of the vehicles\n");
                    manager.listAllVehiclesByCat();
                    manager.listAllClients();
                    String[] idAndPlate = (getUserInput().trim()).split(";");
                    manager.unLeaseVehicle(Integer.valueOf(idAndPlate[0]), idAndPlate[1]);
                    break;
                }
                case "3": {
                    System.out.println("Write the ID of the client");
                    manager.listAllClients();
                    System.out.print("Your choice ->: ");
                    int id = Integer.valueOf(getUserInput().trim());
                    manager.listAllVehiclesForClient(id);
                    break;
                }
                case "4": {
                    manager.listAllLeasedVehicles();
                    break;
                }
                case "5": {
                    runs = false;
                    break;
                }

                default:
                    System.err.println("Wrong input");
            }
        } while (runs);

    }

    // Manages client-related functionality including adding, editing, and deleting clients.
    private void processOptionsClient() {

        boolean runs = true;
        String choice;
        do {
            displayOptionsClient();
            choice = getUserInput();

            switch (choice) {
                case "1": {

                    System.out.println("Enter the name of the client:");
                    String name = getUserInput();
                    manager.addClient(new Client(name));

                    break;
                }
                case "2": {
                    System.out.println("Enter the ID of the client, among the bellow");
                    manager.listAllClients();
                    int id = Integer.valueOf(getUserInput().trim());
                    manager.deleteClient(id);

                    break;
                }
                case "3": {

                    System.out.println("Enter enter the id ,semi-colon (;), new client name ");
                    String[] name = getUserInput().split(";");

                    break;
                }
                case "4": {
                    runs = false;
                    break;
                }

                default:
                    System.err.println("Wrong input");
            }
        } while (runs);

    }

    // Manages vehicle-related tasks such as adding, editing, deleting, and listing vehicles.
    private void processOptionsVehicles() {

        boolean runs = true;
        String choice;
        do {
            displayOptionsVehicles();
            choice = getUserInput();

            switch (choice) {
                case "1": {
                    processAddVehicles();

                    break;
                }
                case "2": {

                    System.out.println("Among all the vehicles choose the 1 want you want to delete."
                            + "\nWrite the plate number off the appropriate car");
                    manager.listAllVehiclesByCat();
                    System.out.print("Your choice ->: ");
                    String plateNbToDelete = sc.next();
                    sc.nextLine();
                    manager.deleteVehicle(plateNbToDelete);
                    break;
                }
                case "3": {
                    System.out.println("Among all the vehicles choose the 1 want you want to edit."
                            + "\nWrite the plate number off the appropriate car");
                    manager.listAllVehiclesByCat();
                    System.out.print("Your choice ->: ");
                    String plateNbToEdit = sc.next();
                    sc.nextLine();
                    System.out.println(
                            "Now write all the attributes (new AND old) of the vehicle, separeted by semi-colon.");
                    String newVehicle = sc.nextLine();
                    manager.editVehicle(plateNbToEdit, newVehicle);
                    break;
                }
                case "4": {
                    manager.listAllVehiclesByCat();
                    break;
                }
                case "5": {
                    runs = false;
                    break;
                }

                default:
                    System.err.println("Wrong input");
            }
        } while (runs);

    }

    private void processAddVehicles() {

        boolean runs = true;
        String choice;
        String newCar[];

        do {
            Vehicle vehicle = null;
            displayAddVehicles();
            choice = getUserInput();

            switch (choice) {
                case "1": {
                    displayWarning();
                    System.out.println(
                            "Model *semi-colon* YearOfProduction *semi-colon* Make *semi-colon* MaxNumberOfPassanger");
                    choice = getUserInput();
                    newCar = choice.split(";");
                    vehicle = new Car(newCar[0], Integer.valueOf(newCar[1].trim()), newCar[2], Integer.valueOf(newCar[3].trim()));
                    manager.addVehicle(vehicle);
                    break;
                }
                case "2": {
                    displayWarning();
                    System.out.println(
                            "Model *semi-colon* YearOfProduction *semi-colon* Make *semi-colon* MaxNumberOfPassanger *semi-colon* MaxRange (Km)");
                    choice = getUserInput();
                    newCar = choice.split(";");
                    vehicle = new ElectricCar(newCar[0], Integer.valueOf(newCar[1].trim()), newCar[2], Integer.valueOf(newCar[3].trim()),
                            Double.valueOf(newCar[4].trim()));
                    manager.addVehicle(vehicle);
                    break;
                }
                case "3": {
                    displayWarning();
                    System.out.println(
                            "Model *semi-colon* YearOfProduction *semi-colon* Make *semi-colon* MaxCapacity (Kg) *semi-colon* TankCapacity (L)");
                    choice = getUserInput();
                    newCar = choice.split(";");
                    vehicle = new DieselTruck(newCar[0], Integer.valueOf(newCar[1].trim()), newCar[2], Double.valueOf(newCar[3].trim()),
                            Double.valueOf(newCar[4].trim()));
                    manager.addVehicle(vehicle);
                    break;
                }
                case "4": {
                    displayWarning();
                    System.out.println(
                            "Model *semi-colon* YearOfProduction *semi-colon* Make *semi-colon* MaxCapacity (Kg) *semi-colon* MaxRange (Km)");
                    choice = getUserInput();
                    newCar = choice.split(";");
                    vehicle = new ElectricTruck(newCar[0], Integer.valueOf(newCar[1]), newCar[2], Double.valueOf(newCar[3]),
                            Double.valueOf(newCar[4].trim()));
                    manager.addVehicle(vehicle);
                    break;
                }
                case "5": {
                    runs = false;
                    break;
                }

                default:
                    System.err.println("Wrong input");
                    break;
            }


        } while (runs);

    }

    private String getUserInput() {
        return sc.nextLine();
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
        System.out.print("""
                What type of vehicles do you want?
                Select from:
                	1): Gasoline car
                	2): Electric car
                	3): Diesel truck
                	4): Eletric truck
                	5): Back
                Your choice is ->: """);
    }

    public static void displayWarning() {
        System.out.println("""
                Don't make an error here!
                Enter all your choices in 1 line, each choice followed by a semi-colon (;).
                """);
    }

    public static void displayOptionsClient() {
        System.out.print("""
                \nSelect from:
                	1) Add a client
                	2) Delete a client
                	3) Edit a client
                	4) Back
                Your choice is ->: """);
    }


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


    public static void displayOptionsAdditional() {
        System.out.print("""
                \nSelect from:
                	1) Display the truck with the largest capacity
                	2) Create a copy of the electric trucks array
                	3) Back
                Your choice is ->: """);
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
