package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import junit.framework.TestCase;

public class RecipeTest extends TestCase {
	private Recipe r1;
	private Recipe r2;

	protected void setUp() throws Exception {
		// Sets up two blank recipes
		r1 = new Recipe();
		r2 = new Recipe();
		super.setUp();
	}

	//Test to get the stored value of a recipe's chocolate
	public void testGetAmtChocolate() {
		try {
			r1.setAmtChocolate("1");
		}catch(RecipeException e){}
		assertEquals(1,r1.getAmtChocolate());
	}

	//Test to set a valid value of chocolate
	public void testSetAmtChocolate() {
		
		try {
		r1.setAmtChocolate("1");
		}catch(RecipeException e){
			fail("Recipe Exception should not be thrown");
		}
		assertEquals(1, r1.getAmtChocolate());
	}
	
	//Test to set an invalid negative value of chocolate
	public void testNegSetAmtChocolate() {
		try {
		r1.setAmtChocolate("-1");
		fail("Recipe Exception should be thrown");
		}catch(RecipeException e) {}
	}
	
	//Test to set an invalid non-number value of chocolate
	public void testNonNumSetAmtChocolate() {
		try {
		r1.setAmtChocolate("a");
		fail("Recipe Exception should be thrown");
		}catch(RecipeException e) {}
	}

	//Test to get the value of coffee in a recipe
	public void testGetAmtCoffee() {
		try {
			r1.setAmtCoffee("1");
		}catch(RecipeException e){}
		assertEquals(1,r1.getAmtCoffee());
	}
	
	//Test to set a valid value of coffee
	public void testSetAmtCoffee() {
		try {
			r1.setAmtCoffee("1");
			}catch(RecipeException e){
				fail("Recipe Exception should not be thrown");
			}
			assertEquals(1, r1.getAmtCoffee());
	}

	//Test to set an invalid negative value of coffee
	public void testNegSetAmtCoffee() {
		try {
		r1.setAmtCoffee("-1");
		fail("Recipe Exception should be thrown");
		}catch(RecipeException e) {}
	}
	
	//Test to set an invalid non-negative value of coffee
	public void testNonNumSetAmtCoffee() {
		try {
		r1.setAmtCoffee("a");
		fail("Recipe Exception should be thrown");
		}catch(RecipeException e) {}
	}
	
	//Test to get the value of milk
	public void testGetAmtMilk() {
		try {
			r1.setAmtMilk("1");
		}catch(RecipeException e){}
		assertEquals(1,r1.getAmtMilk());
	}

	//Test to set a valid value of milk
	public void testSetAmtMilk() {
		try {
			r1.setAmtMilk("1");
			}catch(RecipeException e){
				fail("Recipe Exception should not be thrown");
			}
			assertEquals(1, r1.getAmtMilk());
	}
	
	//Test to set an invalid negative value of milk
	public void testNegSetAmtMilk() {
		try {
		r1.setAmtMilk("-1");
		fail("Recipe Exception should be thrown");
		}catch(RecipeException e) {}
	}
	
	//Test to set an invalid non-number value of milk
	public void testNonNumSetAmtMilk() {
		try {
		r1.setAmtMilk("a");
		fail("Recipe Exception should be thrown");
		}catch(RecipeException e) {}
	}

	//Test to get the value of sugar
	public void testGetAmtSugar() {
		try {
			r1.setAmtSugar("1");
		}catch(RecipeException e){}
		assertEquals(1,r1.getAmtSugar());
	}
	
	//Test to set a valid value of Sugar
	public void testSetAmtSugar() {
		try {
			r1.setAmtSugar("1");
			}catch(RecipeException e){
				fail("Recipe Exception should not be thrown");
			}
			assertEquals(1, r1.getAmtSugar());
	}
	
	//Test to set an invalid negative value of Sugar
	public void testNegSetAmtSugar() {
		try {
		r1.setAmtSugar("-1");
		fail("Recipe Exception should be thrown");
		}catch(RecipeException e) {}
	}
	
	//Test to set an invalid non-number value of Sugar
	public void testNonNumSetAmtSugar() {
		try {
		r1.setAmtSugar("a");
		fail("Recipe Exception should be thrown");
		}catch(RecipeException e) {}
	}
	
	//Test to get the name of a recipe
	public void testGetName() {
		r1.setName("Coffee1");
		assertEquals("Coffee1", r1.getName());
	}
	
	//Test to set the name of a recipe
	public void testSetName() {
		r1.setName("Coffee1");
		assertEquals("Coffee1",r1.getName());
	}
	
	//Test to change the name of a recipe
	public void testChangeSetName() {
		r1.setName("Coffee1");
		r1.setName("Coffee2");
		assertEquals("Coffee2",r1.getName());
	}
	
	//Test to set a recipe name null
	public void testNullSetName() {
		r1.setName("Coffee1");
		r1.setName(null);
		assertEquals("Coffee1",r1.getName());
	}

	//Test to get the value of the price
	public void testGetPrice() {
		try {
			r1.setPrice("1");
		}catch(RecipeException e){}
		assertEquals(1,r1.getPrice());
	}

	//Test to set a valid  value of price
	public void testSetPrice() {
		try {
			r1.setPrice("1");
			}catch(RecipeException e){
				fail("Recipe Exception should not be thrown");
			}
			assertEquals(1, r1.getPrice());
	}

	//Test to set an invalid negative value of price
	public void testNegSetPrice() {
		try {
		r1.setPrice("-1");
		fail("Recipe Exception should be thrown");
		}catch(RecipeException e) {}
	}
	
	//Test to set an invalid non-negative value of price
	public void testNonNumSetPrice() {
		try {
		r1.setPrice("a");
		fail("Recipe Exception should be thrown");
		}catch(RecipeException e) {}
	}

	//Test the string method for a recipe
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
