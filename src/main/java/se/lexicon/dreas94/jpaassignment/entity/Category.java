package se.lexicon.dreas94.jpaassignment.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    String category;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, mappedBy = "categories")
    private Set<Recipe> recipes;

    public Category()
    {

    }

    public Category(String category)
    {
        this.category = category;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public Set<Recipe> getRecipe()
    {
        return recipes;
    }

    public void setRecipe(Set<Recipe> recipes)
    {
        this.recipes = recipes;
    }

    public void addRecipe(Recipe recipe)
    {
        if(recipe == null) throw new IllegalArgumentException("recipe data is null");
        if(recipes == null) recipes = new HashSet<>();
        if(recipe.getCategories() == null) recipe.setCategories(new HashSet<>());

        if(!recipes.contains(recipe))
        {
            recipes.add(recipe);
        }
    }

    public void removeRecipe(Recipe recipe)
    {
        if(category == null) throw new IllegalArgumentException("recipe data is null");
        if(recipes == null) recipes = new HashSet<>();
        if(recipe.getCategories() == null) recipe.setCategories(new HashSet<>());

        if(!recipes.contains(recipe))
        {
            recipes.add(recipe);
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category1 = (Category) o;
        return getId() == category1.getId() && getCategory().equals(category1.getCategory());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getId(), getCategory());
    }

    @Override
    public String toString()
    {
        return "Category{" +
                "id=" + id +
                ", category='" + category +
                '}';
    }
}