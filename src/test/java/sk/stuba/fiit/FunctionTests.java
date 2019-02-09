package sk.stuba.fiit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FunctionTests {

	@Test
	public void testFunc0() {
		assertEquals(Functions.func0(4), "1");
		assertEquals(Functions.func0(3), "2");
	}

	@Test
	public void testFunc1_a() {
		assertEquals(Functions.func1_a(0), "1");
		assertEquals(Functions.func1_a(1), "1");
		assertEquals(Functions.func1_a(2), "2");
		assertEquals(Functions.func1_a(3), "2");
	}

	@Test
	public void testFunc1_b() {
		assertEquals(Functions.func1_b(3), "1");
		assertEquals(Functions.func1_b(0), "2");
		assertEquals(Functions.func1_b(1), "2");
		assertEquals(Functions.func1_b(2), "2");
	}

	@Test
	public void testFunc1_c() {
		assertEquals(Functions.func1_c(0), "1");
		assertEquals(Functions.func1_c(2), "1");
		assertEquals(Functions.func1_c(3), "1");
		assertEquals(Functions.func1_c(1), "2");
	}

	@Test
	public void testFunc1_d() {
		assertEquals(Functions.func1_d(0), "1");
		assertEquals(Functions.func1_d(1), "1");
		assertEquals(Functions.func1_d(2), "2");
		assertEquals(Functions.func1_d(3), "2");
	}

	@Test
	public void testFunc1_e() {
		assertEquals(Functions.func1_e(4), "14");
		assertEquals(Functions.func1_e(5), "15");
		assertEquals(Functions.func1_e(6), "124");
		assertEquals(Functions.func1_e(7), "125");
		assertEquals(Functions.func1_e(1), "34");
		assertEquals(Functions.func1_e(0), "35");
	}

	// @Test
	// public void testFunc0() {
	// assertEquals(Functions.func0(4), "1");
	// assertEquals(Functions.func0(3), "2");
	// }

	// @Test
	// public void testFunc1() {
	// assertEquals(Functions.func1(new int[] { 0, 4 }), "1");
	// assertEquals(Functions.func1(new int[] { 0, 3 }), "2");
	// }

	// @Test
	// public void testFunc2() {
	// assertEquals(Functions.func2(new int[] { 4 }, 0), "1");
	// assertEquals(Functions.func2(new int[] { 3 }, 0), "2");

	// assertEquals(Functions.func2(new int[] { 4, 3 }, 0), "1");
	// assertEquals(Functions.func2(new int[] { 4, 3 }, 1), "2");
	// }

	// @Test
	// public void testFunc2a() {
	// assertEquals(Functions.func2a(new int[] { 0, 0, 0, 0, 0, 0, 0, 4 }, 7),
	// "12");
	// assertEquals(Functions.func2a(new int[] { 0, 0, 0, 0, 0, 0, 0, 3 }, 7),
	// "13");

	// assertEquals(Functions.func2a(new int[] {}, 5), "4");
	// }

	// // TODO: Consider matching with regular expressions
	// @Test
	// public void testFunc2b() {
	// assertEquals(Functions.func2b(new int[] { 1, 2, 3, 4, 5, 6 }, 4),
	// "1515151515123");
	// assertEquals(Functions.func2b(new int[] { 1, 2, 3, 4, 5, 6 }, 1),
	// "1515124123123123");
	// assertEquals(Functions.func2b(new int[] { 1, 2, 3, 4, 5, 6 }, 5),
	// "151515151515");

	// assertEquals(Functions.func2b(new int[] { 0, 4, 4, 4, 4, 4 }, 0),
	// "15123123123123123");
	// assertEquals(Functions.func2b(new int[] { 0, 3, 3, 3, 3, 3 }, 0),
	// "15124124124124124");
	// }

	// @Test
	// public void testFunc3a() {
	// assertEquals(Functions.func3(1), "1");
	// }

	// @Test
	// public void testFunc7() {
	// assertEquals(Functions.func7(new int[] { 4, 6, 0, 0, 5 }, 4, 4), "14");
	// assertEquals(Functions.func7(new int[] { 4, 7, 0, 0, 6 }, 4, 4), "13");

	// assertEquals(Functions.func7(new int[] { 4, 6 }, 1, 1), "23");
	// assertEquals(Functions.func7(new int[] { 4, 6 }, 0, 1), "24");

	// }
}
