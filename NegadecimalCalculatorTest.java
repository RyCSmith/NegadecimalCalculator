/*** Lu Lu and Ryan Smith - CIT591 - HW9 - Negadecimal Numbers***/

package negadecimalCalculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NegadecimalCalculatorTest {
	NegadecimalCalculator operator;

	@Before
	public void setUp() throws Exception {
		operator = new NegadecimalCalculator();
	}

	@Test (expected = ArithmeticException.class)
	public void testEvaluate() {
		assertEquals("0", operator.evaluate("clear"));
		assertEquals("0", operator.evaluate("* 4454"));
		assertEquals("18", operator.evaluate("-2"));
		assertEquals("28", operator.evaluate("+10"));
		assertEquals("190", operator.evaluate("decimal 10"));
		assertEquals("190 (decimal 10)", operator.evaluate("?"));
		assertEquals("10", operator.evaluate("~"));
		assertEquals("0", operator.evaluate("clear"));
		operator.evaluate("cleear");
		operator.evaluate("ssdss");
		
	}

	@Test
	public void testIsAllDigit() {
		assertTrue(operator.isAllDigit("23232"));
		assertFalse(operator.isAllDigit("232dsd"));
		assertFalse(operator.isAllDigit("hello"));
		assertFalse(operator.isAllDigit(" hello "));
	}


	@Test
	public void testCompute() {
		assertEquals("42", operator.compute('+', "42"));
		assertEquals("39", operator.compute('-', "23"));
		assertEquals("96", operator.compute('*', "4"));
		assertEquals("32", operator.compute('/', "3"));
		assertEquals("0", operator.compute('%', "4"));
	}

	@Test (expected = ArithmeticException.class)
	public void testSetDecimal() {
		operator.setDecimal("decimal43");
		assertEquals(43, operator.negaNum.decimalValue());
		assertEquals("163", operator.negaNum.toString());
		operator.setDecimal("ssdss");
	}

	@Test
	public void testIsBinary() {
		assertTrue(operator.isBinary('+'));
		assertTrue(operator.isBinary('-'));
		assertTrue(operator.isBinary('*'));
		assertTrue(operator.isBinary('/'));
		assertTrue(operator.isBinary('%'));
		assertFalse(operator.isBinary('z'));

	
	}
}
