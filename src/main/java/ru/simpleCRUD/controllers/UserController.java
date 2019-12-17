package ru.simpleCRUD.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.simpleCRUD.models.User;
import ru.simpleCRUD.service.UserServiceImpl;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl service;

    @GetMapping(value = "/user")
    public ModelAndView userPage(Principal principal) {
        User user = service.findByLogin(principal.getName());
        return new ModelAndView("user", "user", user.getName());
    }

}
