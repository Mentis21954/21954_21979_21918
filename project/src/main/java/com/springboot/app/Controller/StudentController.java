package com.springboot.app.Controller;

import com.springboot.app.Entity.Lesson;
import com.springboot.app.Entity.RecommendationLetter;
import com.springboot.app.Entity.Request;
import com.springboot.app.Entity.User;
import com.springboot.app.Service.LessonService;
import com.springboot.app.Service.LetterService;
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
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private UserService service;

    @Autowired
    private RequestService requestService;

    @Autowired
    private LessonService lessonService;

    @Autowired
    private LetterService letterService;

    @GetMapping("/home")
    public String homeStudentPage(Model model) {

        return "student_menu";
    }

    private Request request2;

    public User getLoginUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = service.getUserByUsername(username);
        return user;
    }

    @GetMapping("/addRequest")
    public String addNewRequest(Model model) {
        User user = getLoginUser();
        List<User> userList = service.getAllTeachers();

        Request request = new Request();

        request.setSender(user);
        request.setStatus("pending");

        model.addAttribute("user", user);
        model.addAttribute("request", request);
        model.addAttribute("userList", userList);

        return "requestForm";
    }


    @PostMapping("/saveRequest")
    public String saveRequest(@ModelAttribute("request") Request request) {
        // save request to database
        request2 = request;
        requestService.saveRequest(request);
        return "redirect:/student/addLesson";
    }

    @GetMapping("/addLesson")
    public String addLesson(Model model) {
        Lesson lesson = new Lesson();
        List<Lesson> lessonList = lessonService.getStudentLesson(request2.getId());
        model.addAttribute("lesson",lesson);
        model.addAttribute("lessonList", lessonList);
        return "new_lesson";
    }


    @PostMapping("/saveLesson")
    public String saveLesson(@ModelAttribute("lesson") Lesson lesson) {
        // save request to database
        lesson.setRequests(request2);
        lessonService.saveLesson(lesson);
        return "redirect:/student/addLesson";
    }


    @GetMapping("/showRequests")
    public String showNewEmployeeForm(Model model) {
        // create model attribute to bind form data
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = service.getUserByUsername(username);
        List<Request> requestList = requestService.getStudentRequests(user.getId());
        model.addAttribute("listRequests", requestList);
        return "requestList";
    }

    @GetMapping("/viewLetters")
    public String viewLetters(Model model) {
        User user = getLoginUser();
         List<RecommendationLetter> letterList = letterService.getStudentLettersById(user.getId());
        model.addAttribute("letterList", letterList);
        return "lettersList";
    }

    @GetMapping("/viewMore/{id}")
    public String viewLetters(@PathVariable (value = "id") long id, Model model) {
        model.addAttribute("letter", letterService.getLetterById(id));
        if (letterService.getLetterById(id).getRequests().getStatus().equals("Accepted")) {
            return "viewAccepted";

        } else {
            return "viewRejected";
        }
    }


}