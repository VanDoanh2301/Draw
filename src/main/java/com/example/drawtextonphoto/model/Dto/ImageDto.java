package com.example.drawtextonphoto.model.Dto;

import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class ImageDto {

    private int imageId;
    private  String thumb;
    private  String imageSrc;

    private Date date;
    private Integer categoryId;

    public ImageDto() {
    }

    public ImageDto(int imageId, String thumb, String imageSrc, Date date, Integer categoryId) {
        this.imageId = imageId;
        this.thumb = thumb;
        this.imageSrc = imageSrc;
        this.date = date;
        this.categoryId = categoryId;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
