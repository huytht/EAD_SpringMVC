package com.aptech.springmvc.dao;


import org.hibernate.query.Query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aptech.springmvc.entity.Book;

@Repository
public class BookDAOImpl implements BookDAO{

	private SessionFactory sessionFactory;
	
	@Autowired
	public BookDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
    public List<Book> getBooks() {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Book> theQuery = currentSession.createQuery("from Book", Book.class);

        List<Book> Books = theQuery.getResultList();

        return Books;
    }

    @Override
    public Book getBook(int theId) {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        Book theBook = currentSession.get(Book.class, theId);

        return theBook;
    }
    
    @Override
    public void saveBook(Book theBook) {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // if the primaryKey is empty, then INSERT else UPDATE.
        currentSession.saveOrUpdate(theBook);
    }

    @Override
    public void deleteBook(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = currentSession.createQuery("delete from Book where id=:BookId");
        theQuery.setParameter("BookId", theId);
        theQuery.executeUpdate();
    }

    @Override
    public List<Book> searchBooks(String theSearchName) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery = null;

        if (theSearchName != null & theSearchName.trim().length() > 0) {
            theQuery = currentSession.createQuery("from Book where lower(title) like :theName", Book.class);

            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
        } else {
            theQuery = currentSession.createQuery("from Book", Book.class);
        }

        List<Book> Books = theQuery.getResultList();

        return Books;
    }
}
