package se.lexicon.dreas94.jpaassignment.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.dreas94.jpaassignment.entity.Ingredient;

import java.util.List;
import java.util.Optional;


public interface IngredientRepository extends CrudRepository<Ingredient, Integer>
{
    Optional<Ingredient> findByName(String name);

    List<Ingredient> findByNameContaining(String name);
}
