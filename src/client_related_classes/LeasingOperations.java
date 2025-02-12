package client_related_classes;

import java.security.AllPermission;

import vehicules_related_classes.Vehicles;

public class LeasingOperations extends Client {

	protected boolean carAvailability;

	protected Vehicles[] leasedCars;

	protected Vehicles[] clientsCars;

	protected static Client[] allClients = null;
	protected static int totalAmountClients = 0;

	protected Vehicles[] allCars = null;

//	public void addClient(Client c) {
//		boolean clientInside = false;
//		if (allClients == null) {
//			totalAmountClients++;
//			allClients = new Client[1];
//			allClients[0] = c;
//		} else {
//
//			for (int i = 0; i < allClients.length; i++) {
//				if (c.equals(allClients[i])) {
//					clientInside = true;
//					break;
//				}
//
//			}
//
//			if (!clientInside) {
//				Client[] withNewClient = new Client[totalAmountClients + 1];
//				for (int i = 0; i < totalAmountClients; i++) {
//					withNewClient[i] = allClients[i];
//				}
//				withNewClient[totalAmountClients] = c;
//			} else {
//				System.out.println("Client inside client list");
//			}
//
//		}
//
//	}
//
//	public void removeClient(Client c) {
//		boolean clientInside = false;
//		if (allClients == null) {
//			System.out.println("No clients in the list, add clients first");
//		} else if (allClients.length == 0) {
//			allClients = null;
//		} else {
//			for (int i = 0; i < allClients.length; i++) {
//				if (c.equals(allClients[i])) {
//					clientInside = true;
//					break;
//				}
//			}
//			if (clientInside) {
//
//				Client removedClientArray[] = new Client[--totalAmountClients];
//				for (int i = 0, j = 0; i < allClients.length; i++) {
//
//					if (!c.equals(allClients[i])) {
//						removedClientArray[j] = allClients[i];
//						j++;
//					}
//
//				}
//				allClients = removedClientArray;
//			} else {
//				System.out.println("Client not found");
//			}
//
//		}
//	}
	
	public void leaseVehicles(Vehicles v, Client c) {
			
		
	}
	
	
}
