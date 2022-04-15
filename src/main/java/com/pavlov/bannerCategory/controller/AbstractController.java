package com.pavlov.bannerCategory.controller;

import com.pavlov.bannerCategory.mapper.IMapper;
import com.pavlov.bannerCategory.service.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor

public abstract class AbstractController <E, D> implements ICrudController<E, D>{

    private final ICrudService<E> service;

    private final IMapper<E,D> mapper;

    @PostMapping
    @Override
    public ResponseEntity<?> addEntity (@RequestBody D dto) {
        service.addEntity(mapper.toEntity(dto));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<?> deleteEntity(@PathVariable int id) {
        service.deleteEntity(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<?> getEntity(@PathVariable int id) {
        return ResponseEntity.ok(mapper.toDto(service.getEntity(id)));
    }

    @PutMapping
    @Override
    public ResponseEntity<?> updateEntity(@RequestBody D dto) {
        service.updateEntity(mapper.toEntity(dto));
        return ResponseEntity.ok().build();
    }
}
