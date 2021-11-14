package com.aptech.springmvc.controller;

import com.aptech.springmvc.entity.Book;
import com.aptech.springmvc.entity.Category;
import com.aptech.springmvc.service.BookService;
import com.aptech.springmvc.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/book")
public class BookController {

    private BookService bookService;
    private CategoryService categoryService;
    private List<Category> theCategories = null;

    @Autowired
    public BookController(BookService bookService, CategoryService categoryService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public String listBooks(Model theModel) {

        List<Book> theBooks = null;

        theBooks = bookService.getBooks();
        theModel.addAttribute("books", theBooks);

        return "list-book";
    }

    @PostMapping("/saveBook")
    public String saveBook(@Valid @ModelAttribute("book") Book theBook, BindingResult theBindingResult,
    						Model theModel) {
    	
    	// form validation
		if (theBindingResult.hasErrors()) {	
			if (theBook.getId() != 0) {
				// get Book from DB
		        theBook = bookService.getBook(theBook.getId());
		        theModel.addAttribute("oldImage", theBook.getImage());
			}
			theCategories = categoryService.getCategories();
	        theModel.addAttribute("categories", theCategories);
			return "book-form";
		}
    	
        return this.doUpload(theBook);
    }
    
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Book theBook = new Book();
        theModel.addAttribute("book", theBook);
        theModel.addAttribute("oldImage", null);
        
        theCategories = categoryService.getCategories();
        theModel.addAttribute("categories", theCategories);
        
        return "book-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("bookId") int theId, Model theModel) {
        // get Book from DB
        Book theBook = bookService.getBook(theId);

        // bind data to theModel
        theModel.addAttribute("book", theBook);
        theModel.addAttribute("oldImage", theBook.getImage());

        System.out.println(theBook);
        
        theCategories = categoryService.getCategories();
        theModel.addAttribute("categories", theCategories);

        return "book-form";
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam("bookId") int theId) {
    	bookService.deleteBook(theId);
        return "redirect:/book/list";
    }

    @GetMapping("search")
    public String searchBook(@RequestParam("theSearchName") String theSearchName, Model theModel) {
        List<Book> theBooks = bookService.searchBooks(theSearchName);
        theModel.addAttribute("books", theBooks);
        return "list-book";
    }
    
    private String doUpload(@ModelAttribute("book") Book theBook) {

        File uploadRootDir = new File("D:\\MyJava\\work-space\\BookStoreOnline_SpringMVC\\src\\main\\webapp\\resources\\images");

        // Create directory if it not exists.
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdirs();
        }
        CommonsMultipartFile[] fileDatas = theBook.getFileData();

        List<File> uploadedFiles = new ArrayList<File>();
        for (CommonsMultipartFile fileData : fileDatas) {

            // Client File Name
            String name = fileData.getOriginalFilename();
            theBook.setImage(name);
            System.out.println("Client File Name = " + name);
            

            if (name != null && name.length() > 0) {
                try {
                    // Create the file on server
                    File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);
       
                    // Stream to write data to file in server.
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                    stream.write(fileData.getBytes());
                    stream.close();
                    //
                    uploadedFiles.add(serverFile);
                    System.out.println("Write file: " + serverFile);
                } catch (Exception e) {
                    System.out.println("Error Write file: " + name);
                }
            }
        }
        bookService.saveBook(theBook);
        return "redirect:/book/list";
    }
}

