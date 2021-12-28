package com.springboot.app.Controller;

import com.springboot.app.entity.User;
import com.springboot.app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService service;


    @RequestMapping("/userList")
    public String homeAdminPage(Model model) {
        model.addAttribute("listUsers",service.listAll());
        return "update_user_page";
        //<td th:each="userRole : ${User.getRoles()}" th:text="${userRole.name}"></td>
    }

    @RequestMapping("/addUser")
    public String showNewProductForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "add_user_page";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("User") User user) {
        service.save(user);

        return "redirect:/";
    }
/*
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_product");

        Product product = service.get(id);
        mav.addObject("product", product);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id) {
        service.delete(id);

        return "redirect:/";
    }

 */
}
