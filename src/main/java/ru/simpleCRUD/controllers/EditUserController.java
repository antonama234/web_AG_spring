package ru.simpleCRUD.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.simpleCRUD.models.Role;
import ru.simpleCRUD.models.User;
import ru.simpleCRUD.service.UserServiceImpl;

import java.util.Collections;

@Controller
public class EditUserController {
    private UserServiceImpl service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public EditUserController(UserServiceImpl service) {
        this.service = service;
    }

    @GetMapping(value = "/admin/editUser")
    public ModelAndView editUserPage(@RequestParam("id") Long id) {
        User user = service.findById(id);
        return new ModelAndView("edit", "user", user);
    }

    @PostMapping(value = "/admin/editUser")
    public String editUser(@ModelAttribute("user") User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Collections.singleton(Role.USER));
        service.editUser(user);
        return "redirect:/admin/allUsers";
    }
}
