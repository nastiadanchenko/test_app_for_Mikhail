package com.nastiadanchenko.repositories;

import com.nastiadanchenko.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
  //  @Query("SELECT Product.name, Category.name AS Cat, Product.price FROM Product INNER JOIN Category ON Product.category.id = Category.id")
  List<Product> findAll();
}
