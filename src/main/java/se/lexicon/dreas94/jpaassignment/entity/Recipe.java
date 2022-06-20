package se.lexicon.dreas94.jpaassignment.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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

    @OneToOne
    @JoinColumn(name = "instruction_id")
    private RecipeInstruction recipeInstruction;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "recipe_recipe_category"
            ,joinColumns = {@JoinColumn(name = "recipe_id", referencedColumnName = "id")}
            ,inverseJoinColumns = {@JoinColumn(name = "recipe_category_id", referencedColumnName = "id")})
    private Set<RecipeCategory> categories;
}
