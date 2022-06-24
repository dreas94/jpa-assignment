package se.lexicon.dreas94.jpaassignment.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.dreas94.jpaassignment.entity.Ingredient;

import java.util.List;


public interface IngredientRepository extends CrudRepository<Ingredient, Integer>
{
    Ingredient findByName(String name);
    List<Ingredient> findByNameContaining(String name);
}
