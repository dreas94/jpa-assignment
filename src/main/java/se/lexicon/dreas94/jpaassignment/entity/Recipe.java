package se.lexicon.dreas94.jpaassignment.entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class Recipe
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String recipeName;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            mappedBy = "recipe",
            orphanRemoval = true
    )
    private List<RecipeIngredient> recipeIngredients;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instruction_id")
    private RecipeInstruction recipeInstruction;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "recipe_category"
            ,joinColumns = {@JoinColumn(name = "recipe_id", referencedColumnName = "id")}
            ,inverseJoinColumns = {@JoinColumn(name = "recipe_category_id", referencedColumnName = "id")})
    private Set<Category> categories;

    public Recipe()
    {

    }

    public Recipe(String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction recipeInstruction, Set<Category> categories)
    {
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.recipeInstruction = recipeInstruction;
        this.categories = categories;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getRecipeName()
    {
        return recipeName;
    }

    public void setRecipeName(String recipeName)
    {
        this.recipeName = recipeName;
    }

    public List<RecipeIngredient> getRecipeIngredients()
    {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients)
    {
        this.recipeIngredients = recipeIngredients;
    }

    public RecipeInstruction getRecipeInstruction()
    {
        return recipeInstruction;
    }

    public void setRecipeInstruction(RecipeInstruction recipeInstruction)
    {
        this.recipeInstruction = recipeInstruction;
    }

    public Set<Category> getCategories()
    {
        return categories;
    }

    public void setCategories(Set<Category> categories)
    {
        this.categories = categories;
    }

    public void addRecipeIngredient(RecipeIngredient recipeIngredient)
    {
        if(recipeIngredient == null) throw new IllegalArgumentException("recipeIngredient data is null");
        if(recipeIngredients == null) recipeIngredients = new ArrayList<>();
        if(recipeIngredient.getRecipe() == null) recipeIngredient.setRecipe(new Recipe());

        if(!recipeIngredients.contains(recipeIngredient) && recipeIngredient.getRecipe() != this)
        {
            recipeIngredients.add(recipeIngredient);
            recipeIngredient.setRecipe(this);
        }
    }

    public void removeRecipeIngredient(RecipeIngredient recipeIngredient)
    {
        if(recipeIngredient == null) throw new IllegalArgumentException("recipeIngredient data is null");
        if(recipeIngredients == null) recipeIngredients = new ArrayList<>();
        if(recipeIngredient.getRecipe() == null) recipeIngredient.setRecipe(new Recipe());

        if(recipeIngredients.contains(recipeIngredient) && recipeIngredient.getRecipe() == this)
        {
            recipeIngredient.setRecipe(null);
            recipeIngredients.add(recipeIngredient);
        }
    }

    public void addCategory(Category category)
    {
        if(category == null) throw new IllegalArgumentException("category data is null");
        if(categories == null) categories = new HashSet<>();
        if(category.getRecipes() == null) category.setRecipes(new HashSet<>());

        if(!categories.contains(category))
        {
            categories.add(category);
        }
    }

    public void removeCategory(Category category)
    {
        if(category == null) throw new IllegalArgumentException("category data is null");
        if(categories == null) categories = new HashSet<>();
        if(category.getRecipes() == null) category.setRecipes(new HashSet<>());

        if(categories.contains(category))
        {
            categories.remove(category);
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Recipe)) return false;
        Recipe recipe = (Recipe) o;
        return getId() == recipe.getId() && getRecipeName().equals(recipe.getRecipeName()) && getRecipeIngredients().equals(recipe.getRecipeIngredients()) && getRecipeInstruction().equals(recipe.getRecipeInstruction());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getId(), getRecipeName(), getRecipeIngredients(), getRecipeInstruction());
    }

    @Override
    public String toString()
    {
        return "Recipe{" +
                "id=" + id +
                ", recipeName='" + recipeName + '\'' +
                ", recipeInstruction=" + recipeInstruction +
                '}';
    }
}
