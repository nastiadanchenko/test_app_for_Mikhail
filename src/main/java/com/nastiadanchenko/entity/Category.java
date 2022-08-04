package com.nastiadanchenko.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "category_id")
    private Long id;

//    @Column(name = "category_name")
    private String name;

    @OneToMany
    private Set<Product> products;


    public Category(String name) {
        this.name = name;
    }
}
