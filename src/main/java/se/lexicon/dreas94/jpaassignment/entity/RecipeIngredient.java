package se.lexicon.dreas94.jpaassignment.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class RecipeIngredient
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private Measurement measurement;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }

    public Ingredient getIngredient()
    {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient)
    {
        this.ingredient = ingredient;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public Measurement getMeasurement()
    {
        return measurement;
    }

    public void setMeasurement(Measurement measurement)
    {
        this.measurement = measurement;
    }

    public Recipe getRecipe()
    {
        return recipe;
    }

    public void setRecipe(Recipe recipe)
    {
        this.recipe = recipe;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof RecipeIngredient)) return false;
        RecipeIngredient that = (RecipeIngredient) o;
        return Double.compare(that.getAmount(), getAmount()) == 0 && getId().equals(that.getId()) && getIngredient().equals(that.getIngredient()) && getMeasurement() == that.getMeasurement() && getRecipe().equals(that.getRecipe());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getId(), getIngredient(), getAmount(), getMeasurement(), getRecipe());
    }

    @Override
    public String toString()
    {
        return "RecipeIngredient{" +
                "id='" + id + '\'' +
                ", ingredient=" + ingredient +
                ", amount=" + amount +
                ", measurement=" + measurement +
                ", recipe=" + recipe +
                '}';
    }
}