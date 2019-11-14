package com.helloworld.springmvcdemo.controllers;

import com.helloworld.springmvcdemo.dao.UserDao;
import com.helloworld.springmvcdemo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String getUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user/create-user";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String getUserFormData(@ModelAttribute(value = "user") User user) {
        int result = userDao.save(user);
        return "redirect:/home";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String getUserEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("user", userDao.find(id));
        return "user/edit-user";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    public String getUserEditFormData(@ModelAttribute(value = "user") User user, @PathVariable Long id) {
        user.setId(id);
        userDao.update(user);
        return "redirect:/home";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public String getUserEditFormData(@PathVariable Long id) {
        userDao.delete(id);
        return "redirect:/home";
    }
}
