package com.skillstorm;

public class PassBy {

	public static void main(String[] args) {
		
		// PASS-BY-VALUE VS. PASS-BY-REFERENCE
		
		int initialValue = 15;
		
		// since initialValue is a primitive, I ONLY pass it its value
		// NOT any connection to the original variable
		System.out.println(returnNumber(initialValue));
		
		// original value is unchanged
		System.out.println(initialValue);
		
		Vehicle myCar = new Vehicle(0);
		
		System.out.println(myCar.mileage);
		
		addMileage(myCar);
		
		System.out.println(myCar.mileage);
		

	}
	
	public static int returnNumber(int startingNum) {
		startingNum += 10;
		return startingNum;
	}
	
	public static void addMileage(Vehicle vehicle) {
		// this changes the mileage on the referenced object
		vehicle.mileage += 100;
		// this SEEMS like it would delete the object
		// BUT we're just nulling out the local variable holding the reference
		// the original myCar variable still points to the same heap object
		vehicle = null;
	}

}

class Vehicle {
	int mileage;
	
	public Vehicle(int mileage) {
		this.mileage = mileage;
	}
}







