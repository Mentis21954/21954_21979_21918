package com.springboot.app.Controller;

import com.springboot.app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;


    @RequestMapping("/home")
    public String homeAdminPage(Model model) {
        return "Student_menu";
    }
}
