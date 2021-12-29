package com.springboot.app.Controller;

import com.springboot.app.Entity.Role;
import com.springboot.app.Entity.User;
import com.springboot.app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService service;

    @GetMapping("/userList")
    public String viewHomePage(Model model) {
        model.addAttribute("listUsers",service.listAll());
        return "userList";
    }
    @RequestMapping("/showNewUserForm")
    public String showNewUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
        //<td th:each="userRole : ${User.getRoles()}" th:text="${userRole.name}"></td>
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) {
        service.save(user);
        return "redirect:/admin/showNewUserForm";
    }


    @RequestMapping("/showFormUpdate/{id}")
    public String showFormUpdate(@PathVariable(value="id") long id, Model model) {
        User user = service.get(id);
        List<Role> listRoles = service.listRoles();
        model.addAttribute("listRoles", listRoles);
        model.addAttribute("user", user);
        return "update_user";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable (value = "id") long id) {
        this.service.delete(id);
        return "redirect:/admin/userList";
    }

}
