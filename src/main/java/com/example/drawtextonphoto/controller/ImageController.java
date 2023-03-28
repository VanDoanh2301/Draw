package com.example.drawtextonphoto.controller;

import com.example.drawtextonphoto.model.Dto.ImageDto;
import com.example.drawtextonphoto.model.entity.Image;
import com.example.drawtextonphoto.model.service.ImageService;
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
public class ImageController {

    @Autowired
    private ImageService imageService;

    //Create new Image
    @PostMapping("/newImage")
    public ResponseEntity<?> addNewImage(@RequestBody ImageDto imageDto) {
        if (imageService.existsByImageSrc(imageDto.getImageSrc())) {
            return ResponseEntity.ok("Src has been");
        }
        if(imageService.existsByThumb(imageDto.getThumb())) {
            return ResponseEntity.ok("Thumb has been");
        }
        Image image = imageService.saveImage(imageDto);
        return ResponseEntity.ok("Image has been saved");

    }

    //Get list image
    @GetMapping("/images")
    public ResponseEntity<?> getAllImageChoice(@RequestParam(value = "thumb",required = false) String thumb
            ,@RequestParam(value = "page") Optional<Integer> page
            ,@RequestParam("size") Optional<Integer> size) {

        int currentPage = page.orElse(0);
        int pageSize = size.orElse(30);

        Pageable pageable = PageRequest.of(currentPage, pageSize,Sort.by("date"));
        Page<Image> resultPage = null;
        if (StringUtils.hasText(thumb)) {
            resultPage = imageService.findByThumbContaining(thumb, pageable);

        } else {
            resultPage = imageService.findAll(pageable);
        }
        return ResponseEntity.ok(resultPage);
    }
    //Get list image from category
    @GetMapping("/categories/{categoryId}")
    public ResponseEntity<?> getImageByCategoryId(@PathVariable("categoryId") Integer categoryId
            ,@RequestParam(value = "page") Optional<Integer> page
            ,@RequestParam("size") Optional<Integer> size
    ) {
        int currentPage = page.orElse(0);
        int pageSize = size.orElse(30);
        Pageable pageable = PageRequest.of(currentPage,pageSize,Sort.by("date"));

        Page<Image> images = imageService.findByCategoryId(categoryId, pageable);
        if(images.isEmpty()) {
            return  ResponseEntity.ok("Null");
        }
        return ResponseEntity.ok(images);
    }


}
