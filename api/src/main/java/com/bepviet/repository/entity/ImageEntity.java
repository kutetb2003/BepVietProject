package com.bepviet.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "image")
@Data
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "url")
    private String url;

    @Column(name = "caption")
    private String caption;

    @ManyToOne
    @JoinColumn(name = "content_id")
    private ContentEntity contentEntity;
}
