package com.aptech.springmvc.service;

import java.util.List;

import com.aptech.springmvc.entity.Book;

public interface BookService {
    public List<Book> getBooks();
    public Book getBook(int theId);
    public void saveBook(Book theBook);
    public void deleteBook(int theId);
    public List<Book> searchBooks(String theSearchName);
}
