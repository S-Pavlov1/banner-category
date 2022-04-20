package com.pavlov.bannerCategory.service;

import com.pavlov.bannerCategory.entity.DeletableObject;
import com.pavlov.bannerCategory.exception.NotFoundException;
import com.pavlov.bannerCategory.repository.SearchRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public abstract class AbstractCrudService<E extends DeletableObject> implements ICrudService<E> {

    @Getter
    @Setter
    private SearchRepository<E, Integer> repository;

    private LogRecordService logRecordService;

    @Override
    @Transactional
    public void addEntity(E entity) {
        validate(entity);
        repository.save(entity);
    }

    @Override
    @Transactional
    public void deleteEntity(int id) {
        E entity = getEntity(id);
        entity.setDeleted(true);
    }

    @Override
    public E getEntity(int id) throws NotFoundException {
        E entity = repository.findById(id).orElseThrow(() -> new NotFoundException("Object not fond. Wrong id: " + id));
        if (entity.isDeleted()) return null;
        return entity;
    }

    @Override
    @Transactional
    public void updateEntity(E entity) {
        int id = entity.getId();
        if(!repository.existsById(id)) throw new NotFoundException("Object not fond. Wrong id: " + id);
        //validate(entity);
        repository.save(entity);
    }

    @Override
    public List<E> search(String substring) {
        return repository.search("%" + substring + "%");
    }

    protected abstract void validate(E entity);
}