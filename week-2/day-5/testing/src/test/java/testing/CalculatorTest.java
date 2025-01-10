package testing;

import static org.junit.Assert.*;

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
		calc = new Calculator("My Sweet Calculator");
	}
	
	@Before
	public void before() {
		System.out.println("Before");
	}

	// for each test, we take some sort of action, then assume something about it
	// if the assumption is true, we pass the test; otherwise, we fail
	// order of the test is unpredictable
	// failing a test does not stop the testing process -- all will end up running
	@Test
	public void basicAddition() {
		System.out.println("Basic Addition Test");
		int sum = calc.add(2, 2);
		// with an assertion, the first parameter is what you expect, the second is what actually happened
		assertEquals(5, sum);
	}
	
	@Test
	public void basicAddition2() {
		System.out.println("Basic Addition 2 Test");
		int sum = calc.add(10, 11);
		assertEquals(21, sum);
	}
	
	@After
	public void after() {
		System.out.println("After");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("After Class");
	}

}
