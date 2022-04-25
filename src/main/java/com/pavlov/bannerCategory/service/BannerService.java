package com.pavlov.bannerCategory.service;

import com.pavlov.bannerCategory.entity.Banner;
import com.pavlov.bannerCategory.entity.Category;
import com.pavlov.bannerCategory.exception.AlreadyExistingException;
import com.pavlov.bannerCategory.exception.BannerNotFoundException;
import com.pavlov.bannerCategory.repository.BannerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BannerService extends AbstractCrudService<Banner> {

    private final LogRecordService logRecordService;

    private final CategoryService categoryService;

    public BannerService(BannerRepository repository, LogRecordService logRecordService, CategoryService categoryService) {
        this.categoryService = categoryService;
        this.logRecordService = logRecordService;
        this.setRepository(repository);
    }

    @Transactional
    public Banner getByCategories(List<Integer> categoryIds,String userAgent, String ipAddress) {
        List<Category> categories = categoryIds.stream().map(categoryService::getEntity).collect(Collectors.toList());
        List<Banner> distinctByCategoriesIn = ((BannerRepository) getRepository()).findDistinctByCategoriesInOrderByPriceDesc(categories)
                .stream().filter(banner -> !banner.isDeleted()).toList();
        if(distinctByCategoriesIn.isEmpty())throw new BannerNotFoundException("");
        distinctByCategoriesIn.forEach(b->log.info("id: " + b.getId() + " name: " + b.getName() + " price: " + b.getPrice() + " content: " + b.getContent()));
        Banner banner = distinctByCategoriesIn.get(0);
        logRecordService.addLogRecord(banner,userAgent,ipAddress);
        return banner;
    }

    @Transactional
    public Banner getRandomBanner(String userAgent, String ipAddress) {
        List<Banner> todayUserBanners = logRecordService.findTodayUserBanners(userAgent, ipAddress);
        if(todayUserBanners.isEmpty())throw new BannerNotFoundException("");
        Banner banner = todayUserBanners.get(0);
        logRecordService.addLogRecord(banner,userAgent,ipAddress);
        return banner;
    }

    @Override
    protected void validate(Banner entity) {
        ((BannerRepository)this.getRepository()).findByNameAndIsDeletedIsFalse(entity.getName())
                .filter(c -> c.getId() != entity.getId())
                .ifPresent(c -> {
                    throw new AlreadyExistingException("name", entity.getName());
                });
    }
}
