package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
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

	public void testGetAmtChocolate() {
		try {
			r1.setAmtChocolate("1");
		}catch(RecipeException e){}
		assertEquals(1,r1.getAmtChocolate());
	}

	public void testSetAmtChocolate() {
		try {
		r1.setAmtChocolate("1");
		}catch(RecipeException e){
			fail("Recipe Exception should not be thrown");
		}
		assertEquals(1, r1.getAmtChocolate());
	}
	
	public void testNegSetAmtChocolate() {
		try {
		r1.setAmtChocolate("-1");
		fail("Recipe Exception should be thrown");
		}catch(RecipeException e) {}
	}
	
	public void testNonNumSetAmtChocolate() {
		try {
		r1.setAmtChocolate("a");
		fail("Recipe Exception should be thrown");
		}catch(RecipeException e) {}
	}

	public void testGetAmtCoffee() {
		try {
			r1.setAmtCoffee("1");
		}catch(RecipeException e){}
		assertEquals(1,r1.getAmtCoffee());
	}
	
	public void testSetAmtCoffee() {
		try {
			r1.setAmtCoffee("1");
			}catch(RecipeException e){
				fail("Recipe Exception should not be thrown");
			}
			assertEquals(1, r1.getAmtCoffee());
	}

	public void testNegSetAmtCoffee() {
		try {
		r1.setAmtCoffee("-1");
		fail("Recipe Exception should be thrown");
		}catch(RecipeException e) {}
	}
	
	public void testNonNumSetAmtCoffee() {
		try {
		r1.setAmtCoffee("a");
		fail("Recipe Exception should be thrown");
		}catch(RecipeException e) {}
	}
	
	public void testGetAmtMilk() {
		try {
			r1.setAmtMilk("1");
		}catch(RecipeException e){}
		assertEquals(1,r1.getAmtMilk());
	}

	public void testSetAmtMilk() {
		try {
			r1.setAmtMilk("1");
			}catch(RecipeException e){
				fail("Recipe Exception should not be thrown");
			}
			assertEquals(1, r1.getAmtMilk());
	}

	public void testNegSetAmtMilk() {
		try {
		r1.setAmtMilk("-1");
		fail("Recipe Exception should be thrown");
		}catch(RecipeException e) {}
	}
	
	public void testNonNumSetAmtMilk() {
		try {
		r1.setAmtMilk("a");
		fail("Recipe Exception should be thrown");
		}catch(RecipeException e) {}
	}

	public void testGetAmtSugar() {
		try {
			r1.setAmtSugar("1");
		}catch(RecipeException e){}
		assertEquals(1,r1.getAmtSugar());
	}

	public void testSetAmtSugar() {
		try {
			r1.setAmtSugar("1");
			}catch(RecipeException e){
				fail("Recipe Exception should not be thrown");
			}
			assertEquals(1, r1.getAmtSugar());
	}

	public void testNegSetAmtSugar() {
		try {
		r1.setAmtSugar("-1");
		fail("Recipe Exception should be thrown");
		}catch(RecipeException e) {}
	}
	
	public void testNonNumSetAmtSugar() {
		try {
		r1.setAmtSugar("a");
		fail("Recipe Exception should be thrown");
		}catch(RecipeException e) {}
	}

	public void testGetName() {
		r1.setName("Coffee1");
		assertEquals("Coffee1", r1.getName());
	}

	public void testSetName() {
		r1.setName("Coffee1");
		assertEquals("Coffee1",r1.getName());
	}

	public void testGetPrice() {
		try {
			r1.setPrice("1");
		}catch(RecipeException e){}
		assertEquals(1,r1.getPrice());
	}

	public void testSetPrice() {
		try {
			r1.setPrice("1");
			}catch(RecipeException e){
				fail("Recipe Exception should not be thrown");
			}
			assertEquals(1, r1.getPrice());
	}

	public void testNegSetPrice() {
		try {
		r1.setPrice("-1");
		fail("Recipe Exception should be thrown");
		}catch(RecipeException e) {}
	}
	
	public void testNonNumSetPrice() {
		try {
		r1.setPrice("a");
		fail("Recipe Exception should be thrown");
		}catch(RecipeException e) {}
	}
//end
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
