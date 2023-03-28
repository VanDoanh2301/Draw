package com.example.drawtextonphoto.controller;

import com.example.drawtextonphoto.model.entity.Category;
import com.example.drawtextonphoto.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    //Create category
    @PostMapping("/newCategory")
    public ResponseEntity<?> addNewCategory(@RequestBody Category category) {
        if(categoryService.existsByCategoryName(category.getCategoryName())) {
            return ResponseEntity.ok("Name");
        }
        Category newCategory = categoryService.saveCategory(category);
        return ResponseEntity.ok("Category has been saved");

    }
    //Get list category
    @GetMapping("/categories")
    public  ResponseEntity<?> getAllCategories(@RequestParam(value = "name",required = false) String name
            ,@RequestParam(value = "page") Optional<Integer> page
            ,@RequestParam("size") Optional<Integer> size) {

        int currentPage = page.orElse(0);
        int pageSize = size.orElse(30);

        Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by("categoryIndex"));
        Page<Category> resultPage = null;
        if (StringUtils.hasText(name)) {
            resultPage = categoryService.findByCategoryNameContaining(name, pageable);

        } else {
            resultPage = categoryService.findAll(pageable);
        }
        return ResponseEntity.ok(resultPage);
    }



}
