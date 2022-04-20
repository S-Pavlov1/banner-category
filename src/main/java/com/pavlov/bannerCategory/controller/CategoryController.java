package com.pavlov.bannerCategory.controller;

import com.pavlov.bannerCategory.dto.CategoryDTO;
import com.pavlov.bannerCategory.entity.Category;
import com.pavlov.bannerCategory.mapper.CategoryMapper;
import com.pavlov.bannerCategory.mapper.IMapper;
import com.pavlov.bannerCategory.service.CategoryService;
import com.pavlov.bannerCategory.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController extends AbstractController <Category, CategoryDTO>{

    public CategoryController(CategoryService service, CategoryMapper mapper) {
        super(service, mapper);
    }
}
