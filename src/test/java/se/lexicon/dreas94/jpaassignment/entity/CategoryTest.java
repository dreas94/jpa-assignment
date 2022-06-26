package se.lexicon.dreas94.jpaassignment.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryTest
{
    private Category testObject;

    private Recipe recipeObject;

    @BeforeEach
    private void setup()
    {
        testObject = new Category("Test");
        testObject.addRecipe(new Recipe("TestRecipe1", new RecipeInstruction("Testtestesttest1")));
        recipeObject = new Recipe("TestRecipe2", new RecipeInstruction("Testtestesttest2"));
        testObject.addRecipe(recipeObject);
    }

    @Test
    public void testAddRecipe()
    {
        int expectedCount = 3;
        testObject.addRecipe(new Recipe("TestRecipe3", new RecipeInstruction("Testtestesttest3")));

        assertEquals(testObject.getRecipes().size(), expectedCount);
    }

    @Test
    public void testRemoveRecipe()
    {
        int expectedCount = 1;
        testObject.removeRecipe(recipeObject);

        assertEquals(testObject.getRecipes().size(), expectedCount);
    }

}
