package edu.ncsu.csc326.coffeemaker;

import junit.framework.TestCase;

public class RecipeBookTest extends TestCase {

	private RecipeBook rb;
	private Recipe r1;
	private Recipe r2;
	private Recipe r3;
	private Recipe r4;
	private Recipe r5;
	protected void setUp() throws Exception {
		//Setup for recipe book
		rb = new RecipeBook();
		//Setup r1
		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setAmtChocolate("0");
		r1.setAmtCoffee("3");
		r1.setAmtMilk("1");
		r1.setAmtSugar("1");
		r1.setPrice("50");
		rb.addRecipe(r1);
		//Setup r2
		r2 = new Recipe();
		r2.setName("Mocha");
		r2.setAmtChocolate("20");
		r2.setAmtCoffee("3");
		r2.setAmtMilk("1");
		r2.setAmtSugar("1");
		r2.setPrice("75");
		
		//Set up for r3
		r3 = new Recipe();
		r3.setName("Latte");
		r3.setAmtChocolate("0");
		r3.setAmtCoffee("3");
		r3.setAmtMilk("3");
		r3.setAmtSugar("1");
		r3.setPrice("100");
		
		//Set up for r4
		r4 = new Recipe();
		r4.setName("Hot Chocolate");
		r4.setAmtChocolate("4");
		r4.setAmtCoffee("0");
		r4.setAmtMilk("1");
		r4.setAmtSugar("1");
		r4.setPrice("65");
		//Set up for r5
		r5 = new Recipe();
		r5.setName("Water");
		r5.setAmtChocolate("4");
		r5.setAmtCoffee("0");
		r5.setAmtMilk("1");
		r5.setAmtSugar("2");
		r5.setPrice("60");
		
		
		super.setUp();
	}
	//Add recipe to recipe book.
	//Expected return value: True.
	public void testAddRecipe1() {
		assertEquals(true,rb.addRecipe(r2) );
	}
	//Get recipe R1 from the recipebook
	//Expected return value: True
	public void testGetRecipes1() {
		Recipe [] recipeArray;
		Recipe getRecipe;
		recipeArray = rb.getRecipes();
		getRecipe = recipeArray[0];
		assertEquals(true,getRecipe.equals(r1));
	}

	//Attempt to add Recipe 1 again.
	//Expected return value: False
	public void testAddRecipe2() {
		assertEquals(false,rb.addRecipe(r1) );
	}
	//Attempt to add maximum number of recipes
	//Expected return value: True
	public void testAddRecipe3() {
		rb.addRecipe(r2);
		rb.addRecipe(r3);
		assertEquals(true,rb.addRecipe(r4) );
	}
	//Attempt to add more than the maximum number of recipes.
	//Expected return value: false
	public void testAddRecipe4() {
		rb.addRecipe(r2);
		rb.addRecipe(r3);
		rb.addRecipe(r4);
		assertEquals(false,rb.addRecipe(r5) );
	}
	//Attempt to add Recipes after deleting them
	//Expected return value: false
	public void testAddRecipe6() {
		rb.addRecipe(r2);
		rb.addRecipe(r3);
		rb.addRecipe(r4);
		rb.deleteRecipe(0);
		rb.deleteRecipe(1);
		rb.deleteRecipe(2);
		rb.deleteRecipe(3);
		assertEquals(true,rb.addRecipe(r1) );
	}
	//Attempt to delete Recipe 1
	//Expected return value: Coffee
	public void testDeleteRecipe1() {
		assertEquals("Coffee",rb.deleteRecipe(0) );
	}
	//Attempt to delete Recipe not in Recipebook
	//Expected return value: Null
	public void testDeleteRecipe2() {
		assertEquals(null,rb.deleteRecipe(1) );
	}
	//Attempt to change Recipe 1 to Recipe 5
	//Expected return value: Coffee
	public void testEditRecipe1() {
		assertEquals("Coffee",rb.editRecipe(0,r5) );
	}
	//Attempt to change recipe that does not exist
	//Expected return value: null
	public void testEditRecipe2() {
		assertEquals(null,rb.editRecipe(1,r5) );
	}
	//Verify edit recipe with get recipe.
	//Expected return value: true
	public void testEditRecipe3() {
		rb.editRecipe(0,r5);
		Recipe [] recipeArray;
		Recipe getRecipe;
		recipeArray = rb.getRecipes();
		getRecipe = recipeArray[0];
		assertEquals(true, getRecipe.equals(r5) );
	}
	//Verify add recipe with get recipe.
	//Expected return value: true
	public void testAddRecipe5() {
		rb.addRecipe(r2);
		Recipe [] recipeArray;
		Recipe getRecipe;
		recipeArray = rb.getRecipes();
		getRecipe = recipeArray[1];
		assertEquals(true, getRecipe.equals(r2) );
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
