package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    private final RoleService roleService;

    @Autowired
    public UserController(UserService userService, @Lazy RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String showUser(Model model, Principal principal) {
        String name = roleService.findAll().stream()
                .map(role -> role.getName())
                .filter(role_name -> role_name.equals("ROLE_ADMIN")).findFirst().orElse(null);
        model.addAttribute("role_admin", name);
        model.addAttribute("user", userService.findByUsername(principal.getName()));
        return "user/show-user";
    }
}
