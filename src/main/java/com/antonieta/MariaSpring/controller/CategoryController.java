package com.antonieta.MariaSpring.controller;


import com.antonieta.MariaSpring.module.Category;
import com.antonieta.MariaSpring.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/category")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @GetMapping(path = "{categoryId}")
    public Category  getCategoryById(@PathVariable("categoryId") Long id) {
        return categoryService.getCategoryById(id);
    }


    //Peticion post
    @PostMapping
    public Category addCategory (@RequestBody Category category) {
        return categoryService.addCategoryById(category);
    }

    //Peticion Delete
    @DeleteMapping(path = "{categoryId}")
    public Category  deleteCategoryById(@PathVariable("categoryId") Long id) {
        return categoryService.deleteCategoryById(id);
    }


    //Peticion put
    @PutMapping(path = "{categoryId}")
    public Category  updateCategoryById(@PathVariable("categoryId") Long id, @RequestBody Category category) {
        return categoryService.UpdateCategoryById(id, category);
    }


}