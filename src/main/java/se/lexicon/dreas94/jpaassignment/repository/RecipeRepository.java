package se.lexicon.dreas94.jpaassignment.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import se.lexicon.dreas94.jpaassignment.entity.Recipe;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Integer>
{
    List<Recipe> findByRecipeNameContaining(String name);
    @Query("SELECT recipe " +
            "FROM Recipe recipe " +
            "JOIN FETCH recipe.recipeIngredients recipeIngredient " +
            "WHERE recipeIngredient.ingredient.name = :ingredientName")
    List<Recipe> findRecipesByIngredientName(@Param("ingredientName") String ingredientName);

    @Query("SELECT recipe " +
            "FROM Recipe recipe " +
            "JOIN FETCH recipe.categories category " +
            "WHERE category.name = :categoryName")
    List<Recipe> findRecipesByCategoryName(@Param("categoryName") String categoryName);

    @Query("SELECT recipe " +
            "FROM Recipe recipe " +
            "JOIN FETCH recipe.categories category " +
            "WHERE category.name IN :categoryNames")
    List<Recipe> findRecipesByCategoryName(@Param("categoryNames") List<String> categoryNames);
}
