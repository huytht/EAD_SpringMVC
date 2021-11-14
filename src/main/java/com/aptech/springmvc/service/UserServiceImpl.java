package com.aptech.springmvc.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import com.aptech.springmvc.entity.RegisterUser;
import com.aptech.springmvc.entity.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.aptech.springmvc.dao.RoleDAO;
import com.aptech.springmvc.dao.UserDAO;

@Service("myUserDetailsService")
public class UserServiceImpl implements UserService{

	private UserDAO userDAO;
	private RoleDAO roleDAO;
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public UserServiceImpl(UserDAO userDAO, RoleDAO roleDAO, BCryptPasswordEncoder passwordEncoder) {
		this.userDAO = userDAO;
		this.roleDAO = roleDAO;
		this.passwordEncoder = passwordEncoder;
	}
	
    @Override
    @Transactional
    public List<com.aptech.springmvc.entity.User> getUsers() {
        return userDAO.getUsers();
    }

    @Override
    @Transactional
    public com.aptech.springmvc.entity.User getUser(int theId) {
        return userDAO.getUser(theId);
    }

    @Override
    @Transactional
    public void deleteUser(int theId) {
    	userDAO.deleteUser(theId);
    }

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		com.aptech.springmvc.entity.User user = userDAO.findByUserName(username);
		if (user == null)
            throw new UsernameNotFoundException("Invalid username or password!");

        List<Role> roleList = user.getRole();
		
		List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
		 for (Role role : roleList) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
            grantedAuthorityList.add(grantedAuthority);
		 }
		
		UserDetails userDetails = new User(user.getUsername(), user.getPassword(), grantedAuthorityList);
		
		return userDetails;
	}

	@Override
	@Transactional
	public List<com.aptech.springmvc.entity.User> searchUsers(String theSearchName) {
		return userDAO.searchUsers(theSearchName);
	}
	
	@Override
    @Transactional
    public com.aptech.springmvc.entity.User findByUserName(String userName) {
        return userDAO.findByUserName(userName);
    }

    @Override
    @Transactional
    public void save(RegisterUser registeredUser) {
        com.aptech.springmvc.entity.User user = new com.aptech.springmvc.entity.User();

        user.setUsername(registeredUser.getUsername());
        user.setPassword(passwordEncoder.encode(registeredUser.getPassword()));
        user.setEmail(registeredUser.getEmail());
        user.setEnabled(true);

        // give a default role of employee
        user.setRole(Arrays.asList(roleDAO.findRoleByName("ROLE_USER")));

        userDAO.save(user);
    }

	@Override
    @Transactional
	public void saveUser(com.aptech.springmvc.entity.User theUser) {
		userDAO.saveUser(theUser);
	}



}
