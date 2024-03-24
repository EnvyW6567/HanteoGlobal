package org.example;

public interface CategoryRepository {
    Category findById(Integer id);
    Category findByName(String name);
    void save(Category object);
}
