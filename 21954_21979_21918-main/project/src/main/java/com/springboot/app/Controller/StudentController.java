package com.springboot.app.Controller;

import com.springboot.app.Entity.Request;
import com.springboot.app.Service.RecommendationLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.springboot.app.Service.RequestService;
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private RequestService requestService;

    @GetMapping("/home")
    public String homeAdminPage(Model model) {
        return "Student_menu";
    }

    @GetMapping("/requestList")
    public String showRequestList(Model model) {
        // create model attribute to bind form data
        model.addAttribute("listRequests", requestService.getAllRequests());
        return "requestList";
    }

    @PostMapping("/saveRequest")
    public String saveRequest(@ModelAttribute("request") Request request) {
        // save request to database
        requestService.saveRequest(request);
        return "redirect:/";
    }

    @GetMapping("/deleteRequest/{id}")
    public String deleteRequest(@PathVariable(value = "id") long id) {

        // call delete request method
        this.requestService.deleteRequestById(id);
        return "redirect:/student/requestList";
    }

    //Letters

    @Autowired
    private RecommendationLetterService letterService;

    @GetMapping("/recommendationLettersList")
    public String showLettersForm(Model model) {
        // create model attribute to bind form data
        model.addAttribute("listLetters", letterService.listAll());
        return "recommendationLettersList";
    }

    @GetMapping("/deleteRecommendationLetter/{id}")
    public String deleteRecommendationLetter(@PathVariable(value = "id") long id) {

        // call delete request method
        this.letterService.delete(id);
        return "redirect:/student/recommendationLettersList";
    }




}
