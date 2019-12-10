package ru.simpleCRUD.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.simpleCRUD.models.User;
import ru.simpleCRUD.service.UserService;

@Controller
public class EditUserController {
    private UserService service;

    @Autowired
    public EditUserController(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "/editUser")
    public ModelAndView editUserPage(@RequestParam("id") Long id) {
        User user = service.findById(id);
        return new ModelAndView("edit", "user", user);
    }

    @PostMapping(value = "/editUser")
    public String editUser(@ModelAttribute("user") User user) {
        service.editUser(user);
        return "redirect:/allUsers";
    }
}
