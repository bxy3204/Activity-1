package edu.ncsu.csc326.coffeemaker;

import junit.framework.TestCase;

public class RecipeTest extends TestCase {
	private Recipe r1;
	private Recipe r2;

	protected void setUp() throws Exception {
		//Sets up two blank recipes
		r1 = new Recipe();
		r2 = new Recipe();
		super.setUp();
	}
/*
	public void testGetAmtChocolate() {
		fail("Not yet implemented");
	}

	public void testSetAmtChocolate() {
		fail("Not yet implemented");
	}

	public void testGetAmtCoffee() {
		fail("Not yet implemented");
	}

	public void testSetAmtCoffee() {
		fail("Not yet implemented");
	}

	public void testGetAmtMilk() {
		fail("Not yet implemented");
	}

	public void testSetAmtMilk() {
		fail("Not yet implemented");
	}

	public void testGetAmtSugar() {
		fail("Not yet implemented");
	}

	public void testSetAmtSugar() {
		fail("Not yet implemented");
	}

	public void testGetName() {
		fail("Not yet implemented");
	}

	public void testSetName() {
		fail("Not yet implemented");
	}

	public void testGetPrice() {
		fail("Not yet implemented");
	}

	public void testSetPrice() {
		fail("Not yet implemented");
	}
*/
	public void testToString() {
		r1.setName("Coffee1");
		assertEquals("Coffee1", r1.toString());
	}

	//test is equal with same name
	public void testEqualsObject() {
		r1.setName("Test1");
		r2.setName("Test1");
		assertEquals(true, r1.equals(r2));
	}
	
	//test is equal with itself
	public void testEqualsItself() {
		r1.setName("Test2");
		assertEquals(true, r1.equals(r1));
	}

	//test is not equal to recipe with different name
	public void testEqualsObjectDiffName() {
		r1.setName("Test");
		r2.setName("TestDiff");
		assertEquals(false, r1.equals(r2));
	}
	
	//test is equal with null name
	public void testEqualsNullObject() {
		r1.setName(null);
		r2.setName(null);
		assertEquals(true, r1.equals(r2));
	}
	
	//test is not equal to different object type
	public void testEqualsDifferentObjectType() {
		r1.setName("Test1");
		Inventory i1 = new Inventory();
		assertEquals(false, r1.equals(i1));
	}
	
	//test real recipe is not equal to null object
	public void testEqualsOtherNull() {
		r1.setName("Test1");
		assertEquals(false, r1.equals(null));
	}
}
