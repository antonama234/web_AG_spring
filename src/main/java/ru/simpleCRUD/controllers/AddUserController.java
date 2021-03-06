package ru.simpleCRUD.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.simpleCRUD.models.Role;
import ru.simpleCRUD.models.User;
import ru.simpleCRUD.service.UserServiceImpl;

import java.util.Collections;

@Controller
public class AddUserController {
    private UserServiceImpl service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AddUserController(UserServiceImpl service) {
        this.service = service;
    }

    @GetMapping(value = "/admin/addUser")
    public ModelAndView addUserPage() {
        User user = new User();
        return new ModelAndView("add","user", user);
    }

    @PostMapping(value = "/admin/addUser")
    public String addUser(@ModelAttribute("user") User user) {
        if (!service.isExist(user.getLogin())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Collections.singleton(Role.USER));
            service.addUser(user);
        }
        return "redirect:/admin/allUsers";
    }
}