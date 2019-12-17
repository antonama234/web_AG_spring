package ru.simpleCRUD.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.simpleCRUD.models.User;
import ru.simpleCRUD.service.UserServiceImpl;

@Controller
public class DeleteUserController {
    private UserServiceImpl service;

    @Autowired
    public DeleteUserController(UserServiceImpl service) {
        this.service = service;
    }

    @PostMapping(value = "/admin/deleteUser")
    public ModelAndView deleteUserPage(@RequestParam("id") Long id) {
        User user = service.findById(id);
        service.deleteUser(user);
        return new ModelAndView("delete", "user", user);
    }

}
