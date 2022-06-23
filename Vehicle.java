package assignment2;

public class Vehicle {

	// Instance Variables
	private String carmake;
	private String carmodel;
	private int carmileage;
	// Does this car have a navigation system, 1 for yes, 0 for no. 
	private int navigation;
	
	// Constructor 
	public Vehicle(String make, String model, int mileage, int nav) {
		carmake = make;
		carmodel = model;
		carmileage = mileage;
		navigation = nav;
		
	}
	
	//Copy Constructor
	public Vehicle(Vehicle copycar) {
		
		carmake = copycar.carmake;
		carmodel = copycar.carmodel;
		carmileage = copycar.carmileage;
		navigation = copycar.navigation;
	}
	
	//Get fuel efficiency function
	
	public String getFuelEfficiencyCategory() {
		String type = "";
		
		if (carmileage > 15) {
			type = "Best";
		}
		else if (carmileage >= 8) {
			type = "Average";
		}
		else {
			type = "Worst";
		}
		
		return type;
	}
	
	// Getters
	public String getcarMake() {
		return carmake;
	}
	
	public String getcarModel() {
		return carmodel;
	}
	
	public int getcarMileage() {
		return carmileage;
	}
	
	public int getcarNavi() {
		return navigation;
	}
	
	// Setters
	
	public void setcarMake(String valupdate) {
		this.carmake = valupdate;
	}
	
	public void setcarModel(String valupdate) {
		this.carmodel = valupdate;
	}
	
	public void setcarMileage(int valupdate) {
		this.carmileage = valupdate;
	}
	
	public void setNavigation(int valupdate) {
		this.navigation = valupdate;
	}
	
	public String toString() {
		return String.format("Make: " + carmake + " \nModel: " + carmodel + " \nMileage: " + carmileage + " \nNavigation: " + navigation );
	}


}
