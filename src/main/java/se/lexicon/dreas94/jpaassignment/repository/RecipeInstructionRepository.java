package se.lexicon.dreas94.jpaassignment.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.dreas94.jpaassignment.entity.RecipeInstruction;

public interface RecipeInstructionRepository extends CrudRepository<RecipeInstruction, Integer>
{
}
