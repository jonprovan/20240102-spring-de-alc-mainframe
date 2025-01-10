package testing;

public class Calculator {
	
	public String name;
	
	public Calculator(String name) {
		this.name = name;
	}
	
	public int add(int x, int y) {
		return x + y;
	}
	
	public int subtract(int x, int y) {
		return x - y;
	}
	
	public int multiply(int x, int y) {
		return x * y;
	}
	
	public int divide(int x, int y) {
		return x / y;
	}

}
