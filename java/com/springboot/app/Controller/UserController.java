package com.springboot.app.Controller;

import com.springboot.app.Entity.Request;
import com.springboot.app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.springboot.app.Service.RequestService;
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private RequestService requestService;

    @GetMapping("/home")
    public String homeAdminPage(Model model) {
        return "Student_menu";
    }

    @GetMapping("/showAllRequests")
    public String showNewEmployeeForm(Model model) {
        // create model attribute to bind form data
        model.addAttribute("listRequests", requestService.getAllRequests());
        return "requestList";
    }

    @PostMapping("/saveRequest")
    public String saveEmployee(@ModelAttribute("request") Request request) {
        // save request to database
        requestService.saveRequest(request);
        return "redirect:/";
    }

    @GetMapping("/deleteRequest/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {

        // call delete request method
        this.requestService.deleteRequestById(id);
        return "redirect:/user/requestList";
    }
}
