package com.springboot.app.Controller;

import com.springboot.app.Entity.Request;
import com.springboot.app.Entity.User;
import com.springboot.app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.springboot.app.Service.RequestService;
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private RequestService requestService;

    @GetMapping("/home")
    public String homeTeacherPage(Model model) {
        return "Teacher_menu";
    }

    @GetMapping("/requestList")
    public String showRequestList(Model model) {
        // create model attribute to bind form data
        model.addAttribute("listRequests", requestService.getAllRequests());
        return "teacher_requestList";
    }

    @GetMapping("/selectRequest/{id}")
    public String selectRequest(@PathVariable(value = "id") long id, Model model) {
        Request request =  requestService.getRequestById(id);
        model.addAttribute("request",request);
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
