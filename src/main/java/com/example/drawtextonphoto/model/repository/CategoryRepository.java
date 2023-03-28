package com.example.drawtextonphoto.model.repository;

import com.example.drawtextonphoto.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    boolean existsByCategoryName(String name) ;

    Page<Category> findByCategoryNameContaining(String name, Pageable pageable);

    Category findByCategoryId(Integer id);


}
