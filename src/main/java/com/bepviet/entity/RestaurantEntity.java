package com.bepviet.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "restaurententity")
@Data
public class RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="address")
    private String address;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "image_urls")
    private List<String> imageUrls;

    @OneToOne
    @JoinColumn(name="manager_id", referencedColumnName = "id")
    private UserEntity userEntity;
}
