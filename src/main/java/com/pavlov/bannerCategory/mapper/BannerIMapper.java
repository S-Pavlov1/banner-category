package com.pavlov.bannerCategory.mapper;

import com.pavlov.bannerCategory.dto.BannerDTO;
import com.pavlov.bannerCategory.dto.CategoryDTO;
import com.pavlov.bannerCategory.entity.Banner;
import com.pavlov.bannerCategory.entity.Category;
import com.pavlov.bannerCategory.service.CategoryServiceI;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class BannerIMapper implements IMapper<Banner, BannerDTO> {

    private final CategoryServiceI categoryService;

    private final ModelMapper modelMapper;

    @Override
    public Banner toEntity(BannerDTO dto) {
        Banner entity = modelMapper.map(dto, Banner.class);
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setContent(dto.getContent());
        Set<Category> categories = dto.getCategories().stream().map(categoryService::getEntity).collect(Collectors.toSet());
        entity.setCategories(categories);
        return null;
    }

    @Override
    public BannerDTO toDto(Banner entity) {
        BannerDTO dto = modelMapper.map(entity, BannerDTO.class);
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setContent(entity.getContent());
        Set<Integer> categories = entity.getCategories().stream().map(s -> modelMapper.map(s,CategoryDTO.class).getId()).collect(Collectors.toSet());
        dto.setCategories(categories);
        return null;
    }
}
