package se.lexicon.dreas94.jpaassignment.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class RecipeInstruction
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 1500)
    String instructions;

    public RecipeInstruction()
    {
    }

    public RecipeInstruction(String instructions)
    {
        this.instructions = instructions;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getInstructions()
    {
        return instructions;
    }

    public void setInstructions(String instructions)
    {
        this.instructions = instructions;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof RecipeInstruction)) return false;
        RecipeInstruction that = (RecipeInstruction) o;
        return getId() == that.getId() && getInstructions().equals(that.getInstructions());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getId(), getInstructions());
    }

    @Override
    public String toString()
    {
        return "RecipeInstruction{" +
                "id=" + id +
                ", instructions='" + instructions + '\'' +
                '}';
    }
}
