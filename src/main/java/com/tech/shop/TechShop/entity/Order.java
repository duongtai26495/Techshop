package com.tech.shop.TechShop.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @Column(name = "id",unique = true)
    private String id;

    @OneToMany(targetEntity = OrderDetail.class, mappedBy = "order_detail_row", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderDetail> list_order_detail;

    @ManyToOne()
    @JoinColumn(name = "buyer", referencedColumnName = "id")
    private User buyer;

    private Double total = 0.0D;

    private Double sub_total = 0.0D;

    @Column(name = "created_at", updatable = false)
    private String created_at;

    private int order_status = 0;

    @Column(length = 1000)
    private String order_note;

    @ManyToOne()
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    private User created_by;

    private Double tax;


    public void setSub_total(Double sub_total) {
        this.sub_total =  ((this.total * this.tax) / 100) + this.total;
    }


}
