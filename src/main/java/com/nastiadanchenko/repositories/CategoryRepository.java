package com.nastiadanchenko.repositories;

import com.nastiadanchenko.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
