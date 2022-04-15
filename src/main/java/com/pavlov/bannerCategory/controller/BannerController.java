package com.pavlov.bannerCategory.controller;

import com.pavlov.bannerCategory.service.BannerServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.web.bind.annotation.RequestMapping;

@ReadingConverter
@RequestMapping("api/banners")
public class BannerController {

    @Autowired
    private BannerServiceI bannerService;
}
