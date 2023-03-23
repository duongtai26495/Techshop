package com.tech.shop.TechShop.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "product")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {


    @Id
    @Column(name = "id",unique = true)
    private String id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "product_category",
    joinColumns = @JoinColumn(name = "product_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "product_image",
    joinColumns = @JoinColumn(name = "product_id"),
    inverseJoinColumns = @JoinColumn(name = "imnage_id"))
    private List<Image> feature_images;

    @Column(length = 1000)
    private int quantity;

    @Column(length = 1000)
    private String product_desc;

    @ManyToOne()
    @JoinColumn(name = "product", referencedColumnName = "id")
    private Brand brand;

    private Double regular_price;

    private Double sale_price = 0.0D;


    @OneToMany(targetEntity = OrderDetail.class, mappedBy = "product",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<OrderDetail> order_details;

    private boolean display;

    private Double final_price;


    public void setFinal_price(Double final_price) {
        this.final_price = this.sale_price == 0.0D ? this.regular_price : this.sale_price;
    }
}
