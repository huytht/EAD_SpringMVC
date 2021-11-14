package com.aptech.springmvc.dao;

import java.util.List;

import com.aptech.springmvc.entity.User;

public interface UserDAO {
    public List<User> getUsers();
    public User getUser(int theId);
    public void saveUser(User theUser);
    public void deleteUser(int theId);
    public List<User> searchUsers(String theSearchName);
	User findByUserName(String username);
	void save(User user);
}
