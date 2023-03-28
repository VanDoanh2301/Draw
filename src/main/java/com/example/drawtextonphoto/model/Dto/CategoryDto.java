package com.example.drawtextonphoto.model.Dto;

import org.springframework.stereotype.Component;

@Component
public class CategoryDto {
    private int categoryId;
    private String categoryName;

    private Integer categoryIndex;

    public CategoryDto() {
    }

    public CategoryDto(int categoryId, String categoryName, Integer categoryIndex) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryIndex = categoryIndex;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryIndex() {
        return categoryIndex;
    }

    public void setCategoryIndex(Integer categoryIndex) {
        this.categoryIndex = categoryIndex;
    }
}
