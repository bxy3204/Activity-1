package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import junit.framework.TestCase;

public class InventoryTest extends TestCase {
	private Inventory inv;
	private Recipe r1;
	private Recipe r2;
	private Recipe coffeeOnlyRecipe;
	private Recipe milkOnlyRecipe;
	private Recipe sugarOnlyRecipe;
	private Recipe chocolateOnlyRecipe;
	
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
		
		//Set up recipe for coffee only
		coffeeOnlyRecipe = new Recipe();
		coffeeOnlyRecipe.setName("Coffee");
		coffeeOnlyRecipe.setAmtChocolate("0");
		coffeeOnlyRecipe.setAmtCoffee("15");
		coffeeOnlyRecipe.setAmtMilk("0");
		coffeeOnlyRecipe.setAmtSugar("0");
		coffeeOnlyRecipe.setPrice("50");
		super.setUp();
		
		//Set up recipe for milk only
		milkOnlyRecipe = new Recipe();
		milkOnlyRecipe.setName("Coffee");
		milkOnlyRecipe.setAmtChocolate("0");
		milkOnlyRecipe.setAmtCoffee("0");
		milkOnlyRecipe.setAmtMilk("15");
		milkOnlyRecipe.setAmtSugar("0");
		milkOnlyRecipe.setPrice("50");
		super.setUp();
		
		//set up recipe for sugar only
		sugarOnlyRecipe = new Recipe();
		sugarOnlyRecipe.setName("Coffee");
		sugarOnlyRecipe.setAmtChocolate("0");
		sugarOnlyRecipe.setAmtCoffee("0");
		sugarOnlyRecipe.setAmtMilk("0");
		sugarOnlyRecipe.setAmtSugar("15");
		sugarOnlyRecipe.setPrice("50");
		super.setUp();
		
		//set up recipe with chocolate only
		chocolateOnlyRecipe = new Recipe();
		chocolateOnlyRecipe.setName("Coffee");
		chocolateOnlyRecipe.setAmtChocolate("15");
		chocolateOnlyRecipe.setAmtCoffee("0");
		chocolateOnlyRecipe.setAmtMilk("0");
		chocolateOnlyRecipe.setAmtSugar("0");
		chocolateOnlyRecipe.setPrice("50");
		super.setUp();
	}
	
	//test set/get chocolate
	public void testSetGetChocolate() {
		inv.setChocolate(2);
		assertEquals(2, inv.getChocolate());
	}
	
	//test invalid set/get chocolate
	public void testInvalidSetGetChocolate() {
		inv.setChocolate(3);
		inv.setChocolate(-2);
		assertEquals(3, inv.getChocolate());
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
	
	//test add zero chocolate
	public void testAddZeroChocolate() {
		inv.setChocolate(0);
		try {
			inv.addChocolate("0");
		}
		catch(InventoryException e) {
			fail("InventoryException should not be thrown");
		}
		assertEquals(0, inv.getChocolate());
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
	
	//test set/get coffee
	public void testSetGetCoffee() {
		inv.setCoffee(2);
		assertEquals(2, inv.getCoffee());
	}
	
	//test invalid set/get coffee
	public void testInvalidSetGetCoffee() {
		inv.setCoffee(3);
		inv.setCoffee(-2);
		assertEquals(3, inv.getCoffee());
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
	
	//tests adding zero coffee
	public void testAddZeroCoffee() {
		inv.setCoffee(0);
		try {
			inv.addCoffee("0");
		}
		catch(InventoryException e) {
			fail("InventoryException should not be thrown");
		}
		assertEquals(0, inv.getCoffee());
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
	
	//test get/set milk
	public void testGetSetMilk() {
		inv.setMilk(2);
		assertEquals(2, inv.getMilk());
	}
	
	//test get/set invalid amount of milk
	public void testInvalidGetSetMilk() {
		inv.setMilk(3);
		inv.setMilk(-2);
		assertEquals(3, inv.getMilk());
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

	//test adding zero milk
	public void testAddZeroMilk() {
		inv.setMilk(0);
		try {
			inv.addMilk("0");
		}
		catch(InventoryException e) {
			fail("InventoryException should not be thrown");
		}
		assertEquals(0, inv.getMilk());
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
	
	//test set/get sugar
	public void testSetGetSugar() {
		inv.setSugar(2);
		assertEquals(2, inv.getSugar());
	}
	
	//test set/get invalid amount of sugar
	public void testInvalidSetGetSugar() {
		inv.setSugar(2);
		inv.setSugar(-2);
		assertEquals(2, inv.getSugar());
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

	//test enoughIngredients when there is enough chocolate
	public void testEnoughChocolate() {
		inv.setChocolate(30);
		assertEquals(true, inv.enoughIngredients(chocolateOnlyRecipe));
	}
	
	public void testJustEnoughChocolate() {
		inv.setChocolate(15);
		assertEquals(true, inv.enoughIngredients(chocolateOnlyRecipe));
	}
	
	//Test enoughIngredients when there are is not enough coffee
	public void testEnoughIngredients2() {
		inv.setCoffee(0);
		assertEquals(false, inv.enoughIngredients(r2));
	}
	
	//test enoughIngredients when there is enough coffee
	public void testEnoughCoffee() {
		inv.setCoffee(30);
		assertEquals(true, inv.enoughIngredients(coffeeOnlyRecipe));
	}
	
	public void testJustEnoughCoffee() {
		inv.setCoffee(15);
		assertEquals(true, inv.enoughIngredients(coffeeOnlyRecipe));
	}
	
	//Test enoughIngredients when there are is not enough milk
	public void testEnoughIngredients3() {
		inv.setMilk(0);
		assertEquals(false, inv.enoughIngredients(r2));
	}
	
	//test enoughIngredients when there is enough milk
	public void testEnoughMilk() {
		inv.setMilk(30);
		assertEquals(true, inv.enoughIngredients(milkOnlyRecipe));
	}
	
	public void testJustEnoughMilk() {
		inv.setMilk(15);
		assertEquals(true, inv.enoughIngredients(milkOnlyRecipe));
	}
	
	//Test enoughIngredients when there are is not enough sugar
	public void testEnoughIngredients4() {
		inv.setSugar(0);
		assertEquals(false, inv.enoughIngredients(r2));
	}
	
	//test enoughIngredients when there is enough sugar
	public void testEnoughSugar() {
		inv.setSugar(30);
		assertEquals(true, inv.enoughIngredients(sugarOnlyRecipe));
	}
	
	public void testJustEnoughSugar() {
		inv.setSugar(15);
		assertEquals(true, inv.enoughIngredients(sugarOnlyRecipe));
	}
	
	//Test useIngredients when ingredients are available.
	public void testUseIngredients0() {
		assertEquals(true, inv.useIngredients(r1));
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
	
	//tests emptying coffee
	public void testUseAllCoffee() {
		inv.setCoffee(15);
		inv.useIngredients(coffeeOnlyRecipe);
		assertEquals(0, inv.getCoffee());
	}
	
	//tests emptying milk
	public void testUseAllMilk() {
		inv.setMilk(15);
		inv.useIngredients(milkOnlyRecipe);
		assertEquals(0, inv.getMilk());
	}
	
	//tests emptying sugar
	public void testUseAllSugar() {
		inv.setSugar(15);
		inv.useIngredients(sugarOnlyRecipe);
		assertEquals(0, inv.getSugar());
	}
	
	//tests emptying chocolate
	public void testUseAllChocolate() {
		inv.setChocolate(15);
		inv.useIngredients(chocolateOnlyRecipe);
		assertEquals(0, inv.getChocolate());
	}
	
	//tests using less coffee than is available
	public void testUseSomeCoffee() {
		inv.setCoffee(30);
		inv.useIngredients(coffeeOnlyRecipe);
		assertEquals(15, inv.getCoffee());
	}
	
	//tests using less milk than is available
	public void testUseSomeMilk() {
		inv.setMilk(30);
		inv.useIngredients(milkOnlyRecipe);
		assertEquals(15, inv.getMilk());
	}
	
	//tests using less sugar than is available
	public void testUseSomeSugar() {
		inv.setSugar(30);
		inv.useIngredients(sugarOnlyRecipe);
		assertEquals(15, inv.getSugar());
	}
	
	//tests using less chocolate than is available
	public void testUseSomeChocolate() {
		inv.setChocolate(30);
		inv.useIngredients(chocolateOnlyRecipe);
		assertEquals(15, inv.getChocolate());
	}
	
	//Test useIngredients when ingredients coffee is not available.
	public void testUseIngredients1() {
		inv.setCoffee(0);
		assertEquals(false, inv.useIngredients(r2));
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
