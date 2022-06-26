package se.lexicon.dreas94.jpaassignment.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecipeTest
{
    private Recipe testObject;

    private Category categoryObject;

    private RecipeIngredient recipeInstructionObject;

    @BeforeEach
    private void setup()
    {

        testObject = new Recipe("Kladdkaka", new RecipeInstruction("1. Set oven on 175 degrees celsius\n" +
                "2. Melt butter, once done take the heated vessel youve metled the butter with off the stove\n" +
                "3. Mix in the sugar and eggs into the melted butter, mix troughly\n" +
                "4. Add the remaining ingredients all together\n" +
                "5. Pour this into a vessel with removable edges, ensure its buttered and breaded, preferably 24 centimeters in diameter \n" +
                "6. Put into oven for 15 minutes, no more, its done when the surface has started to hardened but still is slightly loose\n" +
                "7. Let it cool off first in rum temp and then in fridge. Cooling process is ca 1-2 hours"));
        testObject.addCategory(new Category("Test"));
        categoryObject = new Category("Test1");
        testObject.addCategory(categoryObject);
        testObject.addRecipeIngredient(new RecipeIngredient(new Ingredient("Flour"), 1, Measurement.DL));
        recipeInstructionObject = new RecipeIngredient(new Ingredient("Sugar"), 2.5, Measurement.DL);
        testObject.addRecipeIngredient(recipeInstructionObject);
    }

    @Test
    public void testAddCategory()
    {
        int expectedCount = 3;
        testObject.addCategory(new Category("Test3"));

        assertEquals(testObject.getCategories().size(), expectedCount);
    }

    @Test
    public void testRemoveCategory()
    {
        int expectedCount = 1;
        testObject.removeCategory(categoryObject);

        assertEquals(testObject.getCategories().size(), expectedCount);
    }

    @Test
    public void testAddRecipeIngredient()
    {
        int expectedCount = 3;
        testObject.addRecipeIngredient(new RecipeIngredient(new Ingredient("Egg"), 2, Measurement.NO));

        assertEquals(testObject.getRecipeIngredients().size(), expectedCount);
    }

    @Test
    public void testRemoveRecipe()
    {
        int expectedCount = 1;
        testObject.removeRecipeIngredient(recipeInstructionObject);

        assertEquals(testObject.getRecipeIngredients().size(), expectedCount);
    }

}