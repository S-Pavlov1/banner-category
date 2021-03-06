package com.pavlov.bannerCategory.service;

import com.pavlov.bannerCategory.entity.Banner;
import com.pavlov.bannerCategory.entity.Category;
import com.pavlov.bannerCategory.entity.IdentifiableObject;
import com.pavlov.bannerCategory.exception.AlreadyExistingException;
import com.pavlov.bannerCategory.exception.RemovalException;
import com.pavlov.bannerCategory.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategoryService extends AbstractCrudService<Category> {

    public CategoryService(CategoryRepository repository) {
        this.setRepository(repository);
    }

    public Category getByRequestId (String requestId){
        return ((CategoryRepository)getRepository()).findByRequestIdAndIsDeletedIsFalse(requestId).get();
    }

    @Override
    public void deleteEntity(int id) {
        Set<Banner> banners = getEntity(id).getBanners().stream().filter(banner-> !banner.isDeleted()).collect(Collectors.toSet());
        if(!banners.isEmpty()) throw new RemovalException("Can't be removed. following banners still exist" +
                banners.stream().map(IdentifiableObject::getId).collect(Collectors.toSet()));
        super.deleteEntity(id);
    }

    @Override
    protected void validate(Category entity) {
        ((CategoryRepository)this.getRepository()).findByNameAndIsDeletedIsFalse(entity.getName())
                .filter(c -> c.getId() != entity.getId())
                .ifPresent(c -> {
                    throw new AlreadyExistingException("name", entity.getName());
                });
        ((CategoryRepository)this.getRepository()).findByRequestIdAndIsDeletedIsFalse(entity.getRequestId())
                .filter(c -> c.getRequestId() != entity.getRequestId())
                .ifPresent(c -> {
                    throw new AlreadyExistingException("requestId", entity.getRequestId());
                });
    }

}
