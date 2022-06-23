package pl.antiquarian.antiquarian.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.antiquarian.antiquarian.model.User;
import pl.antiquarian.antiquarian.security.UserService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/registration")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "registration";
        }
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "log";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }
}
