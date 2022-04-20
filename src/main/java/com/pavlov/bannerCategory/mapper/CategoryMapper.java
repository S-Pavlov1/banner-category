package com.pavlov.bannerCategory.mapper;

import com.pavlov.bannerCategory.dto.CategoryDTO;
import com.pavlov.bannerCategory.entity.Category;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CategoryMapper implements IMapper<Category, CategoryDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Category toEntity(CategoryDTO dto) {
        Category entity = modelMapper.map(dto,Category.class);
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setRequestId(dto.getRequestId());
        return entity;
    }

    @Override
    public CategoryDTO toDto(Category entity) {
        CategoryDTO dto = modelMapper.map(entity, CategoryDTO.class);
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setRequestId(entity.getRequestId());
        return dto;
    }
}
