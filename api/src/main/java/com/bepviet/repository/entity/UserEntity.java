package com.bepviet.repository.entity;

import com.bepviet.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "user")

@Data public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name="password")
    private String password;

    @OneToOne(mappedBy = "userEntity")
    private RestaurantEntity restaurantEntity;

    @OneToMany(mappedBy = "userEntity")
    private List<RecipeEntity> recipeEntityList;

    @OneToMany(mappedBy = "userEntity")
    private List<ReviewEntity> reviewEntities;
}
