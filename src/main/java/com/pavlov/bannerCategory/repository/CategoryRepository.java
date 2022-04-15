package com.pavlov.bannerCategory.repository;

import com.pavlov.bannerCategory.entity.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends SearchRepository<Category, Integer> {

    @Override
    @Query("select c from Category c " +
            "where lower(c.name) like :#{#substring} " +
            "and c.isDeleted = false")
    List<Category> search(String substring);

    Optional<Category> findByName(String name);

    Optional<Category> findByRequestId(String requestId);
}
