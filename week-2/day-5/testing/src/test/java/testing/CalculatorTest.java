package testing;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

// this class is a JUnit test case that must live in our src/test/java folder
// any test cases will be run when the project is built, run, deployed, etc.
public class CalculatorTest {
	
	/*
	 * each test will be annotated with @Test
	 * other annotations will indicate other actions taken before all tests, after each test, etc.
	 * 
	 * @BeforeClass -- executes ONCE BEFORE anything else, it must be static
	 * 
	 * @Before -- executes BEFORE EACH test, for as many tests as you have
	 * 
	 * @Test -- each individual unit test, with its code and final assertion
	 * 
	 * @After -- executes AFTER EACH test, for as many tests as you have
	 * 
	 * @AfterClass -- executes ONCE AFTER anything else, it must be static
	 */
	
	public static Calculator calc;
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before Class");
		// instantiating a Calculator that we'll use for all our tests
		calc = new Calculator("My Sweet Calculator");
	}
	
	@Before
	public void before() {
		System.out.println("Before");
		calc.setName(null);
	}

	// for each test, we take some sort of action, then assume something about it
	// if the assumption is true, we pass the test; otherwise, we fail
	// order of the test is unpredictable
	// failing a test does not stop the testing process -- all will end up running
	@Test
	public void basicAddition() {
		System.out.println("Basic Addition Test");
		long sum = calc.add(2, 2);
		// with an assertion, the first parameter is what you expect, the second is what actually happened
		assertEquals(4, sum);
	}
	
	@Test
	public void basicAddition2() {
		System.out.println("Basic Addition 2 Test");
		long sum = calc.add(10, 11);
		assertEquals(21, sum);
	}
	
	@Test
	public void addNegatives() {
		System.out.println("Add Negatives Test");
		long sum = calc.add(-100, -600);
		assertEquals(-700, sum);
	}
	
	@Test
	public void integerOverflow() {
		System.out.println("Integer Overflow Test");
		int x = Integer.MAX_VALUE;
		int y = 1;
		long a = x;
		long b = y;
		assertEquals(a + b, calc.add(x, y));
	}
	
	// if we wanted our code to throw an exception and stop the program, we could assert that it will do so using this annotation
//	@Test(expected = ArithmeticException.class)
//	public void divideByZero() {
//		System.out.println("Divide By Zero Test");
//		int quotient = calc.divide(9, 0);
//	}
	
	// if we didn't want the program to stop, we'd write a different test
	@Test
	public void divideByZero() {
		System.out.println("Divide By Zero Test");
		double quotient = calc.divide(9, 0);
		assertEquals(0, quotient, 0);
	}
	
	@Test
	public void integerDivision() {
		System.out.println("Integer Division Test");
		double quotient = calc.divide(3, 2);
		assertEquals(1.5, quotient, 0);
	}
	
	@Test
	public void setAndGet() {
		calc.setName("Test Name For Testable Testing");
		assertTrue("Test Name For Testable Testing".equals(calc.getName()));
	}
	
	@Test
	public void constructCalculator() {
		// checking that our constructor produces an object of the correct class
		
		// can also assert that something is false
//		assertFalse(new Calculator("Test").getClass().equals(Other.class));
		
		assertTrue(new Calculator("Test").getClass().equals(Calculator.class));
	}
	
	@After
	public void after() {
		System.out.println("After");
		// we're resetting the name in the @Before method, but we could do it here, also
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("After Class");
		// clearing the Calculator out of memory for when we move on to our other tests
		calc = null;
	}

}
