package com.pavlov.bannerCategory.controller;

import com.pavlov.bannerCategory.service.CategoryServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/Category")
public class CategoryController {

    @Autowired
    private CategoryServiceI categoryService;
}
