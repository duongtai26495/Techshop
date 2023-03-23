package com.tech.shop.TechShop.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "brand")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Brand {

    @Id
    @Column(name = "id",unique = true)
    private String id;

    private String name;

    @OneToMany(targetEntity = Product.class, mappedBy = "brand", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products;

    @Column(length = 1000)
    private String feature_image;

    private boolean display;

    private String brand_desc;

}
