package com.skillstorm;

public class Inheritance {

	public static void main(String[] args) {
		
		// INHERITANCE IN JAVA
		
		/*
		 * child classes inherit from parent classes
		 * we reuse code as much as we can
		 * these hierarchies can go as deep as we like
		 * 
		 * a class can ONLY have one parent
		 * BUT it can have as many children as we like
		 */
		
		Edible edible = new Edible(100, "Salty", 150);
		
		System.out.println(edible);
		
		Fruit fruit = new Fruit(100, "Sweet", 200, "Yellow", false, false);
		
		System.out.println(fruit);
		
		Kiwi kiwi = new Kiwi(100, "Sweet", 100, "Brown and Green", false, false, 1.29, true);
		
		System.out.println(kiwi);
		
		Mango mango = new Mango(100, "Sweet", 250, "Rainbow", false, false);
		
		System.out.println(mango);
		
		// we can now group these because they are both fruits
		Fruit[] fruits = { kiwi, mango };
		
		// if there's no common method in the parent class, we have to check and cast to get the class-specific methods
		// a better solution would be to have a parent method that gets overridden
		for (Fruit f : fruits) {
			if (f instanceof Kiwi)
				( (Kiwi)f ).speak();
			else
				( (Mango)f ).speak();
		}
		
		// setter chaining
		Edible edible2 = new Edible();
		
		System.out.println(edible2);
		
		// without, I have to do this...
//		edible2.setPercentRemaining(100);
//		edible2.setFlavor("Umami");
//		edible2.setCalorieCount(1000);
		
		// with, I can do it all in one statement
		// to make this work, we change the setter return type to match the object type
		// then return "this" so we can take additional actions on the original object
		edible2.setCalorieCount(1000)
			   .setFlavor("Umami")
			   .setPercentRemaining(100);
		
		System.out.println(edible2);
		
	}

}

class Edible {
	
	private int percentRemaining;
	private String flavor;
	private int calorieCount;
	
	public Edible(int percentRemaining, String flavor, int calorieCount) {
		super();
		this.percentRemaining = percentRemaining;
		this.flavor = flavor;
		this.calorieCount = calorieCount;
	}
	
	public Edible() {}

	public int getPercentRemaining() {
		return percentRemaining;
	}

	public Edible setPercentRemaining(int percentRemaining) {
		this.percentRemaining = percentRemaining;
		return this;
	}

	public String getFlavor() {
		return flavor;
	}

	public Edible setFlavor(String flavor) {
		this.flavor = flavor;
		return this;
	}

	public int getCalorieCount() {
		return calorieCount;
	}

	public Edible setCalorieCount(int calorieCount) {
		this.calorieCount = calorieCount;
		return this;
	}

	@Override
	public String toString() {
		return "Edible [percentRemaining=" + percentRemaining + ", flavor=" + flavor + ", calorieCount=" + calorieCount
				+ "]";
	}
	
}

class Fruit extends Edible {
	
	private String color;
	private boolean citrus;
	private boolean outsideSeeded;
	
	// constructor chaining
	// we don't need to rewrite the logic in the parent constructor here!
	public Fruit(int percentRemaining, String flavor, int calorieCount, String color, boolean citrus, boolean outsideSeeded) {
		super(percentRemaining, flavor, calorieCount);
		this.color = color;
		this.citrus = citrus;
		this.outsideSeeded = outsideSeeded;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isCitrus() {
		return citrus;
	}

	public void setCitrus(boolean citrus) {
		this.citrus = citrus;
	}

	public boolean isOutsideSeeded() {
		return outsideSeeded;
	}

	public void setOutsideSeeded(boolean outsideSeeded) {
		this.outsideSeeded = outsideSeeded;
	}

	@Override
	public String toString() {
		return "Fruit [color=" + color + ", citrus=" + citrus + ", outsideSeeded=" + outsideSeeded
				+ ", PercentRemaining=" + getPercentRemaining() + ", Flavor=" + getFlavor()
				+ ", CalorieCount=" + getCalorieCount() + "]";
	}
	
//	public void speak() {
//		System.out.println("I am a fruit, and I am super-generic.");
//	}
	
}

class Kiwi extends Fruit {
	
	private double price;
	private boolean stillFuzzy;
	
	public Kiwi(int percentRemaining, String flavor, int calorieCount, String color, boolean citrus, boolean outsideSeeded,
				double price, boolean stillFuzzy) {
		super(percentRemaining, flavor, calorieCount, color, citrus, outsideSeeded);
		this.price = price;
		this.stillFuzzy = stillFuzzy;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isStillFuzzy() {
		return stillFuzzy;
	}

	public void setStillFuzzy(boolean stillFuzzy) {
		this.stillFuzzy = stillFuzzy;
	}

	@Override
	public String toString() {
		return "Kiwi [price=" + price + ", stillFuzzy=" + stillFuzzy + ", Color=" + getColor() + ", Citrus="
				+ isCitrus() + ", OutsideSeeded=" + isOutsideSeeded() + ", PercentRemaining="
				+ getPercentRemaining() + ", Flavor=" + getFlavor() + ", CalorieCount=" + getCalorieCount()
				+ "]";
	}
	
	// this method does not exist in the parent class
	public void speak() {
		System.out.println("I am a kiwi. Hear me fuzz.");
	}
	
}

class Mango extends Fruit {
	
	public Mango(int percentRemaining, String flavor, int calorieCount, String color, boolean citrus, boolean outsideSeeded) {
		super(percentRemaining, flavor, calorieCount, color, citrus, outsideSeeded);
	}

	@Override
	public String toString() {
		return "Mango [Color=" + getColor() + ", Citrus=" + isCitrus() + ", OutsideSeeded="
				+ isOutsideSeeded() + ", PercentRemaining=" + getPercentRemaining() + ", Flavor="
				+ getFlavor() + ", CalorieCount=" + getCalorieCount() + "]";
	}
	
	// this method does not exist in the parent class
	public void speak() {
		System.out.println("I am a mango. Let's go, man.");
	}
	
}
