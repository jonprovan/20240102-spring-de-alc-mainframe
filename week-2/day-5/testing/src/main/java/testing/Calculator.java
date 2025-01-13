package testing;

public class Calculator {
	
	private String name;
	
	public Calculator(String name) {
		this.name = name;
	}
	
	public long add(int x, int y) {
		return (long)x + y;
	}
	
	public int subtract(int x, int y) {
		return x - y;
	}
	
	public int multiply(int x, int y) {
		return x * y;
	}
	
	public double divide(int x, int y) {
		if (y == 0) {
			System.out.println("You can't divide by zero!");
			return 0;
		} else
			return (double)x / y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
