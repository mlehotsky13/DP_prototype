package sk.stuba.fiit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BasicFunctionTests {

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
		assertEquals(Functions.func2a(new int[] { 0, 0, 0, 0, 0, 0, 0, 4 }, 7), "1");
		assertEquals(Functions.func2a(new int[] { 0, 0, 0, 0, 0, 0, 0, 3 }, 7), "2");

		assertEquals(Functions.func2a(new int[] {}, 5), "3");
	}

	@Test
	public void testFunc2b() {
		assertEquals(Functions.func2b(new int[] { 1, 2, 3, 4, 5, 6 }, 4), "333331");
		assertEquals(Functions.func2b(new int[] { 1, 2, 3, 4, 5, 6 }, 1), "332111");
		assertEquals(Functions.func2b(new int[] { 1, 2, 3, 4, 5, 6 }, 5), "333333");

		assertEquals(Functions.func2b(new int[] { 0, 4, 4, 4, 4, 4 }, 0), "311111");
		assertEquals(Functions.func2b(new int[] { 0, 3, 3, 3, 3, 3 }, 0), "322222");
	}

	@Test
	public void testFunc3() {
		assertEquals(Functions.func3(1), "1");
		assertEquals(Functions.func3(2), "2");
	}
}
