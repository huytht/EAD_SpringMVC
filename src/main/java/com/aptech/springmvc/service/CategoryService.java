package com.aptech.springmvc.service;

import java.util.List;

import com.aptech.springmvc.entity.Category;

public interface CategoryService {
    public List<Category> getCategories();
    public Category getCategory(int theId);
    public void saveCategory(Category theCategory);
    public void deleteCategory(int theId);
    public List<Category> searchCategories(String theSearchName);
    Category findByName(String name);
}
