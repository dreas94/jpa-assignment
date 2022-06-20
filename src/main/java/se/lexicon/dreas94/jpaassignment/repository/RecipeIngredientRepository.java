package se.lexicon.dreas94.jpaassignment.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.dreas94.jpaassignment.entity.RecipeIngredient;

public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient, String>
{
}
