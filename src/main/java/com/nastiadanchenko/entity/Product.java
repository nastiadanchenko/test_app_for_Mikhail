package com.nastiadanchenko.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "product_id")
    private Long id;

//    @Column(name = "product_name")
    private String name;

//   @Column(name = "price")
    private Double price;

    @OneToOne
//    @Column(name = "category")
    private Category category;



    public Product(String name, Double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
}
