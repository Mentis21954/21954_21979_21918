package com.springboot.app.Controller;

import com.springboot.app.Entity.Request;
import com.springboot.app.Entity.User;
import com.springboot.app.Service.RequestService;
import com.springboot.app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/teacher")
public class teacherController {
    @Autowired
    private UserService service;

    @Autowired
    private RequestService requestService;

    public User getLoginUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = service.getUserByUsername(username);
        return user;
    }

    @GetMapping("/home")
    public String homeTeacherPage(Model model) {
        User user = getLoginUser();

        model.addAttribute("requestList", requestService.getStudentRequests(user.getUsername()));
        return "teacher_menu";
    }


}
