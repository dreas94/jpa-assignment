package se.lexicon.dreas94.jpaassignment.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.dreas94.jpaassignment.entity.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Integer>
{
}
