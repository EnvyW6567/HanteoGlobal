package org.example;

import java.util.List;

public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public List<String> getCategoriesById(Integer id) {
        List<Category> categories = categoryService.findById(id);
        return categories.stream().map(Category::toJson).toList();
    }

    public List<String> getCategoriesByName(String name) {
        List<Category> categories = categoryService.findByName(name);
        return categories.stream().map(Category::toJson).toList();
    }

}
