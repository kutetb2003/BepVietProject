package com.bepviet.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cuisine")
public class CuisineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "image_urls")
    private List<String> imageUrls;


}
