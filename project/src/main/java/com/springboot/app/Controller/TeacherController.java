package com.springboot.app.Controller;

import com.springboot.app.Entity.Lesson;
import com.springboot.app.Entity.Request;
import com.springboot.app.Entity.User;
import com.springboot.app.Service.LessonService;
import com.springboot.app.Service.RequestService;
import com.springboot.app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private UserService service;

    @Autowired
    private RequestService requestService;

    @Autowired
    private LessonService lessonService;

    public User getLoginUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = service.getUserByUsername(username);
        return user;
    }

    @GetMapping("/home")
    public String showRequestList(Model model) {
        // create model attribute to bind form data
        User user = getLoginUser();
        model.addAttribute("listRequests", requestService.getTeacherRequests(user.getId()));
        return "teacher_menu";
    }

    @GetMapping("/selectRequest/{id}")
    public String selectRequest(@PathVariable(value = "id") long id, Model model) {
        Request request =  requestService.getRequestById(id);
        List<Lesson> lessons = lessonService.getStudentLesson(request.getId());
        model.addAttribute("request",request);
        model.addAttribute("lessons",lessons);

        return "check_request";
    }

    @RequestMapping(value = "/acceptRequest",method = RequestMethod.GET)
    public String acceptRequest(@ModelAttribute("request") Request request) {

        requestService.getRequestById(request.getId()).setStatus("Accepted");
        requestService.saveRequest(request);
        return "redirect:/teacher/home";
    }

    @RequestMapping (value = "/rejectRequest",method = RequestMethod.GET)
    public String rejectRequest(@ModelAttribute("request") Request request) {

        requestService.getRequestById(request.getId()).setStatus("Rejected");
        requestService.saveRequest(request);
        return "redirect:/teacher/home";
    }

    @GetMapping("/deleteRequest/{id}")
    public String deleteRequest(@PathVariable (value = "id") long id) {

        //this.lessonService.deleteRequest(id);
        this.requestService.deleteRequestById(id);
        return "redirect:/teacher/home";
    }

}
