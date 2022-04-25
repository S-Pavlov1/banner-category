package com.pavlov.bannerCategory.controller;

import com.pavlov.bannerCategory.dto.DTO;
import com.pavlov.bannerCategory.entity.IdentifiableObject;
import com.pavlov.bannerCategory.mapper.IMapper;
import com.pavlov.bannerCategory.service.ICrudService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
@Slf4j
public abstract class AbstractController <E extends IdentifiableObject, D extends DTO> implements ICrudController<E, D>{


    private final ICrudService<E> service;

    private final IMapper<E,D> mapper;

    @PostMapping
    @Override
    public ResponseEntity<?> addEntity (@RequestBody D dto) {
        log.info("POST request DTO: {}", dto.toString());
        E entity = mapper.toEntity(dto);
        service.addEntity(entity);
        log.info("POST request for entity with id : {}", entity.getId());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<?> deleteEntity(@PathVariable int id) {
        service.deleteEntity(id);
        log.info("DELETE request for entity with id : {}", id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<?> getEntity(@PathVariable int id) {
        log.info("GET request for entity with id : {}", id);
        E entity = service.getEntity(id);
        log.info("Found entity with id : {}", entity.getId());
        return entity == null ? ResponseEntity.ok().build() : ResponseEntity.ok(mapper.toDto(entity));
    }

    @GetMapping
    @Override
    public ResponseEntity<?> getAllEntities() {
        List<E> entities = service.getAllEntities();
        //log.info("GET all entities of :{}", entities.get(0).getClass());
        return ResponseEntity.ok(entities.stream().map(mapper::toDto).collect(Collectors.toList()));
    }

    @PutMapping
    @Override
    public ResponseEntity<?> updateEntity(@RequestBody D dto) {
        log.info("PUT request DTO: {}", dto.toString());
        service.updateEntity(mapper.toEntity(dto));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String substring) {
        log.info("SEARCH with substring {}", substring);
        return ResponseEntity.ok(service.search(substring).stream().map(mapper::toDto).collect(Collectors.toList()));
    }
}
