package ru.simpleCRUD.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.simpleCRUD.models.User;
import ru.simpleCRUD.service.UserService;

import java.util.List;

@Controller
public class AllUsersController {
    private UserService service;

    @Autowired
    public AllUsersController(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "/allUsers")
    public ModelAndView allUsersPage() {
        List<User> list = service.allUsers();
        return new ModelAndView("all", "allUsers", list);
    }
}
