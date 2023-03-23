package com.tech.shop.TechShop.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @Column(name = "id",unique = true)
    private String id;

    private String name;


    @ManyToMany(mappedBy = "categories")
    private List<Product> products;

    @Column(length = 1000)
    private String feature_image;

}
