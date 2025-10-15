package com.bepviet.entity;

import com.bepviet.enums.Difficulty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "recipe")
@Data
@EqualsAndHashCode(callSuper = true, exclude = {"ingredientEntities", "cuisineEntities"})
public class RecipeEntity extends ContentEntity {

    @Column(name = "difficulty")
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToMany
    @JoinTable(
            name = "recipe_cuisine",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "cuisine_id")
    )
    private Set<CuisineEntity> cuisineEntities = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "recipe_ingredient",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private Set<IngredientEntity> ingredientEntities = new HashSet<>();
}