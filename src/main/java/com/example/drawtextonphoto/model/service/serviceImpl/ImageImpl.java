package com.example.drawtextonphoto.model.service.serviceImpl;

import com.example.drawtextonphoto.model.Dto.ImageDto;
import com.example.drawtextonphoto.model.entity.Category;
import com.example.drawtextonphoto.model.entity.Image;
import com.example.drawtextonphoto.model.repository.CategoryRepository;
import com.example.drawtextonphoto.model.repository.ImageRepository;
import com.example.drawtextonphoto.model.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepo;

    @Autowired
    private CategoryRepository categoryRepo;


    //Exist image thumb
    @Override
    public boolean existsByThumb(String thumb) {
        return imageRepo.existsByThumb(thumb);
    }

    //Exist image src
    @Override
    public boolean existsByImageSrc(String src) {
        return imageRepo.existsByImageSrc(src);
    }

    //Get list image and pageable
    @Override
    public Page<Image> findByThumbContaining(String thumb, Pageable pageable) {
        return imageRepo.findByThumbContaining(thumb, pageable);
    }

    @Override
    public Page<Image> findAll(Pageable pageable) {
        return imageRepo.findAll(pageable);
    }

    //Create image
    @Override
    public Image saveImage(ImageDto imageDto) {
        Category category = categoryRepo.findByCategoryId(imageDto.getCategoryId());
      Image newImage = new Image();
      newImage.setThumb(imageDto.getThumb());
      newImage.setImageSrc(imageDto.getImageSrc());
      newImage.setDate(imageDto.getDate());
      newImage.setCategories(category);
      return imageRepo.save(newImage);
    }

    @Override
    public List<Image> findAll() {
        return imageRepo.findAll();
    }


    @Override
    public Image findByImageId(Integer id) {
        return imageRepo.findByImageId(id);
    }



    @Override
    public Page<Image> findByCategoryId(Integer id, Pageable pageable) {
        return imageRepo.findByCategoryId(id, pageable);
    }
}
