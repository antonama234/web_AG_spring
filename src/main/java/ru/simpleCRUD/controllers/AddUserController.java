package ru.simpleCRUD.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.simpleCRUD.models.User;
import ru.simpleCRUD.service.UserService;

@Controller
public class AddUserController {
    private UserService service;

    @Autowired
    public AddUserController(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "/addUser")
    public ModelAndView addUserPage() {
        User user = new User();
        return new ModelAndView("add","user", user);
    }

    @PostMapping(value = "/addUser")
    public String addUser(@ModelAttribute("user") User user) {
        if (!service.isExist(user.getLogin())) {
            user.setRole("user");
            service.addUser(user);
        }
        return "redirect:/allUsers";
    }
}