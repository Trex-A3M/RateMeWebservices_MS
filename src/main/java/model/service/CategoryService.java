package model.service;

import model.entity.Category;

public interface CategoryService extends BaseService<Category> {
    int saveCategory(Category category);
}
