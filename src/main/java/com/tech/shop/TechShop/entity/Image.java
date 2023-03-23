package com.tech.shop.TechShop.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "image")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Image {

    @Id
    @Column(name = "id",unique = true)
    private String id;

    @Column(length = 1000)
    private String url = "";


    @ManyToMany(mappedBy = "feature_images")
    private List<Product> products;

}
