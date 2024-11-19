package assignments;

import java.util.Scanner;

public class MissDemo {

	public static void main(String[] args) {

		System.out.println("Hello user! ");

		Scanner sc = new Scanner(System.in);

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

		Registry[] arrayOfAllTheRegistries = { regExactSame1, regExactSame2, regSameStamp1, regSameStamp2,
				regWithNoLable1, regWithNoLable2 };

		// Display everything in the registry

		boolean exitMainLoop = false;

		do {
			String choice = "";
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
			choice = sc.next();
			sc.nextLine(); // Consume the line

			switch (choice) {
			case "1":
				for (int i = 0; i < arrayOfAllTheRegistries.length; i++) {
					System.out.printf("Registry #%d:\n", i + 1);
					System.out.println(arrayOfAllTheRegistries[i].toString());
				}
				break;
				
			case "2":
				
				break;
			
			case "3":
			
				break;
			
			case "4":
				break;
			case "5":
				break;
			case "6":
				break;
			case "7":
				break;
			case "8":
				break;
			case "9":
				break;
			case "0":
				exitMainLoop = true;
				break;
			default:
				System.out.println("The input is invalid :(");
				break;

			}

		} while (!exitMainLoop);
	}
}
