package se.lexicon.dreas94.jpaassignment.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Ingredient
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    public Ingredient()
    {

    }

    public Ingredient(String name)
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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Ingredient)) return false;
        Ingredient that = (Ingredient) o;
        return getId() == that.getId() && getName().equals(that.getName());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getId(), getName());
    }
}
