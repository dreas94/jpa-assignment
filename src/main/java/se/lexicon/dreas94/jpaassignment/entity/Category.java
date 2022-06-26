package se.lexicon.dreas94.jpaassignment.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "category")
public class Category
{
    @Column(nullable = false, unique = true)
    String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, mappedBy = "categories")
    private Set<Recipe> recipes;

    public Category()
    {

    }

    public Category(String name)
    {
        this.name = name;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Set<Recipe> getRecipes()
    {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes)
    {
        this.recipes = recipes;
    }

    public void addRecipe(Recipe recipe)
    {
        if (recipe == null) throw new IllegalArgumentException("recipe data is null");
        if (recipes == null) recipes = new HashSet<>();
        if (recipe.getCategories() == null) recipe.setCategories(new HashSet<>());

        recipes.add(recipe);
    }

    public void removeRecipe(Recipe recipe)
    {
        if (recipe == null) throw new IllegalArgumentException("recipe data is null");
        if (recipes == null) recipes = new HashSet<>();
        if (recipe.getCategories() == null) recipe.setCategories(new HashSet<>());

        recipes.remove(recipe);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category1 = (Category) o;
        return getId() == category1.getId() && getName().equals(category1.getName());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getId(), getName());
    }

    @Override
    public String toString()
    {
        return "Category{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
