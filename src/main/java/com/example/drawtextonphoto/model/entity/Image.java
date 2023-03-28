package com.example.drawtextonphoto.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imageId;
    @Column(name = "thumb", nullable = false, length = 125, unique = true)
    private  String thumb;
    @Column(name = "src", nullable = false, length = 125, unique = true)
    private  String imageSrc;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Column(name = "date", nullable = false)
    private Date date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"images", "handler","hibernateLazyInitializer"}, allowSetters = true)
    @JoinColumn(name = "categoryId")
    private Category categories;

    public Image() {
    }

    public Image(int imageId, String thumb, String imageSrc, Category categories) {
        this.imageId = imageId;
        this.thumb = thumb;
        this.imageSrc = imageSrc;
        this.categories = categories;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public Category getCategories() {
        return categories;
    }

    public void setCategories(Category categories) {
        this.categories = categories;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
