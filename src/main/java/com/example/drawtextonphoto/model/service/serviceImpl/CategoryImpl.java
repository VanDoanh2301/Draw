package com.example.drawtextonphoto.model.service.serviceImpl;

import com.example.drawtextonphoto.model.entity.Category;
import com.example.drawtextonphoto.model.repository.CategoryRepository;
import com.example.drawtextonphoto.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;


    //Create category
    @Override
    public Category saveCategory(Category category) {
        Category newCategory= new Category();
        newCategory.setCategoryName(category.getCategoryName());
        newCategory.setCategoryIndex(category.getCategoryIndex());
        return categoryRepo.save(newCategory);
    }

    //Exist category name
    @Override
    public boolean existsByCategoryName(String name) {
        return categoryRepo.existsByCategoryName(name);
    }

    //Get list category and pageable
    @Override
    public Page<Category> findByCategoryNameContaining(String name, Pageable pageable) {
        return categoryRepo.findByCategoryNameContaining(name, pageable);

    }

    //Get list category not pageable
    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepo.findAll(pageable);
    }


    //Find category id
    @Override
    public Category findByCategoryId(Integer id) {
        return categoryRepo.findByCategoryId(id);
    }
}
