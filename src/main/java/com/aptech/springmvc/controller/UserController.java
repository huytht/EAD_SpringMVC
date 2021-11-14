package com.aptech.springmvc.controller;

import com.aptech.springmvc.entity.User;
import com.aptech.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService UserService) {
        this.userService = UserService;
    }

    @GetMapping("/list")
    public String listUsers(Model theModel) {

        List<User> theUsers = null;

        theUsers = userService.getUsers();
        theModel.addAttribute("users", theUsers);

        return "list-user";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User theUser) {
        userService.saveUser(theUser);

        // redirect from controller to another URL in controller
        return "redirect:/user/list";
    }
    
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        User theUser = new User();
        theModel.addAttribute("user", theUser);

        return "user-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("userId") int theId, Model theModel) {
        // get User from DB
        User theUser = userService.getUser(theId);

        // bind data to theModel
        theModel.addAttribute("user", theUser);

        return "user-form";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("userId") int theId) {
    	userService.deleteUser(theId);
        return "redirect:/user/list";
    }

    @GetMapping("search")
    public String searchUser(@RequestParam("theSearchName") String theSearchName, Model theModel) {
        List<User> theUsers = userService.searchUsers(theSearchName);
        theModel.addAttribute("users", theUsers);
        return "list-user";
    }
}

