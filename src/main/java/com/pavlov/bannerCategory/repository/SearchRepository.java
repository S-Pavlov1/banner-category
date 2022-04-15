package com.pavlov.bannerCategory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface SearchRepository <E, Id> extends JpaRepository <E, Id> {
    List<E> search (String substring);
}
