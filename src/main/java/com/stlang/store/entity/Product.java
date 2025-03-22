package com.stlang.store.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String image;
    private Double price;
    @Temporal(TemporalType.DATE)
    private Date date;
    private Boolean available;
    private Integer sold;
    private Integer inventory;

    @ManyToOne
    @JoinColumn (name ="category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;

}
