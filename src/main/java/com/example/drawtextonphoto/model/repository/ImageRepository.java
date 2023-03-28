package com.example.drawtextonphoto.model.repository;

import com.example.drawtextonphoto.model.entity.Image;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {

    boolean existsByThumb(String thumb);
    boolean existsByImageSrc(String src);

    Page<Image> findByThumbContaining(String thumb,Pageable pageable);

    Image findByImageId(Integer id);

    @Query(value = "SELECT *FROM image  WHERE category_Id = ?1", nativeQuery = true)
    Page<Image> findByCategoryId(Integer id, Pageable pageable);

}
