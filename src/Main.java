import java.util.ArrayList;
import java.util.Scanner;
import vehicle.*;

public class Main {

	//Java OOP implementation using abstract class, inheritance and encapsulation.
	
	//make scanner objet
	Scanner scan = new Scanner(System.in);
	//make arrayList object
	ArrayList<Vehicle> arrVehicle = new ArrayList<Vehicle>();
	
	//to insert Vehicle
	public void insertVehicle() {
		String name, type;
		//check the type of the vehicle
		do {
			System.out.print("Input Vehicle Type[Car | Motor]: ");
			type = scan.nextLine();
		} while (!type.equals("Car") && !type.equals("Motor"));
		
		//if car
		if (type.equals("Car")) {
			// make new class car
			Car car = new Car();
			int capacity;
			do {
				//input the capacity
				System.out.print("Input Car Capacity[4 | 5 | 6]: ");
				capacity = scan.nextInt();
				scan.nextLine();
			//check the capacity using set in class car
			} while (!car.setCarCapacity(capacity));
			//input name
			System.out.print("Input Vehicle Name: ");
			name = scan.nextLine();
			//set the vehicle type and name into class car
			car.setVehicleName(name);
			car.setVehicleType(type);
			//add into arrayList
			arrVehicle.add(car);
		} else {
			//make new class motor
			Motor motor = new Motor();
			String service;
			
			do {
				//check the service using set in class motor
				System.out.print("Input Motor Service[Food | Ride]: ");
				service = scan.nextLine();
			} while (!motor.setMotorService(service));
			
			System.out.print("Input Vehicle Name: ");
			name = scan.nextLine();
			// set the name and type into class motor
			motor.setVehicleName(name);
			motor.setVehicleType(type);
			//add into array list
			arrVehicle.add(motor);
		}

		System.out.println("");
		System.out.println("Insert Vehicle Success!");
		scan.nextLine();

	}
	
	// to print all the list
	public void useService() {
		for (int i = 0; i < arrVehicle.size(); i++) {
			//make new object Vehicle
			Vehicle v = arrVehicle.get(i);
			// get the name and type
			System.out.println((i+1) + ". Type " + v.getVehicleType());
			System.out.println((i+1) + ". Name " + v.getVehicleName());
		
			//check the type
			if (v instanceof Car) {
				//down cast the v object
				Car car = (Car) v;
				//so that we can call the car capacity in class car
				System.out.println((i+1) + ". Car Capacity: " + car.getCarCapacity());
			} else {
				// down cast the v object 
				Motor motor = (Motor) v;
				// so  that we can call the motor service in class motor
				System.out.println((i+1) + ". Motor Service: " + motor.getMotorServices());
			}
			System.out.println("");
		}
		scan.nextLine();
	}
	
	//delete the vehicle
	public void deleteVehicle() {
		//print the list
		useService();
		int choice;
		do {
			// input the number of index that you want to be deleted
			System.out.print("Input Vehicle Number that you want to be deleted [" + 1 + "-" +arrVehicle.size() + "]: ");
			choice = scan.nextInt();
			//validate the input
		} while (choice > arrVehicle.size() && choice < 1);
		//remove by using index
		arrVehicle.remove(choice - 1); // because index is from 0
		System.out.println("Delete Vehicle Success");
		System.out.println("");
		scan.nextLine();
	}
	
	// to clear the screen
	public void clearScreen() {
		for (int i = 0; i < 20; i++) {
			System.out.println("");
		}
	}
	
	public Main() {
		int opt = 0;
		do {
			clearScreen();
			System.out.println("1. Insert new vehicle");
			System.out.println("2. Use vehicle service");
			System.out.println("3. Delete Vehicle");
			System.out.println("4. Exit");
			System.out.print(">> ");
			opt = scan.nextInt(); scan.nextLine();
			
			if (opt == 1) {
				// call the insertVehicle method
				insertVehicle();
				clearScreen();
			} else if (opt == 2) {
				// call the useService method
				useService();
				clearScreen();
			} else if (opt == 3) {
				// call the delete Vehicle method
				deleteVehicle();
				clearScreen();
			} else if (opt == 4) {
				// clear the arrayList
				arrVehicle.clear();
				clearScreen();
			}
		} while (opt != 4);
	}

	public static void main(String[] args) {
		new Main();
	}
	// created by putud
}
