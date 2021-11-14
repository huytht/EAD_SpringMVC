package com.aptech.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aptech.springmvc.dao.BookDAO;
import com.aptech.springmvc.dao.CategoryDAO;
import com.aptech.springmvc.entity.Book;
import com.aptech.springmvc.entity.Category;

@Service
public class BookServiceImpl implements BookService {

	private BookDAO bookDAO;
	
	@Autowired
	public BookServiceImpl(BookDAO bookDAO, CategoryDAO categoryDAO) {
		this.bookDAO = bookDAO;
	}

	@Override
	@Transactional
	public List<Book> getBooks() {
		return bookDAO.getBooks();
	}

	@Override
	@Transactional
	public Book getBook(int theId) {
		return bookDAO.getBook(theId);
	}

	@Override
	@Transactional
	public void saveBook(Book theBook) {
		bookDAO.saveBook(theBook);
	}

	@Override
	@Transactional
	public void deleteBook(int theId) {
		bookDAO.deleteBook(theId);
	}

	@Override
	@Transactional
	public List<Book> searchBooks(String theSearchName) {
		return bookDAO.searchBooks(theSearchName);
	}

}
