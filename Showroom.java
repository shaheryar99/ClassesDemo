package assignment2;

import java.util.ArrayList;

public class Showroom {
	private String name;
	private ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
	
	public Showroom(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Vehicle> getVehicleList() {
		return vehicleList;
	}
	
	public void addVehicle(Vehicle vehicle) {
		vehicleList.add(vehicle);
	}
	
	// Find the car with the least fuel efficiency
	public Vehicle vehicleWithMinFuelEfficiency() {
		int[] mileageArr = new int[vehicleList.size()];	
		Vehicle[] vArr = new Vehicle[vehicleList.size()];
		int i = 0;	
		for(Vehicle v : vehicleList) {	
			mileageArr[i] = v.getcarMileage();
			vArr[i] = v;
			i++;
		}
		
		if(vArr[0] == null) {
			return null;
		}
		
		int minIndex = 0;
		int minMileage = mileageArr[minIndex];
		
		for(int j = 1; j < mileageArr.length; j++) {
			if(mileageArr[j] <= minMileage) {
				minIndex = j;
				minMileage = mileageArr[minIndex];
			}
		}
		
		return vArr[minIndex];
	}
	
	// Get the average mileage of the cars by make
	public double getAverageMileageByMake(String make) {
		int[] mileageArr = new int[vehicleList.size()];
		int i = 0;
		for(Vehicle v : vehicleList) {
			if(v.getcarMake().equals(make)) {
				mileageArr[i] = v.getcarMileage();
				i++;
			}
		}
		
		if(mileageArr[0] == 0) {
			return 0;
		}
		
		int total = 0;
		for(int m : mileageArr) {
			total += m;
		}
			
		double ave = (double) total / i;
		return ave;
		
	}
	
	// Print the make and model of all vehicles in the array
	public void printMakeModel() {
		String[] makeArr = new String[vehicleList.size()];
		String[] modelArr = new String[vehicleList.size()];
		int[] navArr = new int[vehicleList.size()];
		int[] gasArr = new int[vehicleList.size()];
		int i = 0;	
		for(Vehicle v : vehicleList) {	
			makeArr[i] = v.getcarMake();
			modelArr[i] = v.getcarModel();
			navArr[i] = v.getcarNavi();
			gasArr[i] = v.getcarMileage();
			
			i++;
		}
		System.out.println("Current Inventory:\n");
		for(int j = 0; j < makeArr.length; j++) {
			if(!makeArr[j].equals(null)) {
				if(navArr[j] == 0) {
					System.out.println(makeArr[j] + " " + modelArr[j] + " with mileage " + gasArr[j] + " and without navigation");
				} else {
					System.out.println(makeArr[j] + " " + modelArr[j] + " with mileage " + gasArr[j] + " and with navigation");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		// Demo of vehicle class:
		
		System.out.println("**NOTE** NAVIGATION: 0 = NO NAVIGATION, NAVIGATION: 1 = NAVIGATION PRESENT\n");
		System.out.println("VEHICLE CLASS DEMO: ");
		Vehicle ford = new Vehicle("Ford", "Focus", 30, 0);
		System.out.println(ford.toString());
		
		// Copy vehicle ford
		System.out.println("\nUsing Copy Constructor:");
		Vehicle gmc = new Vehicle(ford);
		System.out.println(""+ gmc.toString());
		
		// Use getters & Setter methods:
		System.out.println("\nUsing Setter to change ford into GMC, Using getter to show each value independently:");
		gmc.setcarMake("GMC");
		gmc.setcarModel("Sierra");
		gmc.setcarMileage(7);
		gmc.setNavigation(1);
		System.out.println("CAR MAKER: "+ gmc.getcarMake() + " CAR MODEL: " + gmc.getcarModel() + " CAR MILEAGE: " + gmc.getcarMileage() + " CAR NAVIGATION: " + gmc.getcarNavi());
		
		// Use the fuel efficiency function
		System.out.println("\nFUEL EFFICIENCY FUNCTION:");
		System.out.println("FORD: " + ford.getFuelEfficiencyCategory() + " GMC: " + gmc.getFuelEfficiencyCategory());
		
		//Showroom Class demo:
		System.out.println("\n========================================================================================");
		System.out.println("\nSHOWROOM CLASS DEMO:\n");
		
		Showroom main = new Showroom("main");
		
		// Add cars already present from Vehicle class:
		main.addVehicle(ford);
		main.addVehicle(gmc);
		
		// Add some more cars to test more methods and test addVehicle method:
		
		main.addVehicle(new Vehicle("Toyota", "Corolla", 11, 0));
		main.addVehicle(new Vehicle("Honda", "Civic Si", 9, 0));
		main.addVehicle(new Vehicle("Honda", "Civic", 15, 0));
		main.addVehicle(new Vehicle("Honda", "Accord", 30, 1));
		main.addVehicle(new Vehicle("Honda", "CRV", 25, 1));
		main.addVehicle(new Vehicle("Infiniti", "Q50", 12, 1));
		
		
		// Test the method I chose, essentially display all inventory
		main.printMakeModel();
		
		// Use min fuel efficiency function:
		System.out.println("\nVehicle with the worst fuel efficiency:");
		System.out.println(main.vehicleWithMinFuelEfficiency());
		
		// Using the get average mileage by make function:
		
		System.out.println("\nThe average mileage for all Honda vehicles is:");
		System.out.println(main.getAverageMileageByMake("Honda"));
		
		
	}

}
