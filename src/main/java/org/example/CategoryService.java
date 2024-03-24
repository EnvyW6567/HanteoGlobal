package org.example;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findById(Integer id) {
        Category category = categoryRepository.findById(id);
        return findAllChildren(category);
    }

    public List<Category> findByName(String name) {
        Category category = categoryRepository.findByName(name);
        return findAllChildren(category);
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    private List<Category> findAllChildren(Category category) {
        List<Category> categories = new ArrayList<>();
        categories.add(category);
        recursiveFindChildren(category.getChildrenId(), categories);

        return categories;
    }

    private void recursiveFindChildren(List<Integer> childrenId, List<Category> categories) {
        for (Integer child_id : childrenId) {
            Category childCategory = categoryRepository.findById(child_id);
            categories.add(childCategory);
            if (childCategory.getChildrenId() != null) {
                recursiveFindChildren(childCategory.getChildrenId(), categories);
            }
        }
    }

}
