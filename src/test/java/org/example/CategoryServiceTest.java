package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("Category Service Test")
class CategoryServiceTest {

    private CategoryService categoryService;

    @BeforeEach
    void setup() {
        Category parentCategory = new Category(0, null, null, "남자");
        Category childCategory1 = new Category(1, List.of(0), null, "엑소");
        Category childCategory2 = new Category(2, List.of(0), null, "방탄소년단");
        Category grandChildCategory1 = new Category(4, List.of(1), null, "공지사항");
        Category grandChildCategory2 = new Category(5, List.of(1), null, "첸");
        Category grandChildCategory3 = new Category(6, List.of(1), null, "백현");
        Category grandChildCategory4 = new Category(7, List.of(1, 2), null, "익명게시판");
        Category grandChildCategory5 = new Category(8, List.of(2), null, "공지사항");
        Category grandChildCategory6 = new Category(9, List.of(2), null, "뷔");
        List<Category> categories = List.of(
                parentCategory, childCategory1, childCategory2, grandChildCategory1, grandChildCategory2,
                grandChildCategory3, grandChildCategory4, grandChildCategory5, grandChildCategory6
        );
        categoryService = new CategoryService(new CategoryRepositoryImpl());

        categories.forEach(category -> categoryService.addCategory(category));
    }

    @Test
    @DisplayName("Find all categories include sub categories By category_id")
    void findByCategoryId() {
        // given
        Integer category_id = 2;

        // when
        List<Category> actual = categoryService.findById(category_id);

        // then
        Assertions.assertThat(actual.size()).isEqualTo(4);
    }
}
