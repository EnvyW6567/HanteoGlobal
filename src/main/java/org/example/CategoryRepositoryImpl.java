package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryRepositoryImpl implements CategoryRepository {
    private final List<Category> categories;

    private final Map<Integer, Integer> categoryIdMap;
    private final Map<String, Integer> categoryNameMap;

    public CategoryRepositoryImpl() {
        this.categories = new ArrayList<>();
        this.categoryIdMap = new HashMap<>();
        this.categoryNameMap = new HashMap<>();
    }

    @Override
    public Category findById(Integer id) {
        Integer categoryId = categoryIdMap.get(id);
        return categories.get(categoryId);
    }

    @Override
    public Category findByName(String name) {
        Integer categoryId = categoryNameMap.get(name);
        return categories.get(categoryId);
    }

    @Override
    public void save(Category category) {
        Integer categoryId = categories.size();

        categories.add(category);
        categoryIdMap.put(category.getId(), categoryId);
        categoryNameMap.put(category.getName(), categoryId);
        category.getParentId().forEach(parentId -> {
            Category parentCategory = getCategoryById(parentId);
            parentCategory.updateChildrenId(categoryId);
        });
    }

    private Category getCategoryById(Integer id) {
        Integer categoryId = categoryIdMap.get(id);
        return categories.get(categoryId);
    }

}

