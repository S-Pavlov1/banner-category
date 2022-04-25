package com.pavlov.bannerCategory.controller;

import com.pavlov.bannerCategory.dto.BannerDTO;
import com.pavlov.bannerCategory.entity.Banner;
import com.pavlov.bannerCategory.mapper.BannerMapper;
import com.pavlov.bannerCategory.service.BannerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/banners")
public class BannerController extends AbstractController <Banner, BannerDTO>{

    public BannerController(BannerService service, BannerMapper mapper) {
        super(service, mapper);
    }

    @GetMapping("/bid")
    public ResponseEntity<BannerDTO> getByCategories (@RequestParam List<Integer> categoryIds, HttpServletRequest request )  {
        log.info("GET banner by categories: {}", categoryIds.stream().map(Object::toString).reduce(" ",String::concat));
        Banner banner = ((BannerService)getService()).getByCategories(categoryIds, request.getHeader(HttpHeaders.USER_AGENT), request.getRemoteAddr());
        return ResponseEntity.ok(getMapper().toDto(banner));
    }

    @GetMapping("/randomBanner")
    public ResponseEntity<BannerDTO> getRandomBanner (HttpServletRequest request) {
        log.info("GET random banner");
        Banner banner = ((BannerService)getService()).getRandomBanner(request.getHeader(HttpHeaders.USER_AGENT), request.getRemoteAddr());
        BannerDTO bannerDTO = getMapper().toDto(banner);
        log.info("Got random banner : {}", bannerDTO.toString());
        return ResponseEntity.ok(bannerDTO);
    }
}
