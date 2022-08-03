package com.nastiadanchenko.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

   private String categoryName;
    @OneToMany
    private List<Product> products;
}
