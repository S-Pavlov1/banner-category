package com.pavlov.bannerCategory.service;

import com.pavlov.bannerCategory.entity.Banner;
import com.pavlov.bannerCategory.exception.AlreadyExistingException;
import com.pavlov.bannerCategory.repository.BannerRepository;
import org.springframework.stereotype.Service;

@Service
public class BannerServiceI extends AbstractICrudService<Banner> {

    public BannerServiceI(BannerRepository repository) {
        this.setRepository(repository);
    }

    @Override
    protected void validate(Banner entity) {
        ((BannerRepository)this.getRepository()).findByName(entity.getName())
                .filter(c -> c.getId() != entity.getId())
                .ifPresent(c -> {
                    throw new AlreadyExistingException("name", entity.getName());
                });
    }
}
