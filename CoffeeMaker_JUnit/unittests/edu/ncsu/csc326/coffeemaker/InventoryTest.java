package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import junit.framework.TestCase;

public class InventoryTest extends TestCase {
	private Inventory inv;
	private Recipe r1;
	private Recipe r2;
	protected void setUp() throws Exception {
		inv = new Inventory();
		//Set up for r1
		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setAmtChocolate("0");
		r1.setAmtCoffee("3");
		r1.setAmtMilk("1");
		r1.setAmtSugar("1");
		r1.setPrice("50");
		
		//Set up for r2
		r2 = new Recipe();
		r2.setName("Coffee");
		r2.setAmtChocolate("15");
		r2.setAmtCoffee("15");
		r2.setAmtMilk("15");
		r2.setAmtSugar("15");
		r2.setPrice("50");
		super.setUp();
	}

	//test adding chocolate with negative integer
	public void testAddNegChocolate() {
		inv.setChocolate(0);
		try {
			inv.addChocolate("-1");
			fail("InventoryException should be thrown");
		}
		catch(InventoryException e) {}
	}
	
	//test adding chocolate with non numerical input
	public void testAddNonNumOfChocolate() {
		inv.setChocolate(0);
		try {
			inv.addChocolate("a");
			fail("InventoryException should be thrown");
		}
		catch(InventoryException e) {}
	}
	
	//test add chocolate with a positive integer
	public void testAddChocolate() {
		inv.setChocolate(0);
		try {
			inv.addChocolate("5");
		}
		catch(InventoryException e) {
			fail("InventoryException should not be thrown");
		}
		assertEquals(5, inv.getChocolate());
	}

	//tests adding a negative amount of coffee
	public void testAddNegCoffee() {
		inv.setCoffee(0);
		try {
			inv.addCoffee("-5");
			fail("InventoryException should be thrown");
		}
		catch(InventoryException e) {}
	}
	
	//tests adding a non numerical amount of coffee
	public void testAddNonNumCoffee() {
		inv.setCoffee(0);
		try {
			inv.addCoffee("a");
			fail("InventoryException should be thrown");
		}
		catch(InventoryException e) {}
	}
	
	//tests adding a valid amount of coffee
	public void testAddCoffee() {
		inv.setCoffee(0);
		try {
			inv.addCoffee("5");
		}
		catch(InventoryException e) {
			fail("InventoryException should not be thrown");
		}
		assertEquals(5, inv.getCoffee());
	}

	//tests adding negative amount of milk
	public void testAddNegAmtMilk() {
		inv.setMilk(0);
		try {
			inv.addMilk("-5");
			fail("InventoryException should be thrown");
		}
		catch(InventoryException e) {}
	}
	
	//tests adding non numerical of milk
	public void testAddNonNumMilk() {
		inv.setMilk(0);
		try {
			inv.addMilk("a");
			fail("InventoryException should be thrown");
		}
		catch(InventoryException e) {}
	}
	
	//tests adding valid amount of milk
	public void testAddMilk() {
		inv.setMilk(0);
		try {
			inv.addMilk("5");
		}
		catch(InventoryException e) {
			fail("InventoryException should not be thrown");
		}
		assertEquals(5, inv.getMilk());
	}

	//Test addSugar with a positive integer
	public void testAddSugar0()  {
		try {
			inv.setSugar(0);
			inv.addSugar("5");
		}catch (InventoryException e){
			fail("InventoryException should not be thrown");
		}
		assertEquals(5,inv.getSugar());
	}
	
	//Test addSugar with a negative integer
	public void testAddSugar1()  {
		try {
			inv.setSugar(0);
			inv.addSugar("-5");
			fail("InventoryException should be thrown");
		}catch (InventoryException e){}
	}
	
	//Test addSugar with non numeric input
	public void testAddSugar2()  {
		try {
			inv.setSugar(0);
			inv.addSugar("a");
			fail("InventoryException should be thrown");
		}catch (InventoryException e){}
	}
	
	//Test enoughIngredients when there are is not enough chocolate
	public void testEnoughIngredients0() {
		inv.setChocolate(0);
		assertEquals(false, inv.enoughIngredients(r2));
	}
	
	//Test enoughIngredients when there are enough ingredients
	public void testEnoughIngredients1() {
		assertEquals(true, inv.enoughIngredients(r1));
	}
	
	//Test enoughIngredients when there are is not enough coffee
	public void testEnoughIngredients2() {
		inv.setCoffee(0);
		assertEquals(false, inv.enoughIngredients(r2));
	}
	
	//Test enoughIngredients when there are is not enough milk
	public void testEnoughIngredients3() {
		inv.setMilk(0);
		assertEquals(false, inv.enoughIngredients(r2));
	}
	
	//Test enoughIngredients when there are is not enough sugar
	public void testEnoughIngredients4() {
		inv.setSugar(0);
		assertEquals(false, inv.enoughIngredients(r2));
	}
	
	//Test useIngredients when ingredients are available.
	public void testUseIngredients0() {
		assertEquals(true, inv.useIngredients(r1));
	}
	
	//Test useIngredients when ingredients coffee is not available.
	public void testUseIngredients1() {
		inv.setCoffee(0);
		assertEquals(false, inv.useIngredients(r2));
	}
	
	//Test useIngredients consumes correct amount of ingredients.
	//Inventory starts with 15 units of all ingredients,
	//r2 should consume all ingredients available.
	public void testUseIngredients2() {
		int totalIngredients;
		inv.useIngredients(r2);
		totalIngredients = inv.getChocolate()+inv.getCoffee()+inv.getMilk()
			+ inv.getSugar();
		assertEquals(0, totalIngredients);
	}
	
	//Test useIngredients when ingredients sugar is not available.
	public void testUseIngredients3() {
		inv.setSugar(0);
		assertEquals(false, inv.useIngredients(r2));
	}
	
	//Test useIngredients when ingredients chocolate is not available.
	public void testUseIngredients4() {
		inv.setChocolate(0);
		assertEquals(false, inv.useIngredients(r2));
	}
	
	//Test useIngredients when ingredients milk is not available.
	public void testUseIngredients5() {
		inv.setMilk(0);
		assertEquals(false, inv.useIngredients(r2));
	}
	
	public void testToString() {
		String sample = "Coffee: 15\n" + 
				"Milk: 15\n" + 
				"Sugar: 15\n" + 
				"Chocolate: 15\n";
		assertEquals(sample, inv.toString() );
	}

}