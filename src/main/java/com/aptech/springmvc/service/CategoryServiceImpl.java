package com.aptech.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aptech.springmvc.dao.CategoryDAO;
import com.aptech.springmvc.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryDAO categoryDAO;
	
	@Autowired
	public CategoryServiceImpl(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	@Override
	@Transactional
	public List<Category> getCategories() {
		return categoryDAO.getCategories();
	}

	@Override
	@Transactional
	public Category getCategory(int theId) {
		return categoryDAO.getCategory(theId);
	}

	@Override
	@Transactional
	public void saveCategory(Category theCategory) {
		categoryDAO.saveCategory(theCategory);
	}

	@Override
	@Transactional
	public void deleteCategory(int theId) {
		categoryDAO.deleteCategory(theId);
	}

	@Override
	@Transactional
	public List<Category> searchCategories(String theSearchName) {
		return categoryDAO.searchCategories(theSearchName);
	}

	@Override
	@Transactional
	public Category findByName(String name) {
		return categoryDAO.findByName(name);
	}

}
