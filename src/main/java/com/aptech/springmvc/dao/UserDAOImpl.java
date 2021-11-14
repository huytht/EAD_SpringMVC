package com.aptech.springmvc.dao;


import org.hibernate.query.Query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aptech.springmvc.entity.User;

@Repository
public class UserDAOImpl implements UserDAO{

	private SessionFactory sessionFactory;
	
	@Autowired
	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
    public List<User> getUsers() {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        Query<User> theQuery = currentSession.createQuery("from User", User.class);

        List<User> Users = theQuery.getResultList();

        return Users;
    }

    @Override
    public User getUser(int theId) {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        User theUser = currentSession.get(User.class, theId);

        return theUser;
    }
    
    @Override
    public void saveUser(User theUser) {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // if the primaryKey is empty, then INSERT else UPDATE.
        currentSession.saveOrUpdate(theUser);
    }

    @Override
    public void deleteUser(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = currentSession.createQuery("delete from User where id=:UserId");
        theQuery.setParameter("UserId", theId);
        theQuery.executeUpdate();
    }

    @Override
    public List<User> searchUsers(String theSearchName) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery = null;

        if (theSearchName != null & theSearchName.trim().length() > 0) {
            theQuery = currentSession.createQuery("from User where lower(username) like :theName", User.class);

            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
        } else {
            theQuery = currentSession.createQuery("from User", User.class);
        }

        List<User> Users = theQuery.getResultList();

        return Users;
    }

	 @Override
     public User findByUserName(String username) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<User> theQuery = currentSession.createQuery("from User where username=:uName", User.class);
        theQuery.setParameter("uName", username);

        User theUser = null;
        try {
            theUser = theQuery.getSingleResult();
        } catch (Exception e) {
            theUser = null;
        }

        return theUser;
    }

     @Override
     public void save(User user) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(user);
     }
	
}
