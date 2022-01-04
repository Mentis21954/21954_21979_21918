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

import com.springboot.app.Service.RequestService;

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

    @RequestMapping(value = "/saveRequest", method = RequestMethod.POST)
    public String saveRequest(@ModelAttribute("request") Request request) throws Exception {
        try {
            requestService.saveRequest(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @GetMapping("/rejectRequest/{id}")
    public String deleteRequest(@PathVariable(value = "id") long id) {

        // call delete request method
        this.requestService.deleteRequestById(id);
        return "redirect:/teacher/requestList";
    }

}
