package assignments;

import java.util.Scanner;

//---------------------------------------------------------
//Assignment 4 
//Written by: Alexander Meriakri #40310155
//For COMP 248 Section P – Fall 2024 
//---------------------------------------------------------
/*
This is the driver class that allows me to test the other classes.
I provide the user with 10 choices
1: Display everything in each registry
2: Display 1 specific registry
3: Lists all the registries that have the same amounts
4: Lists all the registries which have the same number of stamps types
5: Lists all the registries that have the same total amount of stamps and the same number of labels
6: Can add 1 label to the registry
7: Can remove 1 label from the registry
8: Update the expiry date of a specific label
9: To add stamps to the registry
and 0 to quit
*/
public class MissDemo {

	public static void main(String[] args) {

		System.out.println("Hello user!\n");

		Scanner sc = new Scanner(System.in);

		// All the stamps, labels and registries for the tests
		Stamps stamp1 = new Stamps(1, 2, 3, 4, 5);
		Stamps stamp2 = new Stamps(5, 2, 1, 0, 0);
		Stamps stamp3 = new Stamps(0, 0, 0, 2, 0);
		Stamps stamp4 = new Stamps(1, 1, 1, 1, 1);

		Label label1 = new Label("Standard", 98123456, 1, 2);
		Label label2 = new Label("Small", 98322132, 12, 12);
		Label label3 = new Label("Oversize", 98856490, 5, 2);
		Label label4 = new Label("Express", 98223571, 30, 6);

		Registry regExactSame1 = new Registry(stamp1, new Label[] { label1 });
		Registry regExactSame2 = new Registry(stamp1, new Label[] { label1 });
		Registry regSameStamp1 = new Registry(stamp2, new Label[] { label2, label3, label4 });
		Registry regSameStamp2 = new Registry(stamp3, new Label[] { label2, label3, label4 });
		Registry regWithNoLable1 = new Registry(stamp4, new Label[] {});
		Registry regWithNoLable2 = new Registry(stamp4, new Label[] {});

		// An array with all of the registries
		Registry[] arrayOfAllTheRegistries = { regExactSame1, regExactSame2, regSameStamp1, regSameStamp2,
				regWithNoLable1, regWithNoLable2 };

		// Length of the array above
		int lengthOfTheArrayWithAllRegistries = arrayOfAllTheRegistries.length;
		// Display everything in the registry

		// boolean to exit the main loop
		boolean exitMainLoop = false;

		do {
			// String that holds the user's choice
			String choice = "";
			// Presents all the options
			System.out.print("""
					What would you like to do?
						1. See the content of all Registries
						2. See the content of one Registry
						3. List Registries with same $ amount of shipment stamps
						4. List Registry with same number of shipment Stamps types
						5. List Registries with same $ amount of Stamps and same number of prepaid Labels
						6. Add a prepaid label to an existing Registry
						7. Remove an existing prepaid label from a Registry
						8. Update the expiry date of an existing prepaid Label
						9. Add Stamps to a Registry
						0. To quit

					Please enter your choice and press <Enter>: """);
			// reads and stores the choice of the user
			choice = sc.next();
			sc.nextLine(); // Consume the line
			System.out.println("");// Skip a line for esthetics

			switch (choice) { // See the content of all Registries
			case "1":
				for (int i = 0; i < lengthOfTheArrayWithAllRegistries; i++) {
					// The number of the registry
					System.out.printf("Registry #%d:\n", i);
					// The content of that registry
					System.out.println(arrayOfAllTheRegistries[i].toString());
				}
				break;

			case "2": // See the content of one Registry

				boolean breakFromLoop = false;
				System.out.print("Which registry would you like to see the contents of? (Enter number 0 to 5): ");
				do {

					int positionOfReg = sc.nextInt();
					sc.nextLine(); // Consumes the line
					// Check's if not out of bounds
					if (positionOfReg >= 0 && positionOfReg <= 5) {
						// Display's the desired registry
						System.out.println(arrayOfAllTheRegistries[positionOfReg].toString());
						breakFromLoop = true; // allows to exit the loop
					} else {
						System.out.print("Try again (Enter number 0 to 5): ");
					}

				} while (!breakFromLoop);

				break;

			case "3": // List Registries with same $ amount of shipment stamps
				System.out.println("List of registries with same total $ Stamps: ");

				for (int i = 0; i < lengthOfTheArrayWithAllRegistries; i++) {

					for (int j = i + 1; j < lengthOfTheArrayWithAllRegistries; j++) {
						// Checks if the total value of 2 registries are the same and that they are not
						// jus tthe same registry
						if (arrayOfAllTheRegistries[i].isTotalValueStampsEqual(arrayOfAllTheRegistries[j]) && i != j) {
							// Get the total amount inside the stamp for display
							int money = arrayOfAllTheRegistries[i].totalAmountOfMoneyInRegistryInStamp();

							// Display the registries that have the same amounts
							System.out.printf("\tRegistries %d and %d both have %d$\n", i, j, money);
						}
					}

				}
				System.out.println(""); // Skip a line
				break;

			case "4": // List Registry with same number of shipment Stamps types
				for (int i = 0; i < lengthOfTheArrayWithAllRegistries; i++) {

					for (int j = i + 1; j < lengthOfTheArrayWithAllRegistries; j++) {
						// checks if the two have the same exact amounts for each category
						if (arrayOfAllTheRegistries[i].isTwoStampCategoriesEqual(arrayOfAllTheRegistries[j])
								&& i != j) {
							// Gets the stamp.toString() to display
							String seriesOfNumbers = arrayOfAllTheRegistries[i].getStampsFromRegistry();
							// Displays the number of both registries and the inside of the stamp
							System.out.printf("\tRegistries %d and %d both have %s\n", i, j, seriesOfNumbers);
						}
					}

				}
				System.out.println(""); // skips a line
				break;
			case "5": // List Registries with same $ amount of Stamps and same number of prepaid
						// Labels
				for (int i = 0; i < lengthOfTheArrayWithAllRegistries; i++) {

					for (int j = i + 1; j < lengthOfTheArrayWithAllRegistries; j++) {
						// If they are equal according to the deff in registries
						if (arrayOfAllTheRegistries[i].equals(arrayOfAllTheRegistries[j]) && i != j) {
							// Display the registries that are equal
							System.out.printf("\tRegistries %d and %d are equal\n", i, j);
						}
					}

				}
				System.out.println(""); // skips a line
				break;
			case "6": // Add a prepaid label to an existing Registry
				boolean breakFromLoop2 = false;
				System.out.print("Which registry would you like to add a label to? (Enter number 0 to 5): ");
				do {
					int positionOfReg = sc.nextInt();
					sc.nextLine();
					// checks if the position is between boundaries
					if (positionOfReg >= 0 && positionOfReg <= 5) {
						System.out.print("\tType of label (Confidential, small, oversized, Standard or Fragile): ");
						String typeOf = sc.nextLine();

						System.out.print("\tID of the prepaid lable prossessor: ");
						int anID = sc.nextInt();
						sc.nextLine();

						System.out.print("\tExipiry day number and month (sparated by a space): ");
						// Splits the string by spaces, should have 2 things in the array
						String[] expiry = sc.nextLine().split(" ");

						// creates a new label with all the info given
						Label aNewLabel = new Label(typeOf, anID, Integer.parseInt(expiry[0]),
								Integer.parseInt(expiry[1]));

						// gets the number of labels after adding them to the registrie
						int numberOfLabelsInReg = arrayOfAllTheRegistries[positionOfReg].addLabelToRegistery(aNewLabel);

						System.out.printf("You know have %d label in your Registry\n\n", numberOfLabelsInReg);

						breakFromLoop2 = true;
					} else {
						System.out.printf("Invalid registry number. Try again (Enter number 0 to %d): ",
								lengthOfTheArrayWithAllRegistries - 1);
					}

				} while (!breakFromLoop2);

				break;
			case "7": // Remove an existing prepaid label from a Registry

				boolean breakFromLoop3 = false;
				System.out.printf("Which registry would you like to remove a label from? (Enter number 0 to %d): ",
						lengthOfTheArrayWithAllRegistries - 1);

				do {
					int positionOfReg = sc.nextInt();

					sc.nextLine();

					if (positionOfReg >= 0 && positionOfReg <= 5) {

						// gets the registry
						Registry registryFromArray = arrayOfAllTheRegistries[positionOfReg];
						// gets amount of labels in the registry
						int amountOfLabelsInThisRegistry = registryFromArray.howManyLabelsInRegistry();

						// Checks if there are no labels
						if (amountOfLabelsInThisRegistry == 0) {

							System.out.println("Sorry, this registry has no labels.");
							breakFromLoop3 = true;

						} else {
							// to keep asking the position of the label
							boolean validLabelPosition = false;
							int positionOfTheLabel = 0;
							while (!validLabelPosition) {

								System.out.printf(
										"What is the position of the label you want to remove? (Enter number 0 to %d): ",
										amountOfLabelsInThisRegistry - 1);
								positionOfTheLabel = sc.nextInt();
								sc.nextLine();
								// Checks if it is inside the boundaries
								if (positionOfTheLabel >= 0 && positionOfTheLabel < amountOfLabelsInThisRegistry) {

									// gets if it was correctly removed after removing it
									boolean wasItRemoved = registryFromArray
											.removeLableFromRegistery(positionOfTheLabel);
									if (wasItRemoved) {
										System.out.println("The label was successfully removed.\n");
									} else {
										System.out.println("The label was unsuccessfully removed.\n");
									}
									validLabelPosition = true;
									breakFromLoop3 = true;

								} else {

									System.out.println("Invalid label position. Please try again.");
								}
							}
						}
					} else {
						System.out.printf("Invalid registry number. Try again (Enter number 0 to %d): ",
								lengthOfTheArrayWithAllRegistries - 1);
					}
				} while (!breakFromLoop3);

				break;

			case "8": // Remove an existing prepaid label from a Registry
				boolean breakFromLoop4 = false;

				System.out.printf("Which registry would you like to update a label from? (Enter number 0 to %d): ",
						lengthOfTheArrayWithAllRegistries - 1);
				do {

					int positionOfReg = sc.nextInt();

					sc.nextLine();
					if (positionOfReg >= 0 && positionOfReg <= 5) {
						Registry registryFromArray = arrayOfAllTheRegistries[positionOfReg];
						// gets the amount of labels in the registry
						int amountOfLabelsInThisRegistry = registryFromArray.howManyLabelsInRegistry();

						if (amountOfLabelsInThisRegistry == 0) {

							System.out.println("Sorry, this registry has no labels.");
							breakFromLoop4 = true;

						} else {

							boolean validLabelPosition = false;
							int positionOfTheLabel = 0;
							while (!validLabelPosition) {

								System.out.printf(
										"What is the position of the label you want to update the date of? (Enter number 0 to %d): ",
										amountOfLabelsInThisRegistry - 1);
								positionOfTheLabel = sc.nextInt();
								sc.nextLine();

								if (positionOfTheLabel >= 0 && positionOfTheLabel < amountOfLabelsInThisRegistry) {
									System.out
											.print("Enter the new expiry date number and month(seperated by space): ");
									// Split to get 2 different values 1st is the day and 2nd is the month
									String[] newDate = sc.nextLine().split(" ");
									// Updates the date
									registryFromArray.updateExpiryDayAndMonth(Integer.parseInt(newDate[0]),
											Integer.parseInt(newDate[1]), positionOfTheLabel);
									System.out.println("The expiry date was successfully updated.\n");
									validLabelPosition = true;
									breakFromLoop4 = true;

								} else {

									System.out.println("Invalid label position. Please try again.");
								}
							}
						}

					} else {
						System.out.printf("Invalid registry number. Try again (Enter number 0 to %d): ",
								lengthOfTheArrayWithAllRegistries - 1);
					}

				} while (!breakFromLoop4);

				break;
			case "9": // Add Stamps to a Registry
				boolean breakFromLoop5 = false;

				System.out.printf("Which registry would you like to add stamps to? (Enter number 0 to %d): ",
						lengthOfTheArrayWithAllRegistries - 1);
				do {

					int positionOfReg = sc.nextInt();
					sc.nextLine();

					if (positionOfReg >= 0 && positionOfReg <= 5) {
						Registry registryFromArray = arrayOfAllTheRegistries[positionOfReg];
						System.out.print(
								"How many 2$, 5$, 10$,15$ and 20$ do you want to add? \nEnter 5 numbers seperated by spaces: ");
						String[] stampsToAdd = sc.nextLine().split(" ");
						if (stampsToAdd.length != 5) {
							System.out.println("Invalid input. Please enter exactly 5 numbers.");
							continue; // Repeats the prompt
						}

						// adds the amounts to the stamp and parses them since they are ints to begin with amount stores the new total amount
						
						int amount = registryFromArray.addStampsToARegistry(Integer.parseInt(stampsToAdd[0]),
								Integer.parseInt(stampsToAdd[1]), Integer.parseInt(stampsToAdd[2]),
								Integer.parseInt(stampsToAdd[3]), Integer.parseInt(stampsToAdd[4]));

						System.out.printf("The new total is %d$\n\n", amount);
						breakFromLoop5 = true;
					} else {
						System.out.printf("Invalid registry number. Try again (Enter number 0 to %d): ",
								lengthOfTheArrayWithAllRegistries - 1);
					}

				} while (!breakFromLoop5);

				break;
			case "0": // To quit
				exitMainLoop = true;
				break;
			default:
				System.out.println("The input is invalid :(");
				break;

			}

		} while (!exitMainLoop);

		System.out.println("Thank you for using this program, Good bye!");
	}
}
