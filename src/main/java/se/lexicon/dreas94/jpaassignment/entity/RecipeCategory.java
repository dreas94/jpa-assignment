package se.lexicon.dreas94.jpaassignment.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class RecipeCategory
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    String category;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "recipe_recipe_category"
            ,joinColumns = {@JoinColumn(name = "recipe_category_id", referencedColumnName = "id")}
            ,inverseJoinColumns = {@JoinColumn(name = "recipe_id", referencedColumnName = "id")})
    private Set<Recipe> recipe;
}
