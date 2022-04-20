package com.pavlov.bannerCategory.controller;

import com.pavlov.bannerCategory.dto.BannerDTO;
import com.pavlov.bannerCategory.entity.Banner;
import com.pavlov.bannerCategory.mapper.BannerMapper;
import com.pavlov.bannerCategory.service.BannerService;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banners")
public class BannerController extends AbstractController <Banner, BannerDTO>{

    public BannerController(BannerService service, BannerMapper mapper) {
        super(service, mapper);
    }
}
