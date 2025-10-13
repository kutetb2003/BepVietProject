package com.bepviet.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cuisine")
@Data
@EqualsAndHashCode(exclude = "recipeEntities")
public class CuisineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "cuisineEntities")
    private Set<RecipeEntity> recipeEntities = new HashSet<>();
}