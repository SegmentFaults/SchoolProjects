import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Luke Skon, John Karro
 */
public class TrendsTest {


	/**
	 * Testing construction of the object
	 */
	@Test
	public void test01() {
		Trends test = new StudentTrends();
		assertEquals(0, test.getCount("bogus"));
	}


	@Test
	public void test02(){
		Trends test = new StudentTrends();
		assertEquals(0, test.numEntries());
	}

	@Test
	public void test03() {
		Trends test = new StudentTrends();
		test.increaseCount("one", 1);
		assertEquals(0, test.getCount("zero"));
		assertEquals(1, test.getCount("one"));
	}

	@Test
	public void test04() {
		Trends test = new StudentTrends();
		test.increaseCount("one", 2);
		assertEquals(0, test.getCount("zero"));
		assertEquals(2, test.getCount("one"));
	}

	@Test
	public void test05() {
		Trends test = new StudentTrends();
		test.increaseCount("one", 1);
		test.increaseCount("two", 2);
		assertEquals(1, test.getCount("one"));
		assertEquals(2, test.getCount("two"));
	}

	@Test
	public void test06() {
		Trends test = new StudentTrends();
		test.increaseCount("one", 1);
		test.increaseCount("two", 1);
		test.increaseCount("one", 1);
		assertEquals(2, test.getCount("one"));
		assertEquals(1, test.getCount("two"));
	}

	@Test
	public void test07() {
		Trends test = new StudentTrends();
		test.increaseCount("one", 1);
		test.increaseCount("two", 2);
		test.increaseCount("three",  3);
		assertEquals("three", test.getNthMostPopular(0));
		assertEquals("two", test.getNthMostPopular(1));
		assertEquals("one", test.getNthMostPopular(2));
	}

	@Test
	public void test08() {
		Trends test = new StudentTrends();
		test.increaseCount("one", 3);
		test.increaseCount("two", 2);
		test.increaseCount("three",  1);
		assertEquals("three", test.getNthMostPopular(2));
		assertEquals("two", test.getNthMostPopular(1));
		assertEquals("one", test.getNthMostPopular(0));
	}

	@Test
	public void test09() {
		Trends test = new StudentTrends();
		test.increaseCount("one", 1);
		test.increaseCount("two", 3);
		test.increaseCount("three",  2);
		assertEquals(test.getNthMostPopular(1), "three");
		assertEquals(test.getNthMostPopular(0), "two");
		assertEquals(test.getNthMostPopular(2), "one");
	}

	@Test
	public void test10() {
		Trends test = new StudentTrends();
		test.increaseCount("one", 1);
		test.increaseCount("two", 1);
		test.increaseCount("three",  1);
		test.increaseCount("two", 1);
		test.increaseCount("three",  1);
		test.increaseCount("two", 1);
		assertEquals("three", test.getNthMostPopular(1));
		assertEquals("two", test.getNthMostPopular(0));
		assertEquals("one", test.getNthMostPopular(2));
	}

	@Test
	public void test11() {
		Trends test = new StudentTrends();
		test.increaseCount("BBB", 1);
		test.increaseCount("AAA",  1);
		System.out.println(test.getNthMostPopular(1));
		assertEquals("AAA", test.getNthMostPopular(0));
		assertEquals("BBB", test.getNthMostPopular(1));
	}


	@Test
	public void test12() {
		Trends test = new StudentTrends();
		test.increaseCount("AAA", 1);
		test.increaseCount("BBB", 1);
		System.out.println(test.getNthMostPopular(1));
		assertEquals("AAA", test.getNthMostPopular(0));
		assertEquals("BBB", test.getNthMostPopular(1));
	}

	@Test
	public void test13() {
		Trends test = new StudentTrends();
		test.increaseCount("AAA", 1);
		test.increaseCount("BBB", 2);
		test.increaseCount("CCC", 1);
		System.out.println(test.getNthMostPopular(1));
		assertEquals("BBB", test.getNthMostPopular(0));
		assertEquals("AAA", test.getNthMostPopular(1));
		assertEquals("CCC", test.getNthMostPopular(2));
	}

	@Test
	public void test14() {
		Trends test = new StudentTrends();
		test.increaseCount("AAA", 1);
		test.increaseCount("BBB", 1);
		test.increaseCount("CCC", 1);
		test.increaseCount("AAA", 1);
		test.increaseCount("CCC", 1);
		test.increaseCount("AAA", 1);
		test.increaseCount("CCC", 1);
		System.out.println(test.getNthMostPopular(1));
		assertEquals("AAA", test.getNthMostPopular(0));
		assertEquals("CCC", test.getNthMostPopular(1));
		assertEquals("BBB", test.getNthMostPopular(2));
	}

	@Test
	public void test15() {
		Trends test = new StudentTrends();
		test.increaseCount("AAA", 1);
		test.increaseCount("BBB", 1);
		assertEquals(2, test.numEntries());
	}

	@Test
	public void test16() {
		Trends test = new StudentTrends();
		test.increaseCount("AAA", 2);
		test.increaseCount("BBB", 2);
		assertEquals(2, test.numEntries());
	}

	@Test
	public void test17() {
		Trends test = new StudentTrends();
		test.increaseCount("AAA", 1);
		test.increaseCount("BBB", 1);
		test.increaseCount("AAA", 1);
		test.increaseCount("BBB", 1);
		test.increaseCount("AAA", 1);
		test.increaseCount("BBB", 1);
		assertEquals(2, test.numEntries());
	}

}
