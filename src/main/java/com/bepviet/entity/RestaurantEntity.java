package com.bepviet.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "restaurant")
@Data
public class RestaurantEntity extends ContentEntity{
    @Column(name="address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name="manager_id", referencedColumnName = "id")
    private UserEntity userEntity;
}
