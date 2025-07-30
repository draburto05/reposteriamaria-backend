package com.antonieta.MariaSpring.service;

import com.antonieta.MariaSpring.module.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategory();

    Category getCategoryById(Long id);
    Category deleteCategoryById(Long id);
    Category addCategoryById(Category category);
    Category UpdateCategoryById(Long id,Category categoryUpdate);
}
