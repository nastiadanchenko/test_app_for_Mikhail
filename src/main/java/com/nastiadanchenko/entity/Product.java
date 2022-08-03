package com.nastiadanchenko.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Integer price;
    @OneToOne
    private Category category;



}
