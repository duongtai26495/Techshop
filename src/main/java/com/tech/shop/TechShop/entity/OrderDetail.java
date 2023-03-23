package com.tech.shop.TechShop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_detail")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {

    @Id
    @Column(name = "id",unique = true)
    private String id;

    @ManyToOne()
    @JoinColumn(name = "order_detail_product", referencedColumnName = "id")
    private Product product;

    private int quantity;

    @ManyToOne()
    @JoinColumn(name = "order_detail_row", referencedColumnName = "id")
    private Order order_detail_row;

    private Double price = 0.0D;


}
