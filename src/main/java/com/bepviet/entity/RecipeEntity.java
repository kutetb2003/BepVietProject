package com.bepviet.entity;

import com.bepviet.enums.Difficulty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "recipe")
@Data
public class RecipeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "difficulty")
    private Difficulty difficulty;

    @Column(name = "image_urls")
    private List<String> imageUrls;

    @ManyToOne
    @JoinColumn(name ="user_id")
    private UserEntity userEntity;
}
