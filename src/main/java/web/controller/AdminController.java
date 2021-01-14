package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.models.User;
import web.services.RoleService;
import web.services.UserService;

import javax.validation.Valid;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    final UserService userService;
    final RoleService roleService;


    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public ModelAndView index(@AuthenticationPrincipal User admin) {
        return getModelAndView(admin);
    }

    @PostMapping
    public String create(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult,
                         @RequestParam("roles") Set<String> roles) {
        user.setRoles(roleService.getRoles(roles));
        userService.save(user);
        return "redirect:/admin";
    }

    @PostMapping("update")
    public String update(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult,
                         @RequestParam("roles") Set<String> roles) {

        user.setRoles(roleService.getRoles(roles));
        userService.update(user);
        return "redirect:/admin";
    }

    @PostMapping("{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/admin";
    }

    private ModelAndView getModelAndView(User admin) {
        User user = new User();
        ModelAndView modelAndView = new ModelAndView("admin/index");
        modelAndView.addObject("admin", admin)
                .addObject("user", user)
                .addObject("users", userService.listUsers());
        return modelAndView;
    }
}