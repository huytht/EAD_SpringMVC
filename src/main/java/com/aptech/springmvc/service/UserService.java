package com.aptech.springmvc.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.aptech.springmvc.entity.RegisterUser;
import com.aptech.springmvc.entity.User;

public interface UserService extends UserDetailsService{
    public List<User> getUsers();
    public User getUser(int theId);
    public void saveUser(User theUser);
    public void deleteUser(int theId);
    public List<User> searchUsers(String theSearchName);
	User findByUserName(String userName);
	void save(RegisterUser registerUser);
}
