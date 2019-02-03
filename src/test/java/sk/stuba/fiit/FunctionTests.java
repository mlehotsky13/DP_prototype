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
	public void testFunc1() {
		assertEquals(Functions.func1(new int[] { 0, 4 }), "1");
		assertEquals(Functions.func1(new int[] { 0, 3 }), "2");
	}

	@Test
	public void testFunc2() {
		assertEquals(Functions.func2(new int[] { 4 }, 0), "1");
		assertEquals(Functions.func2(new int[] { 3 }, 0), "2");

		assertEquals(Functions.func2(new int[] { 4, 3 }, 0), "1");
		assertEquals(Functions.func2(new int[] { 4, 3 }, 1), "2");
	}

	@Test
	public void testFunc2a() {
		assertEquals(Functions.func2a(new int[] { 0, 0, 0, 0, 0, 0, 0, 4 }, 7), "12");
		assertEquals(Functions.func2a(new int[] { 0, 0, 0, 0, 0, 0, 0, 3 }, 7), "13");

		assertEquals(Functions.func2a(new int[] {}, 5), "4");
	}

	// TODO: Consider matching with regular expressions
	@Test
	public void testFunc2b() {
		assertEquals(Functions.func2b(new int[] { 1, 2, 3, 4, 5, 6 }, 4), "1515151515123");
		assertEquals(Functions.func2b(new int[] { 1, 2, 3, 4, 5, 6 }, 1), "1515124123123123");
		assertEquals(Functions.func2b(new int[] { 1, 2, 3, 4, 5, 6 }, 5), "151515151515");

		assertEquals(Functions.func2b(new int[] { 0, 4, 4, 4, 4, 4 }, 0), "15123123123123123");
		assertEquals(Functions.func2b(new int[] { 0, 3, 3, 3, 3, 3 }, 0), "15124124124124124");
	}

	@Test
	public void testFunc3() {
		assertEquals(Functions.func3(1), "1");
		assertEquals(Functions.func3(2), "2");
	}

	@Test
	public void testFunc7() {
		assertEquals(Functions.func7(new int[] { 4, 6, 0, 0, 5 }, 4, 4), "14");
		assertEquals(Functions.func7(new int[] { 4, 7, 0, 0, 6 }, 4, 4), "13");

		assertEquals(Functions.func7(new int[] { 4, 6 }, 1, 1), "23");
		assertEquals(Functions.func7(new int[] { 4, 6 }, 0, 1), "24");

	}
}
