package com.example.drawtextonphoto.model.service;

import com.example.drawtextonphoto.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {


    public  Category saveCategory(Category category);

    boolean existsByCategoryName(String name);

    Page<Category> findByCategoryNameContaining(String name, Pageable pageable);


    Page<Category> findAll(Pageable pageable);

    Category findByCategoryId(Integer id);
}
