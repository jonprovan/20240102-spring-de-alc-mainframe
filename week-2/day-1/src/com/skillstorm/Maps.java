package com.skillstorm;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Maps {

	public static void main(String[] args) {
		
		// MAPS IN JAVA
		
		/*
		 * Wicked fast!
		 * key-value pairs -- there's a key, and when you call it, you get the value
		 * unordered
		 * (some implementations can be ordered)
		 * values CAN be duplicated
		 * unique keys
		 * Objects only (again), no primitives
		 * an array under the hood, hence the fast access time
		 */
		
		// can't instantiate the interface, so we use a HashMap
		Map<String, Integer> wordCountMap = new HashMap<>();
		
		// adding to the map
		wordCountMap.put("Java", 10);
		wordCountMap.put("Python", 0);
		wordCountMap.put("C#", 9);
		
		System.out.println(wordCountMap.get("Java"));
		System.out.println(wordCountMap);
		
		// if the key already exists, putting again will overwrite the value
		wordCountMap.put("Java", 20);
		
		System.out.println(wordCountMap.get("Java"));
		System.out.println(wordCountMap);
		
		// removing a key-value pair completely
		wordCountMap.remove("Python");
		System.out.println(wordCountMap);
		
		// updating the value associated with this key if it exists
		wordCountMap.replace("C#", 34);
		System.out.println(wordCountMap);
		
		// working with Objects as keys
		HashMap<Car, Integer> inventory = new HashMap<>();
		
		inventory.put(new Car("Honda", "Odyssey", "Black", 2011), 10);
		inventory.put(new Car("Honda", "CRV", "Cool Blue", 2020), 50);
		inventory.put(new Car("Honda", "CRV", "Cool Blue", 2020), 70);
		inventory.put(new Car("Toyota", "Corolla", "Silver", 2019), 30);
		
		System.out.println(inventory);
		
		// by default, this returns null, because we haven't yet overridden .hashCode() and .equals()
		System.out.println(inventory.get(new Car("Honda", "CRV", "Cool Blue", 2020)));
		
		Car testCar = new Car("Honda", "CRV", "Cool Blue", 2020);
		
		if (inventory.containsKey(testCar))
			inventory.put(testCar, inventory.get(testCar) + 20);
		
		System.out.println(inventory);
		
		// looping through a map (sort of)
		for (Car c : inventory.keySet())
			System.out.println(c + ": " + inventory.get(c));

	}

}

class Car {
	
	String make;
	String model;
	String color;
	int year;
	
	public Car(String make, String model, String color, int year) {
		super();
		this.make = make;
		this.model = model;
		this.color = color;
		this.year = year;
	}

	@Override
	public String toString() {
		return "Car [make=" + make + ", model=" + model + ", color=" + color + ", year=" + year + "]";
	}

	// with this override, equal objects will now return identical hashcodes
	@Override
	public int hashCode() {
		return Objects.hash(color, make, model, year);
	}

	// this compares the actual properties, not the memory location
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(color, other.color) && Objects.equals(make, other.make)
				&& Objects.equals(model, other.model) && year == other.year;
	}
	
	
	
	
	
}






