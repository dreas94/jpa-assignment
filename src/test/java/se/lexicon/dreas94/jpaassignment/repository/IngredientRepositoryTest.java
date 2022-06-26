package se.lexicon.dreas94.jpaassignment.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.dreas94.jpaassignment.entity.Ingredient;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class IngredientRepositoryTest
{
    @Autowired
    IngredientRepository testObject;

    @BeforeEach
    public void setup()
    {
        testObject.save(new Ingredient("Sugar"));
        testObject.save(new Ingredient("Flour"));
        testObject.save(new Ingredient("All-Purpose-Flour"));
    }

    @Test
    public void given_name_findByName_return_optional_present()
    {
        Ingredient expectedContent = new Ingredient(1, "Sugar");

        Optional<Ingredient> result = testObject.findByName("Sugar");
        assertTrue(result.isPresent());
        assertEquals(expectedContent, result.get());
    }

    @Test
    public void given_name_findByNameContaining_return_list_of_2()
    {
        int expectedCount = 2;

        List<Ingredient> result = testObject.findByNameContaining("Flour");
        assertEquals(expectedCount, result.size());
    }
}
