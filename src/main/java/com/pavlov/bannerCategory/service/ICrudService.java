package com.pavlov.bannerCategory.service;


import java.util.List;

public interface ICrudService<E>{

    void addEntity(E entity);

    void deleteEntity(int id);

    E getEntity(int id);

    void updateEntity (E entity);

    List<E> search (String substring);
}
