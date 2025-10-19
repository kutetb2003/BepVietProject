package com.bepviet.repository.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Formula;

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

    @OneToMany(mappedBy ="contentEntity", fetch = FetchType.LAZY)
    private List<ReviewEntity> reviewEntities;

    @Formula(" (select avg(r.rating) from review r where r.content_id = id )")
    private Double averageRating;
}
