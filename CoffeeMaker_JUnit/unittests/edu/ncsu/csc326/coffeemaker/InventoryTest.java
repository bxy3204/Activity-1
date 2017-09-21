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

/*	public void testInventory() {
		//fail("Not yet implemented");
	}

	public void testGetChocolate() {
		//fail("Not yet implemented");
	}

	public void testSetChocolate() {
		//fail("Not yet implemented");
	}

	public void testAddChocolate() {
		//fail("Not yet implemented");
	}

	public void testGetCoffee() {
		//fail("Not yet implemented");
	}

	public void testSetCoffee() {
		//fail("Not yet implemented");
	}

	public void testAddCoffee() {
		//fail("Not yet implemented");
	}

	public void testGetMilk() {
		//fail("Not yet implemented");
	}

	public void testSetMilk() {
		//fail("Not yet implemented");
	}

	public void testAddMilk() {
		//fail("Not yet implemented");
	}

	public void testGetSugar() {
		//fail("Not yet implemented");
	}

	public void testSetSugar() {
		//fail("Not yet implemented");
	}

	public void testAddSugar() {
		//fail("Not yet implemented");
	}

	*/
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
		inv.setMilk(0);
		assertEquals(false, inv.enoughIngredients(r2));
	}
	//Test useIngredients when ingredients are available.
	public void testUseIngredients0() {
		assertEquals(true, inv.useIngredients(r1));
	}
	//Test useIngredients when ingredients are not available.
	public void testUseIngredients1() {
		inv.setCoffee(0);
		assertEquals(false, inv.useIngredients(r1));
	}
	//Test useIngredients consumes correct amount of ingredients.
	//Inventory starts with 15 units of all ingredients,
	//r2 should consume all ingredients available.
	public void testUseIngredients3() {
		int totalIngredients;
		inv.useIngredients(r2);
		totalIngredients = inv.getChocolate()+inv.getCoffee()+inv.getMilk()
			+ inv.getSugar();
		assertEquals(0, totalIngredients);
	}

	public void testToString() {
		String sample = "Coffee: 15\n" + 
				"Milk: 15\n" + 
				"Sugar: 15\n" + 
				"Chocolate: 15\n";
		assertEquals(sample, inv.toString() );
	}

}
