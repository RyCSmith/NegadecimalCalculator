/*** Lu Lu and Ryan Smith - CIT591 - HW9 - Negadecimal Numbers***/

package negadecimalCalculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NegadecimalNumberTest {
	NegadecimalNumber i;

	@Before
	public void setUp() throws Exception {
		i = new NegadecimalNumber(50);
	}

	@Test
	public void testAdd() {
		assertTrue(new NegadecimalNumber(100).equals(i.add(new NegadecimalNumber(50))));
		assertTrue(new NegadecimalNumber(200).equals(i.add(new NegadecimalNumber(150))));
		assertTrue(new NegadecimalNumber(50).equals(i.add(new NegadecimalNumber(0))));
		assertTrue(new NegadecimalNumber(40).equals(i.add(new NegadecimalNumber(-10))));
		assertFalse(new NegadecimalNumber(500).equals(i.add(new NegadecimalNumber(50))));
		assertFalse(new NegadecimalNumber(50).equals(i.add(new NegadecimalNumber(70))));
	}

	@Test
	public void testSubtract() {
		assertTrue(new NegadecimalNumber(0).equals(i.subtract(new NegadecimalNumber(50))));
		assertTrue(new NegadecimalNumber(40).equals(i.subtract(new NegadecimalNumber(10))));
		assertTrue(new NegadecimalNumber(-50).equals(i.subtract(new NegadecimalNumber(100))));
		assertTrue(new NegadecimalNumber(50).equals(i.subtract(new NegadecimalNumber(0))));
		assertFalse(new NegadecimalNumber(40).equals(i.subtract(new NegadecimalNumber(40))));
		assertFalse(new NegadecimalNumber(40).equals(i.subtract(new NegadecimalNumber(80))));
	}

	@Test
	public void testMultiply() {
		assertTrue(new NegadecimalNumber(2500).equals(i.multiply(new NegadecimalNumber(50))));
		assertTrue(new NegadecimalNumber(1500).equals(i.multiply(new NegadecimalNumber(30))));
		assertTrue(new NegadecimalNumber(0).equals(i.multiply(new NegadecimalNumber(0))));
		assertTrue(new NegadecimalNumber(-500).equals(i.multiply(new NegadecimalNumber(-10))));
		assertFalse(new NegadecimalNumber(2500).equals(i.multiply(new NegadecimalNumber(60))));
		assertFalse(new NegadecimalNumber(700).equals(i.multiply(new NegadecimalNumber(10))));

	}

	@Test(expected = ArithmeticException.class)
	public void testDivide() {
		assertTrue(new NegadecimalNumber(1).equals(i.divide(new NegadecimalNumber(50))));
		assertTrue(new NegadecimalNumber(1).equals(i.divide(new NegadecimalNumber(40))));
		assertTrue(new NegadecimalNumber(10).equals(i.divide(new NegadecimalNumber(5))));
		assertTrue(new NegadecimalNumber(-5).equals(i.divide(new NegadecimalNumber(-10))));
		assertFalse(new NegadecimalNumber(2).equals(i.divide(new NegadecimalNumber(60))));
		assertFalse(new NegadecimalNumber(7).equals(i.divide(new NegadecimalNumber(10))));
		i.divide(new NegadecimalNumber(0));
	}

	@Test(expected = ArithmeticException.class)
	public void testRemainder() {
		assertTrue(new NegadecimalNumber(0).equals(i.remainder(new NegadecimalNumber(50))));
		assertTrue(new NegadecimalNumber(10).equals(i.remainder(new NegadecimalNumber(40))));
		assertTrue(new NegadecimalNumber(1).equals(i.remainder(new NegadecimalNumber(7))));
		assertTrue(new NegadecimalNumber(1).equals(i.remainder(new NegadecimalNumber(-7))));
		assertFalse(new NegadecimalNumber(22).equals(i.remainder(new NegadecimalNumber(30))));
		assertFalse(new NegadecimalNumber(7).equals(i.remainder(new NegadecimalNumber(13))));
		i.remainder(new NegadecimalNumber(0));
	}

	@Test
	public void testNegate() {
		assertTrue(new NegadecimalNumber(-50).equals(new NegadecimalNumber(50).negate()));
		assertTrue(new NegadecimalNumber(-40).equals(new NegadecimalNumber(40).negate()));
		assertTrue(new NegadecimalNumber(0).equals(new NegadecimalNumber(0).negate()));
		assertFalse(new NegadecimalNumber(-30).equals(new NegadecimalNumber(20).negate()));
		assertFalse(new NegadecimalNumber(-15).equals(new NegadecimalNumber(10).negate()));
	}

	@Test
	public void testDecimalValue() {
		assertEquals(50, (new NegadecimalNumber(50).decimalValue()));
		assertEquals(30, (new NegadecimalNumber(30).decimalValue()));
		assertEquals(-50, (new NegadecimalNumber(-50).decimalValue()));
		assertNotEquals(30, (new NegadecimalNumber(20).decimalValue()));
		assertNotEquals(40, (new NegadecimalNumber(10).decimalValue()));
	}

	@Test
	public void testEqualsNegadecimalNumber() {
		assertTrue(new NegadecimalNumber(50).equals(new NegadecimalNumber(50)));
		assertTrue(new NegadecimalNumber(40).equals(new NegadecimalNumber(40)));
		assertTrue(new NegadecimalNumber(0).equals(new NegadecimalNumber(0)));
		assertFalse(new NegadecimalNumber(30).equals(new NegadecimalNumber(20)));
		assertFalse(new NegadecimalNumber(15).equals(new NegadecimalNumber(10)));
	}

	@Test
	public void testToString() {
		assertEquals("150", (new NegadecimalNumber(50).toString()));
		assertEquals("100", (new NegadecimalNumber(100).toString()));
		assertEquals("100", (new NegadecimalNumber("100").toString()));
		assertEquals("50", (new NegadecimalNumber("50").toString()));
		assertNotEquals("10", (new NegadecimalNumber(10).toString()));
		assertNotEquals("130", (new NegadecimalNumber(80).toString()));
	}

}
