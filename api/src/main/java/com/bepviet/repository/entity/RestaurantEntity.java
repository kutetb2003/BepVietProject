package com.bepviet.repository.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Formula;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "restaurant")
@Data
@ToString(exclude = {"reviews", "userEntity"})
public class RestaurantEntity extends ContentEntity{
    @Column(name="address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;
    @OneToOne
    @JoinColumn(name="manager_id", referencedColumnName = "id")
    private UserEntity userEntity;

    @Transient
    private String managerName;

    @PostLoad
    private void onLoad() {
        if (this.userEntity != null) {
            this.managerName = this.userEntity.getFullName();
        }
    }
}
