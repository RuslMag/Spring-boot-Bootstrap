package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/")
    public String getLoginPage() {
        return "/login";
    }

    @GetMapping("/login-error")
    public String loginErrorPage(Model model) {
        model.addAttribute("loginError", true);
        return "/login";
    }

}
