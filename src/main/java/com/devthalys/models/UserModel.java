package com.devthalys.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class UserModel extends PanacheEntity {

    public String name;
    public int age;
}
