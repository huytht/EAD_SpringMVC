package com.aptech.springmvc.controller;

import com.aptech.springmvc.entity.Category;
import com.aptech.springmvc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public String listCategories(Model theModel) {

        List<Category> theCategories = null;

        theCategories = categoryService.getCategories();
        theModel.addAttribute("categories", theCategories);

        return "list-category";
    }

    @PostMapping("/saveCategory")
    public String saveCategory(@Valid @ModelAttribute("category") Category theCategory, BindingResult bindingResult) {
        
    	if (bindingResult.hasErrors()) {
    		return "category-form";
    	} else {
    		categoryService.saveCategory(theCategory);

            return "redirect:/category/list";
    	}
    }
    
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Category theCategory = new Category();
        theModel.addAttribute("category", theCategory);

        return "category-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("categoryId") int theId, Model theModel) {
        // get Category from DB
        Category theCategory = categoryService.getCategory(theId);

        // bind data to theModel
        theModel.addAttribute("category", theCategory);

        return "category-form";
    }

    @GetMapping("/delete")
    public String deleteCategory(@RequestParam("categoryId") int theId) {
    	categoryService.deleteCategory(theId);
        return "redirect:/category/list";
    }

    @GetMapping("search")
    public String searchCategory(@RequestParam("theSearchName") String theSearchName, Model theModel) {
        List<Category> theCategories = categoryService.searchCategories(theSearchName);
        theModel.addAttribute("categories", theCategories);
        return "list-category";
    }
}

