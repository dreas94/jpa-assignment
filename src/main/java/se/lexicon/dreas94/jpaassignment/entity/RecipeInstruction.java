package se.lexicon.dreas94.jpaassignment.entity;

import javax.persistence.*;

@Entity
public class RecipeInstruction
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    String instructions;
}
