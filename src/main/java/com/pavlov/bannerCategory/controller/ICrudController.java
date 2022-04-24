package com.pavlov.bannerCategory.controller;

import org.springframework.http.ResponseEntity;

public interface ICrudController <E, D> {

    ResponseEntity<?> addEntity(D dto);

    ResponseEntity<?> deleteEntity(int id);

    ResponseEntity<?> getEntity(int id);

    ResponseEntity<?> getAllEntities();

    ResponseEntity<?> updateEntity(D dto);

}

