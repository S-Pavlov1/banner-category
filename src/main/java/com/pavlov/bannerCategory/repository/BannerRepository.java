package com.pavlov.bannerCategory.repository;

import com.pavlov.bannerCategory.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BannerRepository extends SearchRepository<Banner, Integer> {

    @Override
    @Query("select b from Banner b " +
            "where lower(b.name) like :#{#substring} " +
            "and b.isDeleted = false")
    List<Banner> search(String substring);

    Optional<Banner> findByName (String name);
}
