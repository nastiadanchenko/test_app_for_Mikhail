package com.nastiadanchenko.repositories;

import com.nastiadanchenko.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
 // @Query(value = "SELECT Product.name, Category.name AS CAT, Product.price FROM Product INNER JOIN Category ON Product.category.id = Category.id")
 @Query(value = "SELECT PRODUCTS.NAME, CATEGORIES.NAME AS CAT, PRODUCTS.PRICE\n" +
         " FROM PRODUCTS INNER JOIN CATEGORIES ON PRODUCTS.CATEGORY_ID = CATEGORIES.ID", nativeQuery = true)
  List<Product> findAllProductWithCategory();
}
