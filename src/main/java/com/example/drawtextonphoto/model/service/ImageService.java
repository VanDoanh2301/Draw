package com.example.drawtextonphoto.model.service;

import com.example.drawtextonphoto.model.Dto.ImageDto;
import com.example.drawtextonphoto.model.entity.Image;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ImageService {

    boolean existsByThumb(String thumb);

    boolean existsByImageSrc(String src);

    Page<Image> findByThumbContaining(String thumb , Pageable pageable);

    Page<Image> findAll(Pageable pageable);

    Image saveImage(ImageDto imageDto);

    List<Image> findAll();

    Image findByImageId(Integer id);

    Page<Image> findByCategoryId(Integer id, Pageable pageable);
}
