package com.helloworld.springmvcdemo.controllers;

import com.helloworld.springmvcdemo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String gteUserForm(@RequestParam(name = "page", required = false) Integer page, Model model) {
        final int itemPerPage = 5;
        int startIndex;
        if (Objects.isNull(page) || page == 1) {
            page = 1;
            startIndex = 0;
        } else {
            startIndex = page - 1;
            startIndex *= itemPerPage;
        }
        model.addAttribute("users", userDao.findAllByPagination(startIndex, itemPerPage));
        model.addAttribute("totalPages", userDao.findTotalPages(itemPerPage));
        model.addAttribute("currentPage", page);
        return "home/home";
    }
}
