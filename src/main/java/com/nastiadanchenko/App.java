package com.nastiadanchenko;

import com.nastiadanchenko.entity.Category;
import com.nastiadanchenko.entity.Product;
import com.nastiadanchenko.repositories.CategoryRepository;
import com.nastiadanchenko.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@AllArgsConstructor
@SpringBootApplication //(exclude={DataSourceAutoConfiguration.class})
public class App //implements ApplicationRunner
{
  //  private final ProductRepository productRepository;
  //  private CategoryRepository categoryRepository;
    public static void main( String[] args )
    {

        SpringApplication.run(App.class, args);
    }

//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        productRepository.save(new Product("Milk", 2.9, new Category("Food")));
//        productRepository.save(new Product("Meat", 10.9, new Category("Food")));
//        productRepository.save(new Product("Dress", 50.0, new Category("Clothes")));
//        productRepository.save(new Product("Jeans", 50.0, new Category("Clothes")));
//        System.out.println(productRepository.findAll());
//    }
}
