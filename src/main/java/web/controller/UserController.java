package web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import web.models.User;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping()
    public ModelAndView show(@AuthenticationPrincipal User user) {
        ModelAndView modelAndView = new ModelAndView("/user/show");
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
