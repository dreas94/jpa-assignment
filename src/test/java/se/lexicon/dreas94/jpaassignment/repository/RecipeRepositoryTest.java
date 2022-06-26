package se.lexicon.dreas94.jpaassignment.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import se.lexicon.dreas94.jpaassignment.entity.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class RecipeRepositoryTest
{
    @Autowired
    RecipeRepository testObject;

    @Autowired
    // TestEntityManager allows us to use entityManager operations in tests
    TestEntityManager em;

    Ingredient ingredient1;
    Ingredient ingredient2;
    Ingredient ingredient3;
    Ingredient ingredient4;
    Ingredient ingredient5;
    Ingredient ingredient6;
    Ingredient ingredient7;
    Ingredient ingredient8;
    Ingredient ingredient9;

    RecipeIngredient recipeIngredient1;
    RecipeIngredient recipeIngredient2;
    RecipeIngredient recipeIngredient3;
    RecipeIngredient recipeIngredient4;
    RecipeIngredient recipeIngredient5;
    RecipeIngredient recipeIngredient6;
    RecipeIngredient recipeIngredient7;
    RecipeIngredient recipeIngredient8;
    RecipeIngredient recipeIngredient9;

    RecipeInstruction recipeInstruction1;
    RecipeInstruction recipeInstruction2;

    Category category1;
    Category category2;
    Category category3;

    Recipe recipe1;
    Recipe insertedRecipe1;

    Recipe recipe2;
    Recipe insertedRecipe2;

    @BeforeEach
    public void setup()
    {
        recipeInstruction1 = em.persistAndFlush(new RecipeInstruction("1. Set oven on 175 degrees celsius\n" +
                "2. Melt butter, once done take the heated vessel youve metled the butter with off the stove\n" +
                "3. Mix in the sugar and eggs into the melted butter, mix troughly\n" +
                "4. Add the remaining ingredients all together\n" +
                "5. Pour this into a vessel with removable edges, ensure its buttered and breaded, preferably 24 centimeters in diameter \n" +
                "6. Put into oven for 15 minutes, no more, its done when the surface has started to hardened but still is slightly loose\n" +
                "7. Let it cool off first in rum temp and then in fridge. Cooling process is ca 1-2 hours"));

        recipeInstruction2 = em.persistAndFlush(new RecipeInstruction("testy test tewst"));

        recipe1 = new Recipe("Kladdkaka", recipeInstruction1);
        recipe2 = new Recipe("TestCake", recipeInstruction2);

        ingredient1 = em.persistAndFlush(new Ingredient("Flour"));
        ingredient2 = em.persistAndFlush(new Ingredient("Sugar"));
        ingredient3 = em.persistAndFlush(new Ingredient("Egg"));
        ingredient4 = em.persistAndFlush(new Ingredient("Cacao"));
        ingredient5 = em.persistAndFlush(new Ingredient("Vanilla Extract"));
        ingredient6 = em.persistAndFlush(new Ingredient("Flour"));
        ingredient7 = em.persistAndFlush(new Ingredient("Test-Sugar"));
        ingredient8 = em.persistAndFlush(new Ingredient("Test-Egg"));
        ingredient9 = em.persistAndFlush(new Ingredient("Test-Extract"));

        recipeIngredient1 = em.persistAndFlush(new RecipeIngredient(ingredient1, 1, Measurement.DL));
        recipeIngredient2 = em.persistAndFlush(new RecipeIngredient(ingredient2, 2.5, Measurement.DL));
        recipeIngredient3 = em.persistAndFlush(new RecipeIngredient(ingredient3, 2, Measurement.NO));
        recipeIngredient4 = em.persistAndFlush(new RecipeIngredient(ingredient4, 3, Measurement.TBSP));
        recipeIngredient5 = em.persistAndFlush(new RecipeIngredient(ingredient5, 1, Measurement.TSP));
        recipeIngredient6 = em.persistAndFlush(new RecipeIngredient(ingredient6, 1, Measurement.DL));
        recipeIngredient7 = em.persistAndFlush(new RecipeIngredient(ingredient7, 2.5, Measurement.DL));
        recipeIngredient8 = em.persistAndFlush(new RecipeIngredient(ingredient8, 2, Measurement.NO));
        recipeIngredient9 = em.persistAndFlush(new RecipeIngredient(ingredient9, 1, Measurement.TSP));

        category1 = em.persistAndFlush(new Category("Chocolate"));
        category2 = em.persistAndFlush(new Category("Cake"));
        category3 = em.persistAndFlush(new Category("Test"));

        recipe1.addRecipeIngredient(recipeIngredient1);
        recipe1.addRecipeIngredient(recipeIngredient2);
        recipe1.addRecipeIngredient(recipeIngredient3);
        recipe1.addRecipeIngredient(recipeIngredient4);
        recipe1.addRecipeIngredient(recipeIngredient5);
        recipe2.addRecipeIngredient(recipeIngredient6);
        recipe2.addRecipeIngredient(recipeIngredient7);
        recipe2.addRecipeIngredient(recipeIngredient8);
        recipe2.addRecipeIngredient(recipeIngredient9);

        recipe1.addCategory(category1);
        recipe1.addCategory(category2);
        recipe2.addCategory(category2);
        recipe2.addCategory(category3);

        insertedRecipe1 = testObject.save(recipe1);
        insertedRecipe2 = testObject.save(recipe2);
    }

    @Test
    public void given_name_findByRecipeNameContaining_return_list_of_1()
    {
        int expectedCount = 1;

        List<Recipe> result = testObject.findByRecipeNameContaining("Kladd");
        assertEquals(expectedCount, result.size());
    }

    @Test
    public void given_name_findRecipesByIngredientName_return_list_of_2()
    {
        int expectedCount = 2;

        List<Recipe> result = testObject.findRecipesByIngredientName("Flour");
        assertEquals(expectedCount, result.size());
    }

    @Test
    public void given_name_findRecipesByCategoryName_return_list_of_2()
    {
        int expectedCount = 2;

        List<Recipe> result = testObject.findRecipesByCategoryName("Cake");
        assertEquals(expectedCount, result.size());
    }

    @Test
    public void given_name_findRecipesByCategoryNames_return_list_of_2()
    {
        int expectedCount = 2;

        List<String> categories = new ArrayList<>(Arrays.asList("Test", "Cake"));
        List<Recipe> result = testObject.findRecipesByCategoryNames(categories);
        assertEquals(expectedCount, result.size());
    }
}
