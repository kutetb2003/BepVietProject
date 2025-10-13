package com.bepviet.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "content")
@Data public class ContentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "contentEntity")
    private List<ImageEntity> imageEntityList;

    @OneToMany(mappedBy ="contentEntity")
    private List<ReviewEntity> reviewEntities;
}
