package com.example.drawtextonphoto.model.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    @Column(name = "category_name", nullable = false, length = 125, unique = true)
    private String categoryName;

    @Column(name = "category_index", nullable = false, length = 50, unique = false)
    private Integer categoryIndex;



    @OneToMany(mappedBy = "categories")
    private  Collection<Image> images;

    public Category(int categoryIndex, String categoryName, Collection<Image> images) {
        this.categoryIndex = categoryIndex;
        this.categoryName = categoryName;
        this.images = images;
    }

    public Category() {
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryIndex(Integer categoryIndex) {
        this.categoryIndex = categoryIndex;
    }

    public int getCategoryIndex() {
        return categoryIndex;
    }

    public void setCategoryIndex(int categoryIndex) {
        this.categoryIndex = categoryIndex;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Collection<Image> getImages() {
        return images;
    }

    public void setImages(Collection<Image> images) {
        this.images = images;
    }
}
