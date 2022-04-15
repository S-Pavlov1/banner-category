package com.pavlov.bannerCategory.controller;

import org.springframework.http.ResponseEntity;

public interface ICrudController <E, D> {

    public ResponseEntity<?> addEntity(D dto);

    public ResponseEntity<?> deleteEntity(int id);

    public ResponseEntity<?> getEntity(int id);

    public ResponseEntity<?> updateEntity(D dto);

}

