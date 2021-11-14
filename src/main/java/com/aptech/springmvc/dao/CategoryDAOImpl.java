package com.aptech.springmvc.dao;


import org.hibernate.query.Query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aptech.springmvc.entity.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO{

	private SessionFactory sessionFactory;
	
	@Autowired
	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
    public List<Category> getCategories() {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Category> theQuery = currentSession.createQuery("from Category", Category.class);

        List<Category> Categorys = theQuery.getResultList();

        return Categorys;
    }

    @Override
    public Category getCategory(int theId) {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        Category theCategory = currentSession.get(Category.class, theId);

        return theCategory;
    }
    
    @Override
    public void saveCategory(Category theCategory) {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // if the primaryKey is empty, then INSERT else UPDATE.
        currentSession.saveOrUpdate(theCategory);
    }

    @Override
    public void deleteCategory(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = currentSession.createQuery("delete from Category where id=:categoryId");
        theQuery.setParameter("categoryId", theId);
        theQuery.executeUpdate();
    }

    @Override
    public List<Category> searchCategories(String theSearchName) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery = null;

        if (theSearchName != null & theSearchName.trim().length() > 0) {
            theQuery = currentSession.createQuery("from Category where lower(name) like :theName", Category.class);

            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
        } else {
            theQuery = currentSession.createQuery("from Category", Category.class);
        }

        List<Category> Categories = theQuery.getResultList();

        return Categories;
    }

	@Override
	public Category findByName(String name) {
		Session currentSession = sessionFactory.getCurrentSession();

        Query<Category> theQuery = currentSession.createQuery("from Category where lower(name) like :theName", Category.class);
        theQuery.setParameter("theName", "%" + name.toLowerCase() + "%");

        Category theCategory = null;
        try {
        	theCategory = theQuery.getSingleResult();
        } catch (Exception e) {
        	theCategory = null;
        }

        return theCategory;
	}
}
